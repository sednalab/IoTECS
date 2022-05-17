//package SN1;
import java.net.Socket;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

public class EdgeDeviceTCP implements Runnable {
	private static Logger logger = Logger.getLogger(EdgeDeviceTCP.class);


	private int edgeIndex;
	private String name;
	private String protocol;
	private int waitTime;
	private Cloud cloud;
	private Socket socket;
	private int stage;
	private boolean flag=false;
	private ArrayList<Device> devices = new ArrayList<>();
	private int workload=0;

	EdgeDeviceTCP(String name, int edgeIndex, String protocol, int waitTime, Cloud cloud, ArrayList<Device> devices,
			Socket socket, int workload) {
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

	void setSocket(Socket socket) {
		this.socket = socket;
		logger.info("set socket to " + socket.toString());
	}

	@Override
	public void run() {
		if (flag == true) {
			InetAddress inetAddress;
			EdgeComputing edgeComputing=new EdgeComputing(workload);
			Thread computing=new Thread(edgeComputing);
			computing.start();
			try {
				inetAddress = InetAddress.getByName(cloud.getIP());

				int index = 0;

				for (Device device : devices) {
					if ((stage % device.getPeriod()) == 0) {
						int packetPayload = device.getPayload();
						String packetName = device.getName();
						byte[] msg = new byte[packetPayload];
						String sendMsg = name + "," + edgeIndex + "," + protocol + "," + packetName + "," + index + ","
																+ packetPayload + "," + System.currentTimeMillis() + ",";
						int msgi = 0;
						for (byte b : sendMsg.getBytes()) {
							msg[msgi] = b;
							msgi++;
						}
						OutputStream os=socket.getOutputStream();
						os.write(msg);
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

