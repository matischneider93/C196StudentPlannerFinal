package com.example.c196studentplanner.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.c196studentplanner.models.Assessment;
import com.example.c196studentplanner.models.Course;
import com.example.c196studentplanner.models.Mentor;
import com.example.c196studentplanner.models.Note;
import com.example.c196studentplanner.models.Term;
import com.example.c196studentplanner.utils.Converters;

@Database(entities = {Term.class, Course.class, Assessment.class, Note.class, Mentor.class}, exportSchema = false, version = 1)
@TypeConverters(Converters.class)
public abstract class AppDB extends RoomDatabase {
    private static final String DB_NAME = "app_db";
    private static AppDB instance;

    public static synchronized AppDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDB.class, DB_NAME).allowMainThreadQueries().build();
        }
        return instance;
    }

    // Dao Calls
    public abstract TermDao termDao();
    public abstract CourseDao courseDao();
    public abstract AssessmentDao assessmentDao();
    public abstract NoteDao noteDao();
    public abstract MentorDao mentorDao();


}
