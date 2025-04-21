package com.ohgiraffers.crud.domain.member.dto;

public class Department {

    private String deptID;
    private String deptTitle;

    public Department() {
    }

    public Department(String deptID, String deptTitle) {
        this.deptID = deptID;
        this.deptTitle = deptTitle;
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    public String getDeptTitle() {
        return deptTitle;
    }

    public void setDeptTitle(String deptTitle) {
        this.deptTitle = deptTitle;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptID='" + deptID + '\'' +
                ", deptTitle='" + deptTitle + '\'' +
                '}';
    }
}
