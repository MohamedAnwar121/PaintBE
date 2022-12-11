package com.example.paintbe.Service;

import com.example.paintbe.Repository.ICacheDriver;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class StackDriver{

    /*Stack<Pair<Object, String>> undo;
    Stack<Pair<Object, String>> redo;

    public StackDriver() {
        undo = new Stack<>();
        redo = new Stack<>();
    }

    @Override
    public void push(Stack<Pair<Object, String>> stack, Pair<Object, String> object) {
        stack.push(object);
    }

    @Override
    public Pair<Object, String> pop(Stack<Pair<Object, String>> stack) {
        return stack.pop();
    }

    @Override
    public void clear(Stack<Pair<Object, String>> stack) {
        stack.clear();
    }

    @Override
    public Pair<Object, String> peek(Stack<Pair<Object, String>> stack) {
        return stack.peek();
    }

    @Override
    public Stack<Pair<Object, String>> getUndo() {
        return undo;
    }

    @Override
    public Stack<Pair<Object, String>> getRedo() {
        return redo;
    }*/
}
