package entity;

public class Student {
    private String id;
    private String password;
    private String name;
    private String gender;
    private Integer age;
    private String major;
    private String number;
    private Integer apartment;
    private Integer floor;

    public Student() {
    }

    public Student(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public Student(String id, String password, String name, String gender, Integer age, String major, Integer apartment, Integer floor, String number) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.gender=gender;
        this.age = age;
        this.major = major;
        this.apartment = apartment;
        this.floor = floor;
        this.number=number;
    }

    public Student(String id, String number, Integer apartment, Integer floor) {
        this.id = id;
        this.number = number;
        this.apartment = apartment;
        this.floor = floor;
    }

    public Student(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}
