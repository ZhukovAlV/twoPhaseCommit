package com.company.command;

import com.company.entity.Picture;
import com.company.storage.PictureStorage;

public class SavePictureCommand implements Command {
    private Picture picture;
    private PictureStorage storage;

    public SavePictureCommand(Picture picture, PictureStorage storage) {
        this.picture = picture;
        this.storage = storage;
    }

    @Override
    public void commit() {
        System.out.println("Картинка №" + picture.getNumber() + " сохранена");
        storage.addElement(picture);
    }

    @Override
    public void rollback() {
        System.out.println("Для картинки №" + picture.getNumber() + " сохранение отменено");
        storage.deleteElement(picture);
    }

    @Override
    public boolean prepare() {
        System.out.println("Возвращаем ПОЛОЖИТЕЛЬНЫЙ статус готовности хранилища для сохранения картинки");
        return true;
    }
}

