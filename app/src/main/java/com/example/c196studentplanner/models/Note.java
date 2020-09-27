package com.example.c196studentplanner.models;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "note_table",
        foreignKeys = @ForeignKey(entity = Course.class, parentColumns = "course_id", childColumns = "course_id_fk",
                onDelete = CASCADE))
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int note_id;
    @ColumnInfo(name = "course_id_fk")
    private int course_id_fk;
    @ColumnInfo(name = "note_title")
    private String note_title;
    @ColumnInfo(name = "note_text")
    private String note_text;

    // Getters
    public int getNote_id() {
        return note_id;
    }

    // Setters
    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public int getCourse_id_fk() {
        return course_id_fk;
    }

    public void setCourse_id_fk(int course_id_fk) {
        this.course_id_fk = course_id_fk;
    }

    public String getNote_title() {
        return note_title;
    }

    public void setNote_title(String note_title) {
        this.note_title = note_title;
    }

    public String getNote_text() {
        return note_text;
    }

    public void setNote_text(String note_text) {
        this.note_text = note_text;
    }
}
