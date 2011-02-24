package o;

public class BinaryComposer {
int i=0;
int scale=1;
int offset=0;

public Integer note() {
   i++;
   String x=Integer.toBinaryString(i);
   int note=0;
   for (int i=0;i<x.length();i++) {
      if ('1'==x.charAt(i)) {note++; }
   }
   note=scale*note+offset;
   return new Integer(note);
}
public void reset() {i=0;}
public void setScale(Integer scale,Integer offset){
    this.scale=scale.intValue();
     this.offset=offset.intValue();
}

}
