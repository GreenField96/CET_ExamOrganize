package com.example.exam2;

public class EmployeeTable {

    //  Column: name,phone_number,work_as,email
    private int id;
    private String name;
    private String phone_number;
    private String work_as;
    private String email;

    EmployeeTable(String name , String email , String phone_number , String work_as){
        this.name = name;
        this.email = email;
        this.work_as = work_as;
        this.phone_number = phone_number;
    }
    EmployeeTable(int id , String name , String email , String phone_number , String work_as){
        this.id = id;
        this.name = name;
        this.email = email;
        this.work_as = work_as;
        this.phone_number = phone_number;
    }
    EmployeeTable(int id,String name){
        this.id = id;
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPhone_number() {
        return phone_number;
    }

    public String getWork_as() {
        return work_as;
    }

    public String getEmail() {
        return email;
    }

}
