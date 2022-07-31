import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        //Arrays类
        //toString将整个数组转换为字符串输出
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(arr));

        //sort将数组元素升序排序
        int[] nums = {5,4,3,2,1};
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println();
        //binarySearch找到数组元素所在的下标
        //目标数组必须是有序的,否则会出错
        //找不到指定元素,则返回一个负数
        //重复元素以第一个元素下标为返回值
        int[] sorted = {1,2,3,4,5,6,7,7,8,9,10};
        int[] unsorted = {1,5,3,2,9,7,6,4,10};
        System.out.println(Arrays.binarySearch(sorted, 7));
        System.out.println(Arrays.binarySearch(sorted, 111));
        System.out.println(Arrays.binarySearch(unsorted, 4));
    }
}
