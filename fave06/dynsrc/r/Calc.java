package r;

public class Calc {
public float calcFrScale(Integer ratio){
     return ratio.intValue()*0.03f*-1f;
}
public float div(Float val, Float divisor){
     return val.floatValue()/divisor.floatValue();
}
public float rndpos() {
   return (float)Math.random()*4+-2f;	
}
public float rndrot() {
   return (float)Math.random()*360+-180f;	
}
}
