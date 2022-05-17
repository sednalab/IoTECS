//package SN2;
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
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E17=new EdgeDeviceUDP("E1",7,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E18=new EdgeDeviceUDP("E1",8,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E19=new EdgeDeviceUDP("E1",9,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E110=new EdgeDeviceUDP("E1",10,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E111=new EdgeDeviceUDP("E1",11,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E112=new EdgeDeviceUDP("E1",12,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E113=new EdgeDeviceUDP("E1",13,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E114=new EdgeDeviceUDP("E1",14,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E115=new EdgeDeviceUDP("E1",15,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E116=new EdgeDeviceUDP("E1",16,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E117=new EdgeDeviceUDP("E1",17,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E118=new EdgeDeviceUDP("E1",18,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E119=new EdgeDeviceUDP("E1",19,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E120=new EdgeDeviceUDP("E1",20,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E121=new EdgeDeviceUDP("E1",21,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E122=new EdgeDeviceUDP("E1",22,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E123=new EdgeDeviceUDP("E1",23,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E124=new EdgeDeviceUDP("E1",24,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E125=new EdgeDeviceUDP("E1",25,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E126=new EdgeDeviceUDP("E1",26,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E127=new EdgeDeviceUDP("E1",27,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E128=new EdgeDeviceUDP("E1",28,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
	workload=0;
	workload=workload*1000;
	
	EdgeDeviceUDP E129=new EdgeDeviceUDP("E1",29,"UDP",waitTime,E1Cloud,
			E1Devices, C1Socket,workload);
					
		
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
			E17.setStage(count);
			E17.setFlag(true);
			E18.setStage(count);
			E18.setFlag(true);
			E19.setStage(count);
			E19.setFlag(true);
			E110.setStage(count);
			E110.setFlag(true);
			E111.setStage(count);
			E111.setFlag(true);
			E112.setStage(count);
			E112.setFlag(true);
			E113.setStage(count);
			E113.setFlag(true);
			E114.setStage(count);
			E114.setFlag(true);
			E115.setStage(count);
			E115.setFlag(true);
			E116.setStage(count);
			E116.setFlag(true);
			E117.setStage(count);
			E117.setFlag(true);
			E118.setStage(count);
			E118.setFlag(true);
			E119.setStage(count);
			E119.setFlag(true);
			E120.setStage(count);
			E120.setFlag(true);
			E121.setStage(count);
			E121.setFlag(true);
			E122.setStage(count);
			E122.setFlag(true);
			E123.setStage(count);
			E123.setFlag(true);
			E124.setStage(count);
			E124.setFlag(true);
			E125.setStage(count);
			E125.setFlag(true);
			E126.setStage(count);
			E126.setFlag(true);
			E127.setStage(count);
			E127.setFlag(true);
			E128.setStage(count);
			E128.setFlag(true);
			E129.setStage(count);
			E129.setFlag(true);
			//define
			Thread E10Thread=new Thread(E10);
			Thread E11Thread=new Thread(E11);
			Thread E12Thread=new Thread(E12);
			Thread E13Thread=new Thread(E13);
			Thread E14Thread=new Thread(E14);
			Thread E15Thread=new Thread(E15);
			Thread E16Thread=new Thread(E16);
			Thread E17Thread=new Thread(E17);
			Thread E18Thread=new Thread(E18);
			Thread E19Thread=new Thread(E19);
			Thread E110Thread=new Thread(E110);
			Thread E111Thread=new Thread(E111);
			Thread E112Thread=new Thread(E112);
			Thread E113Thread=new Thread(E113);
			Thread E114Thread=new Thread(E114);
			Thread E115Thread=new Thread(E115);
			Thread E116Thread=new Thread(E116);
			Thread E117Thread=new Thread(E117);
			Thread E118Thread=new Thread(E118);
			Thread E119Thread=new Thread(E119);
			Thread E120Thread=new Thread(E120);
			Thread E121Thread=new Thread(E121);
			Thread E122Thread=new Thread(E122);
			Thread E123Thread=new Thread(E123);
			Thread E124Thread=new Thread(E124);
			Thread E125Thread=new Thread(E125);
			Thread E126Thread=new Thread(E126);
			Thread E127Thread=new Thread(E127);
			Thread E128Thread=new Thread(E128);
			Thread E129Thread=new Thread(E129);
			long startTime=System.currentTimeMillis();
			E10Thread.start();
			E11Thread.start();
			E12Thread.start();
			E13Thread.start();
			E14Thread.start();
			E15Thread.start();
			E16Thread.start();
			E17Thread.start();
			E18Thread.start();
			E19Thread.start();
			E110Thread.start();
			E111Thread.start();
			E112Thread.start();
			E113Thread.start();
			E114Thread.start();
			E115Thread.start();
			E116Thread.start();
			E117Thread.start();
			E118Thread.start();
			E119Thread.start();
			E120Thread.start();
			E121Thread.start();
			E122Thread.start();
			E123Thread.start();
			E124Thread.start();
			E125Thread.start();
			E126Thread.start();
			E127Thread.start();
			E128Thread.start();
			E129Thread.start();
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
			E17.setFlag(false);
			E18.setFlag(false);
			E19.setFlag(false);
			E110.setFlag(false);
			E111.setFlag(false);
			E112.setFlag(false);
			E113.setFlag(false);
			E114.setFlag(false);
			E115.setFlag(false);
			E116.setFlag(false);
			E117.setFlag(false);
			E118.setFlag(false);
			E119.setFlag(false);
			E120.setFlag(false);
			E121.setFlag(false);
			E122.setFlag(false);
			E123.setFlag(false);
			E124.setFlag(false);
			E125.setFlag(false);
			E126.setFlag(false);
			E127.setFlag(false);
			E128.setFlag(false);
			E129.setFlag(false);
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
