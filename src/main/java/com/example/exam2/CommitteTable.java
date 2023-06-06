package com.example.exam2;

public class CommitteTable {
    private int idCol;
    private String classNumberCol;  // مسرح / رقم قاعة
    private String dateCol;
    private int courseCol;
    private String numberAnswerPaperCol;
    private String specificCol;
    private String semesterCol;
    private String periodCol;
    private String yearCol;
    private String semesterPeriodCol;

    private int courseId;
    private String courseName;
    private String courseNumber;

    private String groupCol;
    private int numberPapersReceivedCol;

    public CommitteTable(int idCol, String classNumberCol, String dateCol, int courseCol, String specificCol,String semesterCol, String numberAnswerPaperCol, int courseId, String courseName, String courseNumber,String periodCol,String groupCol,int numberPapersReceivedCol) {
        this.idCol = idCol;
        this.classNumberCol = classNumberCol;
        this.dateCol = dateCol;
        this.courseCol = courseCol;
        this.numberAnswerPaperCol = numberAnswerPaperCol;
        this.specificCol = specificCol;
        this.semesterCol = semesterCol;
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.periodCol = periodCol;
        this.groupCol = groupCol;
        this.numberPapersReceivedCol = numberPapersReceivedCol;
    }

    public CommitteTable(int idCol, String classNumberCol, String dateCol, int courseCol, String semesterCol, String numberAnswerPaperCol, String specificCol) {
        this.idCol = idCol;
        this.classNumberCol = classNumberCol;
        this.dateCol = dateCol;
        this.courseCol = courseCol;
        this.semesterCol = semesterCol;
        this.numberAnswerPaperCol = numberAnswerPaperCol;
        this.specificCol = specificCol;
    }
    public CommitteTable(String classNumberCol, String dateCol, int courseCol, String semesterCol, String numberAnswerPaperCol, String specificCol,String periodCol,String yearCol,String semesterPeriodCol) {
        this.classNumberCol = classNumberCol;
        this.dateCol = dateCol;
        this.courseCol = courseCol;
        this.semesterCol = semesterCol;
        this.numberAnswerPaperCol = numberAnswerPaperCol;
        this.specificCol = specificCol;
        this.periodCol = periodCol;
        this.yearCol = yearCol;
        this.semesterPeriodCol = semesterPeriodCol;

    }

    // id,class,date,course,specification,number_answer_paper
    public CommitteTable(int idCol, String classNumberCol, String dateCol, int courseCol, String specificCol, String numberAnswerPaperCol) {
        this.idCol = idCol;
        this.classNumberCol = classNumberCol;
        this.dateCol = dateCol;
        this.courseCol = courseCol;
        this.numberAnswerPaperCol = numberAnswerPaperCol;
        this.specificCol = specificCol;
    }


    public int getIdCol() {
        return idCol;
    }
    public String getClassNumberCol() {
        return classNumberCol;
    }
    public String getDateCol() {
        return dateCol;
    }
    public int getCourseCol() { return courseCol;}
    public String getSemesterCol() {
        return semesterCol;
    }
    public String getNumberAnswerPaperCol() {
        return numberAnswerPaperCol;
    }
    public String getSpecificCol(){ return specificCol;}
    public String getPeriodCol() {return periodCol;}
    public int getCourseId() {
        return courseId;
    }
    public String getYearCol() {return yearCol;}
    public String getSemesterPeriodCol() {return semesterPeriodCol;}
    public String getGroupCol() {return groupCol;}
    public int getNumberPapersReceivedCol() {return numberPapersReceivedCol;}


    public String getCourseName() {return courseName;}
    public String getCourseNumber() {return courseNumber;}

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }
    public void getYearCol(String yearCol) {this.yearCol = yearCol;}
    public void getSemesterPeriodCol(String semesterPeriodCol) {this.semesterPeriodCol = semesterPeriodCol;}

    public void getCourseName(String courseName) {this.courseName = courseName;}
    public void getCourseNumber(String courseNumber) {this.courseNumber = courseNumber;}
}


