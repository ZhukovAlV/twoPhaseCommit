package com.company.storage;

import java.util.List;

public interface Storage<T> {

    void addElement(T element);

    void deleteElement(T element);

    void updateElement(T element);

    T getElement(int number);

    List<T> getElements();
}

