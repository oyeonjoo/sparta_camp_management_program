package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.List;
import java.util.Scanner;

public class  inquireRoundGradeBySubject_Function{

        private static List<Student> studentStore;
        private static List<Subject> subjectStore;
        private static List<Score> ScoreStore;
        private String studentId;
        public void functions() {
            //hashmap scoreList (과목id, 회차별 점수List)
            //List (index = 회차, value = 점수)
            //얘가 student에 들어갈 거임
            // 여기에 작업하시요
            String sId = studentId; // 관리할 수강생 고유 번호
            Student stu = (Student) studentStore.stream()
                    .filter((Student student)-> student.getStudentId().equals(sId));

            // 기능 구현 (조회할 특정 과목)
            System.out.print("\n조회할 특정 과목을 입력하세요...");
            Scanner scan = new Scanner(System.in);
            String subjectName = scan.nextLine();

            //과목 고유번호 찾기
            String subNum;
            for(Subject s : stu.getSubjectStore()){
                if(s.getSubjectName().equals(subjectName)){
                    subNum=s.getSubjectId();
                }
            }

            System.out.println("회차별 등급을 조회합니다...");
            // 기능 구현
            // 기능 구현 (조회할 특정 과목)
            List<int> scoreList.getValue(subNum)

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
