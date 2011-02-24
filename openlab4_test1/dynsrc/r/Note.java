package r;

public class Note {
float note=120.0f;

int ctr=0;
// this fuction s called by the sequence and 
// the note is evaluated by the eqn call.(change it for diff fn)
public float nextNote() {
   ctr=++ctr%12;
   return note+20.0f*eqn(ctr);
}

public float eqn(int x) {
    float num=((float) x-6)/1.0f;
    return ((float)Math.pow(num,2.0))-num*2f+2f;
}

public float eqn1(int x) {
     float num=((float) x)/4.0f;
    return (2f*(float)Math.pow(num,3.0))-num*3f+2f;
}

public float eqn2(int num) {
     float x=((float) num-8)/4.0f;
    return 	(x+0.5f)*(x-0.1f)*(x+0.8f)*(x+1f)*20f;
}

public void setNote(String f) {
  note= Float.parseFloat(f);
}
}
