package dao.Impl;

import dao.DormitoryDao;
import entity.*;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3p0Utils;

import java.sql.*;
import java.util.List;

public class DormitoryDaoImpl implements DormitoryDao {
    QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
    BeanProcessor beanProcessor=new GenerousBeanProcessor();
    RowProcessor rowProcessor=new BasicRowProcessor(beanProcessor);


    @Override
    public List<Student> queryAllStudent(Integer mfloor) throws SQLException {
        String sql="select * from student where apartment=?";
        return (List<Student>) runner.query(sql,new BeanListHandler(Student.class,rowProcessor),mfloor);
    }

    @Override
    public List<Student> queryAllStudent() throws SQLException {
        String sql="select * from student";
        return (List<Student>) runner.query(sql,new BeanListHandler(Student.class,rowProcessor));
    }

    @Override
    public List<Housemaster> queryAllhousemaster() throws SQLException {
        String sql="select * from housemaster";
        return (List<Housemaster>) runner.query(sql,new BeanListHandler(Housemaster.class,rowProcessor));
    }

    @Override
    public List<Administor> queryAlladministor() throws SQLException {
        String sql="select * from administor";
        return (List<Administor>) runner.query(sql,new BeanListHandler(Administor.class,rowProcessor));
    }

    @Override
    public List<Student> querysomestudent(String element,String mfloor) throws SQLException {
//        String sql="select * from student where id like";
//        return (List<Student>) runner.query(sql,new BeanListHandler(Student.class),element,element,element);
        String sql="select * from (select * from student where id like? or name like? or number like?) as somestu where apartment=?";
        Object[] param={"%"+element+"%","%"+element+"%","%"+element+"%",mfloor};
        return (List<Student>) runner.query(sql,new BeanListHandler(Student.class),param);
    }

    @Override
    public Integer update(Student student) throws SQLException {
        String sql="update student set number=?,apartment=?,floor=? where id=?";
        return runner.update(sql,student.getNumber(),student.getFloor(),student.getApartment(),student.getId());
    }

    @Override
    public List<Student> querysomestudent2(String id) throws SQLException {
        String sql="select * from student where id=?";
        return  (List<Student>) runner.query(sql,new BeanListHandler(Student.class),id);
    }

    @Override
    public Integer delete(Student student) throws SQLException {
        String sql="delete from student where id=?";
        return runner.update(sql,student.getId());
    }

    @Override
    public Integer update2(Student student) throws SQLException {
        String sql="update student set password=?,name=?,age=?,gender=?,major=?,apartment=?,floor=?,number=? where id=?";
        return  runner.update(sql,student.getPassword(),student.getName(),student.getAge(),student.getGender(),student.getMajor(),student.getFloor(),student.getApartment(),student.getNumber(),student.getId());
    }

    @Override
    public List<Student> querysomestudent3(String element) throws SQLException {
        String sql="select * from student where id like? or name like? or number like?";
        Object[] param={"%"+element+"%","%"+element+"%","%"+element+"%"};
        return (List<Student>) runner.query(sql,new BeanListHandler(Student.class),param);
    }

    @Override
    public List<Student> querysomestudent4(String id) throws SQLException {
        String sql="select * from student where id=?";
        return  (List<Student>) runner.query(sql,new BeanListHandler(Student.class,rowProcessor),id);
    }

    @Override
    public Integer delete2(Student student) throws SQLException {
        String sql="delete from student where id=?";
        return  runner.update(sql,student.getId());
    }

    @Override
    public List<Administor> querysomeadministor(String element) throws SQLException {
        String sql="select * from administor where id like? or name like?";
        Object[] param={"%"+element+"%","%"+element+"%"};
        return (List<Administor>)runner.query(sql,new BeanListHandler(Administor.class,rowProcessor),param);
    }

    @Override
    public Integer update3(Housemaster housemaster) throws SQLException {
        String sql="update housemaster set password=?,name=?,gender=?,age=?,phnum=?,mfloor=? where id=?";
        return  runner.update(sql,housemaster.getPassword(),housemaster.getName(),housemaster.getGender(),housemaster.getAge(),housemaster.getPhnum(),housemaster.getMfloor(),housemaster.getId());
    }

    @Override
    public Integer update4(Administor administor) throws SQLException {
        String sql="update administor set password=?,name=?,gender=?,age=?,phnum1=? where id=?";
        return runner.update(sql,administor.getPassword(),administor.getName(),administor.getGender(),administor.getAge(),administor.getPhnum1(),administor.getId());
    }

    @Override
    public List<Housemaster> querysomehousemaster(String element) throws SQLException {
        String sql="select * from housemaster where id=?";
        return  (List<Housemaster>) runner.query(sql,new BeanListHandler(Housemaster.class,rowProcessor),element);
    }

