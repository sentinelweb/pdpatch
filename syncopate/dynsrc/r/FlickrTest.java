package r;
import com.silicontransit.timeline.window.LogWindow;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.aetrion.flickr.Flickr;
import com.aetrion.flickr.FlickrException;
import com.aetrion.flickr.REST;
import com.aetrion.flickr.RequestContext;
import com.aetrion.flickr.auth.Auth;
import com.aetrion.flickr.auth.AuthInterface;
import com.aetrion.flickr.auth.Permission;
import com.aetrion.flickr.util.IOUtilities;
import java.util.ArrayList;
import com.aetrion.flickr.activity.ActivityInterface;
import com.aetrion.flickr.activity.Event;
import com.aetrion.flickr.activity.Item;
import com.aetrion.flickr.activity.ItemList;

public class FlickrTest {
// make sure you use the same frob for all requests otherwise things go a bit pear shapeped 
// and you get 108 invalid frob errors 
// showActivity() complains about read permissions.

static String restHost = "www.flickr.com";
Flickr f;
REST rest;
RequestContext requestContext;
String frob = "";
String token = "";

public AuthInterface getAuthInt()  throws ParserConfigurationException, IOException,SAXException{
	rest = new REST();
	rest.setHost(restHost);
	f = new Flickr("676db54d7327ae6c04bc85ffca42873a",rest);
	Flickr.debugStream = false;
	// Set the shared secret which is used for any calls which require signing.
	requestContext = RequestContext.getRequestContext();
	requestContext.setSharedSecret("5dc10eb4132de0c4");
	AuthInterface authInterface = f.getAuthInterface();
	if ("".equals(frob)) {
		try {
			frob = authInterface.getFrob();
		} catch(FlickrException e) {
			e.printStackTrace();
		}
	}
	LogWindow.msg("frob: "+frob);
	return authInterface;
}

public void initTest() throws ParserConfigurationException, IOException, SAXException {
	
	LogWindow.log("init:","warn");
	AuthInterface authInterface=getAuthInt();
	URL url = authInterface.buildAuthenticationUrl(Permission.READ, frob);
	LogWindow.log("Press return after you granted access at this URL:","warn");
	LogWindow.log(url.toExternalForm(),"warn");
	//BufferedReader infile =	new BufferedReader ( new InputStreamReader (System.in) );
	//String line = infile.readLine();
	
}

public void doTest()  throws ParserConfigurationException, IOException,SAXException{
	LogWindow.log("test:","warn");
	AuthInterface authInterface=getAuthInt();
	try {
		LogWindow.msg("frob:"+frob);
		Auth auth = authInterface.getToken(frob);
		LogWindow.log("Authentication success","warn");
		LogWindow.log("Token: "+auth.getToken(),"warn");
		LogWindow.log("nsid: "+auth.getUser().getId(),"warn");
		LogWindow.log("Realname: "+auth.getUser().getRealName(),"warn");
		LogWindow.log("Username: "+auth.getUser().getUsername(),"warn");
		LogWindow.log("Permission: "+auth.getPermission().getType(),"warn");
	} catch(FlickrException e) {
		LogWindow.error("Authentication failed:"+e.getMessage());
		LogWindow.ex(e);
	}
}

public void showActivity() throws FlickrException, IOException, SAXException {
try {
        ActivityInterface iface = f.getActivityInterface();
        ItemList list = iface.userComments(10, 0);
        for (int j = 0; j < list.size(); j++) {
            Item item = (Item) list.get(j);
           LogWindow.msg("Item " + (j + 1) + "/" + list.size() + " type: " + item.getType());
            LogWindow.msg("Item-id:       " + item.getId() + "\n");
            ArrayList events = (ArrayList) item.getEvents();
            for (int i = 0; i < events.size(); i++) {
                LogWindow.msg("Event " + (i + 1) + "/" + events.size() + " of Item " + (j + 1));
                LogWindow.msg("Event-type: " + ((Event) events.get(i)).getType());
                LogWindow.msg("User:       " + ((Event) events.get(i)).getUser());
                LogWindow.msg("Username:   " + ((Event) events.get(i)).getUsername());
                LogWindow.msg("Value:      " + ((Event) events.get(i)).getValue() + "\n");
            }
        }
        ActivityInterface iface2 = f.getActivityInterface();
        list = iface2.userPhotos(50, 0, "300d");
        for (int j = 0; j < list.size(); j++) {
            Item item = (Item) list.get(j);
            LogWindow.msg("Item " + (j + 1) + "/" + list.size() + " type: " + item.getType());
            LogWindow.msg("Item-id:       " + item.getId() + "\n");
            ArrayList events = (ArrayList) item.getEvents();
            for (int i = 0; i < events.size(); i++) {
                LogWindow.msg("Event " + (i + 1) + "/" + events.size() + " of Item " + (j + 1));
                LogWindow.msg("Event-type: " + ((Event) events.get(i)).getType());
                if (((Event) events.get(i)).getType().equals("note")) {
                    LogWindow.msg("Note-id:    " + ((Event) events.get(i)).getId());
                } else if (((Event) events.get(i)).getType().equals("comment")) {
                    LogWindow.msg("Comment-id: " + ((Event) events.get(i)).getId());
                }
                LogWindow.msg("User:       " + ((Event) events.get(i)).getUser());
                LogWindow.msg("Username:   " + ((Event) events.get(i)).getUsername());
                LogWindow.msg("Value:      " + ((Event) events.get(i)).getValue());
                LogWindow.msg("Dateadded:  " + ((Event) events.get(i)).getDateadded() + "\n");
            }
        }
} catch (Exception e) {
	LogWindow.ex(e);
}
    }

}
