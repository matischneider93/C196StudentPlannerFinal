package com.example.c196studentplanner.databases;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.c196studentplanner.models.Note;

import java.util.List;

public interface NoteDao {
    @Query("SELECT * FROM note_table WHERE note_id = :noteId ORDER BY note_id")
    Note getNote(int noteId);

    @Query("SELECT * FROM note_table")
    List<Note> getAllNotes();

    @Query("SELECT * FROM note_table WHERE course_id_fk = :courseId ORDER BY note_id")
    List<Note> getNotesByCourse(int courseId);


    @Insert
    void insertNote(Note note);

    @Insert
    void insertAll(Note... note);

    @Update
    void updateNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Query("DELETE FROM note_table")
    void nukeNoteTable();
}
