package camp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    private List<Subject> subjectStore=new ArrayList<>();
    private HashMap<Integer,List<Score>> scoremap = new HashMap<>();
    public Student(String seq, String studentName){
        this.studentId = seq;
        this.studentName = studentName;
        //
        if(scoremap.size()<2){
            HashMap<Integer,List<Score>> temphash = new HashMap<>();
            List<Score> ScoreStore;
            for (int i = 0; i < 10; i++) {
                ScoreStore = new LinkedList<>();
                for (int j = 0; j < 10; j++) {
                    ScoreStore.add(new Score("",-1));
                }//
                temphash.put(i,ScoreStore);
            }
            this.scoremap = new HashMap<>(temphash);
        }
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
    public HashMap<Integer,List<Score>> getMap(){
        return this.scoremap;
    }
    public void SetMap(HashMap<Integer,List<Score>> scoremap){
        this.scoremap = scoremap;
    }

    public void setSublist(List<Subject> newLs) {
        this.subjectStore = newLs;
    }
}