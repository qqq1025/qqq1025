package entity;

public class Administor {
    private String id;
    private String password;
    private String name;
    private String gender;
    private Integer age;
    private String phnum1;

    public Administor() {
    }

    public Administor(String id, String password, String name, String gender, Integer age, String phnum1) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phnum1 = phnum1;
    }

    public Administor(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public Administor(String id) {
        this.id = id;
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

    public String getPhnum1() {
        return phnum1;
    }

    public void setPhnum1(String phnum1) {
        this.phnum1 = phnum1;
    }
}
