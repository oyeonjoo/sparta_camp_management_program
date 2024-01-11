package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRegister {
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> ScoreStore;

    StudentRegister(List<Student> studentStore,List<Subject> subjectStore,List<Score> ScoreStore){
        this.studentStore =studentStore;
        this.subjectStore = subjectStore;
        this.ScoreStore = ScoreStore;
    }
    public void functions() {
        // 여기에 작업하시요
    }
    public List<Student> GetstudentStore(){
        return this.studentStore;
    }
    public List<Subject> GetsubjectStore(){
        return this.subjectStore;
    }
    public List<Score> GetScoreStore(){
        return this.ScoreStore;
    }
}
