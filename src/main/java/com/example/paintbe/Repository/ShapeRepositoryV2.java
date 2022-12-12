package com.example.paintbe.Repository;

import com.example.paintbe.Repository.cache.DbCacheRepository;
import com.example.paintbe.Repository.cache.ShapeCacheRepository;
import com.example.paintbe.Repository.db.CRUD;
import com.example.paintbe.Repository.db.CRUDRepository;
import com.example.paintbe.Service.Model.*;
import com.example.paintbe.Service.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

@Component
public class ShapeRepositoryV2 extends CRUDRepository<Shape> {

    private ShapeCacheRepository shapeCacheRepo;
    private DbCacheRepository dbCacheRepo;

    private final static Stack<Pair<String, CRUD>> undoActions = new Stack<>();
    private final static Stack<Pair<String, CRUD>> redoActions = new Stack<>();

    @Autowired
    public ShapeRepositoryV2(ShapeCacheRepository cacheRepository, DbCacheRepository dbCacheRepository) {
        this.shapeCacheRepo = cacheRepository;
        this.dbCacheRepo = dbCacheRepository;
    }

    @Override
    public boolean insert(Shape shape) {
        undoActions.push(new Pair<>(shape.getId(), CRUD.CREATE));

        LineSegment temp = (LineSegment) shape;
        LineSegment line = (LineSegment) shape.clone();
        System.out.println(temp.getPoints().get(0));
        System.out.println(line.getPoints().get(0));

        temp.getPoints().set(0,new BigDecimal(50));

        System.out.println(temp.getPoints().get(0));
        System.out.println(line.getPoints().get(0));

        /*RegularPolygon square = (RegularPolygon) shape.clone();
        System.out.println(square.getX());
        System.out.println(square.getY());
        System.out.println(square.getStrokeWidth());
        System.out.println(square.getSides());
        System.out.println(square.getRadius());*/


        shapeCacheRepo.save(shape.clone());
        return super.insert(shape);
    }

    @Override
    public boolean update(Shape shape) {
        undoActions.push(new Pair<>(shape.getId(), CRUD.UPDATE));

        /*RegularPolygon square = (RegularPolygon) shape.clone();
        System.out.println(square.getX());
        System.out.println(square.getY());
        System.out.println(square.getStrokeWidth());
        System.out.println(square.getSides());
        System.out.println(square.getRadius());*/


        shapeCacheRepo.update(shape.clone());
        return super.update(shape);
    }

    public void clear() {
        undoActions.push(new Pair<>("clear", CRUD.CLEAR));
        dbCacheRepo.save(getDataBase());
        deleteAll();
    }

    @Override
    public boolean delete(String id) {
        undoActions.push(new Pair<>(id, CRUD.DELETE));
        shapeCacheRepo.update(getByID(id).clone());
        return super.delete(id);
    }

    public Shape copy(String id) {
        Shape shape = getByID(id).clone();
        shape.setId(UUID.randomUUID().toString());
        return shape;
    }

    public Pair<List<Shape>, CRUD> undo() {
        Pair<String, CRUD> lastAction = undoActions.pop();
        redoActions.push(lastAction);
        String id = lastAction.getFirst();
        CRUD action = lastAction.getSecond();
        switch (action) {
            case CREATE -> {
                Shape shape = getByID(id);
                super.delete(id);
                shapeCacheRepo.undoById(id);
                return new Pair<>(List.of(shape), CRUD.DELETE);
            }
            case UPDATE -> {
                Shape shape = shapeCacheRepo.undoById(id);
                super.update(shape.clone());
                return new Pair<>(List.of(shape), CRUD.UPDATE);
            }
            case DELETE -> {
                Shape shape = shapeCacheRepo.undoById(id);
                super.insert(shape.clone());
                return new Pair<>(List.of(shape), CRUD.CREATE);
            }
            case CLEAR -> {
                ArrayList<Shape> cacheDb = dbCacheRepo.undoClear();
                super.loadDataBase(cacheDb);
                return new Pair<>(cacheDb, CRUD.CREATE);
            }
        }
        return null;
    }

    public Pair<List<Shape>, CRUD> redo() {
        Pair<String, CRUD> lastAction = redoActions.pop();
        undoActions.push(lastAction);
        String id = lastAction.getFirst();
        CRUD action = lastAction.getSecond();
        switch (action) {
            case CREATE -> {
                Shape shape = shapeCacheRepo.redoById(id);
                super.insert(shape.clone());
                return new Pair<>(List.of(shape), CRUD.CREATE);
            }
            case UPDATE -> {
                Shape shape = shapeCacheRepo.redoById(id);
                super.update(shape.clone());
                return new Pair<>(List.of(shape), CRUD.UPDATE);
            }
            case DELETE -> {
                Shape shape = shapeCacheRepo.redoById(id);
                super.delete(shape.getId());
                return new Pair<>(List.of(shape), CRUD.DELETE);
            }
            case CLEAR -> {
                dbCacheRepo.redoClear();
                super.deleteAll();
            }
        }
        return null;
    }

}
