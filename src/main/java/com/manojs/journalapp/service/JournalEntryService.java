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

    public Journal saveEntity(Journal journal, String userName) throws Exception {
        User user = userService.findUserByName(userName);
        if (user == null) {
            throw new Exception("user not found: " + userName);
        }
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

    public void deleteById(Long id, String username) {

        Optional<Journal> journal = journalEntryRepo.findByIdAndUsername(id, username);

        if (journal.isEmpty()) {
            return;
        }

        journalEntryRepo.delete(journal.get());
    }

    public Journal updateData(Long id, String username, Journal newEntry) {
        Optional<Journal> optionalJournal = journalEntryRepo.findByIdAndUsername(id, username);

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