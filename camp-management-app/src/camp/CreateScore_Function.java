//
package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

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
        Student student = getStudentStore().get(studentId-1);
        student.getsubjectlist();
        // 과목 입력
        // 과목 목록 조회
        System.out.println("과목 번호를 입력해주세요.");
        int inputSubject = sc.nextInt();
        // 회차 입력
        System.out.println("시험 회차를 입력해주세요.");
        int count = availableExamGroud();
        dataExists(student,inputSubject,count);
        // 점수 입력
        System.out.println("시험 점수를 입력해주세요");
        availableScore(studentId-1,inputSubject,count);

    }

    // 점수 등록 존재 여부 확인
    public void dataExists (Student s,int sub,int index){
        if(s.getScorelist(sub).get(index).getScore()>=0){
            System.out.println("이미 점수가 입력되어있습니다. 다시 입력하세요.");
            addStudentScore(sub);
        }else{
            System.out.println("점수를 등록할 수 있습니다.");
        }
    }

    public int availableExamGroud(){
        int inputExamGround = sc.nextInt();
        if(inputExamGround <= 10 && inputExamGround > 0){
            return inputExamGround;
        }else {
            System.out.println("시험 회차를 1~10 값으로 입력해주세요");
            availableExamGroud();
        }
        return inputExamGround;
    }

    public void availableScore(int stid, int courseid, int count){
        int inputScore = sc.nextInt(); // 점수 받기
        if(inputScore <= 100 && inputScore >= 0){
            //리스트에 있는 학생 에 있는 코스 에 있는 , 회차에 값 넣기
            Student news = studentStore.get(stid);
            Score newScore = new Score("",count);
            news.addScore(courseid,newScore);
            studentStore.add(news);
        }else {
            System.out.println("시험 점수를 0 ~ 100 값으로 입력해주세요");
            availableScore(stid,courseid,count);
        }
    }

    //         점수 -> 등급 클래스
    public String scoreToGrade(Student s,int subject,int count){
        List tmp = s.getsubjectlist();
        Subject sub = (Subject) tmp.get(1);
        String subjectType = sub.getSubjectType();
        String grade = null;
        int scores = s.getScorelist(subject).get(count).getScore();
        switch (subjectType){
            case "MANDATORY":
                if(scores >= 95){
                    grade = "A";
                }else if ((scores >= 90)){
                    grade = "B";
                }else if (scores >= 80){
                    grade = "C";
                }else if (scores >= 70){
                    grade = "D";
                } else if (scores >= 60) {
                    grade = "F";
                }else {
                    grade = "N";
                }

            case "CHOICE":
                if(scores >= 90){
                    grade = "A";
                }else if ((scores >= 80)){
                    grade = "B";
                }else if (scores >= 70){
                    grade = "C";
                }else if (scores >= 60){
                    grade = "D";
                } else if (scores >= 50) {
                    grade = "F";
                }else {
                    grade = "N";
                }
        }
        return grade;
    }

}


