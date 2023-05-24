package com.example.exam2;

public class answerPaperMovementTable {
//    String query = "INSERT INTO answer_paper_movement (committe_id,recent_id,date,number_papers_received,group) VALUES (?,?,?,?,?);";
    int committeIdCol;
    int recentIdCol;
    String dateCol;
    String numberPaperRecivedCol;
    String groupCol;
    public answerPaperMovementTable(int committeIdCol, int recentIdCol, String dateCol, String numberPaperRecivedCol, String groupCol) {
        this.committeIdCol = committeIdCol;
        this.recentIdCol = recentIdCol;
        this.dateCol = dateCol;
        this.numberPaperRecivedCol = numberPaperRecivedCol;
        this.groupCol = groupCol;
    }
    public int getCommitteIdCol() {
        return committeIdCol;
    }
    public int getRecentIdCol() {
        return recentIdCol;
    }
    public String getDateCol() {
        return dateCol;
    }
    public String getNumberPaperRecivedCol() {
        return numberPaperRecivedCol;
    }
    public String getGroupCol() {
        return groupCol;
    }

}
