//package SN2;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.InetAddress;
import org.apache.log4j.Logger;

public class ReceiveTCP implements Runnable {
	Socket socket;

	private static Logger logger = Logger.getLogger(ReceiveTCP.class);

	ReceiveTCP(Socket s) {
		socket = s;
	}

	@Override
	public void run() {
		int receiveCount = 0;

		while (true) {
			byte[] buf = new byte[4096];
			try {
				
				InputStream is=socket.getInputStream();
				int len=is.read(buf);
			
			InetAddress localAddress=socket.getLocalAddress();
			String ip = localAddress.getHostAddress();
			String port = Integer.toString(socket.getLocalPort());
			String isString=new String(buf,0,len);
			
			logger.info("receive:"+ip + "," + port + "," + System.currentTimeMillis());
			receiveCount++;
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error(e.toString());
			}
		}

	}
}
