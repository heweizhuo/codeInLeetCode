public class FindMin {
    public static void main(String[] args){
        FindMin Solution=new FindMin();
        System.out.println(Solution.findMin(new int[]{3,1,2}));
    }
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int low=0,hi=nums.length-1;
        while (low<hi){
            if(nums[low]<nums[hi]) return nums[low];

            int mid=(low+hi)/2;
            if(nums[mid]>nums[hi])
                low=mid+1;
            else hi=mid;
        }
        return nums[low];
    }
}
