public class ReverseWord {
    public String reverseWords(String s) {
         String s_t=s.trim();
         String [] words=s_t.split(" ");
         String ans="";
         
         for(int i=words.length-1;i>=0;i--){
             String word=words[i].trim();
             if(!word.equals("")){
             if(words.length>1){
                if(i!=0){
                   ans+=word.trim()+" ";
                }else{
                    ans+=word.trim();
                }
             }else{
                 ans=word;
             }
             
         }else{
             continue;
         }
         }
         return ans;
    }

    
}