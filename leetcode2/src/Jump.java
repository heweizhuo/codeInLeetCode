public class Jump {
    public static void main(String[] args){
        Jump Solution=new Jump();
        System.out.println(Solution.jump(new int[]{0}));
    }
    public int jump(int[] nums) {
        int ans=0,pre=0,cur=0;
        while (cur<nums.length){
            for (int i=pre;i>=0;i--){
                cur=Math.max(cur,i+nums[i]);
                if (cur>=nums.length-1) return ans+1;
            }
            ans++;
            if(cur==pre) return -1;
            pre=cur;
        }
        return ans;
    }
}
