package com.ohgiraffers.section01.insert;

public class Menu {

    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderalbeStatus;

    public Menu( String menuName, int menuPrice, int categoryCode, String orderalbeStatus) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderalbeStatus = orderalbeStatus;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderalbeStatus() {
        return orderalbeStatus;
    }

    public void setOrderalbeStatus(String orderalbeStatus) {
        this.orderalbeStatus = orderalbeStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderalbeStatus='" + orderalbeStatus + '\'' +
                '}';
    }
}
