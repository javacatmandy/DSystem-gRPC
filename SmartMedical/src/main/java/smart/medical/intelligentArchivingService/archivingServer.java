// Name of the package where all the generated files are present.
package smart.medical.intelligentArchivingService;
//required java packages for the program. 
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import smart.medical.intelligentArchivingService.IntelligentArchivingServiceGrpc.IntelligentArchivingServiceImplBase;
//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
public class archivingServer extends IntelligentArchivingServiceImplBase{
	//Main method would contain the logic to start the server.
	public static void main(String[] args) {
		//The archivingServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
		archivingServer archivingServer = new archivingServer();
		// Register a service
		archivingServer.registerService();
		//this port number where server will be listen to
		int port = 50097;
		try {
			//create a server
			 // Here, we create a server on the port defined in in variable "port" and attach a service "archivingServer" (instance of the class) defined above.
				Server server = ServerBuilder.forPort(port)//listen to 50097
					.addService(archivingServer)//this archivingServer service
					.build()//build
					.start();// Start the server and keep it running for clients to contact.
			
			System.out.println("IntelligentArchivingService Server started, listening on "+port );
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
			ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "Intelligent Archiving Service", 50097, "Intelligent Archiving Service");
			jmdns.registerService(serviceInfo);
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	//rpc method Client Streaming
	//This method will be implemented with Client Streaming, allowing nurses 
	//to input a set of a patient's basic information and disease diagnosis, 
	//then get a filing No. from the server.

	public StreamObserver<HealthInfoRequest> healthProfile(
			StreamObserver<ProfileNoReply> responseObserver){
		
		return new StreamObserver<HealthInfoRequest> () {

			ArrayList<String> list = new ArrayList<>();
			//String[] patient = new String[1];
			@Override
			//get one at a time
			public void onNext(HealthInfoRequest value) {
				// TODO Auto-generated method stub
				// Keep on adding all the input values to arraylist sent by the client in the stream 
				list.add(value.getInfo());
				list.add(value.getName());
				list.add(value.getGender());
				list.add(value.getDiagnose());
				
				
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("receiving healthProfile method completed \n");
				String currInfo = " ";
				for(String s: list) {
					currInfo += s + " ";
				}
				currInfo += "is filing completed";
				// Preparing and sending the reply for the client. Here, response is build and with the value (currInfo) computed by above logic.
				 // Here, response is sent once the client is done with sending the stream.
				ProfileNoReply reply = ProfileNoReply.newBuilder().setMessage(currInfo).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}
			
		};//return statement, don't forget ";"
	}
	//rpc method unary
	//This method will be implemented with Unary, 
	//allowing a nurse to request who is the patient’s responsible doctor
	public void responsibleDoctorInfo(DoctorRequest request,
			StreamObserver<DoctorReply> responseObserver ) {
		//Retrieve the value from the request of the client
		System.out.println("receiving DoctorRequest request: "+request.getRequestPatientsDoctor());
		String msg = "The requested patient ";
		
		if(request.getRequestPatientsDoctor().equalsIgnoreCase("Amy")) {
			msg += request.getRequestPatientsDoctor() + "'s responsible doctor is Sean.";
		}else {
			msg += "Other patients' responsible doctor is Michael.";
		}
		// Preparing the reply for the client. Here, response is build and with the value (msg) computed by above logic.  
		DoctorReply reply = DoctorReply.newBuilder().setDoctor(msg).build();
		// Sending the reply for each request. 
		  responseObserver.onNext(reply);

	      responseObserver.onCompleted();
	}
	
	
}