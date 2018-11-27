package tools;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTools {

    /**
     * 获取MySQL数据库的my_database库中test表的连接
     * @return  返回一个Connection对象
     */
    public static Connection getConnection() {
        FileInputStream in = null;
        Properties pro = new Properties();
        Connection conn = null;
        try {
            in = new FileInputStream(
                    "C:\\Users\\65404\\Desktop\\" +
                            "learningJava\\src\\ShangGuiGu\\" +
                            "JDBC_Learning\\jdbc.properties");
            pro.load(in);
            String driver = pro.getProperty("driver");
            String jdbcUrl = pro.getProperty("jdbcUrl");
            String user = pro.getProperty("user");
            String password = pro.getProperty("password");
            Class.forName(driver);
            conn = DriverManager.getConnection(jdbcUrl, user, password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 执行SQL语句, 使用PreparedStatement
     * @param sql
     * @param args: 填写SQL 占位符的可变参数
     */
    public static void update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = JDBCTools.getConnection();
            preparedStatement = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           JDBCTools.closeResultStateConn(null,preparedStatement,conn);
        }
    }

    /**
     * 关闭各个资源连接,
     * @param r ResultSet
     * @param s Statement
     * @param c Connection
     */
    public static void closeResultStateConn(ResultSet r, Statement s, Connection c) {
        if (r != null) { try {
                r.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        if (s != null) { try {
                s.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        if (c != null) { try {
                c.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}
