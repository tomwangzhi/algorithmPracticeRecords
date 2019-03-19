package TwoSum;

import java.util.*;

/**
 * target problem url：https://leetcode-cn.com/problems/two-sum/
 * detail sovle ways:https://leetcode-cn.com/articles/two-sum/
 */
public class TwoSumTotal {

    // example data build
    private static int[] array = new int[] {4,6,9,22,3,11};
    private static int target = 31;


    // way1: time:o(n2)
    /**
     * search in the given array,the two data sum is equal to target
     * @param array given array not null
     * @param target object value
     * @return if not find the two data return null else return two data index in array
     */
    private static int[] sum(int[] array,int target) {
        int[] result = new int[2];
        if(Objects.isNull(array)) {
            throw new NullPointerException("offer parameters is null");
        }

        int size = array.length;
        boolean flag = false;
        for (int i = 0;i < size;i++) {
            for(int j = i+1;j < size;j++) {
                if(array[i]+array[j] == target) {
                    result[ResulIndex.First.getValue()] = i;
                    result[ResulIndex.TWO.getValue()] = j;
                    flag = true;
                    break;
                }
            }
        }

        // not find
        if(!flag) {
            return null;
        }

        return result;


    }

    // way2: time:o(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] result = TwoSumTotal.sum(array,target);
        System.out.println(Arrays.toString(result));
    }
     enum ResulIndex{
        First(0),
        TWO(1);
        int value;
        ResulIndex(int value) {
            this.value = value;
        }

         public int getValue() {
             return value;
         }
     }
}
