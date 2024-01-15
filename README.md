## [2024] 내일배움캠프 학생 관리 프로그램

Spring을 배우는 학생들을 관리하는 프로그램입니다!

## 목차

- [개요](#1-개요)

- [프로그램 설명](#2-프로그램 설명)

- [사용 방법](#3-사용 방법)

## 개요

- 프로젝트 이름: camp_management_program
- 프로젝트 기간: 2024/01/11 - 2024/01/16
- 개발 언어: JAVA
- 개발 멤버: 13조의 금요일(오연주, 공완희, 박희은, 방세훈, 남예빈)

## 프로그램 설명

- 학생 이름과 선택 과목을 저장하고 점수 등록도 가능한 프로그램!

- 학생을 등록하면 자동으로 고유 아이디가 부여!

- 필수 수강 과목과 선택 수강 과목 구분 가능!
  - 필수 과목: Java | 객체지향 | Spring | JPA | MySQL
  
  - 선택 과목: 디자인 패턴 | Spring Security | Redis | MongoDB
 
- 한 과목 당 10회차까지 점수 등록 가능!

- 점수에 따른 등급 책정 가능!
  
  - 점수는 0 ~ 100 사이의 값으로 등록!

  -  필수 과목
    
    | A | B | C | D | F | N |
    | --- | --- | --- | --- | --- | --- |
    | 95 ~ 100 | 90 ~ 94 | 80 ~ 89 | 70 ~ 79 | 60 ~ 69 | 60점 미만 |

  - 선택 과목
    
  | A | B | C | D | F | N |
  | --- | --- | --- | --- | --- | --- |
  | 90 ~ 100 | 80 ~ 89 | 70 ~ 79 | 60 ~ 69 | 50 ~ 59 | 50점 미만 |

- 한 눈에 보기 쉽게 학생 정보와 점수 조회 가능!

## 사용방법

1. 수강생 등록

- 등록할 학생 이름을 입력해주세요.
- 필수 과목 3개 이상, 선택 과목 2개 이상을 필수적으로 선택해주세요!
- 2초 후 등록 완료_✨

2. 수강생 조회

- 아이디 | 학생 이름 | 수강 정보가 조회됩니다!

3. 수강생 점수 등록

- 등록된 학생 중 점수를 등록할 학생 ID를 입력해주세요.
- 선택한 학생의 수강 목록 중 점수를 등록할 과목 번호를 입력해주세요!
- 등록할 시험 회차를 선택해주세요!
- 이미 등록되어 있는 회차는 등록 할 수 없습니다 ❌
- 점수를 입력하면 등록 완료_✨

4. 수강생 점수 수정

- 점수를 수정할 학생의 ID를 입력해주세요!
- 학생의 수강 목록 중 점수를 수정할 과목 번호를 입력해주세요!
- 점수를 수정할 회차를 입력해주세요.
- 수정할 점수를 입력하면 수정 완료_✨

5. 수강생 점수 조회
   
- 점수가 조회 됩니다!
