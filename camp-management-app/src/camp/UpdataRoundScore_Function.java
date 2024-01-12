package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.HashMap;
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
            if(CheckStudentExist()){  //학생이 있는지 없는지
                GetInput(); // 입력받기
                System.out.println("\n점수 수정 성공!");
            }
        }

    private boolean CheckStudentExist() {
            boolean exists = false;
            //
        if(studentStore.size()>0){
            exists = true;
        }
        //
            return exists;
    }

    private void GetInput() {
         // 분기 체크
        // 점수도 체크.
        Scanner sc = new Scanner(System.in);
        System.out.println("과목별 회차 점수 조회를 시작합니다.");
        System.out.println("학생 ID를 입력해주세요");
        int studentId = sc.nextInt();
        //
        int subjectId = 0;
        while(true) {
            System.out.println("학생이 신청한 과목번호를 입력해주세요");
            subjectId = sc.nextInt(); // 1 이하 10 이상 면 다시 받기
            if (subjectId <= 1 && subjectId >= 10) {
                break;
            } else {
                System.out.println("1 이상 10 이하의 숫자를 넣어주세요.");
            }
        }

        //
        System.out.println("이전 회차의 숫자와 해당 점수를 입력해주세요.");
        int testNum = sc.nextInt();// 1 이하 10 이상 면 다시 받기
        //
        System.out.println("변경하실 점수를 입력해주세요.");
        int scoreId = sc.nextInt();// 100 이상 0 이하 면 다시 받기
        editScore(studentId, subjectId, testNum, scoreId);
        System.out.println("과목별 회차 점수가 수정되었습니다.");
    }

    private void editScore(int studentId, int subjectId, int testNum, int scoreId) {
            // 학생
            Student st = studentStore.get(studentId);
            // 학생 -> 과목 -> 과목이름
            Subject sb = st.getSubject(subjectId);
            // 학생 -> map<Integer,List<Score>> -> List<Score> -> Score -> Score 값 int
            // 학생 -> map 받기
            HashMap map = st.getMap();
            List<Score> ls = st.getScorelist(subjectId);
            //score (클라스)
            Score sc = st.getScorelist(subjectId).get(testNum);
            // score 안에 있는 값 int 정수
            int score = sc.getScore();
            System.out.println("학생이름"+st.getStudentName() + "과목이름:" + sb.getSubjectName() +"회차:"+testNum+ "점수:" + score);
            //변경
            sc.addscore(scoreId); //addscore 메소드로  score class 안에 점수 변경
            ls.set(testNum,sc); // 리스트 안에 score 변병
            map.put(subjectId,ls);  // map 안에 리스트 넣기
            st.SetMap(map); // student 안에 map 넣기
            studentStore.set(studentId,st); // 학생 리스트 안에 학생 변경
            for(Student s: studentStore){
                System.out.println("이름 : "+s.getStudentName()+"회차"+testNum+" 새로운 점수 "+ s.getScorelist(subjectId).get(testNum).getScore());
            }
            //System.out.println(ls.get(testNum).getScore());

            //
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



