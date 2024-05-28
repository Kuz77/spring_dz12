package com.example.spring_dz_6.listeners;

import com.example.spring_dz_6.events.NoteAddedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NoteAddedListener {

    @EventListener
    public void handleNoteAddedEvent(NoteAddedEvent event) {
        System.out.println("Note added: " + event.getNote().getTitle());

    }
}

