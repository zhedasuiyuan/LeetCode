
public class ReversePolish {
    public int evalRPN(String[] tokens) {
     int len=tokens.length;
//     int num=len;
     int result=0;
     while(len>2){
         for(int i=0;i<len;i++){
             if(tokens[i+2].equals("+")){
                result=Integer.parseInt(tokens[i])+Integer.parseInt(tokens[i+1]);
                int index=i;
                
                for( i=0;i<len;i++){
                    if(i==index){
                    tokens[index]=String.valueOf(result);
                    }else if(i>index&&i<len-2){
                      tokens[i]=tokens[i+2];
                    }
                }
                len=len-2;
             }else if(tokens[i+2].equals("-")){
                 result=Integer.parseInt(tokens[i])-Integer.parseInt(tokens[i+1]);
                int index=i;
                
                for( i=0;i<len;i++){
                    if(i==index){
                    tokens[index]=String.valueOf(result);
                    }else if(i>index&&i<len-2){
                      tokens[i]=tokens[i+2];
                    }
                }
                len=len-2;
             }else if(tokens[i+2].equals("*")){
                 result=Integer.parseInt(tokens[i])*Integer.parseInt(tokens[i+1]);
                int index=i;
                
                for( i=0;i<len;i++){
                    if(i==index){
                    tokens[index]=String.valueOf(result);
                    }else if(i>index&&i<len-2){
                      tokens[i]=tokens[i+2];
                    }
                }
                len=len-2;
             }else if(tokens[i+2].equals("/")){
                 result=Integer.parseInt(tokens[i])/Integer.parseInt(tokens[i+1]);
                int index=i;
                
                for( i=0;i<len;i++){
                    if(i==index){
                    tokens[index]=String.valueOf(result);
                    }else if(i>index&&i<len-2){
                      tokens[i]=tokens[i+2];
                    }
                }
                len=len-2;
             }else{
                 continue;
             }
         }
     }
     if(len==1){
         return Integer.parseInt(tokens[0]);
     }
     return result;
    }
}