    @Override
    public Integer deletehousemaster(Housemaster housemaster) throws SQLException {
        String sql="delete from housemaster where id=?";
        return runner.update(sql,housemaster.getId());
    }

    @Override
    public List<Housemaster> querysomehousemasterBy(String element) throws SQLException {
        String sql="select * from housemaster where id like? or name like?";
        Object[] param={"%"+element+"%","%"+element+"%"};
        return (List<Housemaster>) runner.query(sql,new BeanListHandler(Housemaster.class,rowProcessor),param);
    }

    @Override
    public List<Administor> querysomedeleteadministor(String id) throws SQLException {
        String sql="select * from administor where id=?";
        return (List<Administor>) runner.query(sql,new BeanListHandler(Administor.class,rowProcessor),id);
    }

    @Override
    public Integer deleteadministor(Administor administor) throws SQLException {
        String sql="delete from administor where id =?";
        return runner.update(sql,administor.getId());
    }

    @Override
    public Integer housemasterinsertstu(Student student) throws SQLException {
        String sql="insert into student(id,password,name,gender,age,major,apartment,floor,number) values(?,?,?,?,?,?,?,?,?)";
        return  runner.update(sql,student.getId(),student.getPassword(),student.getName(),student.getGender(),student.getAge(),student.getMajor(),student.getApartment(),student.getFloor(),student.getNumber());
    }

    @Override
    public Integer administorinsertstu(Student student) throws SQLException {
        String sql="insert into student(id,password,name,gender,age,major,apartment,floor,number) values(?,?,?,?,?,?,?,?,?)";
        return runner.update(sql,student.getId(),student.getPassword(),student.getName(),student.getGender(),student.getAge(),student.getMajor(),student.getApartment(),student.getFloor(),student.getNumber());
    }

    @Override
    public Integer administorinserthmt(Housemaster housemaster) throws SQLException {
        String  sql="insert into housemaster(id,password,name,gender,age,phnum,mfloor) values(?,?,?,?,?,?,?)";
        return  runner.update(sql,housemaster.getId(),housemaster.getPassword(),housemaster.getName(),housemaster.getGender(),housemaster.getAge(),housemaster.getPhnum(),housemaster.getMfloor());
    }

    @Override
    public Integer administorselfinsert(Administor administor) throws SQLException {
        String sql="insert into administor(id,password,name,gender,age,phnum1) values(?,?,?,?,?,?)";
        return runner.update(sql,administor.getId(),administor.getPassword(),administor.getName(),administor.getGender(),administor.getAge(),administor.getPhnum1());
    }

    @Override
    public String queryhousemasterMfloor(String id) throws SQLException {
        String sql="select mfloor from housemaster where id=?";
        return  (String) runner.query(sql,new BeanHandler(Housemaster.class,rowProcessor),id);
    }

    @Override
    public Housemaster checkhousemasterbymfloor(Integer mfloor) throws SQLException {
        String sql="select * from housemaster where mfloor=?";
        return  (Housemaster) runner.query(sql,new BeanHandler(Housemaster.class),mfloor);
    }

    @Override
    public List<Student> queryupdatestu(String id) throws SQLException {
        String sql="select * from student where id=?";
        return (List<Student>) runner.query(sql,new BeanListHandler(Student.class,rowProcessor),id);
    }

    @Override
    public Student queryinsertstuexisit(String id) throws SQLException {
        String sql="select * from student where id=?";
        return (Student) runner.query(sql,new BeanHandler(Student.class),id);
    }

    @Override
    public Housemaster queryhousemasterById(String id) throws SQLException {
        String sql="select * from housemaster where id=?";
        return (Housemaster) runner.query(sql,new BeanHandler(Housemaster.class),id);
    }

    @Override
    public Administor queryadministorById(String id) throws SQLException {
        String sql="select * from administor where id=?";
        return  (Administor) runner.query(sql,new BeanHandler(Administor.class),id);
    }

    @Override
    public List<Student> queryStudentById(String id) throws SQLException {
        String sql="select * from student where id=?";
        return  (List<Student>) runner.query(sql,new BeanListHandler(Student.class,rowProcessor),id);
    }

    @Override
    public Integer queryStuInSameDormitoryCount(Integer apartment, Integer floor, String number) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Integer result=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/dormitory";
            String user="root";
            String password="q123456";
            connection= DriverManager.getConnection(url,user,password);
            String sql="select COUNT(*) FROM student where apartment=? AND floor=? AND number=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,apartment);
            preparedStatement.setInt(2,floor);
            preparedStatement.setString(3,number);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                result=resultSet.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer housemasterinsertabent(Absent absent) throws SQLException {
        String sql="insert into absent (id,name,major,apartment,number,time) values(?,?,?,?,?,?)";
        return runner.update(sql,absent.getId(),absent.getName(),absent.getMajor(),absent.getApartment(),absent.getNumber(),absent.getTime());
    }

