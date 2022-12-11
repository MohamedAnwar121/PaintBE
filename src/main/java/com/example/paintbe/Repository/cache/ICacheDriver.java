package com.example.paintbe.Repository;

import com.example.paintbe.Repository.cache.Storage;
import com.example.paintbe.Repository.db.CRUD;
import com.example.paintbe.Service.Pair;

/*
 * this interface manage the stack
 *  which is manage undo and redo function
 * */
public interface ICacheDriver {

    void push(Storage storage, Pair<Object, CRUD> object);

    Pair<Object, CRUD> pop(Storage storage);

    void clear(Storage storage);

    Pair<Object, CRUD> peek(Storage storage);

}
