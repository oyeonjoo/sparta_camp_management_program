//
package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CreateScore_Function {
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> ScoreStore;
    private int studentId;
    public void functions() {
        // 여기에 작업하시요

    }
    CreateScore_Function(int studentId,List<Student> studentStore,List<Subject> subjectStore,List<Score> ScoreStore){
        this.studentId = studentId;
        this.studentStore =studentStore;
        this.subjectStore = subjectStore;
        this.ScoreStore = ScoreStore;
    }
    ////
    public List<Student> getStudentStore(){
        return this.studentStore;
    }
    public List<Subject> getSubjectStore(){
        return this.subjectStore;
    }
    public List<Score> getScoreStore(){
        return this.ScoreStore;
    }

    Scanner sc = new Scanner(System.in);

    public void addStudentScore (int studentId){
        Student student = getStudentStore().get(studentId);
        System.out.print(student.getStudentId() + " " + student.getStudentName() + " " );
        System.out.println("시험 점수를 등록합니다.");
        student.getsubjectlist();
        // 과목 목록 조회
        System.out.println();
        int i = 1;
        for(Subject subject : student.getsubjectlist()){
            System.out.println(i++ + ". " + subject.getSubjectName());
        }
        // 과목 입력
        System.out.println("과목 번호를 입력해주세요.");
        // 과목 범위 확인
        int inputSubject = availableSubject(); // 과목 범위 확인
        System.out.print(student.getSubject(inputSubject).getSubjectName());
        System.out.println(" 을 선택하셨습니다.");

        // 회차 입력
        System.out.println("시험 회차를 입력해주세요.");
        int count = availableExamGroud(); // 회차 범위 확인
        dataExists(student,inputSubject,count); // 등록 내역 확인
        // 점수 입력
        System.out.println("시험 점수를 입력해주세요");
        int inputScore = availableScore(); // 점수 범위 확인
        addScoreToStudent(studentId,inputSubject,count,inputScore); // 점수 등록

    }

    public int availableSubject (){ // 범위 오류 해결??? 완
        Student student = getStudentStore().get(studentId);
        int num = sc.nextInt() - 1;
        if(num >= student.getsubjectlist().size() || num < 0){
            System.out.println("입력하신 항목이 없습니다. 다시 입력해주세요.");
            return availableSubject();
        }else {
            return num;
        }
    }

    // 점수 등록 존재 여부 확인
    public void dataExists (Student s,int sub,int index){
        if(s.getScorelist(sub).get(index).getScore()>=0){
            System.out.println("이미 점수가 입력되어있습니다. 다시 입력하세요.");
            addStudentScore(studentId);
        }else{
            System.out.print(index + 1 + " 회차 ");
            System.out.println("점수를 등록할 수 있습니다.");
        }
    }

    public int availableExamGroud(){ // 오류발생 해결
        int inputExamGround = sc.nextInt() - 1;
        if(inputExamGround < 10 && inputExamGround > -1){
            return inputExamGround;
        }else {
            System.out.println("시험 회차를 1~10 값으로 입력해주세요");
            return availableExamGroud();
        }
//        return inputExamGround;

    }

    public int availableScore(){
        int inputScore = sc.nextInt();
        if (inputScore <= 100 && inputScore >= 0){
            return inputScore;
        }else {
            System.out.println("시험 점수를 0~100 값으로 입력해주세요.");
            return availableScore();
        }
    }

    public void addScoreToStudent(int stid, int courseid, int count, int inputScore){ // 범위 오류 해결 완료
            //리스트에 있는 학생 에 있는 코스 에 있는 , 회차에 값 넣기
            // 학생 -> map<Integer,List<Score>> -> List<Score> -> Score -> Score 값 int
            //학생 가져오기
            Student st = studentStore.get(stid);
            // 학생 -> 과목 -> 과목이름
            Subject sb = st.getSubject(courseid);
            // 학생 -> map 받기
            HashMap map = st.getMap();
            List<Score> ls = st.getScorelist(courseid);
            //score (클라스)
            // score 안에 있는 값 int 정수
            Score sc = new Score("SC"+courseid,inputScore);
            int score = sc.getScore();
            // 점수를 등급으로 치환
            String grade = scoreToGrade(st, sb.getSubjectType(), score);
            System.out.println(st.getStudentName() + ":  " + sb.getSubjectName() + " " + (count + 1) + "회차| "+ score + "점 " + grade + "등급");
            //리스트 등록 문제!!!!!!!!!!!!!!!!!
            try {
            ls.set(count,sc); // 리스트 안에 score 변병
        }catch (Exception e){
            System.out.println("ls.set(count,sc); 에러");
        }
        try{
            map.put(courseid,ls);  // map 안에 리스트 넣기
        }catch (Exception e){
            System.out.println(" map.put(courseid,ls); 에러");
        }
        try {
            st.SetMap(map); // student 안에 map 넣기
        }catch (Exception e){
            System.out.println(" st.SetMap(map);; 에러");
        }
        //
        try {
            studentStore.set(stid,st); // 학생 리스트 안에 학생 변경
        }catch (Exception e){
            System.out.println(" studentStore.set(studentId,st) 에러");
        }
//        System.out.println(ls.get(testNum).getScore());

    }

    //         점수 -> 등급 클래스
    public String scoreToGrade(Student s, String subject, int score){ // 구현 완료
        List tmp = s.getsubjectlist();
        Subject sub = (Subject) tmp.get(1);
        String subjectType = subject;
        String grade = null;
//        score = s.getScorelist(subject).get(count).getScore();
        switch (subjectType){
            case "MANDATORY":
                if(score >= 95){
                    grade = "A";
                }else if ((score >= 90)){
                    grade = "B";
                }else if (score >= 80){
                    grade = "C";
                }else if (score >= 70){
                    grade = "D";
                } else if (score >= 60) {
                    grade = "F";
                }else {
                    grade = "N";
                }
            break;

            case "CHOICE":
                if(score >= 90){
                    grade = "A";
                }else if ((score >= 80)){
                    grade = "B";
                }else if (score >= 70){
                    grade = "C";
                }else if (score >= 60){
                    grade = "D";
                } else if (score >= 50) {
                    grade = "F";
                }else {
                    grade = "N";
                }
            break;
        }
        return grade;
    }

}

