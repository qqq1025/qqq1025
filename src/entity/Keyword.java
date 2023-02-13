package entity;

public class Keyword {
    private Integer sign;
    private String passkey;
    private String passkey1;

    public Keyword() {
    }

    public Keyword(String passkey, String passkey1) {
        this.passkey = passkey;
        this.passkey1 = passkey1;
    }

    public String getPasskey1() {
        return passkey1;
    }

    public void setPasskey1(String passkey1) {
        this.passkey1 = passkey1;
    }

    public Keyword(String passkey) {
        this.passkey = passkey;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public String getPasskey() {
        return passkey;
    }

    public void setPasskey(String passkey) {
        this.passkey = passkey;
    }
}
