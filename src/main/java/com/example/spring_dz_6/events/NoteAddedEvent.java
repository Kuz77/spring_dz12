package com.example.spring_dz_6.events;


import com.example.spring_dz_6.Note;
import org.springframework.context.ApplicationEvent;

public class NoteAddedEvent extends ApplicationEvent {
    private final Note note;

    public NoteAddedEvent(Object source, Note note) {
        super(source);
        this.note = note;
    }

    public Note getNote() {
        return note;
    }
}
