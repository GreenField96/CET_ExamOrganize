package com.example.exam2;

public class CommitteTable {
    private int idCol;
    private String classNumberCol;  // مسرح / رقم قاعة
    private String dateCol;
    private int courseCol;
    private String numberAnswerPaperCol;
    private String specificCol;
    private String semesterCol;

    private int courseId;
    private String courseName;
    private String courseNumber;

    public CommitteTable(int idCol, String classNumberCol, String dateCol, int courseCol,String semesterCol, String numberAnswerPaperCol, String specificCol, int courseId, String courseName, String courseNumber) {
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
    public CommitteTable(String classNumberCol, String dateCol, int courseCol, String semesterCol, String numberAnswerPaperCol, String specificCol) {
        this.classNumberCol = classNumberCol;
        this.dateCol = dateCol;
        this.courseCol = courseCol;
        this.semesterCol = semesterCol;
        this.numberAnswerPaperCol = numberAnswerPaperCol;
        this.specificCol = specificCol;
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


    public int getCourseId() {
        return courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

}


