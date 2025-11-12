package com.aura.journal.main_backend.repository;

import com.aura.journal.main_backend.model.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Tells Spring this is a Repository
public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {
    // That's it!
    // JpaRepository gives us all the common database methods for free:
    // .save(), .findById(), .findAll(), .deleteById(), etc.
}