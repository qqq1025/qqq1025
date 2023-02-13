package dao.Impl;

import dao.UserDao;
import entity.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3p0Utils;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());

    @Override
    public Student_login queryById(String id) throws SQLException {
        String sql="select * from student where id=?";
        //System.out.println(runner.query(sql,new BeanHandler(Student_login.class),id));
        return (Student_login) runner.query(sql,new BeanHandler(Student_login.class),id);
    }

    @Override
    public Housemaster_login queryByIdhmt(String id) throws SQLException {
        String sql="select * from housemaster where id=?";
        return (Housemaster_login) runner.query(sql,new BeanHandler(Housemaster_login.class),id);
    }

    @Override
    public Administor_login querByIdadm(String id) throws SQLException {
        String sql="select * from administor where id=?";
        return (Administor_login) runner.query(sql,new BeanHandler(Administor_login.class),id);
    }

    @Override
    public Integer register(String id, String password) {
        try {
            String sql="insert into administor(id,password) values(?,?)";
            return runner.update(sql, id, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Administor querByidadm1(String id) throws SQLException {
        String sql="select * from administor where id=?";
        return (Administor) runner.query(sql,new BeanHandler(Administor.class),id);
    }

    @Override
    public Integer queryhousemaster(String id) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Integer mfloor=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/dormitory";
            String user="root";
            String password="q123456";
            connection= DriverManager.getConnection(url,user,password);
            String sql="select mfloor from housemaster where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                mfloor=resultSet.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return mfloor;
    }

    @Override
    public Keyword querykeyword(String key) throws SQLException {
        String sql="select * from keynumber where passkey=?";
        return (Keyword) runner.query(sql,new BeanHandler(Keyword.class),key);
    }
}
