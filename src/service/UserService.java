package service;

import entity.*;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    Student_login login_stu(String id, String password) throws SQLException;

    Housemaster_login login_hmt(String id, String password) throws SQLException;

    Administor_login login_adm(String id,String password) throws SQLException;

    int register(String id, String password);

    Integer queryhousemaster(String id) throws SQLException;

    Keyword querykeyword(String key) throws SQLException;
}
