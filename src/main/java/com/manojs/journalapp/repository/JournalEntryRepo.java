package com.manojs.journalapp.repository;

import com.manojs.journalapp.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepo extends JpaRepository<Journal, Long> {

}
