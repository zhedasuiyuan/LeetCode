import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//import java.util.Map.Entry;

// Definition for a point.
  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
 }
 
public class MaxPoints {
    public int maxPoints(Point[] points) {
      int len=points.length;
      int ans=0;
      int[] num = new int[len];
      HashMap<Double,Integer> slope=new HashMap<Double,Integer>();
      int maxp=0;
      for(int i=0;i<len;i++){
          for(int j=0;j<len;j++){
              if(i!=j){
                  if(points[j].y==points[i].y&&points[j].x==points[i].x){
                      num[i]++;     
                  }else if(points[j].x==points[i].x){
                	   int tmp=0;
                	   if(slope.get(new Double(Double.MAX_VALUE))!=null){
                		   tmp=slope.get(new Double(Double.MAX_VALUE));
                	   }
                	   tmp++;
                       slope.put(new Double(Double.MAX_VALUE),tmp);
                  }else{
                      double tmp=(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x);
                      int tmp2=0;
                      if(slope.get(tmp)!=null){
                    	  tmp2=slope.get(tmp);
                      }
                      tmp2++;
                      slope.put(tmp,tmp2);
                  }
            }
          }
      Iterator it=slope.entrySet().iterator();
      int maxvalue=0;
      while(it.hasNext()){
          Map.Entry pairs=(Map.Entry)it.next();
          if((Integer)pairs.getValue()>maxvalue){
              maxvalue=(int) pairs.getValue();
          }
          it.remove();
      }
      num[i]=num[i]+1+maxvalue;
      slope.clear();
    }
    for(int k=0;k<len;k++){
        if(num[k]>ans){
            ans=num[k];
        }
    }
    return ans;
    }
    
    public static void main(String[] args){
    	Point[] points=new Point[9];
    //	test case [(84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)]
    	points[0]=new Point(84,250);
    	points[1]=new Point(0,0);
    	points[2]=new Point(1,0);
    	points[3]=new Point(0,-70);
    	points[4]=new Point(0,-70);
    	points[5]=new Point(1,-1);
    	points[6]=new Point(21,10);
    	points[7]=new Point(42,90);
    	points[8]=new Point(-42,-230);
    	System.out.println(new MaxPoints().maxPoints(points));
    	
    }
}