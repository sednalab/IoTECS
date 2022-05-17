import java.util.Random;

public class EdgeComputing implements Runnable {
	int workload;


	EdgeComputing(int workload) {
		this.workload = workload;
	}

	@Override
	public void run() {
		long startTime=System.currentTimeMillis();
		while((System.currentTimeMillis()-startTime)<workload) {
			Random random=new Random();
			double r1=random.nextDouble();
			double r2=random.nextDouble();
			double r3=r1*r2;
		}

	}
}
