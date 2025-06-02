class Solution {
    public void moveZeroes(int[] nums) {
        int result[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i]=0;
        }
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                result[j]=nums[i];
                j++;
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=result[i];
        }
    }
}