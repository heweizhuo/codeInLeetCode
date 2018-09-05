public class ShortestPalindrome {
    public static void main(String[] args){
        String s="aaaaace";
        ShortestPalindrome Solution =new ShortestPalindrome();
        System.out.println(Solution.shortestPalindrome(s));
        System.out.println();
        System.out.println(Solution.shortestPalindrome2(s));
    }
    public String shortestPalindrome(String s) {
        StringBuilder r=new StringBuilder(s).reverse();
        StringBuilder sr=new StringBuilder(s+"#"+r);
        int k=-1,j=0,srlen=sr.length();
        int next[]=new int[srlen];
        next[0]=-1;
        while(j<srlen-1){
            if(k==-1 || sr.charAt(j)==sr.charAt(k))
                next[++j]=++k;
            else k=next[k];
        }
        for (int i=0;i<s.length()*2+1;i++)
            System.out.print(next[i]+" ");
        System.out.println();
        return r.substring(0,s.length()-next[srlen-1]-1)+s;
    }
    public String shortestPalindrome2(String s) {
        String r = new StringBuilder(s).reverse().toString();
        String t = s + "#" + r;
        int[] next = new int[t.length()];
        for (int i = 1; i < t.length(); ++i) {
            int j = next[i - 1];
            while (j > 0 && t.charAt(i) != t.charAt(j)) j = next[j - 1];
            j += (t.charAt(i) == t.charAt(j)) ? 1 : 0;
            next[i] = j;
        }
        for (int i=0;i<s.length()*2+1;i++)
            System.out.print(next[i]+" ");
        System.out.println();
        return r.substring(0, s.length() - next[t.length() - 1]) + s;
    }
}
