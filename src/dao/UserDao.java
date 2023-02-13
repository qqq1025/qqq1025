package dao;

import entity.*;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    Student_login queryById(String id) throws SQLException;

    Housemaster_login queryByIdhmt(String id) throws SQLException;

    Administor_login querByIdadm(String id) throws SQLException;

    Integer register(String id, String password);

    Administor querByidadm1(String id) throws SQLException;

    Integer queryhousemaster(String id) throws SQLException;

    Keyword querykeyword(String key) throws SQLException;
}
