package com.example.exam2;

public class CourseTable {
    private int id;
    private String courseName;
    private String courseNumber;

    public CourseTable(int id, String courseName, String courseNumber) {
        this.id = id;
        this.courseName = courseName;
        this.courseNumber = courseNumber;
    }
    public CourseTable(String courseName, String courseNumber) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
    }

    public int getId() {
        return id;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getCourseNumber() {
        return courseNumber;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }
}
