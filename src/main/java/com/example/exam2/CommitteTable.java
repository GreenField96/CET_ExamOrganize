package com.example.exam2;

public class CommitteTable {
    private int idCol;
    private String classNumberCol;  // مسرح / رقم قاعة
    private String dateCol;
    private String courseCol;
    private String numberAnswerPaperCol;
    private String specificCol;
    private String semesterCol;

    public CommitteTable(int idCol, String classNumberCol, String dateCol, String courseCol, String semesterCol, String numberAnswerPaperCol, String specificCol) {
        this.idCol = idCol;
        this.classNumberCol = classNumberCol;
        this.dateCol = dateCol;
        this.courseCol = courseCol;
        this.semesterCol = semesterCol;
        this.numberAnswerPaperCol = numberAnswerPaperCol;
        this.specificCol = specificCol;
    }
    public CommitteTable(String classNumberCol, String dateCol, String courseCol, String semesterCol, String numberAnswerPaperCol, String specificCol) {
        this.classNumberCol = classNumberCol;
        this.dateCol = dateCol;
        this.courseCol = courseCol;
        this.semesterCol = semesterCol;
        this.numberAnswerPaperCol = numberAnswerPaperCol;
        this.specificCol = specificCol;
    }

    // id,class,date,course,specification,number_answer_paper
    public CommitteTable(int idCol, String classNumberCol, String dateCol, String courseCol, String specificCol, String numberAnswerPaperCol) {
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
    public String getCourseCol() { return courseCol;}
    public String getSemesterCol() {
        return semesterCol;
    }
    public String getNumberAnswerPaperCol() {
        return numberAnswerPaperCol;
    }
    public String getSpecificCol(){ return specificCol;}
}
