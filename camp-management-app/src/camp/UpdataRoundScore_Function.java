package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.List;
import java.util.Scanner;

public class UpdataRoundScore_Function {
        private static List<Student> studentStore;
        private static List<Subject> subjectStore;
        private static List<Score> ScoreStore;
        private String studentId;
        public void functions() {    // 과목별 회차 점수 수정  ( 과목, 회차, 이름, 점수)
            // 여기에 작업하시요 (
            // 수학 3회차 점수는 40 이고 4회차는 70이면 70으로 변경
            // 국어 2회차 점수가 70이고 3회차 점수는 60이면 60으로 변경
            // 회차를 비교해서 바뀐 점수를 반영한다.
            // 과목별 회차 점수 수정  ( 과목, 회차, 이름, 점수)

            Scanner sc = new Scanner(System.in);
            System.out.println("과목별 회차 점수 조회를 시작합니다.");
            System.out.println("학생 ID를 입력해주세요");
            int studentId = sc.nextInt();
            System.out.println("학생이 신청한 과목번호를 입력해주세요");
            int subjectId = sc.nextInt();
            System.out.println("이전 회차의 숫자와 해당 점수를 입력해주세요.");
            int testNum = sc.nextInt();
            System.out.println("변경하실 점수를 입력해주세요.");
            int scoreId = sc.nextInt();
            editScore(studentId, subjectId, testNum, scoreId);
            System.out.println("과목별 회차 점수가 수정되었습니다.");

        }

        private void editScore(int studentId, int subjectId, int testNum, int scoreId) {
            Student st = studentStore.get(studentId);
            Subject sb = st.getSubject(subjectId);
            Score sc = st.getScorelist(subjectId).get(testNum);
            int score = sc.getScore();
            System.out.println(st.getStudentName() + " " + sb.getSubjectName() + " " + score);


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



