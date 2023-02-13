package service.impl;

import dao.Impl.UserDaoImpl;
import entity.*;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDao=new UserDaoImpl();
    @Override
    public Student_login login_stu(String id, String password) throws SQLException {
        Student_login student_login=userDao.queryById(id);
        if(student_login!=null){
            if(student_login.getPassword().equals(password)){
                System.out.println("密码正确");
                return student_login;
            }else {
                System.out.println("密码错误");
            }
        }else  {
            System.out.println("用户不存在,请检查账号是否正确");
        }
        return null;
    }

    @Override
    public Housemaster_login login_hmt(String id, String password) throws SQLException {
        Housemaster_login housemaster_login=userDao.queryByIdhmt(id);
        if(housemaster_login!=null){
            if(housemaster_login.getPassword().equals(password)){
                System.out.println("密码正确");
                return housemaster_login;
            }else {
                System.out.println("密码错误");
            }
        }
        else {
            System.out.println("用户不存在，请确认账户是否正确");
        }
        return null;
    }

    @Override
    public Administor_login login_adm(String id,String password) throws SQLException {
        Administor_login administor_login=userDao.querByIdadm(id);
        if(administor_login!=null){
            if(administor_login.getPassword().equals(password)){
                System.out.println("密码正确");
                return administor_login;
            }else {
                System.out.println("密码错误");
            }
        }else {
            System.out.println("用户不存在，请检查账号是否正确");
        }
        return null;
    }

    @Override
    public int register(String id, String password) {
        Integer result = 0;
        Administor administor=null;
        try{
            administor=userDao.querByidadm1(id);
//            result = userDao.register(id,password);

        }catch(Exception e){
            e.printStackTrace();
        }
        if(administor==null){
            System.out.println("用户不存在");
            return userDao.register(id,password);
        }
        else  {
            System.out.println("用户名存在，注册失败");
        }
        return result;
    }

    @Override
    public Integer queryhousemaster(String id) throws SQLException {
        return userDao.queryhousemaster(id);
    }

    @Override
    public Keyword querykeyword(String key) throws SQLException {
        return userDao.querykeyword(key);
    }
}
