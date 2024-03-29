package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Notification
 * Java, 객체지향이 아직 익숙하지 않은 분들은 위한 소스코드 틀입니다.
 * main 메서드를 실행하면 프로그램이 실행됩니다.
 * model 의 클래스들과 아래 (// 기능 구현...) 주석 부분을 완성해주세요!
 * 프로젝트 구조를 변경하거나 기능을 추가해도 괜찮습니다!
 * 구현에 도움을 주기위한 Base 프로젝트입니다. 자유롭게 이용해주세요!
 */
public class CampManagementApplication {
    // 데이터 저장소
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;

    // 과목 타입
    private static String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    private static String SUBJECT_TYPE_CHOICE = "CHOICE";

    // index 관리 필드
    private static int studentIndex = 0;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex=0;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex=0;
    private static final String INDEX_TYPE_SCORE = "SC";

    // 스캐너
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        setInitData();
        try {
            displayMainView();
        } catch (Exception e) {
            System.out.println("\n오류 발생!\n프로그램을 종료합니다.");
        }
    }

    // 초기 데이터 생성
    private static void setInitData() {
        studentStore = new ArrayList<>();
        subjectStore = List.of(
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Java",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "객체지향",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "JPA",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MySQL",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "디자인 패턴",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring Security",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Redis",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MongoDB",
                        SUBJECT_TYPE_CHOICE
                )
        );

    }

    // index 자동 증가
    private static String sequence(String type) {
        switch (type) {
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return INDEX_TYPE_STUDENT + studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return INDEX_TYPE_SUBJECT + subjectIndex;
            }
            default -> {
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
            }
        }
    }

    private static void displayMainView() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요...");
            int input;
            try{
                input = sc.nextInt();
            }catch (Exception e){
                System.out.println("숫자로 입력해주세요");
                input = 3;
            }


            switch (input) {
                case 1 -> displayStudentView(); // 수강생 관리
                case 2 -> displayScoreView(); // 점수 관리
                case 3 -> flag = false; // 프로그램 종료
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    Thread.sleep(2000);
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    private static void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("수강생 관리 실행 중...");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 메인 화면 이동");
            System.out.println("관리 항목을 선택하세요...");
            int input;
            try {
                input = sc.nextInt();
            }
            catch (Exception e){
                System.out.println("숫자로 입력해주세요");
                input =3;
            }


            switch (input) {
                case 1 -> createStudent(); // 수강생 등록
                case 2 -> inquireStudent(); // 수강생 목록 조회
                case 3 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }
    // 수강생 등록
    private static void createStudent() {
        System.out.println("\n수강생을 등록합니다...");
        System.out.print("수강생 이름 입력: ");
        // 기능 구현
        StudentRegister studentregister = new StudentRegister(studentIndex,studentStore,subjectStore);
        studentregister.functions();
        studentStore = studentregister.GetstudentStore();
        studentIndex++;
        System.out.println("수강생 등록 성공!\n");
    }

    // 수강생 목록 조회
    private static void inquireStudent() {
        System.out.println("\n수강생 목록을 조회합니다...");
        // 기능 구현
        StudentView studentview = new StudentView(studentStore,subjectStore);
        studentview.functions();
        // 보기용이라 getdata 는 할필요 없을듯 해요
//        studentview.GetScoreStore();
//        studentview.GetstudentStore();
//        studentview.GetsubjectStore();
        System.out.println("\n수강생 목록 조회 성공!");
    }

    private static void displayScoreView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 메인 화면 이동");
            System.out.println("관리 항목을 선택하세요...");
            int input;
            try {
                input = sc.nextInt();
            }catch (Exception e){
                System.out.println("숫자를 넣어주세요");
                input = 4;
            }
            switch (input) {
                case 1 -> createScore(); // 수강생의 과목별 시험 회차 및 점수 등록
                case 2 -> updateRoundScoreBySubject(); // 수강생의 과목별 회차 점수 수정
                case 3 -> inquireRoundGradeBySubject(); // 수강생의 특정 과목 회차별 등급 조회
                case 4 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    public static String getStudentId() {
        // 수강생 목록 조회
        System.out.println();
        System.out.println("이름 \t | \t ID");
        for(Student student : studentStore){
            System.out.println(student.getStudentName() + "\t  \t" + student.getStudentId());
        }
        System.out.println("\n관리할 수강생의 ID를 입력하시오...");

        String str = sc.next();
        boolean contains = false;
        for (Student student : studentStore){
            if (student.getStudentId().equals(str)){
                contains = true;
                break;
            }
        }
        if(!contains) {
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            return getStudentId();
        }
        System.out.println();
        return str;
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    private static void createScore() {
        //학생 id 받기

        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        int intStuentId = Integer.parseInt(studentId.substring(2, studentId.length()))-1;

        System.out.println("시험 점수를 등록합니다.");
        // 기능 구현
        CreateScore_Function createscore_function = new CreateScore_Function(intStuentId,studentStore,subjectStore);

        try{createscore_function.addStudentScore(intStuentId);
            System.out.println("\n점수 등록 성공!");
        }catch (Exception e){
            System.out.println("function.addStudentScore");
        }
        try {
            studentStore = createscore_function.getStudentStore();
            subjectStore = createscore_function.getSubjectStore();
        }catch (Exception e) {
            System.out.println("geeting the data");
        }


    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
        String studentId = "temp"; // 관리할 수강생 고유 번호
        // 기능 구현 (수정할 과목 및 회차, 점수)
        System.out.println("시험 점수를 수정합니다...");
        UpdataRoundScore_Function update = new UpdataRoundScore_Function(studentId,studentStore,subjectStore);
        update.functions();
        studentStore = update.GetstudentStore();
        subjectStore = update.GetsubjectStore();

        // 기능 구현

    }

    // 수강생의 특정 과목 회차별 등급 조회
    private static void inquireRoundGradeBySubject() {
        String studentId = "temp"; // 관리할 수강생 고유 번호
        inquireRoundGradeBySubject_Function inquireroundgradebysubject_function = new inquireRoundGradeBySubject_Function(studentId,studentStore,subjectStore);
        inquireroundgradebysubject_function.functions();

    }
}
