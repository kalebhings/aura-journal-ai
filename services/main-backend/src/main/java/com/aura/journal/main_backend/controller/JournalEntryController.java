package com.aura.journal.main_backend.controller;

import com.aura.journal.main_backend.model.JournalEntry;
import com.aura.journal.main_backend.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000") // Tells Java server to allow request from React app
@RestController // Tells Spring this is an API Controller
@RequestMapping("/api/entries") // All endpoints in this class will start with /api/entries
public class JournalEntryController {

    // Asks Spring to give the repository
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @GetMapping("/ping")
    public String ping() {
        return "journal backend is alive";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from the Journal Controller";
    }

    /**
     * This method creates a new text-only journal entry.
     * It listens for HTTP POST requests to /api/entries
     */
    @PostMapping
    public ResponseEntity<JournalEntry> createTextEntry(@RequestBody JournalEntry newEntry) {

        // Take the entry from the request and save it.
        // The .save() method is provided by JpaRepository
        // It saves the entry and returns the saved version (with the new ID)
        JournalEntry savedEntry = journalEntryRepository.save(newEntry);

        // Return a 200 OK response with the saved entry in the body
        return ResponseEntity.ok(savedEntry);
    }
}