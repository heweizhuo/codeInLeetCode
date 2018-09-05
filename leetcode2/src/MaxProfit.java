import java.util.Stack;

public class MaxProfit {
    public static void main(String[] args){
        MaxProfit Solution=new MaxProfit();
//        System.out.println(Solution.maxProfit(new int[]{7,11,4,1,2}));
    }
//    public int maxProfitIV(int k, int[] prices) {
//
//    }
    public int maxProfitIII(int[] prices) {
        if(prices.length==0) return 0;
        int len=prices.length,buy=prices[0],max=0;
        int first[]=new int[len];
        for (int i=1;i<len;i++){
            if(prices[i]<buy)
                buy=prices[i];
            else max=Math.max(max,prices[i]-buy);
            first[i]=max;
        }
        int second[]=new int[len];
        int sale=prices[len-1];
        max=0;
        for (int j=len-2;j>=0;j--){
            if(prices[j]<sale)
                max=Math.max(max,sale-prices[j]);
            else sale = prices[j];
            second[j]=max;
        }
        for (int i=0;i<len-1;i++){
            max=Math.max(first[i]+second[i+1],max);
        }
        return max;
    }
}
