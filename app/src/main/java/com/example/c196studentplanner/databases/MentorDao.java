package com.example.c196studentplanner.databases;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.c196studentplanner.models.Mentor;

import java.util.List;

public interface MentorDao {
    @Query("SELECT * FROM mentor_table WHERE mentor_id = :mentorId ORDER BY mentor_id")
    Mentor getMentor(int mentorId);

    @Query("SELECT * FROM mentor_table")
    List<Mentor> getAllMentors();

    @Query("SELECT * FROM mentor_table WHERE course_id_fk = :courseId ORDER BY course_id_fk")
    List<Mentor> getMentorsByCourse(int courseId);


    @Insert
    void insertMentor(Mentor mentor);

    @Insert
    void insertAll(Mentor... mentor);

    @Update
    void updateMentor(Mentor mentor);

    @Delete
    void deleteMentor(Mentor mentor);

    @Query("DELETE FROM mentor_table")
    void nukeMentorTable();
}
