class Solution {
    public void sortColors(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int temp=0;
            if(nums[j]<nums[i]){
               temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;       
        }
    }
    System.out.print(nums[i]);
  }
 }
}
