package edu.asu.ser515.sockets;

import java.net.*;
import java.io.*;

public class MulticastPeer{
    public static void main(String args[]){ 
		// args give message contents and destination multicast group (e.g. "228.5.6.7")
		MulticastSocket s =null;
		try {
			InetAddress group = InetAddress.getByName(args[1]);
			s = new MulticastSocket(6789);
			s.joinGroup(new InetSocketAddress(group, 6789), NetworkInterface.getByName("eth0"));
 			byte [] m = args[0].getBytes();
			DatagramPacket messageOut = new DatagramPacket(m, m.length, group, 6789);
			s.send(messageOut);	
			byte[] buffer = new byte[1000];
 			for(int i=0; i< 3;i++) {		// get messages from others in group
 				DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
 				s.receive(messageIn);
 				System.out.println("Received:" + new String(messageIn.getData(), 0, messageIn.getLength()));
  			}
			s.leaveGroup(new InetSocketAddress(group, 6789), NetworkInterface.getByName("eth0"));
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){System.out.println("IO: " + e.getMessage());
		}finally {if(s != null) s.close();}
	}		      	
	
}
