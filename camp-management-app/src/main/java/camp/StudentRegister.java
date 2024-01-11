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
    int compulsarypaper_num = 0;
    int optionalpaper_num =0;
    /*                                       여기에 작업하시요                                    */
    public void functions() {
        // 여기에 작업하시요
        // 이름 받기
        String studentName = scan.next();
        Student student = new Student(sequence(INDEX_TYPE_STUDENT), studentName);

        // 기능 구현 (필수 과목, 선택 과목)
        System.out.println("과목을 선택해주세요");
        //과목 리스트 프린트 하기.
        boolean flag = true;
        while(flag) {
            for (int i = 0; i < subjectStore.size(); i++) {
                System.out.println(i + " : " + subjectStore.get(i).getSubjectName() + " : " + subjectStore.get(i).getSubjectType());
            }
            System.out.println("9 를 누르거나 더큰수 를 눌러 뒤로 가기");
            System.out.println("넣은 필수과목수 : "+compulsarypaper_num);
            System.out.println("넣은 선택과목수 : "+optionalpaper_num);
            int a = scan.nextInt();
            if(a>=9){
                if(optionalpaper_num<2&&compulsarypaper_num<3){
                    System.out.println("필수과목 3개, 선택과목 2개 미만입니다, 과목을 더 넣어 주세요");
                    System.out.println("이해 하셨습니까?(아무키나 넣고 나가기)");
                    a = scan.nextInt();
                }
                else {
                    System.out.println("나갑니다");
                    flag = false;
                }
            }
            else {
                if(student.getsubjectlist().contains(subjectStore.get(a))){
                    System.out.println(subjectStore.get(a).getSubjectName() + "은 이미 추가된 과목입니다");
                    System.out.println("이해 하셨습니까?(아무키나 넣고 나가기)");
                    a = scan.nextInt();
                }
                else {
                    student.addSubject(subjectStore.get(a));
                    CheckpaperType(a);
                    System.out.println(subjectStore.get(a).getSubjectName() + "을 추가 했습니다");
                }
            }
        }
        //
        studentStore.add(student);
        System.out.println("이름:"+ studentName + "(대략 2초)등록중 ....");
        // 기다리기
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println("Student Register 2초 대기 문제");
        }
        // 끝
        scan = null;
    }

    private void CheckpaperType(int a) {
        if(subjectStore.get(a).getSubjectType().equals("MANDATORY")){
            compulsarypaper_num++;
        }
        else {
            optionalpaper_num++;
        }
    }
    //
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

