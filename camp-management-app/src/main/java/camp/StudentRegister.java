package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRegister {
    Scanner scan = new Scanner(System.in);
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> ScoreStore;
    /*                                       여기에 작업하시요                                    */
    public void functions() {
        // 여기에 작업하시요
        // 이름 받기
        String studentName = scan.next();
        Student student = new Student(sequence(INDEX_TYPE_STUDENT), studentName);
        studentStore.add(student);
        // 기능 구현 (필수 과목, 선택 과목)
        System.out.println("이름:"+ studentName + "등록중 ....");
        // 기다리기
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println("Student Register 2초 대기 문제");
        }
        // 끝
        scan = null;
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
    //
    private static String sequence(String type) {
        switch (type) {
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return INDEX_TYPE_STUDENT + studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return INDEX_TYPE_SUBJECT + subjectIndex;
            }
            default -> {
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
            }
        }
    }
    StudentRegister(int studentIndex,List<Student> studentStore,List<Subject> subjectStore,List<Score> ScoreStore){
        this.studentIndex = studentIndex;
        this.studentStore =studentStore;
        this.subjectStore = subjectStore;
        this.ScoreStore = ScoreStore;
    }
    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";
}

