//package SN1;
import org.apache.log4j.Logger;

public class Device {
	private String name;
	private int period;
	private int payload;
	private String payloadUnit;
	
	private static Logger logger = Logger.getLogger(Device.class);

	Device(String name, int period, int payload, String payloadUnit) {
		this.name = name;
		this.period = period;
		this.payloadUnit = payloadUnit;
		if (payloadUnit.equals("b")) {
			this.payload = payload;
		} else if (payloadUnit.equals("Kb")) {
			this.payload = payload * 1024;
		} else if (payloadUnit.equals("Mb")) {
			this.payload = payload * 1024 * 1024;
		} else {
			System.out.println("error: wrong payload unit!");
			logger.error("error: wrong payload unit - " + payloadUnit);
		}
	}
	
	String getName() {
		return name;
	}

	int getPeriod() {
		return period;
	}

	int getPayload() {
		return payload;
	}

}

