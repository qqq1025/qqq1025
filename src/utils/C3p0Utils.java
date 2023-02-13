package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class C3p0Utils {
    public  static DataSource dataSource;
    static {
        dataSource = new ComboPooledDataSource();
    }
    public static DataSource getDataSource() {
        return dataSource;
    }

    static {
        dataSource=new ComboPooledDataSource("itcast");
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
