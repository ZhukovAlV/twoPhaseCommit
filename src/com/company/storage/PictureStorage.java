package com.company.storage;

import com.company.entity.Picture;

import java.util.ArrayList;
import java.util.List;

public class PictureStorage implements Storage<Picture> {
    static ArrayList<Picture> storage = new ArrayList<>();

    @Override
    public void addElement(Picture element) {
        if(!storage.contains(element)) {
            storage.add(element);
            System.out.println("Картинка добавлена");
        }
    }

    @Override
    public void deleteElement(Picture element) {
        if(storage.contains(element)) {
            storage.remove(element);
            System.out.println("Картинка удалена");
        }
    }

    @Override
    public void updateElement(Picture element) {
        deleteElement(getElement(element.getNumber()));
        addElement(element);
        System.out.println("Картинка обновлена");
    }

    @Override
    public Picture getElement(int number) {
        for(Picture picture : storage){
            if(picture.getNumber()==number){
                System.out.println("Картинка с номером " + number);
                return picture;
            }
        }
        return null;
    }

    @Override
    public List<Picture> getElements() {
        return storage;
    }
}
