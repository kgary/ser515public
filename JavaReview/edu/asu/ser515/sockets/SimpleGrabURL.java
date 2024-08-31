import java.net.*;
import java.io.*;

public class SimpleGrabURL {
    public static void main(String[] args) {
	if (args.length != 1) {
	    System.out.println("USAGE: java SimpleGrabURL <url>");
	    System.exit(0);
	}

	URLConnection conn = null;
	BufferedReader instream = null;
	try {
	    URI uri = new URI(args[0]);
	    conn = uri.toURL().openConnection();
	    conn.connect();
	    
	    instream = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String line = null;
	    while ((line = instream.readLine()) != null) {
		System.out.println(line);
	    }
	}
	catch (URISyntaxException use) {
	    System.out.println("Invalid URL " + args[0]);
	    use.printStackTrace();
	}
	catch (IOException exc) {
	    exc.printStackTrace();
	}
	finally {
	    try {
		if (instream != null) instream.close();
	    }
	    catch (Throwable t) {
		t.printStackTrace();
	    }
	}
    }
}
