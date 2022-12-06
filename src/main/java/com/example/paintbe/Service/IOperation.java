package com.example.paintbe.Service;

import com.example.paintbe.Service.Shapes.Shape;

public interface IOperation {

    /**
     * @param newShapeJSONObject
     * This is the new object which we get from the front end
     * ToDO : Use the newJson object to get the id then get the object by id
     *        from the database then update that object according to the newJSOnObject
     */
    void updateShape(String newShapeJSONObject);

    /**
     * @param id
     * This is the id which we get from the front end which belongs to the object we want to copy
     * ToDO : Clone the object which we get from the database and generates a new id for the cloned object
     */
    void copyShape(String id);


    /**
     * @param id
     * This is the id which we get from the front end which belongs to the object we want to delete
     * ToDo : get the object we want to delete by ID then delete that object.
     */
    void deleteShape(String id);


    /**
     * In case of Undo of shapeModification pop the front of the undo stack and put it in the redo stack
     * then get the front of the undo stack and get the id of that object and search with it in the database
     * to get the object then convert the other object(front of undo stack) to jsonString then update DataBase Object
     *
     *
     */
    Object undo(Shape lastShape);

    void redo();

    void save();

    void load();

}
