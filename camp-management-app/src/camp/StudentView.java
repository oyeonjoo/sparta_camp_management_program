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
        this.studentStore =studentStore;
        this.subjectStore = subjectStore;
        this.ScoreStore = ScoreStore;
    }
    public void functions() {
        // 여기에 작업하시요
        // 고유 번호, 이름을 조회한다.
        Scanner sc = new Scanner(System.in);
        System.out.println("학생 번호를 입력하세요.");
        String studentId = sc.nextLine();
        // 학생을 찾는다. 해당 학생의 학생번호와 이름을 출력한다.
        int num = 1;
        for(Student s : studentStore) {
            if(s.getStudentId().equals(studentId)) {
                num = 2;
                System.out.println("학생 번호 : " + s.getStudentId() + "학생 이름: " + s.getStudentName());
            }
        } if(num == 1) {
            System.out.println("학생을 찾지 못했습니다.");
        }
    }
}