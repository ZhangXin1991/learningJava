package ShangGuiGu.JDBC_Learning;

import ShangGuiGu.Reflect.ReflectUtils;
import tools.JDBCTools;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO: Data Access Object  数据库访问对象(数据库存取)
 *
 * 实现功能的模块化,有利于代码的维护和升级
 * DAO 可以被子类继承或直接使用
 *
 * 访问数据信息的类, 包含对数据的CRUD(create,read,update,delete)
 * 而不包含任何业务相关的信息
 *
 * 使用JDBC编写DAO可能会包含的方法:
 *      INSERT,UPDATE,DELETE 操作都可以包含在其中
 *      void update(String sql, Object ... args);
 *      查询一条记录
 *      <T> T get(Class<T> clazz, String sql, Object ... args);
 *      查询多条记录
 *      <T> List<T> getForList(Class<T> clazz, String sql, Object ... args);
 *      返回某一个对象的属性值,或一个统计的值
 *      <E> E getForValue(String sql,Object ... args);
 */
public class L08_DAO {

    /**
     * INSERT,UPDATE,DELETE 操作都可以包含在其中
     * @param sql
     * @param args
     */
    public void update(String sql, Object... args) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            //  获取数据库连接, 获取sql执行对象, 传入sql模板
            connection = JDBCTools.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            //  将指定的参数传入sql模板中
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.closeResultStateConn(null,preparedStatement,connection);
        }

    }

    /**
     * 查询一条记录
     * 返回一个实例化结果对象
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T get(Class<T> clazz, String sql, Object... args) {

        T entity = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        try {
            //1, 获取Connection
            connection = JDBCTools.getConnection();

            //2, 获取PreparedStatement
            preparedStatement = connection.prepareStatement(sql);

            //3, 填充占位符
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            //4, 进行查询,得到ResultSet
            resultSet = preparedStatement.executeQuery();

            //5, 如果resultSet中next()方法返回true(含有记录)
            // 准备一个Map<String, Object> 键: 存放列的别名 值: 存放列的值
            if (resultSet.next()) {
                Map<String, Object> values = new HashMap<String, Object>();

                //6, 得到ResultSetMetaData 对象
                resultSetMetaData = resultSet.getMetaData();

                //7, 处理ResultSet, 把指针向下移动一个单位
                //  此处由于第5处已经执行了resultSet.next()方法,
                // 故 指针已经下移一个单位, 所以什么都不写了

                //8, 由ResultSetMetaData对象得到具体结果集中有多少列
                int columnCount = resultSetMetaData.getColumnCount();

                //9, 由ResultSetMetaData得到每一列的别名,
                //   由ResultSet得到具体每一列的值
                for (int i = 0; i < columnCount; i++) {
                    //  获取每一列的别名
                    String columnLabel = resultSetMetaData.getColumnLabel(i + 1);
                    //  获取每一列的值 resultSet.getObject(传入别名)
                    Object columnValue = resultSet.getObject(columnLabel);

                    //10, 填充Map对象   其实可以在此循环前创建Class对应对象,
                    // 在此处直利用列的别名填充对象的属性值
                    values.put(columnLabel, columnValue);
                }

                //11, 利用反射创建Class对应的对象
                entity = clazz.newInstance();
                //12, 遍历Map对象, 用反射填充对象的属性值, 其中属性名为key,属性值为value
                for (Map.Entry<String, Object> entry : values.entrySet()) {
                    String propertyName = entry.getKey();
                    Object value = entry.getValue();

                    //  设置对象对应参数名的属性值
                    ReflectUtils.setFieldValue(entity,propertyName,value);
                }
            }
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } finally {//   关闭各个资源
            JDBCTools.closeResultStateConn(resultSet,preparedStatement,connection);
        }

        return entity;
    }

    /**
     * 查询多条记录
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {

        
        return null;
    }

    /**
     * 返回某一个对象的属性值,或一个统计的值
     * @param sql
     * @param args
     * @param <E>
     * @return
     */
    public <E> E getForValue(String sql, Object... args) {

        return null;
    }

}
