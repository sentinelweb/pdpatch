package r;
import com.silicontransit.timeline.window.LogWindow;

public class Multi {
public int last = 0;
int direction =1;
public Float getSurge(Integer offset, Integer limit,Integer step) {
	if (last ==0) {
		last = offset;
	}
	if (last>=limit) {direction=-1;}
	else if (last <= offset) {direction =1;} 
	last += Math.random()*((direction* limit)/step);
//LogWindow.log(last+":"+direction,"warn");
	return new Float(last);
}
}
