//package SN1;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import org.apache.log4j.Logger;

public class ReceiveUDP implements Runnable {
	DatagramSocket socket;

	private static Logger logger = Logger.getLogger(ReceiveUDP.class);

	ReceiveUDP(DatagramSocket s) {
		socket = s;
	}

	@Override
	public void run() {
		int receiveCount = 0;

		while (true) {
			byte[] buf = new byte[4096];
			DatagramPacket receivePackets = new DatagramPacket(buf, buf.length);

			try {
				socket.receive(receivePackets);
			
			byte[] data = receivePackets.getData();
			String dataString=new String(data,"UTF-8");
			String ip = receivePackets.getAddress().toString();
			String port = Integer.toString(receivePackets.getPort());
			logger.info("receive:"+ip + "," + port + "," + System.currentTimeMillis());
			receiveCount++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error(e.toString());
			}
		}

	}
}
