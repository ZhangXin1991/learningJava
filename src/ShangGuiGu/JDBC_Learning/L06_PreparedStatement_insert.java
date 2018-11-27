package ShangGuiGu.JDBC_Learning;

import org.junit.Test;
import tools.JDBCTools;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * PreparedStatement是Statement的子接口,可以传入带占位符的SQL语句
 * 并且提供了补充占位符变量的方法.
 * 此种方式还可以有效的避免sql注入
 * 使用PreparedStatement代替Statement
 *
 * 由于使用Statement INSERT 多条SQL语句不容易对SQL进行拆解,过于不便
 * 所欲使用PreparedStatement来替换Statement
 *
 * 准备SQL模板:     占位符 : ?
 *      String sql = "INSERT INTO test(tid,tname,birthday)VALUES(?,?,?)
 * 获取PreparedStatement对象,并传入sql模板:
 *      PreparedStatement ps = conn.preparedStatement(sql);
 * 传入数据:    set对应类型(索引,值)
 *      ps.setxxx(int index, Object value);
 * 调用:
 *      - ps.executeQuery();    查询(SELECT
 *      - ps.executeUpdate();   更新(UPDATE,插入(INSERT,删除(DELETE
 */
public class L06_PreparedStatement_insert {

    @Test
    public void testPreparedStatement()  {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //  获取数据库连接对象
            conn = JDBCTools.getConnection();

            //  准备sql模板
            String sql = "INSERT INTO test(name,gender,age,job,grade)values(?,?,?,?,?)";

            //  获取调用sql对象并接收sql模板
            ps = conn.prepareStatement(sql);

            //  填写sql模板
            ps.setString(1,"花花");
            ps.setString(2,"花");
            ps.setInt(3,2);
            ps.setString(4,"摆件");
            ps.setInt(5,8);

            //  调用sql
            ps.executeUpdate();

        } catch (SQLException e) { e.printStackTrace();
        }finally {//    关闭各种资源
            JDBCTools.closeResultStateConn(null,ps,conn);
        }
    }
}

