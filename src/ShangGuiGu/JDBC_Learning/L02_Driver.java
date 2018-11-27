package ShangGuiGu.JDBC_Learning;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Java.sql.Driver接口
 * 驱动程序
 *
 * 不知道什么原因失败了
 */
public class L02_Driver {

    /**
     * 演示:  通过Driver直接连接数据库
     * Driver 是一个接口
     * 是数据库厂商必须提供实现的接口,能从其中获取数据库连接
     * 可以通过Driver的实现类获取获取数据库的连接
     * 1, 加入MySQL驱动jar包
     *    control+shift+atl+S,导入MySQL的驱动jar包
     * 2,
     */
    @Test
    public void testDriver() throws SQLException {
        //1,  加载MySQL驱动类
        Driver driver = new com.mysql.jdbc.Driver();

        /*
        JDBC URL的标准由三部分组成
        JDBC: <子协议>:<子名称>
        协议:JDBC URL 中的协议总是jdbc
        子协议:子协议用于标识一个数据库驱动程序
        子名称:一种标识数据库的方法,子名称可以依不同的子协议而变化,
        用自名称的目的是为了定位数据库提供足够的信息
         */
        //2,  准备连接数据库的基本信息:url, user,password
        String url = "jdbc:mysql://localhost:3306/my_database";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "zx15245083842");

        //3,  调用Driver接口的connect(url,info)获取数据库的连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

    /**
     * 编写一个通用的方法,在不修改源程序的情况下,可以获取任何数据库的连接
     * 解决方案: 把数据库驱动Driver实现类的全类名,url,user,password放入配置文件中,
     * 通过修改配置文件的方式实现和具体数据库解耦
     */
    @Test
    public Connection getConnection() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException, IOException {
        //可以把这些信息封装到文件中
        String driverClass = null;
        String jdbcUrl = null;
        String user = null;
        String password = null;
        //读取类路径下的jdbc.properties文件
        InputStream in = getClass().getClassLoader().getResourceAsStream(
                "C:\\Users\\65404\\Desktop\\learningJava\\src\\SGU\\JDBC_Learning");
//        File jdbc = new File(
//                "C:\\Users\\65404\\Desktop\\learningJava\\src\\SGU\\JDBC_Learning");
//        FileInputStream in = new FileInputStream(
//                jdbc);
        Properties properties = new Properties();
        properties.load(in);
        driverClass = properties.getProperty("driver");
        jdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");

        //使用jdbc.properties文件中的数据库基本信息调用Driver接口中的connect方法连接数据库
        Driver driver = (Driver) Class.forName(driverClass).newInstance();
        Properties info = new Properties();
        info.put("user", user);
        info.put("password", password);
        Connection conn = driver.connect(jdbcUrl, info);

        return conn;
    }
    @Test
    public void testgetConn() throws ClassNotFoundException, SQLException, InstantiationException, IOException, IllegalAccessException {
        System.out.println(getConnection());
    }
}
