package com.example.exam2;

public class studentAbsenceTable {
    private int idCol;
    private int studentIdCol;
    private String nameCol;
    private String groupNumberCol;
    private String phoneNumberCol;
    private String specification;
    private String noteCol;
    private int committeIdCol;

    public studentAbsenceTable(int idCol, int studentIdCol, String nameCol, String phoneNumberCol ,String specification, String groupNumberCol ,String noteCol ,int committeIdCol) {
        this.idCol = idCol;
        this.studentIdCol = studentIdCol;
        this.nameCol = nameCol;
        this.phoneNumberCol = phoneNumberCol;
        this.specification = specification;
        this.groupNumberCol = groupNumberCol;
        this.noteCol = noteCol;
        this.committeIdCol = committeIdCol;
    }
    public studentAbsenceTable(int studentIdCol, String nameCol, String phoneNumberCol,String specification, String groupNumberCol, String noteCol) {
        this.studentIdCol = studentIdCol;
        this.nameCol = nameCol;
        this.phoneNumberCol = phoneNumberCol;
        this.specification = specification;
        this.groupNumberCol = groupNumberCol;
        this.noteCol = noteCol;
    }
    public void setCommitteIdCol(int committeIdCol) {
        this.committeIdCol = committeIdCol;
    }

    public int getIdCol() {
        return idCol;
    }
    public int getStudentIdCol() {return studentIdCol;}
    public String getNameCol() {
        return nameCol;
    }
    public String getPhoneNumberCol() {
        return phoneNumberCol;
    }
    public String getGroupNumberCol(){return groupNumberCol;}
    public String getNoteCol() {
        return noteCol;
    }
    public String getSpecification(){ return specification; }

    public int getCommitteIdCol() {
        return committeIdCol;
    }
    public void setGroupNumberCol(String groupNumberCol){ this.groupNumberCol = groupNumberCol; }
    public void setStudentIdCol(int studentIdCol) {
        this.studentIdCol = studentIdCol;
    }
    public void setNameCol(String nameCol) {
        this.nameCol = nameCol;
    }


}
