package com.example.paintbe.Repository;

import com.example.paintbe.Repository.cache.CacheRepository;
import com.example.paintbe.Repository.cache.Storage;
import com.example.paintbe.Repository.db.CRUD;
import com.example.paintbe.Repository.db.CRUDRepository;
import com.example.paintbe.Service.Model.Shape;
import com.example.paintbe.Service.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ShapeRepository {

    /*private CacheRepository cacheRepository;

    @Autowired
    public ShapeRepository(CacheRepository cacheRepository) {
        this.cacheRepository = cacheRepository;
    }

    @Override
    public boolean insert(Shape shape) {
        cacheRepository.push(Storage.UNDO, new Pair<>(shape.clone(), CRUD.CREATE));
        return super.insert(shape);
    }

    public void clear() {
        ArrayList<Shape> db = getDataBase();
        ArrayList<Shape> cloneDb = new ArrayList<>();
        db.forEach(shape -> cloneDb.add(shape.clone()));
        cacheRepository.push(Storage.UNDO, new Pair<>(cloneDb, CRUD.CLEAR));
        deleteAll();
    }

    @Override
    public boolean delete(String id) {
        Shape shape = getByID(id);
        cacheRepository.push(Storage.UNDO, new Pair<>(shape.clone(), CRUD.DELETE));
        return super.delete(id);
    }

    public Shape copy(String id) {
        Shape shape = getByID(id);
        return shape.clone();
    }*/

}
