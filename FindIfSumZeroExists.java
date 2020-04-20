import java.util.*;
/**
 * find a sub array that sums to zero
 * in an array
 * */
public class FindIfSumZeroExists {
    public static void main(String[] args) {
        // sample input
        int[] arr = new int[] {
            1,
            2,
            3,
            -5,
            5,
            5,
            7
        };
        /**
         * in the input above
         * idx 1,2,3 sum to zero
         * so the answer to this test input would be true
         * */
        System.out.println(findIfSumZeroExists(arr));
    }
    public static boolean findIfSumZeroExists(int[] arr) {
        // we use a set to reduce complexity
        Set < Integer > set = new HashSet < > ();
        // we init sum to 0
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // we add arr[idx] to sum
            sum += arr[i];
            // if sum already exists in the set, that means
            // we have found a subset that has sum zero
            // because we have seen the same sum before
            // 10 + something = 10 means something is 0
            if (set.contains(sum)) {
                // if we find a sum, we return true
                return true;
            } else {
                // we add the sum to set for future reference
                set.add(sum);
            }
        }
        // in all other cases, we return false
        return false;
    }
}
