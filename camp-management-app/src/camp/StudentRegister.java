package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRegister {
    Scanner scan = new Scanner(System.in);
    private static int studentIndex;
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> ScoreStore;
    private  int total_Student ;
    int compulsarypaper_num = 0;
    int optionalpaper_num =0;
    /*                                       여기에 작업하시요                                    */
    public void functions() {
        // 여기에 작업하시요
        // 이름 받기
        String studentName = scan.next();
        // 새리스트
        List<Subject> new_ls = new ArrayList<>();
        studentIndex +=1;
        Student student = new Student("ST"+studentIndex, studentName);
        // 기능 구현 (필수 과목, 선택 과목)
        System.out.println("과목을 선택해주세요");
        //과목 리스트 프린트 하기.
        boolean flag = true;
        while(flag) {
            for (int i = 0; i < subjectStore.size(); i++) {
                System.out.println(i+1 + " : " + subjectStore.get(i).getSubjectName() + " : " + subjectStore.get(i).getSubjectType());
            }
            // 나가기 밑 들어야 하는 페이퍼
            System.out.println("10 를 누르거나 더큰수 를 눌러 나가기");
            System.out.println("넣은 필수과목수 : "+compulsarypaper_num);
            System.out.println("넣은 선택과목수 : "+optionalpaper_num);
            /// 모든 과목을 이미 넣은 상황
            try{

                //// 입력받기
                int a = 0;
                try{
                    a = scan.nextInt();
                }catch (Exception e){
                    System.out.println("숫자를 입력해주세요");
                }
                // 3개 이상 2개미만 확인
                if(a>=10){ // a 가 10면 나가기
                    if(optionalpaper_num<2||compulsarypaper_num<3){
                        System.out.println("필수과목 3개, 선택과목 2개 미만입니다, 과목을 더 넣어 주세요");
                        System.out.println("이해 하셨습니까?(아무 키 넣고 나가기)");
                        try{
                            String any = scan.next();
                        }catch (Exception e){
                            System.out.println("69 StudentRegister error");
                        }
                    }
                    else {
                        System.out.println("나갑니다");
                        flag = false;
                    }
                }
                // a 가 <1일 경우
                else if(a < 1){
                    System.out.println("그 과목에 있는 번호를 넣어주세요. (1 부터 9 까지)");
                    try{
                        String any = scan.next();
                    }catch (Exception e){
                        System.out.println("69 StudentRegister error");
                    }
                }
                // a 가 10 이하면
                else {
                    Subject su = subjectStore.get(a-1);
                    if(new_ls.contains(su)){
                        System.out.println(subjectStore.get(a-1).getSubjectName() + "은 이미 추가된 과목입니다");
                        System.out.println("이해 하셨습니까?(아무키나 넣고 나가기)");
                        try{
                            String any = scan.next();
                        }catch (Exception e){
                            System.out.println("에러!:StudentRegister.Java/ line 72");
                        }
                    }
                    else {
                        new_ls.add(su);
                        CheckpaperType(a-1);
                        System.out.println(subjectStore.get(a-1).getSubjectName() + "을 추가 했습니다");
                    }
                }
            }catch (Exception e){
                System.out.println("Student Register 오류입니다.");
            }
        }
        //
        //
        student.setSublist(new_ls);
        studentStore.add(student);
        new_ls = null;
        System.out.println("아이디 : ST"+studentIndex+"  이름 : " + studentName + "(대략 2초)등록중 ....");
        compulsarypaper_num = 0;
        optionalpaper_num = 0;
        // 기다리기
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println("Student Register 2초 대기 문제");
        }
        // 끝
        scan = null;
    }

    private void CheckpaperType(int a) {
        if(subjectStore.get(a).getSubjectType().equals("MANDATORY")){
            compulsarypaper_num++;
        }
        else {
            optionalpaper_num++;
        }
    }
    //
    public List<Student> GetstudentStore(){
        return this.studentStore;
    }

    //
    StudentRegister(int studentIndex,List<Student> studentStore,List<Subject> subjectStore,List<Score> ScoreStore){
        this.studentIndex = studentIndex;
        this.studentStore =studentStore;
        this.subjectStore = subjectStore;
        this.ScoreStore = ScoreStore;
    }
}
