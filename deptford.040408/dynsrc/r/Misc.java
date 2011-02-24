package r;
import java.util.HashMap;

public class Misc {
public float samplePos() {
  return (float) (0.39+Math.random()*0.2);
}

private HashMap counters = new HashMap();
public int inc(String key, Integer step, Integer mod) {
	Integer counter = (Integer)counters.get(key);
	if (counter==null) {
		counter = new Integer(0);
		
	}
	counter += step;
	counter %= mod;
	counters.put(key,counter);
	return counter;
}
}
