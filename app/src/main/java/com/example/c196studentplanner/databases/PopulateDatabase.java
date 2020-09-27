package com.example.c196studentplanner.databases;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c196studentplanner.models.Assessment;
import com.example.c196studentplanner.models.Course;
import com.example.c196studentplanner.models.Mentor;
import com.example.c196studentplanner.models.Note;
import com.example.c196studentplanner.models.Term;

public class PopulateDatabase extends AppCompatActivity {
    public static String LOG_TAG = "PopData";
    Term tempTerm1 = new Term();
    Term tempTerm2 = new Term();
    Term tempTerm3 = new Term();

    Course tempCourse1 = new Course();
    Course tempCourse2 = new Course();
    Course tempCourse3 = new Course();

    Assessment tempAssessment1 = new Assessment();
    Assessment tempAssessment2 = new Assessment();
    Assessment tempAssessment3 = new Assessment();

    Mentor tempMentor1 = new Mentor();
    Mentor tempMentor2 = new Mentor();
    Mentor tempMentor3 = new Mentor();

    Note tempNote1 = new Note();
    Note tempNote2 = new Note();
    Note tempNote3 = new Note();

    AppDB appDB;

    public void populate(Context context) {
        appDB = AppDB.getInstance(context);
        try {
            insertTerms();
            insertCourses();
            insertAssessments();
            insertMentors();
            insertNotes();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(LOG_TAG, "Populate DB Failed");
        }
    }

    private void insertNotes() {
    }

    private void insertMentors() {
    }

    private void insertAssessments() {
    }

    private void insertCourses() {
    }

    private void insertTerms() {
    }

}
