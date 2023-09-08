package de.ait.bootapp.models;

public class Event {
    String eventName;
    String title;
    public Event(String eventName, String title) {
        this.eventName = eventName;
        this.title = title;
    }

    public String getEventName() {
        return eventName;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
