package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.List;

    public class UpdataRoundScore_Function {
        private static List<Student> studentStore;
        private static List<Subject> subjectStore;
        private static List<Score> ScoreStore;
        private String studentId;
        public void functions() {    // 과목별 회차 점수 수정  ( 과목, 회차, 이름, 점수)
            // 여기에 작업하시요
            // 수학 3회차 점수는 40 이고 4회차는 70이면 70으로 변경
            // 국어 2회차 점수가 70이고 3회차 점수는 60이면 60으로 변경
            // 회차를 비교해서 바뀐 점수를 반영한다.
            // 과목별 회차 점수 수정  ( 과목, 회차, 이름, 점수)


        }
        UpdataRoundScore_Function(String studentId,List<Student> studentStore,List<Subject> subjectStore,List<Score> ScoreStore){
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



