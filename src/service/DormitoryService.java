package service;

import entity.*;

import java.sql.SQLException;
import java.util.List;

public interface DormitoryService {
    List<Student> queryAllStudent(Integer mfloor) throws SQLException;
    List<Student> queryAllStudent() throws SQLException;

    List<Housemaster> queryAllhousemaster() throws SQLException;

    List<Administor> queryAlladiministor() throws SQLException;

    List<Student> querysomestudent(String element,String mfloor) throws SQLException;

    void update(Student student) throws SQLException;

    List<Student> querysomestudent2(String id) throws SQLException;

    void delete(Student student) throws SQLException;

    void update2(Student student) throws SQLException;

    List<Student> querysomestudent3(String element) throws SQLException;

    List<Student> querysomestudent4(String id) throws SQLException;

    void delete2(Student student) throws SQLException;

    List<Administor> querysomeadministor(String element) throws SQLException;

    void update3(Housemaster housemaster) throws SQLException;

    void update4(Administor administor) throws SQLException;

    List<Housemaster> querysomehousemaster(String element) throws SQLException;

    void deletehousemaster(Housemaster housemaster) throws SQLException;

    List<Housemaster> querysomehousemasterBy(String element) throws SQLException;

    List<Administor> querysomedeleteadministor(String id) throws SQLException;

    void deleteadministor(Administor administor) throws SQLException;

    void housemasterinsertstu(Student student) throws SQLException;

    void administorinsertstu(Student student) throws SQLException;

    void administorinserthms(Housemaster housemaster) throws SQLException;

    void administorselfinsert(Administor administor) throws SQLException;

    String queryhousemasterMfloor(String id) throws SQLException;

    Housemaster checkhousemasterbyfloor(Integer mfloor) throws SQLException;

    List<Student> queryupdatestu(String id) throws SQLException;

    Student queryinsertstuexisit(String id) throws SQLException;

    Housemaster checkhousemasterbyId(String id) throws SQLException;

    Administor queryadministorById(String id) throws SQLException;

    List<Student> queryAllStudentById(String id) throws SQLException;

    Integer queryStuInSameDormitoryCount(Integer apartment, Integer floor, String number) throws SQLException;

    void housemasterinsertabsent(Absent absent) throws SQLException;

    String queryAbsentStuName(String id) throws SQLException;

    Integer queryAbsentStuApartment(String id) throws SQLException;

    String queryAbsentStuNum(String id) throws SQLException;

    String queryAbsentStuMajor(String id) throws SQLException;

    List<Absent> queryAllAbsentStuMsg(Integer apartment) throws SQLException;

    void houseMasterUpdateStuAbsentMsg(Absent absent) throws SQLException;

    List<Absent> HousemasterQueryDeleteAbsentMsg(Integer sign) throws SQLException;

    void housemasterDeleteAbsentMsg(Absent absent) throws SQLException;

    Integer housemasterqueryabsentstumsgsign(String id) throws SQLException;

    Student queryAbsentStuexists(String id) throws SQLException;

    List<Absent> housemastersearchabsentmsg(String element, String mfloor) throws SQLException;

    Housemaster queryinsertapartmentexists(Integer apartment) throws SQLException;

    List<Building> queryAllBuilding() throws SQLException;

    Building querybuildingexisits(Integer mfloor) throws SQLException;

    void administorinsertbuilding(Building building) throws SQLException;

    List<Building> querysomebuilding(Integer apartment) throws SQLException;

    String queryStuPassword(String id) throws SQLException;

    Student studentmodifypassword(Student student) throws SQLException;

    Keyword querykeyword(String key) throws SQLException;

    void administorupdatekeyword(Keyword keyword) throws SQLException;
}
