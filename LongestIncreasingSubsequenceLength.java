import java.util.ArrayList;
import java.util.Stack;

public class LongestIncreasingSubsequenceLength {
    public static void setUp(){
        int[] arr = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        //System.out.println("The length of the Longest Subsequence is: " + longSub(arr));
        System.out.println(LIS(arr));
    }

    public static ArrayList<Integer> LIS(int[] nums) {
        if(nums == null || nums.length==0)
            return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int num : nums){
            if(list.size() == 0 || num > list.get(list.size()-1)){
                list.add(num);
            }
            else{
                int i=0;
                int j = list.size() - 1;
                while(i < j){
                    int mid = (i + j) / 2;
                    if(list.get(mid) < num){
                        i = mid + 1;
                    }
                    else{
                        j = mid;
                    }
                }
                list.set(j, num);
            }
        }
        return list;
    }
}
