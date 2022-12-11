package com.example.paintbe.Repository.cache;

import com.example.paintbe.Repository.ICacheDriver;
import com.example.paintbe.Repository.db.CRUD;
import com.example.paintbe.Service.Pair;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class CacheRepository implements ICacheDriver {

    Stack<Pair<Object, CRUD>> undo;
    Stack<Pair<Object, CRUD>> redo;

    public CacheRepository() {
        undo = new Stack<>();
        redo = new Stack<>();
    }

    @Override
    public void push(Storage storage, Pair<Object, CRUD> object) {
        switch (storage) {
            case REDO -> redo.push(object);
            case UNDO -> undo.push(object);
        }
    }

    @Override
    public Pair<Object, CRUD> pop(Storage storage) {
        return switch (storage) {
            case REDO -> redo.pop();
            case UNDO -> undo.pop();
        };
    }

    @Override
    public void clear(Storage storage) {
        switch (storage) {
            case REDO -> redo.clear();
            case UNDO -> undo.clear();
        }
    }

    @Override
    public Pair<Object, CRUD> peek(Storage storage) {
        return switch (storage) {
            case REDO -> redo.peek();
            case UNDO -> undo.peek();
        };
    }

    public void search(){

    }

}
