package com.company;

import com.company.command.Command;
import com.company.command.SaveDocumentCommand;
import com.company.command.SavePictureCommand;
import com.company.entity.Document;
import com.company.entity.Picture;
import com.company.storage.DocumentStorage;
import com.company.storage.PictureStorage;
import com.company.storage.Storage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    private static PictureStorage pictureStorage = new PictureStorage();
    private static DocumentStorage documentStorage = new DocumentStorage();

    public static void main(String[] args) throws MalformedURLException {
        // Статус для начала второй фазы
        boolean status = true;

        // Берем картинку и документ
        Picture picture = new Picture(1, new URL("http://сервер/хранилище_картинок"));
        Document document = new Document(1, "Важный документ", picture);

        // Список команд для работы с картинкой и документом
        ArrayList<Command> commands = new ArrayList<>();
        commands.add(new SavePictureCommand(picture, pictureStorage));
        commands.add(new SaveDocumentCommand(document, documentStorage));

        // На первой фазе проводится prepare, чтобы убедиться что данные запишутся
        for (Command command : commands) {
            if (!command.prepare()) status = false;
        }

        // Если все в порядке сохраняем (коммитим) результат на второй фазе, иначе отменяем
        for (Command command : commands) {
            if (status) command.commit();
            else command.rollback();
        }
    }
}
