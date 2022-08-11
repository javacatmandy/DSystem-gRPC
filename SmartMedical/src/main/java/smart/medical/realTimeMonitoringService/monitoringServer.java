// Name of the package where all the generated files are present.
package smart.medical.realTimeMonitoringService;
//required java packages for the program. 
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
//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
public class monitoringServer extends RealTimeMonitoringServiceImplBase{

	//Main method would contain the logic to start the server.
	public static void main(String[] args) {
		//The monitoringServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
		monitoringServer monitoringServer = new monitoringServer();
		// Register a service
		monitoringServer.registerService();
		// This is the port number where server will be listening to clients. 
		int port = 50096;
		
		try {
			 // Here, we create a server on the port defined in in variable "port" and attach a service "monitoringServer" (instance of the class) defined above.
			 Server server = ServerBuilder.forPort(port)
					.addService(monitoringServer)
					.build()// Build the server
					.start(); // Start the server and keep it running for clients to contact.
			System.out.println("Real Time Monitoring Server started, listening on "+port);
			// Server will be running until externally terminated.
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
		
	//rpc method1 This method will be implemented with Server Streaming, allowing the nurse 
	//to request continuous access to heartbeat per minute data for a pre-set period
	public void realTimeHeartbeatDetection(HeartbeatRequest request, 
			StreamObserver<HeartbeatReply> responseObserver) {
		System.out.println("receiving real Time Monitoring");
		Random rnd = new Random();
		for(int i=0; i< (request.getTime()/10); i++) {
			int heartbeat = rnd.nextInt(90, 120);
			// Preparing and sending the reply for the client. Here, response is build and with the value (heartbeat) computed by above logic.
			 // Here, a stream of response is sent using the for loop.
			responseObserver.onNext(HeartbeatReply.newBuilder().setResult(heartbeat).build());
				
		}
		
		
		responseObserver.onCompleted();
	}
	// This is the second RPC method defined in proto file.
	//This method will be implemented with Unary, When a patient's blood oxygen is too low, 
	//an alert request is sent from the client via a smart medical device linked to the patient, 
	//and the server responds with an alert processing status to help doctors and nurses 
	//rescue the patient in the first time.
	public void lowBloodOxygenAlert(LowBloodOxygenAlertRequest request,
			StreamObserver<AlertReply> responseObserver ) {
		//Retrieve the value from the request of the client
		System.out.println("receiving lowBloodOxygen request: "+request.getNum());
		String msg = "ok ";
		if(request.getNum() < 0.95) {
			msg = "Alert! The blood oxygen level is too low.";
		}
		// Preparing the reply for the client. Here, response is build and with the value (msg) computed by above logic.  
		AlertReply reply = AlertReply.newBuilder().setMessage(msg).build();
		// Sending the reply for each request. 
		responseObserver.onNext(reply);

	      responseObserver.onCompleted();
	}
	
	
}
