package com.manojs.journalapp.controller;

import com.manojs.journalapp.entity.Journal;
import com.manojs.journalapp.entity.User;
import com.manojs.journalapp.service.JournalEntryService;
import com.manojs.journalapp.service.UserService;
import lombok.RequiredArgsConstructor;
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

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<Journal>> getall() {
        return ResponseEntity.ok(journalEntryService.getAllEntries());
    }

    @PostMapping(path = "/{userName}")
    public ResponseEntity<Journal> createEntry(@RequestBody Journal journal, @PathVariable final String userName) {
        try {
            Journal saved = journalEntryService.saveEntity(journal, userName);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/{userName}")
    public ResponseEntity<List<Journal>> getAllJournalEntriesOfUser(@PathVariable String userName) {
        User userByName = userService.findUserByName(userName);
        if (userByName == null) {
            return ResponseEntity.notFound().build();
        }
        List<Journal> journalEntries = userByName.getJournalEntries();
        return ResponseEntity.ok(journalEntries);
    }

    @DeleteMapping(path = "/{username}/{id}")
    public ResponseEntity<?> deleteEntry(@PathVariable Long id, @PathVariable final String username) {

        Optional<Journal> entry = journalEntryService.getById(id);

        if (entry.isEmpty()) {
            return new ResponseEntity<>("Journal entry not found", HttpStatus.NOT_FOUND);
        }

        journalEntryService.deleteById(id, username);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{username}/{id}")
    public ResponseEntity<?> putEntry(@PathVariable Long id, @RequestBody Journal newEntry, @PathVariable final String username) {
        Journal updated = journalEntryService.updateData(id, username, newEntry);
        if (updated == null) {
            return new ResponseEntity<>("Journal entry not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(updated);
    }
}


