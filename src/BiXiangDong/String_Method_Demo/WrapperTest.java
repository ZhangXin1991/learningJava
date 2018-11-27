package BiXiangDong.String_Method_Demo;


public class WrapperTest {
    public static void main(String[] args) {
        //  练习:
        /*
        对一个字符串的数值进行从小到大的排序
        "20 78 9 -7 88 36 29"

        思路1:
            把 字符串切割成一组string数字
            把 这组string数字转换成int
            把 这组int进行从小到大的排序

         */

        String str0 = "20 78 9 -7 88 36 29";

        //  字符串变字符串数组, 创建相同长度整数数组, copy字符串数组
        int[] numberStrings = stringToNumberArray(str0);
        //  bubbleSort
        int[] numbers = bubbleSort(numberStrings);
        //  print
        for (int a:numbers) {
            System.out.print(a + " ");
        }
//        //  切割字符串, 返回由字符串数字组成的字符串数组
//        String[] str1 = str0.split(" ");
//        //  创建相同长度的整数数组
//        int[] arr = new int[str1.length];
//        //  把字符串数组中的元素转换成int类型, 用int数组copy这些元素
//        for (int x=0; x<str1.length;x++) {
//            int l = Integer.parseInt(str1[x]);
//            arr[x] = l;
//        }
//
//        //  bubbleSort......
//        for (int x = 0; x<arr.length; x++){
//            for(int y = x; y<arr.length;y++){
//                int temp;
//                if (arr[x]<arr[y]){
//                    continue;
//                }
//                else{
//                    temp = arr[x];
//                    arr[x] = arr[y];
//                    arr[y] = temp;
//                }
//            }
//        }
//        //  for each 打印arr......
//        for (int x:arr)
//            System.out.println(x);
    }

    private static int[] bubbleSort(int[] numberStrings) {

        //  bubbleSort......
        for (int x = 0; x<numberStrings.length; x++){
            for(int y = x; y<numberStrings.length;y++){
                int temp;
                if (numberStrings[x]<numberStrings[y]){
                    continue;
                }
                else{
                    temp = numberStrings[x];
                    numberStrings[x] = numberStrings[y];
                    numberStrings[y] = temp;
                }
            }
        }
        return numberStrings;
    }

    private static int[] stringToNumberArray(String str0) {
        String[] str1 = str0.split(" ");
        int[] numberString = new int[str1.length];
        for (int x=0;x<str1.length;x++){
            numberString[x] = Integer.parseInt(str1[x]);
        }
        return numberString;
    }

}

