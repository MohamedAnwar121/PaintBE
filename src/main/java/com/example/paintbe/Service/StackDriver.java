package com.example.paintbe.Service;

import com.example.paintbe.Service.Shapes.Shape;

import java.util.ArrayList;
import java.util.Stack;


public class StackDriver implements IStackDriver {

    Stack<Triplet<Shape, ArrayList<Shape>, String>> undo;
    Stack<Triplet<Shape, ArrayList<Shape>, String>> redo;

    public StackDriver() {
        undo = new Stack<>();
        redo = new Stack<>();
    }

    @Override
    public void push(Stack<Triplet<Shape, ArrayList<Shape>, String>> stack,
                     Triplet<Shape, ArrayList<Shape>, String> object) {

        if (object.first != null) {
            Shape clonedObject = object.first.clone();
            clonedObject.setId(object.first.getId());

            Triplet<Shape, ArrayList<Shape>, String> triplet = new Triplet<>();
            triplet.first = clonedObject;
            triplet.third = object.getThird();
            stack.push(triplet);
        }

    }

    @Override
    public Triplet<Shape, ArrayList<Shape>, String> pop(Stack<Triplet<Shape, ArrayList<Shape>, String>> stack) {
        return stack.pop();
    }

    @Override
    public void clear(Stack<Triplet<Shape, ArrayList<Shape>, String>> stack) {
        stack.clear();
    }

    @Override
    public Triplet<Shape, ArrayList<Shape>, String> peek(Stack<Triplet<Shape, ArrayList<Shape>, String>> stack) {
        return stack.peek();
    }

    @Override
    public Stack<Triplet<Shape, ArrayList<Shape>, String>> getUndo() {
        return undo;
    }

    @Override
    public Stack<Triplet<Shape, ArrayList<Shape>, String>> getRedo() {
        return redo;
    }
}
