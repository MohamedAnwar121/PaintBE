package com.example.paintbe.Service;

import com.example.paintbe.Repository.ShapeRepositoryV2;
import com.example.paintbe.Repository.db.CRUD;
import com.example.paintbe.Service.Model.Shape;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShapeService implements IOperation{

    private ShapeRepositoryV2 shapeRepository;
    private final ShapeFactory shapeFactory;

    public ShapeService(ShapeRepositoryV2 shapeRepository, ShapeFactory shapeFactory) {
        this.shapeRepository = shapeRepository;
        this.shapeFactory = shapeFactory;
    }

    @Override
    public String addNewShape(String json) {
        Shape shape = shapeFactory.getShape(new JSONObject(json));
        shapeRepository.createShape(shape);

        shapeRepository.printDb();

        return shape.getId();
    }

    @Override
    public void updateShape(String json) {
        Shape shape = shapeFactory.getShape(new JSONObject(json));
        shape.setId(new JSONObject(json).getJSONObject("attrs").getString("id"));
        shapeRepository.updateShape(shape);
        shapeRepository.printDb();
    }

    @Override
    public String copyAndInsert(String id) {
       Shape shape = shapeRepository.copyShape(id);
       shapeRepository.createShape(shape);

       shapeRepository.printDb();

       return shape.getId();
    }

    @Override
    public void deleteShape(String id) {
        shapeRepository.deleteShape(id);

        shapeRepository.printDb();
    }

    @Override
    public JSONObject undo() {
        //return new Pair<>(result.first,result.second.name());
        Pair<List<Shape>, CRUD> result = shapeRepository.undo();
        shapeRepository.printDb();
        JSONArray array = JSONUtil.convertListToJSONArray(new ArrayList<>(result.getFirst()));
        return JSONUtil.wrapListAndOperation(array,result.getSecond().name());
    }

    @Override
    public JSONObject redo() {
        //return new Pair<>(result.first,result.second.name());
        Pair<List<Shape>, CRUD> result = shapeRepository.redo();
        shapeRepository.printDb();
        JSONArray array = JSONUtil.convertListToJSONArray(new ArrayList<>(result.getFirst()));
        return JSONUtil.wrapListAndOperation(array,result.getSecond().name());
    }

    @Override
    public void clearStage() {
        shapeRepository.clearDB();
    }
}

