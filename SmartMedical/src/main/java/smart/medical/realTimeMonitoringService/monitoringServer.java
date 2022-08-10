package smart.medical.realTimeMonitoringService;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import smart.medical.realTimeMonitoringService.RealTimeMonitoringServiceGrpc.RealTimeMonitoringServiceImplBase;

public class monitoringServer extends RealTimeMonitoringServiceImplBase{

	public static void main(String[] args) {
		monitoringServer monitoringServer = new monitoringServer();
		
		monitoringServer.registerService();
		
		int port = 50096;
		
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(monitoringServer)
					.build()
					.start();
			System.out.println("Real Time Monitoring Server started, listening on "+port);
			
			server.awaitTermination();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void registerService() {
		try {
			//create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			//register a service
			ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local", "Monitoring", 50096, "RealTime Monitoring service");
			jmdns.registerService(serviceInfo);
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
		
	public void realTimeHeartbeatDetection(HeartbeatRequest request, 
			StreamObserver<HeartbeatReply> responseObserver) {
		System.out.println("receiving real Time Monitoring");
		Random rnd = new Random();
		for(int i=0; i< (request.getTime()/10); i++) {
			int heartbeat = rnd.nextInt(90, 120);
			responseObserver.onNext(HeartbeatReply.newBuilder().setResult(heartbeat).build());
				
		}
		
		
		responseObserver.onCompleted();
	}
	
	public void lowBloodOxygenAlert(LowBloodOxygenAlertRequest request,
			StreamObserver<AlertReply> responseObserver ) {
		System.out.println("receiving lowBloodOxygen request: "+request.getNum());
		String msg = "ok ";
		if(request.getNum() < 0.95) {
			msg = "Alert! The blood oxygen level is too low.";
		}
		
		AlertReply reply = AlertReply.newBuilder().setMessage(msg).build();
		  responseObserver.onNext(reply);

	      responseObserver.onCompleted();
	}
	
	
}
