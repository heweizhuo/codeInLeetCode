import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FullJustify {
    public static void main(String[] args){
        FullJustify Solution=new FullJustify();
        Solution.fullJustify(new String[]{"Listen","to","many,","speak","to","a","few."},6);
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans=new LinkedList<>();
        int indexOfwords=0,len=words.length;
        while (indexOfwords<len){
            String str=new String(words[indexOfwords++]);
            int wordCnt=1,curLen=str.length();
            while (indexOfwords<len && curLen+words[indexOfwords].length()+1<=maxWidth){
                curLen+=words[indexOfwords++].length()+1;
                wordCnt++;
            }
            if(wordCnt>1 && curLen<maxWidth && indexOfwords<len){
                int dt=maxWidth-curLen+wordCnt-1;
                while (dt>0){
                    for (int i=indexOfwords-wordCnt;i<indexOfwords-1;i++){
                        words[i]+=" ";
                        dt--;
                        if(dt==0) break;
                    }
                }
                str=String.join("",Arrays.copyOfRange(words,indexOfwords-wordCnt,indexOfwords));
            }
            else {
                str=String.join(" ",Arrays.copyOfRange(words,indexOfwords-wordCnt,indexOfwords));
                while (maxWidth-str.length()>0)
                    str+=" ";
            }
            ans.add(str);
        }
        return ans;
    }
}
