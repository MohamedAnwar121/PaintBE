package com.example.paintbe.Service;

import com.example.paintbe.Service.Shapes.Shape;

import java.util.ArrayList;
import java.util.Stack;

/*
* this interface manage the stack
*  which is manage undo and redo function
* */
public interface IStackDriver {

    void push(Stack<Triplet<Shape, ArrayList<Shape>,String>> stack, Triplet<Shape, ArrayList<Shape>,String> object);

    Triplet<Shape, ArrayList<Shape>,String> pop(Stack<Triplet<Shape, ArrayList<Shape>,String>> stack);

    void clear(Stack<Triplet<Shape, ArrayList<Shape>,String>> stack);

    Triplet<Shape, ArrayList<Shape>,String> peek(Stack<Triplet<Shape, ArrayList<Shape>,String>> stack);

    Stack<Triplet<Shape, ArrayList<Shape>,String>> getUndo();

    Stack<Triplet<Shape, ArrayList<Shape>,String>> getRedo();

}
