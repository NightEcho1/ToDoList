package com.gui.todolist;

import java.time.LocalDate;

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
}
