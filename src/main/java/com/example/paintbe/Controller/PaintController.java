package com.example.paintbe.Controller;

import com.example.paintbe.Service.LoadService;
import com.example.paintbe.Service.SaveService;
import com.example.paintbe.Service.ShapeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@CrossOrigin()
@RequestMapping("/api")
@RestController
public class PaintController {

    private final ShapeService service;
    private final SaveService saveService;
    private final LoadService loadService;

    @Autowired
    public PaintController(ShapeService service, SaveService saveService, LoadService loadService) {
        this.service = service;
        this.saveService = saveService;
        this.loadService = loadService;
    }

    // add , update , copy , delete , undo , redo, clear

    @PostMapping("/Create")
    public ResponseEntity<String> createShape(@RequestBody String json) {
        return ResponseEntity.ok(new JSONObject().put("id", service.addNewShape(json)).toString());
    }

    @PostMapping("/Update")
    public void updateShape(@RequestBody String json) {
        service.updateShape(json);
    }

    @PostMapping("/Copy")
    public ResponseEntity<String> copyShape(@RequestBody String id) {
        return ResponseEntity.ok(new JSONObject().put("id", service.copyAndInsert(id)).toString());
    }

    @PostMapping("/Delete")
    public void deleteShape(@RequestBody String id) {
        service.deleteShape(id);
    }

    @GetMapping("/Undo")
    public ResponseEntity<String> undoOperation() {
        return ResponseEntity.ok(service.undo());
    }

    @GetMapping("/Redo")
    public ResponseEntity<String> redoOperation() {
        return ResponseEntity.ok(service.redo());
    }

    @GetMapping("/Clear")
    public void clearDataBase() {
        service.clearStage();
    }

    @PostMapping("/Save")
    public File save(@RequestBody() String json) {
        return saveService.save(json);
    }

    @PostMapping("/Load")
    public String load(@RequestBody File file) {
        return loadService.load(file);
    }


    /*@GetMapping("/GETDataBase")
    public ArrayList<Shape> getDataBase() {
        return service.getDataBase();
    }*/
}
