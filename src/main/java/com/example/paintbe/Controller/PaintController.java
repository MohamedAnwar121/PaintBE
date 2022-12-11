package com.example.paintbe.Controller;

import com.example.paintbe.Service.LoadService;
import com.example.paintbe.Service.SaveService;
import com.example.paintbe.Service.ShapeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String createShape(@RequestBody String json) {
        return service.addNewShape(json);
    }

    @PostMapping("/Update")
    public void updateShape(@RequestBody String json) {
        service.updateShape(json);
    }

    @PostMapping("/Copy")
    public String copyShape(@RequestBody String id) {
        return service.copyAndInsert(id);
    }

    @PostMapping("/Delete")
    public void deleteShape(@RequestBody String id) {
        service.deleteShape(id);
    }

    @GetMapping("/Undo")
    public JSONObject undoOperation() {
        return service.undo();
    }

    @GetMapping("/Redo")
    public JSONObject redoOperation() {
        return service.redo();
    }

    @GetMapping("/Clear")
    public void clearDataBase() {
        service.clearStage();
    }

    @PostMapping("/Save")
    public File save(@RequestBody String jsonStage, @RequestBody String fileType) {
        return saveService.save(jsonStage, fileType);
    }

    @PostMapping("/Load")
    public String load(@RequestBody File file) {
        return loadService.load(file);
    }


    /*@PostMapping("/POSTShapeWithOperation")
    public String postShapeWithOperation(@RequestBody String shapeJSON, @RequestBody String operation) {
        service.addNewShapeWithOperation(shapeJSON, operation);
        return service.getLastID();
    }

    @PostMapping("/PostOperation")
    public String postOperation(@RequestBody String operation) {
        return null;
    }*/

    /*@GetMapping("/GETDataBase")
    public ArrayList<Shape> getDataBase() {
        return service.getDataBase();
    }*/
}
