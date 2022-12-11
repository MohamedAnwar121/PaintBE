package com.example.paintbe.Service;

import com.example.paintbe.Repository.ShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class LoadService {

    private ShapeRepository shapeRepository;

    /**
     * ToDo: load
     * @param savedData file chosen by user from the front end to load data from
     * @return jsonString of the dataBase(Konva Stage)
     */
    @Autowired
    public LoadService(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    public String load(File savedData) {
        return null;
    }
}
