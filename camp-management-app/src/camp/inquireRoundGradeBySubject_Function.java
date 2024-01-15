// 1/15 5:40 최종 yb inquire변경
package camp;

import camp.model.Student;
import camp.model.Subject;
import camp.model.Score;

import java.util.List;
import java.util.Scanner;

public class  inquireRoundGradeBySubject_Function{

    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> ScoreStore;
    private String studentId;
    public void functions() {
        // hashmap scoremap (과목id, 회차별 점수List)
        //scoreStore List(index = 회차, value = 점수)
        //얘가 student에 들어갈 거임
        // 여기에 작업하시요

        Scanner scan = new Scanner(System.in);
        System.out.println("수강생의 고유 번호를 입력하세요 ex) ST1 : ");
        System.out.println(studentStore);
        String sId = scan.nextLine(); // 관리할 수강생 고유 번호

        Student stu = new Student("","");
        for(Student s : studentStore){
            if(s.getStudentId().equals(sId)){
                stu = s;
                break;
            }
        }
        //Student stu = (Student)
            /*studentStore.stream()
                    .filter((Student student)-> student.getStudentId().equals(sId))
                    .forEach(student-> System.out.println(student.getStudentId()));*/


        // 기능 구현 (조회할 특정 과목)
        System.out.print("\n조회할 특정 과목을 입력하세요...");
        String subjectName = scan.nextLine();
        //subjectName = 1

        int sListNum=0;
        sListNum=Integer.parseInt(subjectName);
        //sListNum=1 학생이 듣는 리스트에서 과목 번호인거임 != 과목 고유번호

        String subjectType="";
        subjectName="SU"+subjectName;


        subjectType=stu.getSubject(sListNum-1).getSubjectType();


        System.out.println("회차별 등급을 조회합니다...");
        //studentId = string 타입, ST1이런식임
        //string => int st떼어내고 바꾸기
        String a=sId.substring(2);
        int studentIdInteger=Integer.parseInt(a);

        CreateScore_Function c = new CreateScore_Function(
                studentIdInteger,
                studentStore,
                subjectStore,
                ScoreStore
        );


        boolean hasScore=false;
        int count=1;

        //spring Security=SU7, sLIstNum=5
        //scoreList = 0부터 시작 0=SU1 java임
        for(Score s : stu.getScorelist(sListNum-1)){

            if(s.getScore()!=-1) {
                System.out.println("회차 : " + (count) + "\t 등급 : "+c.scoreToGrade(subjectType,s.getScore()));
                hasScore=true;
            }
            count++;
        }

        if(!hasScore){
            System.out.println("등록된 점수가 없습니다.");
        }else{
            System.out.println("\n등급 조회 성공!");
        }
    }
    inquireRoundGradeBySubject_Function(String studentId,List<Student> studentStore,List<Subject> subjectStore,List<Score> ScoreStore){
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
}





