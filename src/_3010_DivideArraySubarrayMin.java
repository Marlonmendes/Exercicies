import java.util.Arrays;

public class _3010_DivideArraySubarrayMin {

    public static void main(String[] args) {
        int[] nums = {1,2,3,12};
        minimumCost(nums);
    }

    public static int minimumCost(int[] nums) {
        int minValue = 0;
        int custo;

        for(int i=1;i<nums.length;i++) {
            for (int j=i+1; j<nums.length; j++) {
                custo = nums[0] + nums[i] + nums[j];
                if(custo < minValue || minValue == 0){
                    minValue = custo;
                }
            }
        }
        System.out.println(minValue);
        return minValue;
    }
}