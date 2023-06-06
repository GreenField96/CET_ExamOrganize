package com.example.exam2;

public class answerPaperMovementTable {
//    String query = "INSERT INTO answer_paper_movement (committe_id,recent_id,date,number_papers_received,group) VALUES (?,?,?,?,?);";
    private int idCol;
    private int committeIdCol;
    private int heHadCol;
    private int heHaveCol;
    private String dateCol;
    private String numberPaperRecivedCol;
    private String groupCol;

    public answerPaperMovementTable(int committeIdCol, int heHadCol , int heHaveCol, String dateCol, String numberPaperRecivedCol, String groupCol) {
        this.committeIdCol = committeIdCol;
        this.heHadCol = heHadCol;
        this.heHaveCol = heHaveCol;
        this.dateCol = dateCol;
        this.numberPaperRecivedCol = numberPaperRecivedCol;
        this.groupCol = groupCol;
    }
    public answerPaperMovementTable(int idCol,int committeIdCol, int heHadCol , int heHaveCol, String dateCol, String numberPaperRecivedCol, String groupCol) {
        this.idCol = idCol;
        this.committeIdCol = committeIdCol;
        this.heHadCol = heHadCol;
        this.heHaveCol = heHaveCol;
        this.dateCol = dateCol;
        this.numberPaperRecivedCol = numberPaperRecivedCol;
        this.groupCol = groupCol;
    }
    public int getIdCol(){return idCol;}
    public int getCommitteIdCol() {
        return committeIdCol;
    }
    public int getHeHadCol() {
        return heHadCol;
    }
    public int getHeHaveCol() {
        return heHaveCol;
    }
    public String getDateCol() {
        return dateCol;
    }
    public String getNumberPaperRecivedCol() {return numberPaperRecivedCol;}
    public String getGroupCol() {
        return groupCol;
    }

    public void setIdCol(int idCol) {this.idCol = idCol;}
    public void setCommitteIdCol(int committeIdCol) {
        this.committeIdCol = committeIdCol;
    }
    public void setHeHadCol(int heHadCol) {
        this.heHadCol = heHadCol;
    }
    public void setHeHaveCol(int heHaveCol) {
        this.heHaveCol = heHaveCol;
    }
    public void setDateCol(String dateCol) {
        this.dateCol = dateCol;
    }
    public void setNumberPaperRecivedCol(String numberPaperRecivedCol) {
        this.numberPaperRecivedCol = numberPaperRecivedCol;
    }
    public void setGroupCol(String groupCol) {
        this.groupCol = groupCol;
    }

}
