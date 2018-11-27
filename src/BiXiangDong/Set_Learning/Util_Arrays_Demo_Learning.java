package BiXiangDong.Set_Learning;

/*
  Arrays
  这是一个数组的工具类
  这个工具类中的方法都是static的
  java.lang.Object
    |-  java.util.Arrays

  特点:
  注意:

  类方法:
    - 重点: List asList(数组) 将数组转化成集合, 可以使用集合自带的方法
      如: 查找一个数组中是否包含某个元素, 就可以用ArrayList集合中的contains方法来完成
      注意: 因为数组的长度是固定的, 所以对于转化后的集合中的增删方法是不支持的,会引发异常
        static <T> List<T>
        Arrays.asList(T... a)
        返回由指定数组支持的固定大小列表 (指定数组的列表视图)
        此方法充当基于数组和基于集合的API之间的桥梁, 并与之结合使用
        Collection.toArray(), 返回的列表是可序列化的并且实现RandomAccess(随机存取
        此方法还提供了一种方便的方法来船舰初始化为包含多个元素的固定大小的列表:
         List <String> stooges = Arrays.asList("Larry","Moe","Curly");
*/
public class Util_Arrays_Demo_Learning {
}
