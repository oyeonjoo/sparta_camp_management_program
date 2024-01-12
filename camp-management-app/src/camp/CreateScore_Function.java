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
        student.getsubjectlist();
        // 과목 목록 조회
        System.out.println();
        System.out.println(student.getSubject(studentId).getSubjectName() +student.getSubject(studentId).getSubjectId());
        // 과목 입력
        System.out.println("과목 번호를 입력해주세요.");
        int inputSubject = sc.nextInt();
        // 회차 입력
        System.out.println("시험 회차를 입력해주세요.");
        int count = availableExamGroud();
        dataExists(student,inputSubject,count);
        // 점수 입력
        System.out.println("시험 점수를 입력해주세요");
        availableScore(studentId,inputSubject,count);

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
            System.out.println("학생이름"+st.getStudentName() + "과목이름:" + sb.getSubjectName() +"회차:"+count+ "점수:" + score);
            //변경 문제
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
            //System.out.println(ls.get(testNum).getScore());

            //
            //
        }
        else {
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


