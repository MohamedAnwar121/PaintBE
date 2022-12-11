package com.example.paintbe.Service;

import com.example.paintbe.Repository.ShapeRepositoryV2;
import com.example.paintbe.Repository.db.CRUD;
import com.example.paintbe.Service.Model.Shape;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
    public void clearStage() {
        shapeRepository.clear();
    }

    @Override
    public String addNewShape(String json) {
        Shape shape = shapeFactory.getShape(new JSONObject(json));
        shapeRepository.insert(shape);
        return shape.getId();
    }

    @Override
    public void updateShape(String json) {
        Shape shape = shapeFactory.getShape(new JSONObject(json));
        shapeRepository.update(shape);
    }

    @Override
    public String copyAndInsert(String id) {
       Shape shape = shapeRepository.copy(id);
       shapeRepository.insert(shape);
       return shape.getId();
    }

    @Override
    public void deleteShape(String id) {
        shapeRepository.delete(id);
    }

    @Override
    public JSONObject undo() {
        Pair<List<Shape>, CRUD> result = shapeRepository.undo();
        //return new Pair<>(result.first,result.second.name());
        JSONArray array = convertListToJSONArray((ArrayList<Shape>) result.getFirst());
        return wrapListAndOperation(array,result.getSecond().name());
    }

    @Override
    public JSONObject redo() {
        Pair<List<Shape>, CRUD> result = shapeRepository.redo();
        //return new Pair<>(result.first,result.second.name());
        JSONArray array = convertListToJSONArray((ArrayList<Shape>) result.getFirst());
        return wrapListAndOperation(array,result.getSecond().name());
    }

    public JSONObject convertShapeToJSON(Shape shape) {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {json = objectWriter.writeValueAsString(shape);} catch (Exception ignored) {}
        return new JSONObject(json);
    }

    public JSONArray convertListToJSONArray(ArrayList<Shape> shapes){
        JSONArray jsonArray = new JSONArray();
        for (Shape shape : shapes){
            jsonArray.put(convertShapeToJSON(shape));
        }
        return jsonArray;
    }

    public JSONObject wrapListAndOperation(JSONArray array , String operation){
        JSONObject json = new JSONObject();
        json.put("shapes",array);
        json.put("operation",operation);
        return json;
    }
}

