package edu.asu.ser515.sockets;

import java.net.*;
import java.util.List;
import java.util.Map;
import java.io.*;

public class SimpleGrabHttpURL {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE: java SimpleGrabHttpURL <url>");
			System.exit(0);
		}

		HttpURLConnection conn = null;
		BufferedReader instream = null;
		try {
		    URI uri = new URI(args[0]);
		    conn = (HttpURLConnection) uri.toURL().openConnection();
		    Map<String, List<String>> map = conn.getHeaderFields();
		    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + 
					   " ,Value : " + entry.getValue());
		    }
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
		    System.out.println("Unable to read from URL " + args[0]);
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
