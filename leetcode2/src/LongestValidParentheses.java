public class LongestValidParentheses {
    public static void main(String[] args){
        LongestValidParentheses Solution=new LongestValidParentheses();
        System.out.println("\n"+Solution.longestValidParentheses(")(((((()())()()))()(()))("));
    }
    public int longestValidParentheses(String s) {
        int dp[]=new int[s.length()+1],max=0;
        for (int i=1;i<s.length();i++){
            char c=s.charAt(i);
            if(s.charAt(i)==')'){
                if (s.charAt(i-1)=='('){
                    dp[i+1]=dp[i-1]+2;
                }
                else {
                    if(i-1-dp[i]>=0 && s.charAt(i-1-dp[i])=='(')
                        dp[i+1]=dp[i]+2+dp[i-1-dp[i]];
                }
            }
            max=Math.max(dp[i+1],max);
        }
        return max;
    }
}
