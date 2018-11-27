package BiXiangDong;

/**
 * 查找字符串数组中 是否存在指定的字符串,
 * 如果存在, 则返回第一个存在的角标, 否则返回-1
 */

class catchArrayIndex{

    public int getindex(String[] arr, String num)
    {
        if (arr == null)
        {
            throw new IllegalArgumentException("数组没有字符");
        }

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == num){
                return i;
            }
        }
        return -1;
    }


}

public class Question25 {
    public static void main(String[] ars)
    {
        String[] arr1 = new String[] {"123", "321", "223"};
        String[] arr2 = null;
        catchArrayIndex a = new catchArrayIndex();
        System.out.println(a.getindex(arr1, "321"));
        System.out.println(a.getindex(arr2, "a"));
    }
}
