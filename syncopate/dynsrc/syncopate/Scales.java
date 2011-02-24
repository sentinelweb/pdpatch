package syncopate;
import com.silicontransit.timeline.window.LogWindow;
import java.util.Vector;

public class Scales {
// with ref:-
// http://www.phy.mtu.edu/~suits/scales.html (quite cool)
//
public static double equal=Math.pow(2,1/12.0);
int ctr=-1;
int scaleCtr=0;
int scaleAccum=0;
float freqBase=60.0f;
//public void setFreqBase(Float f) {freqBase = f.floatValue();}
//public Float getFreqBase() {return new Float(freqBase);}

float justFactors[]= {1, (25.0f/24.0f) , (9.0f/8.0f) , (6.0f/5.0f) , (5.0f/4.0f) ,
 (4.0f/3.0f) , (45f/32.0f) ,(3.0f/2.0f) , (8.0f/5.0f) , (5.0f/3.0f) , (9f/5.0f) , (15f/8.0f), 2f};

// get equal temperament factors.
public float getEqFact(int i) {    return (float)Math.pow(2,i/12.0);}
// get Just temprament factor
public double getJustFact(int i) {return justFactors[i];}

public float getNote(int  numIntervals) {
    //ctr=++ctr%12;
     // int octave=	numIntervals/12;
     //double freq  = octave*this.freq;
     float fact = (float)getEqFact(numIntervals%12);
     return fact;
}
public float getNote() {
    ctr=++ctr%12;
    return getNote(ctr); 
}
//////////////////////////////////////////////////////////////////////////
// scales
int majorScale[] = {2,2,1,2,2,2,1};
int minorscale[] = {2,1,2,2,1,2,2};
int harmonicMinorScale[] = {2,1,2,2,1,3,1};
int majorPentatonicScale[] = {2,2,3,2,3};
int minorPentatonicScale[] = {3,2,2,3,2};
int wholeNoteHextonicScale[] = {2,2,2,2,2,2};
int bluesHextonicScale[] = {3,2,1,1,3,2};

int scale[]=minorscale;
public float getOctaveFactor(int  numIntervals) {
   int fact=(numIntervals)/12;
   return (float) Math.pow(2,(float) fact);
}
public Float playScale() {
     //ctr=++ctr%48;
     scaleCtr = (++scaleCtr) % scale.length;
     scaleAccum+=scale[scaleCtr];
     scaleAccum%=50;
     return (float) getOctaveFactor(scaleAccum)*getNote(scaleAccum%12);
}
public float freqScale() {
    playScale();
    float freq = this.freqBase;
     freq=freq*getOctaveFactor(scaleAccum)*getNote(scaleAccum%12);
    return freq;
}

public void resetScale() {
	scaleCtr = 0; 
	scaleAccum = 0;
}

public Float getNoteFreq(Integer index) {
	long start = System.nanoTime();
	int accum=0;
	//System.out.println("hello");
	for (int i=0;i<index;i++) {	accum+=scale[i%scale.length];	}
	//System.out.println(accum);
	float note = getNote(accum%12);
	double scaleMutliplier = Math.pow(2.0f,(float)(accum/12)); 
	float op=(float)freqBase*((float)scaleMutliplier)*note;
	//LogWindow.log("acc:"+(accum/12)+":"+" ("+(accum%12)+") "+":"+(accum)+" : "+freqBase*((accum/12)+1) +"*"+note+" ="+op,"msg");
	//LogWindow.log("acc:"+(accum/12)+":"+" ("+(accum%12)+") "+":"+(accum)+" : "+(freqBase+"*")+scaleMutliplier+"*"+note+" ="+op,"msg");
	Float f = new Float(op);
//LogWindow.log("time("+index+"):"+(System.nanoTime()-start),"warn");
	return  f;
}
}
