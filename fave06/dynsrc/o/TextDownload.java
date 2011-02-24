package o;
import java.net.*;
import java.util.*;
import java.io.*;

public class TextDownload {
final int NUM_BYTES_TO_READ=50;
String dataRead = "Nothing read yet";
public String hello() {return "hello";}
int ctr=0;
public void getData() {
     getData("http://rss.slashdot.org/Slashdot/slashdot");
}
public void getData(String urlStr) {

   try {
        URL url = new URL(urlStr);
    
        // Read all the text returned by the server
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer strBuf=new StringBuffer();
        String str;
        while ((str = in.readLine()) != null) {
            // str is one line of text; readLine() strips the newline character(s)
            strBuf.append(str);
        }
        in.close();
dataRead=strBuf.toString();
       System.out.println( "Ended");
    } catch(Throwable t) {
       System.out.println(t.getMessage()+":"+t.getClass().getName());
        t.printStackTrace();
    }

}
public String getLine() {
String str="";
 System.out.println((ctr+NUM_BYTES_TO_READ)+":"+dataRead.length());
if ( (ctr+NUM_BYTES_TO_READ)<dataRead.length() ){ 
     str=dataRead.substring(ctr,ctr+NUM_BYTES_TO_READ);
     ctr+=NUM_BYTES_TO_READ;
} else {
    str=dataRead.substring(ctr,dataRead.length());
    ctr=0;
}
return str;

}

}
