package ShangGuiGu.JDBC_Learning;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * ResultSet : 结果集. 封装了JDBC进行查询的结果
 * 1, 调用Statement对象的executeQuery(sql)可以得到结果集
 * 2, ResultSet返回的实际上就是一张数据表,
 *  有一个指针指向数据表的第一行的前面,可以调用next()方法检测下一行是否有效,
 *  如果有效返回true,并且指针下移
 * 3, 当指针定位到一行时, 可以通过调用getxxx(index)或getxxx(columnName)获取每一列的值
 *  例如: getInt(1), getString("name"), getDate("1991-11-9")
 * 4, 注意:   操作结束后ResultSet必须关闭!
 */
public class L05_ResultSet_select {
    @Test
    public void testResultSet() {

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1, 获取Connection
            conn = getConnection();

            //2, 获取statement
            statement = conn.createStatement();

            //3, 准备select语句
            String sql = "SELECT * FROM test";

            //4, 执行查询, 得到ResultSet
            resultSet = statement.executeQuery(sql);

            //5, 处理ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Date birthday = resultSet.getDate(3);
                System.out.print(id);
                System.out.print(name);
                System.out.println(birthday);
            }

        } catch (SQLException | IOException e) { e.printStackTrace();
        } finally {
            //6, 关闭各个资源
            try {
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) { e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) { e.printStackTrace();
            }
        }
    }

    /**
     * 获取MySQL数据库中my_database库test表的连接
     * @return 返回 Connection实例对象
     * @throws IOException
     * @throws SQLException
     */
    private Connection getConnection() throws IOException, SQLException {
        FileInputStream in = null;
        try {
            in = new FileInputStream("C:\\Users\\65404\\Desktop\\learningJava\\src\\SGU\\JDBC_Learning\\jdbc.properties");
        } catch (FileNotFoundException e) { e.printStackTrace();
        }
        Properties pro = new Properties();
        assert in != null;
        pro.load(in);

        String driver = pro.getProperty("driver");
        String url = pro.getProperty("jdbcUrl");
        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("异常....");
        }
        finally {
            in.close();
        }
        return DriverManager.getConnection(url, user, password);
    }
}
