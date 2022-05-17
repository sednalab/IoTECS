//package SN2;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

public class EdgeDeviceUDP implements Runnable {
	private static Logger logger = Logger.getLogger(EdgeDeviceUDP.class);


	private int edgeIndex;
	private String name;
	private String protocol;
	private int waitTime;
	private Cloud cloud;
	private DatagramSocket socket;
	private int stage;
	private boolean flag=false;
	private ArrayList<Device> devices = new ArrayList<>();
	private int workload=0;

	EdgeDeviceUDP(String name, int edgeIndex, String protocol, int waitTime, Cloud cloud, ArrayList<Device> devices,
			DatagramSocket socket,int workload) {
		this.workload=workload;
		this.edgeIndex = edgeIndex;
		this.name = name;
		this.protocol = protocol;
		this.waitTime = waitTime;
		this.cloud = cloud;
		for (Device device : devices) {
			this.devices.add(device);
		}
		this.socket = socket;
	}
boolean getFlag() {
	return flag;
}
	
void setFlag(boolean newValue) {
	flag=newValue;
}

	void setStage(int stage) {
		this.stage = stage;
		logger.info("set stage to " + stage);
	}

	void setSocket(DatagramSocket socket) {
		this.socket = socket;
		logger.info("set socket to " + socket.toString());
	}

	@Override
	public void run() {
		if (flag == true) {
			
			InetAddress inetAddress;
			try {
				inetAddress = InetAddress.getByName(cloud.getIP());

				int index = 0;
				
				EdgeComputing edgeComputing=new EdgeComputing(workload);
				Thread computing=new Thread(edgeComputing);
				computing.start();
				
				for (Device device : devices) {
					if ((stage % device.getPeriod()) == 0) {
						int packetPayload = device.getPayload();
						String packetName = device.getName();
						byte[] msg = new byte[packetPayload];
						String sendMsg = name + "," + edgeIndex + "," + protocol + "," + packetName + "," + index + ","+ packetPayload + "," + System.currentTimeMillis() + ",";
						int msgi = 0;
						for (byte b : sendMsg.getBytes()) {
							msg[msgi] = b;
							msgi++;
						}
						DatagramPacket sendPacket = new DatagramPacket(msg, packetPayload, inetAddress,
								cloud.getPort());
						socket.send(sendPacket);
						logger.info("send:"+name + "," + edgeIndex + "," + protocol + "," + packetName + "," + index + ","
								+ packetPayload + "," + System.currentTimeMillis());
						if (flag == false) {
							logger.warn("unfinished!");
							return;
						}
						Thread.sleep(waitTime);
					}

					index++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}
}

