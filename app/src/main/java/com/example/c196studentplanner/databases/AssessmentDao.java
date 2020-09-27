package com.example.c196studentplanner.databases;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.c196studentplanner.models.Assessment;

import java.util.List;

public interface AssessmentDao {
    @Query("SELECT * FROM assessment_table ORDER BY assessment_id")
    List<Assessment> getAssessmentList();

    @Query("SELECT * FROM assessment_table WHERE assessment_id = :assessmentId ORDER BY assessment_id")
    Assessment getAssessment(int assessmentId);

    @Query("SELECT * FROM assessment_table")
    List<Assessment> getAllAssessments();

    @Query("SELECT * FROM assessment_table WHERE course_id_fk = :courseId ORDER BY assessment_id")
    List<Assessment> getAssessmentsByCourse(int courseId);


    @Insert
    void insertAssessment(Assessment assessment);

    @Insert
    void insertAll(Assessment... assessment);

    @Update
    void updateAssessment(Assessment assessment);

    @Delete
    void deleteAssessment(Assessment assessment);

    @Query("DELETE FROM assessment_table")
    void nukeAssessmentTable();
}
