// Name of the package where all the generated files are present.
package smart.medical.appointmentService;
//required java packages for the program. 
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import smart.medical.appointmentService.SmartAppointmentServiceGrpc.SmartAppointmentServiceImplBase;
//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
public class AppointmentServer extends SmartAppointmentServiceImplBase{
	//Main method would contain the logic to start the server.
	public static void main(String[] args) {
		//The AppointmentServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
		AppointmentServer appointmentServer = new AppointmentServer();
		// Register a service
		appointmentServer.registerService();
		//this port number where server will be listen to
		int port = 50095;
		try {
			//create a server
			Server server = ServerBuilder.forPort(port)//listen to 50072
					.addService(appointmentServer)//this smartBuildingServer service
					.build()//build
					.start();// Start the server and keep it running for clients to contact.
			
			System.out.println("SmartAppoint Server started, listening on "+port );
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
			ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "AppointmentService", 50095, "mobile appointment service");
			jmdns.registerService(serviceInfo);
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	//rpc method Bi-Directional Streaming
	/*This method will be implemented with Bi-Directional Streaming, allowing a patient to request 
	detailed information such as date, doctor name, and available timetables step by step and finally 
	complete the appointment*/
	public StreamObserver<AppointmentInfoRequest> mobileAppointment(
			StreamObserver<AppointmentInfoReply> responseObserver){
		return new StreamObserver<AppointmentInfoRequest> () {
			// For each message in the stream, get one stream at a time.
			ArrayList<String> list = new ArrayList<>();
			@Override
			//get one at a time
			public void onNext(AppointmentInfoRequest value) {
				// TODO Auto-generated method stub
				// In bidirectional stream, both server and  client would be sending the stream of messages.
				// Here, for each message in stream from client, server is sending back one response.
				System.out.println("Request Info: " +value.getInfo());
				String info = "";
				info = value.getInfo();
				String msg = "";
				if(info.equalsIgnoreCase("date")) {
					msg = " available date is 09-AUG-2022";
					//System.out.println(msg);
				}
				else if(info.equalsIgnoreCase("doctor")) {
					msg = " available doctor is kevin";
					//System.out.println(msg);
				}
				else if(info.equalsIgnoreCase("time")) {
					msg = " available time is 10:15";
					//System.out.println(msg);
				}
				else {
					msg = "Info not available";
					//System.out.println(msg);
				}
				// Preparing and sending the reply for the client. Here, response is build and with the value (msg) computed by above logic.
			    AppointmentInfoReply reply = AppointmentInfoReply.newBuilder().setMessage(msg).build();
				
				responseObserver.onNext(reply);
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
				System.out.println("receiving appointment method completed \n");
				
				responseObserver.onCompleted();
			}
			
		};//return statement, don't forget ";"
	}
	//rpc method with unary
	/*This method will be implemented with Unary,
	 *  allowing a user to cancel the previous appointmen*/
	public void oneClickCancellation(OneClickCancellationRequest request,
			StreamObserver<CancellationStatusReply> responseObserver ) {
		//Retrieve the value from the request of the client
		System.out.println("receiving cancellation request: "+request.getCancellation());
		String msg = "ok ";
		if(request.getCancellation().equalsIgnoreCase("cancel")) {
			msg = "The status is cancelled.";
		}
		// Preparing the reply for the client. Here, response is build and with the value (msg) computed by above logic.  
		CancellationStatusReply reply = CancellationStatusReply.newBuilder().setMessage(msg).build();
		// Sending the reply for each request. 
		responseObserver.onNext(reply);

	      responseObserver.onCompleted();
	}
	
	
}
