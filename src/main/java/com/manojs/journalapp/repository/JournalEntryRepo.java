package com.manojs.journalapp.repository;

import com.manojs.journalapp.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JournalEntryRepo extends JpaRepository<Journal, Long> {
    @Query("SELECT j FROM Journal j WHERE j.id = :id AND j.user.userName = :username")
    Optional<Journal> findByIdAndUsername(@Param("id") Long id, @Param("username") String username);
}
