package com.wavemaker.training.db.model;

public class Department {

    private int Id;
    private String DepName;

    public Department(int id, String name) {
    }

    public void Employee() {
    }

    public void Employee(int id, String name) {
        this.Id = id;
        this.DepName = name;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return DepName;
    }

    public void setName(String name) {
        this.DepName = name;
    }



    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", name='" + DepName + '\'' +
                '}';
    }
}