    @Override
    public String queryAbsentStuName(String id) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String result=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/dormitory";
            String user="root";
            String password="q123456";
            connection= DriverManager.getConnection(url,user,password);
            String sql="select name from student where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                result=resultSet.getString(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer queryAbsentAStuApartment(String id) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Integer result=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/dormitory";
            String user="root";
            String password="q123456";
            connection= DriverManager.getConnection(url,user,password);
            String sql="select apartment from student where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                result=resultSet.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String queryAbsentStuNum(String id) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String result=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/dormitory";
            String user="root";
            String password="q123456";
            connection= DriverManager.getConnection(url,user,password);
            String sql="select number from student where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                result=resultSet.getString(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String queryAbsentStuMajor(String id) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String result=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/dormitory";
            String user="root";
            String password="q123456";
            connection= DriverManager.getConnection(url,user,password);
            String sql="select major from student where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                result=resultSet.getString(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Absent> queryAllAbsentMsg(Integer apartment) throws SQLException {
        String sql="select * from absent where apartment=?";
        return (List<Absent>) runner.query(sql,new BeanListHandler(Absent.class,rowProcessor),apartment);
    }

    @Override
    public Integer housemasterupdatestuabsentmsg(Absent absent) throws SQLException {
        String sql="update absent set time=? where id=?";
        return runner.update(sql,absent.getTime(),absent.getId());
    }

    @Override
    public List<Absent> housemasterqueryDeleteAbasentMsg(Integer sign) throws SQLException {
        String sql="select * from absent where sign=?";
        return  (List<Absent>) runner.query(sql,new BeanListHandler(Absent.class,rowProcessor),sign);
    }
    @Override
    public Integer housemasterqueryabsentstumsg(String id) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Integer result=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/dormitory";
            String user="root";
            String password="q123456";
            connection= DriverManager.getConnection(url,user,password);
            String sql="select sign from absent where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                result=resultSet.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
    @Override
    public Integer housemasterdeleteabsentmsg(Absent absent) throws SQLException {
        String sql="delete from absent where sign=?";
        return runner.update(sql,absent.getSign());
    }

    @Override
    public Student queryAbsentStuExists(String id) throws SQLException {
        String sql="select * from student where id=?";
        return (Student) runner.query(sql,new BeanHandler(Student.class),id);
    }

    @Override
    public List<Absent> housemastersearchabsentmsg(String element, String mfloor) throws SQLException {
        String sql="select * from (select * from absent where id like? or name like? or number like?) as someabsent where apartment=?";
        Object[] param={"%"+element+"%","%"+element+"%","%"+element+"%",mfloor};
        return (List<Absent>) runner.query(sql,new BeanListHandler(Absent.class),param);
    }

    @Override
    public Housemaster queryinsertapaetmentexists(Integer apartment) throws SQLException {
        String sql="select * from housemaster where mfloor=?";
        return (Housemaster) runner.query(sql,new BeanHandler(Housemaster.class),apartment);
    }

    @Override
    public List<Building> queryAllBuilding() throws SQLException {
        String sql="select * from building";
        return (List<Building>) runner.query(sql,new BeanListHandler(Building.class,rowProcessor));
    }

    @Override
    public Building querybuildingexisits(Integer mfloor) throws SQLException {
        String sql="select * from building where apartment=?";
        return (Building) runner.query(sql,new BeanHandler(Building.class),mfloor);
    }

    @Override
    public Integer administorinsertbuilding(Building building) throws SQLException {
        String sql="insert into building(apartment,introduction) values(?,?)";
        return runner.update(sql,building.getApartment(),building.getIntroduction());
    }

    @Override
    public List<Building> querysomebuilding(Integer apartment) throws SQLException {
        String sql="select * from building where apartment=?";
        return (List<Building>) runner.query(sql,new BeanListHandler(Building.class,rowProcessor),apartment);
    }

    @Override
    public String queryStudentPassword(String id) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String result=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/dormitory";
            String user="root";
            String password="q123456";
            connection= DriverManager.getConnection(url,user,password);
            String sql="select password from student where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                result=resultSet.getString(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer StudentModifyPassword(Student student) throws SQLException {
        String sql="update student set password=? where id=?";
        return runner.update(sql,student.getPassword(),student.getId());
    }

    @Override
    public Keyword querykeyword(String key) throws SQLException {
        String sql="select * from keynumber where passkey=?";
        return (Keyword) runner.query(sql,new BeanHandler(Keyword.class),key);
    }

    @Override
    public Integer administorupdatekeyword(Keyword keyword) throws SQLException {
        String sql="update keynumber set passkey=? where passkey=?";
        return runner.update(sql,keyword.getPasskey1(),keyword.getPasskey());
    }
}
