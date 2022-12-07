package com.example.paintbe.Controller;

import com.example.paintbe.Service.PaintService;
import com.example.paintbe.Service.Shapes.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@CrossOrigin()
@RequestMapping("/api")
@RestController
public class PaintController {

    private final PaintService service;

    @Autowired
    public PaintController(PaintService service) {
        this.service = service;
    }

    @PostMapping("/POSTShape")
    public String postShape(@RequestBody String shapeJSON){
        service.addNewShape(shapeJSON);
        return service.getLastID();
    }

    @GetMapping("/GETDataBase")
    public ArrayList<Shape> getDataBase(){
        return service.getDataBase();
    }

    /*@GetMapping("/GETid")
    public String getLastID(){
        return service.getLastID();
    }*/

    /*@PostMapping("/POSTShape")
    public void postShape(@RequestBody String shapeJSON){
        service.addNewShape(shapeJSON);
    }*/

}
