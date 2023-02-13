package entity;

public class Housemaster {
    private String id;
    private String password;
    private String name;
    private String gender;
    private Integer age;
    private String phnum;
    private Integer mfloor;

    public Housemaster() {
    }

    public Housemaster(String id) {
        this.id = id;
    }

    public Housemaster(String id, String password, String name, String gender, Integer age, String phnum, Integer mfloor) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phnum = phnum;
        this.mfloor = mfloor;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhnum() {
        return phnum;
    }

    public void setPhnum(String phnum) {
        this.phnum = phnum;
    }

    public Integer getMfloor() {
        return mfloor;
    }

    public void setMfloor(Integer mfloor) {
        this.mfloor = mfloor;
    }
}
