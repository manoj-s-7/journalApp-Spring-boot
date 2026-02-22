package com.manojs.journalapp.service;

import com.manojs.journalapp.entity.Journal;
import com.manojs.journalapp.entity.User;
import com.manojs.journalapp.repository.JournalEntryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class JournalEntryService {

    private final JournalEntryRepo journalEntryRepo;
    private final UserService userService;

    public Journal saveEntity(Journal journal, String userName) {
        User user = userService.findUserByName(userName);
        journal.setDate(LocalDateTime.now());
        journal.setUser(user);
        Journal savedJournal = journalEntryRepo.save(journal);
        user.getJournalEntries().add(savedJournal);
        userService.saveUser(user); // add this
        return savedJournal;
    }

    public List<Journal> getAllEntries() {
        return journalEntryRepo.findAll();
    }

    public Optional<Journal> getById(Long id) {
        return journalEntryRepo.findById(id);
    }

    public boolean deleteById(Long id) {

        Optional<Journal> journal = journalEntryRepo.findById(id);

        if (journal.isEmpty()) {
            return false;
        }

        journalEntryRepo.delete(journal.get());
        return true;
    }

    public Journal updateData(Long id, Journal newEntry) {

        Optional<Journal> optionalJournal = journalEntryRepo.findById(id);

        if (optionalJournal.isEmpty()) {
            return null;
        }

        Journal existing = optionalJournal.get();

        if (newEntry.getTitle() != null && !newEntry.getTitle().isBlank()) {
            existing.setTitle(newEntry.getTitle());
        }

        if (newEntry.getContent() != null && !newEntry.getContent().isBlank()) {
            existing.setContent(newEntry.getContent());
        }

        return journalEntryRepo.save(existing);
    }
}