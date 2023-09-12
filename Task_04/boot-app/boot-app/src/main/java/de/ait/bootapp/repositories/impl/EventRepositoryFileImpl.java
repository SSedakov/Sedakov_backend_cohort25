package de.ait.bootapp.repositories.impl;


import de.ait.bootapp.dto.NewEventDto;
import de.ait.bootapp.models.Event;
import de.ait.bootapp.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class EventRepositoryFileImpl implements EventRepository {
    private final String fileName;

    public EventRepositoryFileImpl(@Value("C:\\Education\\Backend\\Lesson6\\hw\\boot-app\\boot-app\\evens.txt") String fileName) {
        this.fileName = fileName;
    }


    @Override
    public List<Event> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            return reader.lines()
                    .map(line -> line.split("#"))
                    .map(parsed -> new Event(parsed[0], parsed[1]))
                    .collect(Collectors.toList());

        } catch (IOException e)  {
            throw new IllegalStateException("Проблемы с чтением из файла: " + e.getMessage());
        }
    }


    @Override
    public void save(NewEventDto event) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(event.getEventName() + "#" + event.getTitle());
            writer.newLine();

        } catch (IOException e) {
            throw new IllegalStateException("Проблемы с записью в файл: " + e.getMessage());
        }
    }
}
