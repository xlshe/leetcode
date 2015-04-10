public class RotateArray {


    public void rotateWithExtraSpace(int[] nums, int k) {
        if (nums==null || nums.length == 0 || k<=0) {
            return;
        }
        int[] result = new int[nums.length];
        
        for (int i=0; i<nums.length; i++) {
            result[(i+k)%nums.length] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }
}
