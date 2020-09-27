package com.example.c196studentplanner.models;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "assessment_table",
        foreignKeys = @ForeignKey(entity = Course.class, parentColumns = "course_id", childColumns = "course_id_fk",
                onDelete = CASCADE)
)
public class Assessment {
    @PrimaryKey(autoGenerate = true)
    private int assessment_id;
    @ColumnInfo(name = "course_id_fk")
    private int course_id_fk;
    @ColumnInfo(name = "assessment_title")
    private String assessment_title;
    @ColumnInfo(name = "assessment_type")
    private String assessment_type;
    @ColumnInfo(name = "due_date")
    private Date due_date;

    // Getters
    public int getAssessment_id() {
        return assessment_id;
    }
    public int getCourse_id_fk() {
        return course_id_fk;
    }

    public String getAssessment_title() {
        return assessment_title;
    }

    public String getAssessment_type() {
        return assessment_type;
    }

    public Date getDue_date() {
        return due_date;
    }

    // Setters
    public void setAssessment_id(int assessment_id) {
        this.assessment_id = assessment_id;
    }

    public void setCourse_id_fk(int course_id_fk) {
        this.course_id_fk = course_id_fk;
    }

    public void setAssessment_title(String assessment_title) {
        this.assessment_title = assessment_title;
    }

    public void setAssessment_type(String assessment_type) {
        this.assessment_type = assessment_type;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }
}
