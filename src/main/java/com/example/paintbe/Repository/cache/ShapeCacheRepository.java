package com.example.paintbe.Repository.cache;

import com.example.paintbe.Service.Model.Shape;
import com.example.paintbe.Service.Pair;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Stack;

@Component
public class ShapeCacheRepository {

    // first for undo
    private final static HashMap<String, Pair<Stack<Shape>, Stack<Shape>>> cache = new HashMap<>();

    public void save(Shape shape) {
        Stack<Shape> undo = new Stack<>();
        Stack<Shape> redo = new Stack<>();
        undo.push(shape);
        Pair<Stack<Shape>,Stack<Shape>> history = new Pair<>(undo,redo);
        cache.put(shape.getId(), history);
    }

    public void update(Shape shape) {
        Pair<Stack<Shape>,Stack<Shape>> history = cache.get(shape.getId());
        if (history == null){
            save(shape);
        }else {
            history.getFirst().push(shape);//undo
        }
    }

    // peek at undo stack only
//    public Shape peekById(String id) {
//        Pair<Stack<Shape>,Stack<Shape>> history = cache.get(id);
//        if (history == null || history.getFirst().isEmpty()) return null;
//        return history.getFirst().peek();
//    }

    public Shape undoById(String id) {
        Pair<Stack<Shape>,Stack<Shape>> history = cache.get(id);
        if (history != null) {
            Stack<Shape> undo = history.getFirst();
            Stack<Shape> redo = history.getSecond();
            redo.push(undo.pop());
            if (undo.isEmpty()) return null;
            return undo.peek();
        }else {
            return null;
        }
    }

    public Shape redoById(String id) {
        Pair<Stack<Shape>,Stack<Shape>> history = cache.get(id);
        if (history != null) {
            Stack<Shape> undo = history.getFirst();
            Stack<Shape> redo = history.getSecond();
            undo.push(redo.pop());
            return undo.peek();
        }else {
            return null;
        }
    }

    public void clear() {
        cache.clear();
    }

}
