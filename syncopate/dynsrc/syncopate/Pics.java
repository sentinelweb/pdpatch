package syncopate;
import com.rob.FlickrPhotoDownload;
import com.silicontransit.timeline.TimeLine;
import java.util.Vector;
import com.silicontransit.timeline.window.LogWindow;

public class Pics {
public FlickrPhotoDownload flickr = null;
TimeLine t= null;
public int picIndex = 1;

public Pics(TimeLine t,String folder,Integer index) {
	this.t=t;
	this.picIndex = index.intValue();
	if (!"".equals(folder)) {flickr = new FlickrPhotoDownload(folder);}
 	else {flickr = new FlickrPhotoDownload();}
}

public void startDownloadWithTag(String tag) {
	flickr.getPhotosThread( tag );
	Vector sendTagData = new Vector();
	sendTagData.add(tag);
	this.t.oscUtil.simpleOscMessage("/pic/tag",sendTagData,1);
}
public String getPhotoPath() {
	Vector v = flickr.getPhotos();
	if (v.size()==0) {return "";}
	int index =(int)Math.round( Math.random()*(v.size()-1));
	Vector picDetails=(Vector)v.get(index);
	return (String) picDetails.get(0);
}
public void sendAPhoto(Integer i) {
	//if ( this.t != null ) {
		Vector v = flickr.getPhotos();
		if (v.size()==0) {return;}
		
		int index =(int)Math.round( Math.random()*(v.size()-1));
		Vector picDetails=(Vector)v.get(index);
		Vector sendPicData = new Vector();
		sendPicData.add(picDetails.get(0));
		Vector sendPicWid = new Vector();
		sendPicWid.add(Integer.parseInt((String)picDetails.get(2)));
		Vector sendPicHgt = new Vector();
		sendPicHgt.add(Integer.parseInt((String)picDetails.get(3)));
		Vector sendPicText = new Vector();
		sendPicText.add(picDetails.get(1));
		this.t.oscUtil.simpleOscMessage("/pic"+picIndex+"/data",sendPicData,1);
		this.t.oscUtil.simpleOscMessage("/pic"+picIndex+"/wid",sendPicWid,1);
		this.t.oscUtil.simpleOscMessage("/pic"+picIndex+"/hgt",sendPicHgt,1);
		this.t.oscUtil.simpleOscMessage("/pic"+picIndex+"/title",sendPicText,1);
		//LogWindow.msg("send:"+picDetails.get(0));
	//}
}

public TimeLine getTimeline(){
	return t;
}
public void setTimeLine(TimeLine t) {
	this.t=t;
}
}
