package com.manojs.journalapp.controller;

import com.manojs.journalapp.entity.JournalEntry;
import com.manojs.journalapp.service.JournalEntryService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "journal")
@RequiredArgsConstructor
public class JournalEntryController {

    private final JournalEntryService journalEntryService;

    @GetMapping
    public ResponseEntity<List<JournalEntry>> getall() {
        return ResponseEntity.ok(journalEntryService.getallEntries());
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry journalEntry) {
        JournalEntry saved = journalEntryService.saveEntity(journalEntry);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<JournalEntry> getid(@PathVariable ObjectId id) {
        JournalEntry entry = journalEntryService.getById(id).orElse(null);

        if (entry == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entry);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteentry(@PathVariable ObjectId id) {
        Optional<JournalEntry> entry = journalEntryService.getById(id);

        if (entry.isEmpty()) {
            return new ResponseEntity<>("Journal entry not found", HttpStatus.NOT_FOUND);
        }

        journalEntryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> putentry(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
        JournalEntry updated = journalEntryService.updateData(id, newEntry);

        if (updated == null) {
            return new ResponseEntity<>("Journal entry not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(updated);
    }
}


