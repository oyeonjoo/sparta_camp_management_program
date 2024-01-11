package camp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Student {
    private String studentId;
    private String studentName;

    private static List<Score> ScoreStore = new LinkedList<>();
    private static List<Subject> subjectStore=new ArrayList<>();
    private static HashMap<Integer,List<Score>> scoremap = new HashMap<>();

    public Student(String seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
        //
        Score temp = new Score("",-1);
        for (int i = 0; i < 10; i++) {
            ScoreStore.add(temp);
        }//
        scoremap.put(0,ScoreStore);
        scoremap.put(1,ScoreStore);
        scoremap.put(2,ScoreStore);
        scoremap.put(3,ScoreStore);
        scoremap.put(4,ScoreStore);
        scoremap.put(5,ScoreStore);
        scoremap.put(6,ScoreStore);
        scoremap.put(7,ScoreStore);
        scoremap.put(8,ScoreStore);
        scoremap.put(9,ScoreStore);
        scoremap.put(10,ScoreStore);
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }
    //
    public void addSubject(Subject s) {
        subjectStore.add(s);
    }
    public Subject getSubject(int i) {
        if(subjectStore.isEmpty()){
            return new Subject("no subject","no Subject","no subject");
        }
        else {
            return subjectStore.get(i);
        }
    }
    ///
    public void addScore(int index,Score s) {
        // 새 리스트
        List<Score> temp = new LinkedList<>();
        // 인덱스에 리스트 복사
        temp = scoremap.get(index);
        // 새로운 score 넣기
        temp.add(s);
        //새 리스트 넣기(바꾸기)
        scoremap.put(index,temp);
    }
    public List<Subject> getsubjectlist(){
        return subjectStore;
    }
    public List<Score> getScorelist(int index) {
        return scoremap.get(index);
    }
}