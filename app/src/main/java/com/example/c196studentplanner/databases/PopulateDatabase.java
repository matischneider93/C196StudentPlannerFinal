package com.example.c196studentplanner.databases;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c196studentplanner.models.Assessment;
import com.example.c196studentplanner.models.Course;
import com.example.c196studentplanner.models.Mentor;
import com.example.c196studentplanner.models.Note;
import com.example.c196studentplanner.models.Term;

import java.util.Calendar;
import java.util.List;

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
        List<Course> courseList = appDB.courseDao().getCourseList();
        if (courseList == null) return;

        tempNote1.setNote_title("Note 1");
        tempNote1.setNote_text("New Note for Course");
        tempNote1.setCourse_id_fk(courseList.get(0).getCourse_id());

        tempNote2.setNote_title("Note 2");
        tempNote2.setNote_text("New Note for Course");
        tempNote2.setCourse_id_fk(courseList.get(0).getCourse_id());

        tempNote3.setNote_title("Note 1");
        tempNote3.setNote_text("New Note for Course");
        tempNote3.setCourse_id_fk(courseList.get(1).getCourse_id());

        appDB.noteDao().insertAll(tempNote1, tempNote2, tempNote3);


    }

    private void insertMentors() {
        List<Course> courseList = appDB.courseDao().getCourseList();
        if (courseList == null) return;

        tempMentor1.setMentor_name("Bob Bobert");
        tempMentor1.setMentor_phone("666-6666");
        tempMentor1.setMentor_email("bob@bobert.org");
        tempMentor1.setCourse_id_fk(courseList.get(0).getCourse_id());

        tempMentor2.setMentor_name("Boberta Bobert");
        tempMentor2.setMentor_phone("646-6666");
        tempMentor2.setMentor_email("boberta@bobert.org");
        tempMentor2.setCourse_id_fk(courseList.get(1).getCourse_id());

        tempMentor3.setMentor_name("Bobertino Boberts");
        tempMentor3.setMentor_phone("648-1116");
        tempMentor3.setMentor_email("bobertino@boberts.org");
        tempMentor3.setCourse_id_fk(courseList.get(2).getCourse_id());

        appDB.mentorDao().insertAll(tempMentor1, tempMentor2, tempMentor3);
    }

    private void insertAssessments() {
    }

    private void insertCourses() {
        Calendar start;
        Calendar end;
        List<Term> termList = appDB.termDao().getTermList();
        if (termList == null) return;

        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -2);
        end.add(Calendar.MONTH, 1);
        tempCourse1.setCourse_name("C196 - Android App");
        tempCourse1.setCourse_start(start.getTime());
        tempCourse1.setCourse_end(end.getTime());
        tempCourse1.setCourse_notes("Notes for C196");
        tempCourse1.setCourse_status("Active");
        tempCourse1.setTerm_id_fk(termList.get(0).getTerm_id());


        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -2);
        end.add(Calendar.MONTH, 1);
        tempCourse2.setCourse_name("C154 -  Capstone");
        tempCourse2.setCourse_start(start.getTime());
        tempCourse2.setCourse_end(end.getTime());
        tempCourse2.setCourse_notes("capstone notes");
        tempCourse2.setCourse_status("Active");
        tempCourse2.setTerm_id_fk(termList.get(01).getTerm_id());


        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -2);
        end.add(Calendar.MONTH, 1);
        tempCourse3.setCourse_name("C154 -  Capstone");
        tempCourse3.setCourse_start(start.getTime());
        tempCourse3.setCourse_end(end.getTime());
        tempCourse3.setCourse_notes("capstone notes");
        tempCourse3.setCourse_status("Active");
        tempCourse3.setTerm_id_fk(termList.get(0).getTerm_id());


    }

    private void insertTerms() {
        Calendar start;
        Calendar end;

        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, -2);
        end.add(Calendar.MONTH, 1);
        tempTerm1.setTerm_name("Fall 2020");
        tempTerm1.setTerm_start(start.getTime());
        tempTerm1.setTerm_end(end.getTime());

        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 3);
        end.add(Calendar.MONTH, 6);
        tempTerm2.setTerm_name("Spring 2021");
        tempTerm2.setTerm_start(start.getTime());
        tempTerm2.setTerm_end(end.getTime());

        start = Calendar.getInstance();
        end = Calendar.getInstance();
        start.add(Calendar.MONTH, 7);
        end.add(Calendar.MONTH, 9);
        tempTerm3.setTerm_name("Summer 2021");
        tempTerm3.setTerm_start(start.getTime());
        tempTerm3.setTerm_end(end.getTime());

        appDB.termDao().insertAll(tempTerm1, tempTerm2, tempTerm3);

    }

}
