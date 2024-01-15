package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StudentView { //fgkjdnf
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> ScoreStore;
    StudentView(List<Student> studentStore,List<Subject> subjectStore,List<Score> ScoreStore){
        this.studentStore =studentStore;
        this.subjectStore = subjectStore;
        this.ScoreStore = ScoreStore;
    }
    public void functions() {
        // 여기에 작업하시요
        // 고유 번호, 이름을 조회한다.
        System.out.println("======== 수강생 목록 ========");
        System.out.println();
        System.out.printf("%-12s | %s\n", "ID ", "수강생 이름");

        for(Student s : studentStore) {
            System.out.printf("%-12s | %s\n", s.getStudentId(), s.getStudentName());
        }
    }
}