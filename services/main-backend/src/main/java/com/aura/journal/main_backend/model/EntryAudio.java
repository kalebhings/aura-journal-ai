package com.aura.journal.main_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "entry_audios")
public class EntryAudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String audioUrl; // This will be the S3 URL

    @Column(columnDefinition = "TEXT")
    private String transcription; // For the Whisper AI transcription

    // This links the audio back to its parent journal entry
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "journal_entry_id")
    private JournalEntry journalEntry;
}