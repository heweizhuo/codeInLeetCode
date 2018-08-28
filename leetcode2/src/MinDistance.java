public class MinDistance {
    public  static void main(String[] args){
        MinDistance Solution=new MinDistance();
        Solution.minDistance("bbc","abcd");
    }
    public int minDistance(String word1, String word2) {
        int len1=word1.length(),len2=word2.length();
        int dp[][]=new int[len1+1][len2+1];
        for (int i=0;i<=len1;i++){
            for (int j=0;j<=len2;j++){
                if(i==0) dp[i][j]=j;
                else if(j==0) dp[i][j]=i;
                else {
                    int min=Integer.MAX_VALUE;
                    min=Math.min(min,dp[i-1][j]+1);
                    min=Math.min(min,dp[i][j-1]+1);
                    if (word1.charAt(i-1)==word2.charAt(j-1))
                        min=Math.min(min,dp[i-1][j-1]);
                    else min=Math.min(min,dp[i-1][j-1]+1);
                    dp[i][j]=min;
                }
            }
        }
//        for (int i=0;i<=len1;i++){
//            for (int j=0;j<=len2;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        return dp[len1][len2];
    }
}
