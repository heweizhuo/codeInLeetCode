package Tree;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        int l=nums.length;
        if(l<2) return 0;
        int[] tmp=new int[l];
        int max=0,div=1;
        for(int i=0;i<l;i++){
            max=Math.max(max,nums[i]);
        }
        while (max/div!=0){
            int[] vector=new int[10];
            for (int i=0;i<l;i++) vector[(nums[i]/div)%10]++;
            for (int i=1;i<10;i++) vector[i]+=vector[i-1];
            for (int i=l-1;i>=0;i--) tmp[--vector[(nums[i]/div)%10]]=nums[i];
            for (int i=0;i<l;i++) nums[i]=tmp[i];
            div*=10;
        }
        max=0;
        for (int i=1;i<l;i++) max=Math.max(max,nums[i]-nums[i-1]);
        return max;
    }
}
