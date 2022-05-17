//package SN2;
public class Cloud {
	String IP;
	int port;

	Cloud(String ip, int p) {
		IP = ip;
		port = p;
	}

	String getIP() {
		return IP;
	}
	
	int getPort() {
		return port;
	}
}
