package service.impl;

import dao.DormitoryDao;
import dao.Impl.DormitoryDaoImpl;
import entity.*;
import service.DormitoryService;

import java.sql.SQLException;
import java.util.List;

public class DormitoryServiceImpl implements DormitoryService {
    DormitoryDao dormitoryDao=new DormitoryDaoImpl();
    @Override
    public List<Student> queryAllStudent(Integer mfloor) throws SQLException {
        return dormitoryDao.queryAllStudent(mfloor);
    }
    @Override
    public List<Student> queryAllStudent() throws SQLException {
        return dormitoryDao.queryAllStudent();
    }

    @Override
    public List<Housemaster> queryAllhousemaster() throws SQLException {
        return dormitoryDao.queryAllhousemaster();
    }

    @Override
    public List<Administor> queryAlladiministor() throws SQLException {
        return dormitoryDao.queryAlladministor();
    }

    @Override
    public List<Student> querysomestudent(String element,String mfloor) throws SQLException {
        return dormitoryDao.querysomestudent(element,mfloor);
    }

    @Override
    public void update(Student student) throws SQLException {
        Integer result=dormitoryDao.update(student);
        if(result>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    @Override
    public List<Student> querysomestudent2(String id) throws SQLException {
        return dormitoryDao.querysomestudent2(id);
    }

    @Override
    public void delete(Student student) throws SQLException {
        Integer result=dormitoryDao.delete(student);
        if(result>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Override
    public void update2(Student student) throws SQLException {
        Integer result=dormitoryDao.update2(student);
        if(result>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    @Override
    public List<Student> querysomestudent3(String element) throws SQLException {
        return dormitoryDao.querysomestudent3(element);
    }

    @Override
    public List<Student> querysomestudent4(String id) throws SQLException {
        return dormitoryDao.querysomestudent4(id);
    }

    @Override
    public void delete2(Student student) throws SQLException {
        Integer result=dormitoryDao.delete2(student);
        if(result>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Override
    public List<Administor> querysomeadministor(String element) throws SQLException {
        return dormitoryDao.querysomeadministor(element);
    }

    @Override
    public void update3(Housemaster housemaster) throws SQLException {
        Integer result=dormitoryDao.update3(housemaster);
        if(result>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    @Override
    public void update4(Administor administor) throws SQLException {
        Integer result=dormitoryDao.update4(administor);
        if(result>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    @Override
    public List<Housemaster> querysomehousemaster(String element) throws SQLException {
        return dormitoryDao.querysomehousemaster(element);
    }

    @Override
    public void deletehousemaster(Housemaster housemaster) throws SQLException {
        Integer result=dormitoryDao.deletehousemaster(housemaster);
        if(result>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Override
    public List<Housemaster> querysomehousemasterBy(String element) throws SQLException {
        return dormitoryDao.querysomehousemasterBy(element);
    }

    @Override
    public List<Administor> querysomedeleteadministor(String id) throws SQLException {
        return dormitoryDao.querysomedeleteadministor(id);
    }

    @Override
    public void deleteadministor(Administor administor) throws SQLException {
        Integer result=dormitoryDao.deleteadministor(administor);
        if(result>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Override
    public void housemasterinsertstu(Student student) throws SQLException {
        Integer result=dormitoryDao.housemasterinsertstu(student);
        if(result>0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

    @Override
    public void administorinsertstu(Student student) throws SQLException {
        Integer result=dormitoryDao.administorinsertstu(student);
        if(result>0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

    @Override
    public void administorinserthms(Housemaster housemaster) throws SQLException {
        Integer result=dormitoryDao.administorinserthmt(housemaster);
        if(result>0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

    @Override
    public void administorselfinsert(Administor administor) throws SQLException {
        Integer result=dormitoryDao.administorselfinsert(administor);
        if(result>0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

    @Override
    public String queryhousemasterMfloor(String id) throws SQLException {
        return dormitoryDao.queryhousemasterMfloor(id);
    }

    @Override
    public Housemaster checkhousemasterbyfloor(Integer mfloor) throws SQLException {
        return dormitoryDao.checkhousemasterbymfloor(mfloor);
    }

    @Override
    public List<Student> queryupdatestu(String id) throws SQLException {
        return dormitoryDao.queryupdatestu(id);
    }

    @Override
    public Student queryinsertstuexisit(String id) throws SQLException {
        return dormitoryDao.queryinsertstuexisit(id);
    }

    @Override
    public Housemaster checkhousemasterbyId(String id) throws SQLException {
        return dormitoryDao.queryhousemasterById(id);
    }

    @Override
    public Administor queryadministorById(String id) throws SQLException {
        return dormitoryDao.queryadministorById(id);
    }

    @Override
    public List<Student> queryAllStudentById(String id) throws SQLException {
        return dormitoryDao.queryStudentById(id);
    }

    @Override
    public Integer queryStuInSameDormitoryCount(Integer apartment, Integer floor, String number) throws SQLException {
        return dormitoryDao.queryStuInSameDormitoryCount(apartment,floor,number);
    }

    @Override
    public void housemasterinsertabsent(Absent absent) throws SQLException {
        Integer result=dormitoryDao.housemasterinsertabent(absent);
        if (result>0){
            System.out.println("插入数据成功");
        }else {
            System.out.println("插入数据失败");
        }
    }

    @Override
    public String queryAbsentStuName(String id) throws SQLException {
        return dormitoryDao.queryAbsentStuName(id);
    }

    @Override
    public Integer queryAbsentStuApartment(String id) throws SQLException {
        return dormitoryDao.queryAbsentAStuApartment(id);
    }

    @Override
    public String queryAbsentStuNum(String id) throws SQLException {
        return dormitoryDao.queryAbsentStuNum(id);
    }

    @Override
    public String queryAbsentStuMajor(String id) throws SQLException {
        return dormitoryDao.queryAbsentStuMajor(id);
    }

    @Override
    public List<Absent> queryAllAbsentStuMsg(Integer apartment) throws SQLException {
        return dormitoryDao.queryAllAbsentMsg(apartment);
    }

    @Override
    public void houseMasterUpdateStuAbsentMsg(Absent absent) throws SQLException {
        Integer result=dormitoryDao.housemasterupdatestuabsentmsg(absent);
        if (result>0){
            System.out.println("修改数据成功");
        }else {
            System.out.println("数据修改失败");
        }
    }

    @Override
    public List<Absent> HousemasterQueryDeleteAbsentMsg(Integer sign) throws SQLException {
        return dormitoryDao.housemasterqueryDeleteAbasentMsg(sign);
    }

    @Override
    public void housemasterDeleteAbsentMsg(Absent absent) throws SQLException {
        Integer result=dormitoryDao.housemasterdeleteabsentmsg(absent);
        if (result>0){
            System.out.println("数据删除成功");
        }else {
            System.out.println("数据删除失败");
        }
    }

//    @Override
//    public void housemasterDeleteAbsentMsg(Absent absent) throws SQLException {
//        Integer result=dormitoryDao.housemasterdeleteabsentmsg(absent);
//        if(result>0){
//            System.out.println("删除数据成功");
//        }else {
//            System.out.println("数据删除失败");
//        }
//    }

    @Override
    public Integer housemasterqueryabsentstumsgsign(String id) throws SQLException {
        return dormitoryDao.housemasterqueryabsentstumsg(id);
    }

    @Override
    public Student queryAbsentStuexists(String id) throws SQLException {
        return  dormitoryDao.queryAbsentStuExists(id);
    }

    @Override
    public List<Absent> housemastersearchabsentmsg(String element, String mfloor) throws SQLException {
        return dormitoryDao.housemastersearchabsentmsg(element,mfloor);
    }

    @Override
    public Housemaster queryinsertapartmentexists(Integer apartment) throws SQLException {
        return dormitoryDao.queryinsertapaetmentexists(apartment);
    }

    @Override
    public List<Building> queryAllBuilding() throws SQLException {
        return dormitoryDao.queryAllBuilding();
    }

    @Override
    public Building querybuildingexisits(Integer mfloor) throws SQLException {
        return dormitoryDao.querybuildingexisits(mfloor);
    }

    @Override
    public void administorinsertbuilding(Building building) throws SQLException {
        Integer result=dormitoryDao.administorinsertbuilding(building);
        if(result>0){
            System.out.println("插入数据成功");
        }else {
            System.out.println("插入数据失败");
        }
    }

    @Override
    public List<Building> querysomebuilding(Integer apartment) throws SQLException {
        return dormitoryDao.querysomebuilding(apartment);
    }

    @Override
    public String queryStuPassword(String id) throws SQLException {
        return dormitoryDao.queryStudentPassword(id);
    }

    @Override
    public Student studentmodifypassword(Student student) throws SQLException {
        Integer result=dormitoryDao.StudentModifyPassword(student);
        if(result>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
        return null;
    }

    @Override
    public Keyword querykeyword(String key) throws SQLException {
        return dormitoryDao.querykeyword(key);
    }

    @Override
    public void administorupdatekeyword(Keyword keyword) throws SQLException {
        Integer result=dormitoryDao.administorupdatekeyword(keyword);
        if(result>0){
            System.out.println("修改密钥成功");
        }else {
            System.out.println("修改密钥失败");
        }
    }
}
