package com.aura.journal.main_backend.model;

import jakarta.persistence.*; // For database annotations
import lombok.Data; // For automatic getters/setters

import java.time.LocalDateTime;
import java.util.List;

@Data // Lombok annotation: auto-creates getters, setters, toString, etc.
@Entity // JPA annotation: Tells Spring this class is a database table.
@Table(name = "journal_entries") // Specifies the actual table name
public class JournalEntry {

    @Id // Marks this field as the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID
    private Long id;

    @Column(columnDefinition = "TEXT") // Use a TEXT type for long entries
    private String entryText;

    private String sentiment; // We'll store "positive", "negative", etc. here

    private LocalDateTime createdAt;

    // This sets up the one-to-many relationship with images
    @OneToMany(mappedBy = "journalEntry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntryImage> images;

    // This sets up the one-to-many relationship with audio
    @OneToMany(mappedBy = "journalEntry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntryAudio> audios;

    // This method automatically sets the timestamp before saving
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}