package com.company.storage;

import com.company.entity.Document;

import java.util.ArrayList;
import java.util.List;

public class DocumentStorage implements Storage<Document> {

    ArrayList<Document> storage = new ArrayList<>();

    @Override
    public void addElement(Document document) {
        if(!storage.contains(document)) {
            storage.add(document);
            System.out.println("Документ добавлен");
        }
    }

    @Override
    public void deleteElement(Document document) {
        if(storage.contains(document)) {
            storage.remove(document);
            System.out.println("Документ удален");
        }
    }

    @Override
    public void updateElement(Document document) {
        deleteElement(getElement(document.getNumber()));
        addElement(document);
        System.out.println("Документ обновлен");
    }

    @Override
    public Document getElement(int number) {
        for(Document document: storage){
            if(document.getNumber()==number){
                System.out.println("Документ с номером " + number);
                return document;
            }
        }
        return null;
    }

    @Override
    public List<Document> getElements() {
        return storage;
    }
}

