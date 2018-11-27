package ShangGuiGu.JDBC_Learning;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 通过JDBC 向指定的数据表插入一条记录
 *
 * 1, Statement: 用于执行SQL语句的对象
 *  - 通过Connection的createStatement()方法来获取
 *  - 通过executeUpdate(sql)可以执行SQL语句
 *  - sql可以是INSERT, UPDATE, DELETE 但不能是SELECT
 *
 * 2, Connection与Statement都是应用程序与数据库服务器的连接资源,
 *      使用后必须要关闭
 *
 * 3, 注意:  异常可以不处理, 但各个资源连接必须要关闭! 注意关闭顺序!
 *
 */
public class L04_Statement_insert_update_delete {

    /**
     * 向my_database数据库中的test表插入一条SQL语句
     * sql="INSERT INTO test(tid,tname)VALUES(6,'赵毅'),(7,'范英博')"
     * @throws SQLException
     */
    @Test
    public void testStatement() throws SQLException {
        Connection conn = null;
        Statement statement = null;
        try {
            //1, 获取数据库连接
            conn = getConnection();

            //3, 准备插入的SQL语句, sql可以是插入,删除,更改语句
            String sql = "INSERT INTO test(tid,tname)values(6,'赵毅'),(7,'范英博')";
//            String sql = "DELETE FROM test WHERE tid>=6";
//            String sql = "UPDATE test SET tname='喵喵' WHERE tid=6";
            //4, 执行插入
            //4.1, 获取操作SQL语句的Statement对象,
            // 通过调用Connection的createStatement()方法来获取
            statement = conn.createStatement();
            //4.2, 调用Statement对象的executeUpdata(sql)执行SQL语句进行插入
            statement.executeUpdate(sql);
        } catch (IOException | SQLException e) { e.printStackTrace();
        } finally {
            try {
                //5, 关闭Statement对象, 必不可少的!
                assert statement != null;
                statement.close();
            } finally {
                //2, 关闭数据库连接, 必不可少的!
                assert conn != null;
                conn.close();
            }
        }
    }

    /**
     * 建立MysSQL数据库中my_database数据库的连接
     * 读取一个存有MySQL数据库连接信息的properties文件
     * @return 返回 Connection类的实例对象
     * @throws IOException
     * @throws SQLException
     */
    public static Connection getConnection() throws IOException, SQLException {
        FileInputStream in = new FileInputStream(
                "C:\\Users\\65404\\Desktop\\learningJava\\src\\SGU\\JDBC_Learning\\jdbc.properties"
        );
        Properties pro = new Properties();
        pro.load(in);

        String driver = pro.getProperty("driver");
        String url = pro.getProperty("jdbcUrl");
        String user = pro.getProperty("user");
        String passsword = pro.getProperty("password");

        return DriverManager.getConnection(url, user, passsword);
    }

    /**
     * 通用的更新方法: 接收INSERT , UPDATE, DELETE语句
     * 版本1.
     */
    public void update(String sql) {
        Connection conn = null;
        Statement statement = null;
        try {// 获取数据库连接,执行sql语句
            conn = getConnection();
            statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException | IOException e) { e.printStackTrace();
        } finally {//   关闭资源
            try {
                assert statement != null;
                statement.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}
