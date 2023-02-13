package entity;

public class Building {
    private Integer num;
    private Integer apartment;
    private String introduction;

    public Building(Integer apartment, String induc) {
        this.apartment=apartment;
        this.introduction=induc;
    }

    public Building() {
    }

    public Building(Integer apartment) {
        this.apartment = apartment;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
