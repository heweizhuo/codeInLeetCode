import java.util.*;

public class FindSubstring {
    public static void main(String[] args){
        String s = "barfoofoobarthefoobarman";
        String[] words =new String[]{"foo","bar","the"};
        FindSubstring findSubstring=new FindSubstring();
        List<Integer> ans=findSubstring.findSubstring(s,words);
        for (Integer i:ans){
            System.out.print(i+", ");
        }
    }
    public List<Integer> findSubstring(String s, String[] words) {
        if(s.length()==0 || words.length==0) return new ArrayList<>();
        Map<String,Integer> wordsMap=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        int len=words[0].length(),cnt=words.length,wordlength=len*cnt;
        for (int i=0;i<words.length;i++){
            wordsMap.put(words[i],wordsMap.getOrDefault(words[i],0)+1);
        }
        for (int i=0;i<len;i++){
            for(int j=i;j+wordlength<=s.length();j+=len){
                String curStr=s.substring(j,j+wordlength);
                Map<String,Integer> map=new HashMap<>();
                for (int k=cnt-1;k>=0;k--){
                    String subCurStr=curStr.substring(k*len,(k+1)*len);
                    int count=map.getOrDefault(subCurStr,0)+1;
                    if(count>wordsMap.getOrDefault(subCurStr,0)){
                        j=j+k*len;
                        break;
                    }
                    else if(k==0 && !ans.contains(j)){
                        ans.add(j);
                    }
                    else map.put(subCurStr,count);
                }
            }
        }

        return ans;
    }
}
