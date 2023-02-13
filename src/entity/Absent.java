package entity;

public class Absent {
    private Integer sign;
    private String id;
    private String name;
    private String major;
    private Integer apartment;
    private String number;
    private String time;

    public Absent() {
    }

    public Absent(Integer sign) {
        this.sign = sign;
    }

    public Absent(String id, String name, String major, Integer apartment, String number, String time) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.apartment = apartment;
        this.number = number;
        this.time = time;
    }
    public Absent(String id, String time) {
        this.id = id;
        this.time = time;
    }
    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
