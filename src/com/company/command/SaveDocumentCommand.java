package com.company.command;

import com.company.entity.Document;
import com.company.storage.DocumentStorage;

public class SaveDocumentCommand implements Command {
    Document document;
    DocumentStorage storage;

    public SaveDocumentCommand(Document document, DocumentStorage storage) {
        this.document = document;
        this.storage = storage;
    }

    @Override
    public void commit() {
        System.out.println("Документ №" + document.getNumber() + " сохранен");
        storage.addElement(document);
    }

    @Override
    public void rollback() {
        System.out.println("Для документа №" + document.getNumber() + " сохранение отменено");
        storage.deleteElement(document);
    }

    @Override
    public boolean prepare() {
        System.out.println("Возвращаем ПОЛОЖИТЕЛЬНЫЙ статус готовности хранилища для сохранения документа");
        return true;
    }
}
