import java.util.HashMap;

public class CommPos {
static int[][][] locations = {// video, position, length
	{{18900,450},	{2500,350},		{66282,1000},	{18900,1000},	{140519,1000},	{63631,1000},	{121960,1000},	{121960,1000}},
	{{1025,950},	{5000,350},		{92795,1000},	{1325,1000},	{34366,1000},	{76300,1000},	{197700,1000},	{121960,1000}},
	{{74336,750},	{121634,350},	{120634,1000},{39769,1000},	{103401,1000},	{114006,1000},	{151124,1000},	{121960,1000}},
	{{60980,750},	{50000,350},	{113906,1000},	{60980,1000},	{110229,1000},	{66282,1000},	{176312,1000},	{121960,1000}}
};
static String[] tags = {"amazing","positive1","product","amazing1","positive2","negative","moneyback"}; 
static HashMap<String,Integer> tagHash = new HashMap<String,Integer>();
static {
	for (int i=0;i<tags.length;i++) {
		tagHash.put(tags[i],i);
	}
}
public int getPos(Integer vid,String tag) {
	return locations[vid][tagHash.get(tag)][0];
}
public int getLen(Integer vid,String tag) {
	return locations[vid][tagHash.get(tag)][1];
}
public int getPosi(Integer vid,Integer tag) {
	return locations[vid][tag][0];
}
}
