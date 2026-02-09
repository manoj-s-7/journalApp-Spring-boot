package com.manojs.journalapp.controller;

import com.manojs.journalapp.entity.JournalEntry;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntryMap = new HashMap<>();

    @GetMapping(path = "get")
    public List<JournalEntry> getall() {
        return new ArrayList<>(journalEntryMap.values());
    }

    @PostMapping(path = "add")
    public boolean post(@RequestBody JournalEntry journalEntry) {
        journalEntryMap.put(journalEntry.getId(), journalEntry);
        return true;
    }

    @GetMapping(path = "getID/{id}")
    public JournalEntry getid(@PathVariable Long id) {
        return  journalEntryMap.get(id);
    }

    @DeleteMapping(path = "delete/{id}")
    public boolean deleteentry(@PathVariable Long id){
        journalEntryMap.remove(id);
        return true;
    }
    @PutMapping(path = "put/{id}")
    public boolean putentry(@PathVariable Long id,@RequestBody JournalEntry journalEntry){
        journalEntryMap.replace(id,journalEntry);
        return true;
    }
}

