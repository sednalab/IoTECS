//package SN1;
import java.io.*;
import java.net.DatagramSocket;
import java.net.Socket;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


import org.apache.log4j.Logger;

public class SimulationNode {
	private static Logger logger = Logger.getLogger(SimulationNode.class);

	public static void main(String args[]) {

		try{
		int i=0;
		
		long duration=10000;
		long quanta=1000;
				
		//setup edge devices
		int speed;
		int waitTime;
		int workload=0;

	ArrayList<Device> E1Devices=new ArrayList<>();
	
	
	int E1D1Num=100;
	
	i=0;
	while (i<E1D1Num){
		//Device(String name, int period, int payload, String payloadUnit)
		Device D1 =new Device("D1",1,60,"b");
		E1Devices.add(D1);
		i++;
	}
	
	
	//set up cloud for edge devices				
	Cloud E1Cloud=new Cloud("192.168.0.2",1883);

	DatagramSocket C1Socket=new DatagramSocket();
	ReceiveUDP C1Receive=new ReceiveUDP(C1Socket);
	Thread C1ReceiveThread=new Thread(C1Receive);
	C1ReceiveThread.start();
	logger.info("new Cloud found: "+"C1");
	logger.info("start receiving thread for this Cloud.");
				
	waitTime=0;

	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E10=new EdgeDeviceUDP("E1",0,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E11=new EdgeDeviceUDP("E1",1,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E12=new EdgeDeviceUDP("E1",2,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E13=new EdgeDeviceUDP("E1",3,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E14=new EdgeDeviceUDP("E1",4,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E15=new EdgeDeviceUDP("E1",5,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E16=new EdgeDeviceUDP("E1",6,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);

	ArrayList<Device> E2Devices=new ArrayList<>();
	
	
	int E2D1Num=10;
	
	i=0;
	while (i<E2D1Num){
		//Device(String name, int period, int payload, String payloadUnit)
		Device D1 =new Device("D1",1,60,"b");
		E2Devices.add(D1);
		i++;
	}
	
	int E2D2Num=20;
	
	i=0;
	while (i<E2D2Num){
		//Device(String name, int period, int payload, String payloadUnit)
		Device D2 =new Device("D2",2,100,"b");
		E2Devices.add(D2);
		i++;
	}
	
	
	//set up cloud for edge devices				
	Cloud E2Cloud=new Cloud("192.168.0.3",2605);

	DatagramSocket C2Socket=new DatagramSocket();
	ReceiveUDP C2Receive=new ReceiveUDP(C2Socket);
	Thread C2ReceiveThread=new Thread(C2Receive);
	C2ReceiveThread.start();
	logger.info("new Cloud found: "+"C2");
	logger.info("start receiving thread for this Cloud.");
				
	speed=100;
	waitTime=Math.toIntExact(quanta/speed);

	workload=20;
	
	EdgeDeviceUDP E20=new EdgeDeviceUDP("E2",0,"UDP",waitTime,E2Cloud,
			E2Devices, C2Socket,workload);
	workload=20;
	
	EdgeDeviceUDP E21=new EdgeDeviceUDP("E2",1,"UDP",waitTime,E2Cloud,
			E2Devices, C2Socket,workload);
	workload=20;
	
	EdgeDeviceUDP E22=new EdgeDeviceUDP("E2",2,"UDP",waitTime,E2Cloud,
			E2Devices, C2Socket,workload);
					
		
		//start simulation nodes
		logger.info("start simulation threads.");
		
		//start
		int count=0;
		while(count<Math.toIntExact(duration/quanta)){
			E10.setStage(count);
			E10.setFlag(true);
			E11.setStage(count);
			E11.setFlag(true);
			E12.setStage(count);
			E12.setFlag(true);
			E13.setStage(count);
			E13.setFlag(true);
			E14.setStage(count);
			E14.setFlag(true);
			E15.setStage(count);
			E15.setFlag(true);
			E16.setStage(count);
			E16.setFlag(true);
			E20.setStage(count);
			E20.setFlag(true);
			E21.setStage(count);
			E21.setFlag(true);
			E22.setStage(count);
			E22.setFlag(true);
			//define
			Thread E10Thread=new Thread(E10);
			Thread E11Thread=new Thread(E11);
			Thread E12Thread=new Thread(E12);
			Thread E13Thread=new Thread(E13);
			Thread E14Thread=new Thread(E14);
			Thread E15Thread=new Thread(E15);
			Thread E16Thread=new Thread(E16);
			Thread E20Thread=new Thread(E20);
			Thread E21Thread=new Thread(E21);
			Thread E22Thread=new Thread(E22);
			long startTime=System.currentTimeMillis();
			E10Thread.start();
			E11Thread.start();
			E12Thread.start();
			E13Thread.start();
			E14Thread.start();
			E15Thread.start();
			E16Thread.start();
			E20Thread.start();
			E21Thread.start();
			E22Thread.start();
			while(System.currentTimeMillis()-startTime<quanta){
				Thread.sleep(10);
			}
			E10.setFlag(false);
			E11.setFlag(false);
			E12.setFlag(false);
			E13.setFlag(false);
			E14.setFlag(false);
			E15.setFlag(false);
			E16.setFlag(false);
			E20.setFlag(false);
			E21.setFlag(false);
			E22.setFlag(false);
			count++;
		}
		
		File files = new File("LOGS");
		File[] tempList = files.listFiles();
		int countReceive = 0;
		int countSend = 0;
		for (int iFile = 0; i < tempList.length; iFile++) {
			if (tempList[iFile].isFile()) {

				String filename = tempList[iFile].toString();

				try {
					FileInputStream inputStream = new FileInputStream(filename);
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
					String str = null;
					while ((str = bufferedReader.readLine()) != null) {
						String lineElem[] = str.split("INFO");
						if (lineElem.length >= 2) {
							String lElem[] = lineElem[1].split("-");
							if (lElem.length >= 2) {
								String elem[] = lElem[1].split(":");
								System.out.println(elem[0]);
								if (elem[0].trim().equals("receive")) {
									countReceive = countReceive + 1;
								} else if (elem[0].trim().equals("send")) {
									countSend = countSend + 1;
								}

							}
						}

					}
					inputStream.close();
					bufferedReader.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter("results"));
			out.write(Integer.toString(countReceive));
			out.write("\n");
			out.write(Integer.toString(countSend));
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		logger.info("finish!!!");
		System.exit(0);
		} catch (Exception e) {
			System.out.println(e.toString());
			logger.error(e.toString());
		}
	}
}
