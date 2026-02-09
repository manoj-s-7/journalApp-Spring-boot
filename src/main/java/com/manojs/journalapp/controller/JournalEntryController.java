package com.manojs.journalapp.controller;

import com.manojs.journalapp.entity.JournalEntry;
import com.manojs.journalapp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping(path = "get")
    public List<JournalEntry> getall() {
        return journalEntryService.getallEntries();
    }

    @PostMapping(path = "add")
    public JournalEntry createEntry(@RequestBody JournalEntry journalEntry) {
        journalEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntity(journalEntry);
        return journalEntry;
    }

    @GetMapping(path = "getid/{id}")
    public Optional<JournalEntry> getid(@PathVariable ObjectId id) {
        return journalEntryService.getById(id);
    }

    @DeleteMapping(path = "delete/{id}")
    public boolean deleteentry(@PathVariable ObjectId id) {
        return journalEntryService.deleteById(id);
    }

    @PutMapping(path = "put/{id}")
    public JournalEntry putentry(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.getById(id).orElse(null);
        if (newEntry != null){
            old.setTitle(newEntry.getTitle() !=null && !newEntry.getTitle().equals("")?newEntry.getTitle():old.getTitle());
            old.setContent(newEntry.getContent() !=null && !newEntry.getContent().equals("")?newEntry.getContent():old.getContent());
        }
        journalEntryService.saveEntity(old);
        return old;
    }
}


