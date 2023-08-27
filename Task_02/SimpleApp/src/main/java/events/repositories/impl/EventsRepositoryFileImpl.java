package events.repositories.impl;


import events.models.Event;
import events.repositories.EventRepository;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EventsRepositoryFileImpl implements EventRepository {

    private final String fileName;

    public EventsRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }
    private int generatedId = 0;

    @Override
    public Event findById(int id) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            return reader.lines()
                    .map(line -> line.split("#"))
                    .map(parsed -> new Event(Integer.parseInt(parsed[0]), parsed[1], LocalDate.parse(parsed[2]) , LocalDate.parse(parsed[3])))
                    .collect(Collectors.toList());

        } catch (IOException e)  {
            throw new IllegalStateException("Проблемы с чтением из файла: " + e.getMessage());
        }
    }

    @Override
    public void save(Event model) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            model.setId(generatedId);

            writer.write(model.getId() + "#" + model.getTitle() + "#" + model.getStart() + "#" + model.getFinish());
            writer.newLine();

        } catch (IOException e) {
            throw new IllegalStateException("Проблемы с записью в файл: " + e.getMessage());
        }
        generatedId++;
    }

    @Override
    public void update(Event model) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Event findByTitle(String title) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            return reader.lines()
                    .map(line -> line.split("#"))
                    .filter(parsed -> parsed[1].equals(title))
                    .findFirst()
                    .map(parsed -> new Event(Integer.parseInt(parsed[0]), parsed[1], LocalDate.parse(parsed[2]) , LocalDate.parse(parsed[3])))
                    .orElse(null);

        } catch (IOException e)  {
            throw new IllegalStateException("Проблемы с чтением из файла: " + e.getMessage());
        }
    }
}
