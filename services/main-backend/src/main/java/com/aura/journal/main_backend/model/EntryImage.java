package com.aura.journal.main_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "entry_images")
public class EntryImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl; // This will be the S3 URL

    @Column(columnDefinition = "TEXT")
    private String imageCaption; // For the AI-generated caption

    // This links the image back to its parent journal entry
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "journal_entry_id")
    private JournalEntry journalEntry;
}