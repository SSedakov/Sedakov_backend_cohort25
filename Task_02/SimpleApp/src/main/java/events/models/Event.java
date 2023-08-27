package events.models;

import java.time.LocalDate;
import java.util.Objects;

public class Event {
  private int id;
  private String title;
  private LocalDate start;
  private LocalDate finish;

    public Event(int id, String title, LocalDate start, LocalDate finish) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.finish = finish;
    }

    public Event(String title, LocalDate start, LocalDate finish) {
        this.title = title;
        this.start = start;
        this.finish = finish;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getFinish() {
        return finish;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setFinish(LocalDate finish) {
        this.finish = finish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id && Objects.equals(title, event.title) && Objects.equals(start, event.start) && Objects.equals(finish, event.finish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, start, finish);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                '}';
    }
}
