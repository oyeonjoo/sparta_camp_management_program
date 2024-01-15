package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StudentView {
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> ScoreStore;
    StudentView(List<Student> studentStore,List<Subject> subjectStore,List<Score> ScoreStore){
        this.studentStore = studentStore;
        this.subjectStore = subjectStore;
        this.ScoreStore = ScoreStore;
    }
    public void functions() { // 01.15 17:44 수정
        // 여기에 작업하시요
        // 고유 번호, 이름, 수강 과목을 조회한다.
        System.out.println("============================ 수강생 목록 ============================");
        System.out.println();
        System.out.printf("%-12s | %-12s | %s\n", "ID ", "수강생 이름", "수강 과목");
        if (studentStore.size() > 0) {
            for(Student s1 : studentStore) {
                System.out.printf("%-12s | %-12s  |", s1.getStudentId(), s1.getStudentName());

                for (int i = 0; i < s1.getsubjectlist().size(); i++) {
                    System.out.printf(" %s", s1.getsubjectlist().get(i).getSubjectName());
                }
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("================================ 끝 ================================");
    }
}