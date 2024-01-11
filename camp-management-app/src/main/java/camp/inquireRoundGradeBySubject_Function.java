package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.List;

public class  inquireRoundGradeBySubject_Function{

        private static List<Student> studentStore;
        private static List<Subject> subjectStore;
        private static List<Score> ScoreStore;
        private String studentId;
        public void functions() {
            // 여기에 작업하시요

            // 기능 구현 (조회할 특정 과목)

            System.out.println("회차별 등급을 조회합니다...");
            // 기능 구현

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
