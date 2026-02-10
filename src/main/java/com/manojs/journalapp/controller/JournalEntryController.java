package com.manojs.journalapp.controller;

import com.manojs.journalapp.entity.JournalEntry;
import com.manojs.journalapp.service.JournalEntryService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Optional<JournalEntry>> getid(@PathVariable ObjectId id) {
        Optional<JournalEntry> entry = journalEntryService.getById(id);

        if (entry.isEmpty()) {
            return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);
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


