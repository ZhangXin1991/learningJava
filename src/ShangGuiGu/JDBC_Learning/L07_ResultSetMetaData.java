package ShangGuiGu.JDBC_Learning;

import org.junit.Test;
import tools.JDBCTools;
import tools.Student;

import javax.xml.transform.Result;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * ResultSetMetaData 可以用来结果集的细化处理
 */
public class L07_ResultSetMetaData {
    /**
     * ResultSetMetaData中方法的应用
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void test() throws IOException, ClassNotFoundException, SQLException {
        FileInputStream in = new FileInputStream(
                "C:\\Users\\65404\\Desktop\\learningJava\\src\\" +
                        "ShangGuiGu\\JDBC_Learning\\jdbc.properties");
        Properties pro = new Properties();
        pro.load(in);
        String driver = pro.getProperty("driver");
        String jdbcUrl = pro.getProperty("jdbcUrl");
        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
        String sql = "select id, name 名字, gender, age, job, grade from test;";
        Statement statement = conn.createStatement();


        ResultSet resultSet =  statement.executeQuery(sql);
        ResultSetMetaData rsmd =  resultSet.getMetaData();

        //  获取结果集的列总数
        int numOfColumns = rsmd.getColumnCount();
        System.out.println("获取结果集的总列数:"+numOfColumns);
        //  获取指定列的名称
        String columnName = rsmd.getColumnName(2);
        System.out.println("获取指定列的名称:"+columnName);
        //  获取指定列的包装数据类型
        String columnClassName = rsmd.getColumnClassName(2);
        System.out.println("获取指定列中的数据在Java中的包装数据类型:"+columnClassName);
        //  获取指定列的别名
        String columnLabel = rsmd.getColumnLabel(2);
        System.out.println("获取指定列的别名:" + columnLabel);
        //  获取指定列的数据库特定类型
        String columnType2 = rsmd.getColumnTypeName(2);
        System.out.println("获取指定列的数据库特定类型:"+columnType2);
        //  获取指定列的指定列宽
        int precision = rsmd.getPrecision(2);
        System.out.println("获取指定列的指定列宽"+precision);
        //  获取指定列的小数点右边的位数
        int scale = rsmd.getScale(1);
        System.out.println("获取指定列的小数点右边的位数"+scale);
        //  获取指定列的名称
        String tableName = rsmd.getTableName(2);
        System.out.println("获取指定列的名称"+tableName);
        //  判断指定列是否自动序列
        boolean ac = rsmd.isAutoIncrement(1);
        System.out.println("判断指定列是否自动序列"+ac);
        //  判断指定列是否可为null   返回1为可以,返回0则不能为空
        int isNull = rsmd.isNullable(3);
        System.out.println("判断指定列是否可为null   返回1为可以,返回0则不能为空"+isNull);

//        //  获取指定列的表模式。
//        String schemaName = rsmd.getSchemaName(2);
//        System.out.println("获取指定列的表模式"+schemaName);
//        //  获取指定列的表名称(如果所有列出自同一个表,则所有列的返回结果相同)
//        String catalogName = rsmd.getCatalogName(2);
//        System.out.println("获取结果集的目录名:"+catalogName);
//        //  指示指定列的最大标准宽度，以字符为单位(显示尺寸)
//        int columnDisplaySize = rsmd.getColumnDisplaySize(2);
//        System.out.println("指示指定列的最大标准宽度，以字符为单位:"+columnDisplaySize);
//        //  获取指定列的SQL类型
//        int columnType = rsmd.getColumnType(2);
//        System.out.println("获取指定列的SQL类型:"+columnType);

        JDBCTools.closeResultStateConn(resultSet,statement,conn);
    }

    /**
     * 尝试返回SQL语句的查询结果的细化输出
     */
    @Test
    public void test2() throws IOException, ClassNotFoundException, SQLException {
        FileInputStream in = new FileInputStream("C:\\Users\\65404\\" +
                "Desktop\\learningJava\\src\\ShangGuiGu\\" +
                "JDBC_Learning\\jdbc.properties");
        Properties pro = new Properties();
        pro.load(in);
        String driver = pro.getProperty("driver");
        String jdbcUrl = pro.getProperty("jdbcUrl");
        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(jdbcUrl, user, password);

        String sql = "SELECT ?,?,?,? FROM test WHERE id=1;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "name");
        ps.setString(2, "gender");
        ps.setString(3, "age");
        ps.setString(4, "jog");


        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i = 0; i < rsmd.getColumnCount(); i++) {
            String columnName = rsmd.getColumnLabel(i+1);
            System.out.println(columnName);
        }
//        ResultSetMetaData rsmd = rs.getMetaData();
//        int columnCount = rsmd.getColumnCount();
//        while (rs.next()) {
//            System.out.println(rs.getString(1));
//            System.out.println(rs.getString(2));
//            System.out.println(rs.getString(3));
//            System.out.println(rs.getString(4));
//
//        }
//10 struts2,
//11 hibernate,
//18 jpa.
//25 shiro


        JDBCTools.closeResultStateConn(rs,ps,conn);

    }
}
