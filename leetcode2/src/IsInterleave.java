public class IsInterleave {
    public static void main(String[] args){
        IsInterleave Solution = new IsInterleave();
        Solution.isInterleave("aabcc","dbbca","aadbbcbcac");
        System.out.println();
        Solution.isInterleave("aabcc", "dbbca", "aadbbbaccc");
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
        dp[0][0]=true;
        for (int i=0;i<=s1.length();i++){
            for (int j=0;j<=s2.length();j++){
                dp[i][j]=(i==0 && j==0) || (i>0 && s3.charAt(Math.max(i+j-1,0))==s1.charAt(i-1) && dp[i-1][j])
                        || (j>0 && s3.charAt(Math.max(i+j-1,0))==s2.charAt(j-1) && dp[i][j-1]);
            }
        }
        for (int i=0;i<s1.length();i++){
            for (int j=0;j<s2.length();j++){
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
        return dp[s1.length()][s2.length()];
    }
}
