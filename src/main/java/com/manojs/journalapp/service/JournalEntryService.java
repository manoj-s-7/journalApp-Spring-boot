package com.manojs.journalapp.service;

import com.manojs.journalapp.entity.JournalEntry;
import com.manojs.journalapp.repository.JournalEntryRepo;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JournalEntryService {

    private final JournalEntryRepo journalEntryRepo;

    public JournalEntry saveEntity(JournalEntry journalEntry) {
        journalEntry.setDate(LocalDateTime.now());
        return journalEntryRepo.save(journalEntry);
    }

    public List<JournalEntry> getallEntries() {
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> getById(ObjectId id) {
        return journalEntryRepo.findById(id);
    }

    public boolean deleteById(ObjectId id) {
        if (!journalEntryRepo.existsById(id)) {
            return false;
        }
        journalEntryRepo.deleteById(id);
        return true;
    }

    public JournalEntry updateData(ObjectId id, JournalEntry newEntry) {
        Optional<JournalEntry> optionalEntry = getById(id);

        if (optionalEntry.isEmpty()) {
            return null;
        }

        JournalEntry exists = optionalEntry.get();

        if (newEntry.getTitle() != null && !newEntry.getTitle().isBlank()) {
            exists.setTitle(newEntry.getTitle());
        }

        if (newEntry.getContent() != null && !newEntry.getContent().isBlank()) {
            exists.setContent(newEntry.getContent());
        }

        return journalEntryRepo.save(exists);
    }
}
