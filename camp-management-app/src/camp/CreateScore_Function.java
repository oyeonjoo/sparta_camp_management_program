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
        private String studentId;
        public void functions() {
        // 여기에 작업하시요

        }
    CreateScore_Function(String studentId,List<Student> studentStore,List<Subject> subjectStore,List<Score> ScoreStore){
        this.studentId = studentId;
        this.studentStore =studentStore;
        this.subjectStore = subjectStore;
        this.ScoreStore = ScoreStore;
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

        public void addStudentScore (String studentId){
            Scanner sc = new Scanner(System.in);
            Student student = new Student();
            student.getsubjectlist();
            // 과목 입력
            System.out.println("과목 번호를 입력해주세요.");
            int inputSubject = sc.nextInt();
            // 회차 입력
            System.out.println("시험 회차를 입력해주세요.");
            int inputExamGround = sc.nextInt();
            AvailableExamGroud(inputExamGround);
            // 점수 입력
            System.out.println("시험 점수를 입력해주세요");
            int inputScore = sc.nextInt();
            AvailableScore();
            student.addScore(inputSubject, student.getScorelist(inputSubject).add(inputExamGround, inputScore));
        }

        // 점수 등록 존재 여부 확인
        public void dataExists (){
            Student student = new Student();
            if(student.getScorelist(int index).exists = false){
                System.out.println("이미 점수가 입력되어있습니다. 다시 입력하세요.");
                addStudentScore(String studentId);
              }
            }

        public int AvailableExamGroud (int inputExamGround){
            if(inputExamGround <= 10 && inputExamGround > 0){
                return inputExamGround;
            }else {
                System.out.println("시험 회차를 1~10 값으로 입력해주세요");
                return AvailableExamGroud();
            }
        }

        public int AvailableScore (){
            if(inputScore <= 100 && inputScore >= 0){
                return inputScore;
            }else {
                System.out.println("시험 점수를 0 ~ 100 값으로 입력해주세요");
                return AvailableScore();
            }
        }

//         점수 -> 등급 클래스
        public String scoreToGrade(List<Score> scores){
            String grade = null;
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


