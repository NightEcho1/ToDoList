package com.gui.todolist;

import java.time.LocalDate;
import java.util.Objects;

public class LocalEvent {
    private String description;
    private LocalDate date;

    public LocalEvent(LocalDate date, String description) {
        this.setDate(date);
        this.setDescription(description);
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "На: " + this.getDate() + " " + this.getDescription();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof LocalEvent)) return false;

        LocalEvent that = (LocalEvent) o;

        return Objects.equals(getDate(), that.getDate()) && Objects.equals(getDescription(), that.getDescription());

    }

    @Override

    public int hashCode() {

        return Objects.hash(getDate(), getDescription());

    }

}


