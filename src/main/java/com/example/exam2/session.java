package com.example.exam2;

public class session {

    static private int id;
    static private String name;
    static private String phone_number;
    static private String work_as;
    static private String email;
    static private String password;

    static public void setDataSession(int id,String name,String email,String password,String phone_number,String work_as){
        session.id = id;
        session.name = name;
        session.email = email;
        session.password = password;
        session.phone_number = phone_number;
        session.work_as = work_as;
    }

    static public int getId() {
        return id;
    }
    static public String getName() {
        return name;
    }
    static public String getPhone_number() {
        return phone_number;
    }
    static public String getWork_as() {
        return work_as;
    }
    static public String getEmail() {
        return email;
    }
    static public String getPassword() {
        return password;
    }

}
