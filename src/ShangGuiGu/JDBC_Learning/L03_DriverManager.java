package ShangGuiGu.JDBC_Learning;

import org.junit.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DriverManager 是驱动的管理类
 *  比Driver类好用.......
 *  优点:
 *      1, 可以通过重载的getConnection()方法获取数据库连接,比较方便
 *      2, 可以同时管理多个驱动程序: 若注册了多个数据库连接,则调用
 *          getConnection()方法时传入的参数不同,即返回不同的数据库连接
 *
 */
public class L03_DriverManager {
    @Test
    public void testDriverManager() throws SQLException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
//        String url = "jdbc:mysql://localhost:3306/my_database";
//        String user = "root";
//        String password = "zx15245083842";

        File jdbcDriver = new File(
                "C:\\Users\\65404\\Desktop\\learningJava\\src\\SGU\\JDBC_Learning\\jdbc.properties");
        FileInputStream in = new FileInputStream(jdbcDriver);


        Properties properties = new Properties();
        properties.load(in);

        //  可以准备多个database的信息
        String url = properties.getProperty("jdbcUrl");
//        String url2 = properties.getProperty("jdbcUrl2");
        String user = properties.getProperty("user");
//        String user2 = properties.getProperty("user2");
        String password = properties.getProperty("password");
//        String password2 = properties.getProperty("password2");
        String driverClass = properties.getProperty("driver");
//        String driverClass2 = properties.getProperty("driver2");

        //  注册驱动类(可以省略
//        DriverManager.registerDriver((Driver) Class.forName(driverClass).newInstance());
        //  注册(加载)驱动类   不知道有啥作用
        Class.forName(driverClass);
//        Class.forName(driverClass2);

        //  调用DricerManager类的getConnection(url,user,password)方法建立数据库的连接
        //  通过传入不同的database信息来管理不同的database
        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println(conn);
    }

    @Test
    public void testConnection() throws IOException, ClassNotFoundException, SQLException {
        //1, 准备数据库信息
        File driverMessage = new File(
                "C:\\Users\\65404\\Desktop\\learningJava\\src\\SGU\\JDBC_Learning\\jdbc.properties"
        );
        FileInputStream in = new FileInputStream(driverMessage);
        Properties p = new Properties();
        p.load(in);
        String driverClass = p.getProperty("driver");
        String url = p.getProperty("jdbcUrl");
        String user = p.getProperty("user");
        String password = p.getProperty("password");
        //2, 加载数据库驱动
        Class.forName(driverClass);
        //3, 通过DriverManager 的 getConnection()方法获取数据库连接;
        DriverManager.getConnection(url, user, password);

    }
}
