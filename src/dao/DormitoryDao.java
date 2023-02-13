package dao;

import entity.*;

import java.sql.SQLException;
import java.util.List;

public interface DormitoryDao {
    List<Student> queryAllStudent(Integer mfloor) throws SQLException;
    List<Student> queryAllStudent() throws SQLException;

    List<Housemaster> queryAllhousemaster() throws SQLException;

    List<Administor> queryAlladministor() throws SQLException;

    List<Student> querysomestudent(String element,String mfloor) throws SQLException;

    Integer update(Student student) throws SQLException;

    List<Student> querysomestudent2(String id) throws SQLException;

    Integer delete(Student student) throws SQLException;

    Integer update2(Student student) throws SQLException;

    List<Student> querysomestudent3(String element) throws SQLException;

    List<Student> querysomestudent4(String id) throws SQLException;

    Integer delete2(Student student) throws SQLException;

    List<Administor> querysomeadministor(String element) throws SQLException;

    Integer update3(Housemaster housemaster) throws SQLException;

    Integer update4(Administor administor) throws SQLException;

    List<Housemaster> querysomehousemaster(String element) throws SQLException;

    Integer deletehousemaster(Housemaster housemaster) throws SQLException;

    List<Housemaster> querysomehousemasterBy(String element) throws SQLException;

    List<Administor> querysomedeleteadministor(String id) throws SQLException;

    Integer deleteadministor(Administor administor) throws SQLException;

    Integer housemasterinsertstu(Student student) throws SQLException;

    Integer administorinsertstu(Student student) throws SQLException;

    Integer administorinserthmt(Housemaster housemaster) throws SQLException;

    Integer administorselfinsert(Administor administor) throws SQLException;

    String queryhousemasterMfloor(String id) throws SQLException;

    Housemaster checkhousemasterbymfloor(Integer mfloor) throws SQLException;

    List<Student> queryupdatestu(String id) throws SQLException;

    Student queryinsertstuexisit(String id) throws SQLException;

    Housemaster queryhousemasterById(String id) throws SQLException;

    Administor queryadministorById(String id) throws SQLException;

    List<Student> queryStudentById(String id) throws SQLException;

    Integer queryStuInSameDormitoryCount(Integer apartment, Integer floor, String number) throws SQLException;

    Integer housemasterinsertabent(Absent absent) throws SQLException;

    String queryAbsentStuName(String id) throws SQLException;

    Integer queryAbsentAStuApartment(String id) throws SQLException;

    String queryAbsentStuNum(String id) throws SQLException;

    String queryAbsentStuMajor(String id) throws SQLException;

    List<Absent> queryAllAbsentMsg(Integer apartment) throws SQLException;

    Integer housemasterupdatestuabsentmsg(Absent absent) throws SQLException;

    List<Absent> housemasterqueryDeleteAbasentMsg(Integer sign) throws SQLException;

//    Integer housemasterdeleteabsentmsg(Absent absent) throws SQLException;

    Integer housemasterqueryabsentstumsg(String id) throws SQLException;

    Integer housemasterdeleteabsentmsg(Absent absent) throws SQLException;

    Student queryAbsentStuExists(String id) throws SQLException;

    List<Absent> housemastersearchabsentmsg(String element, String mfloor) throws SQLException;

    Housemaster queryinsertapaetmentexists(Integer apartment) throws SQLException;

    List<Building> queryAllBuilding() throws SQLException;

    Building querybuildingexisits(Integer mfloor) throws SQLException;

    Integer administorinsertbuilding(Building building) throws SQLException;

    List<Building> querysomebuilding(Integer apartment) throws SQLException;

    String queryStudentPassword(String id) throws SQLException;

    Integer StudentModifyPassword(Student student) throws SQLException;

    Keyword querykeyword(String key) throws SQLException;

    Integer administorupdatekeyword(Keyword keyword) throws SQLException;
}
