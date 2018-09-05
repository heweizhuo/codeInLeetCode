import java.util.*;

public class CanCross {
    public static void main(String[] args){
        CanCross Solution=new CanCross();
        System.out.println(Solution.canCross(new int[]{0,1,3,5,6,8,12,17}));
    }
    public boolean canCross(int[] stones) {
        int []dp=new int[stones.length];
        Map<Integer, List<Integer>> m=new HashMap<>();
        int k=0;
        m.put(0, Arrays.asList(0));
        for (int i=1;i<stones.length;i++){
            while (dp[k]+1<stones[i]-stones[k]) k++;
            for (int j=k;j<i;j++){
                int step=stones[i]-stones[j];
                if(m.containsKey(j) && (m.get(j).contains(step) || m.get(j).contains(step+1) || m.get(j).contains(step-1))){
                    dp[i]=Math.max(dp[i],step);
                    List<Integer> tmp=m.getOrDefault(i,new ArrayList<>());
                    tmp.add(step);
                    m.put(i,tmp);
                }
            }
        }
        return dp[stones.length-1]>0;
    }

}
