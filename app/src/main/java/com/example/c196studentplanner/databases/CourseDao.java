package com.example.c196studentplanner.databases;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.c196studentplanner.models.Course;

import java.util.List;

public interface CourseDao {
    @Query("SELECT * FROM course_table WHERE course_id = :courseId ORDER BY course_id")
    Course getCourse(int courseId);

    @Query("SELECT * FROM course_table")
    List<Course> getAllCourses();

    @Query("SELECT * FROM course_table WHERE term_id_fk = :termId ORDER BY course_id")
    List<Course> getCoursesByTerm(int termId);


    @Insert
    void insertCourse(Course course);

    @Insert
    void insertAll(Course... course);

    @Update
    void updateCourse(Course course);

    @Delete
    void deleteCourse(Course course);

    @Query("DELETE FROM course_table")
    void nukeCourseTable();
}
