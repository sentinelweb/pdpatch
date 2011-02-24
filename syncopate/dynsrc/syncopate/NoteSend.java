package syncopate;
import com.silicontransit.timeline.window.LogWindow;
import syncopate.Scales;
import java.util.Vector;
import com.silicontransit.timeline.TimeLine;

public class NoteSend {
// this just sends a calculated note maybe need to make a standard object that does this
Scales scales = new Scales();
TimeLine t = null;
public NoteSend() {
	
}
public void setTL(TimeLine t){
	this.t =t; 
	LogWindow.log("setTL:","warn");
}
public TimeLine getTL(){ 
	return t;
}
public void getNoteFreq(Integer pit, Integer vel, Integer poly) {
	long start = System.nanoTime();
	if (vel.intValue()>0) {
		pit-=36;
		scales.setFreqBase(new Float (20));
		Float f = scales.getNoteFreq(pit);
		//LogWindow.log("note:"+pit+"="+f.floatValue(),"warn");
		int index=(poly.intValue()+1);
		Vector v = new Vector();
		v.add(f);
		t.oscUtil.simpleOscMessage("/bird"+index+"/f",v,0);
		Vector v1 = new Vector();v1.add(new Integer(0));
		t.oscUtil.simpleOscMessage("/bird"+index+"/trig",v1,0);
	}
	//LogWindow.log("time("+pit+":"+(System.nanoTime()-start),"warn");
	return ;//gettNoteFreq((Integer) noteVec.get(0));
}
}
