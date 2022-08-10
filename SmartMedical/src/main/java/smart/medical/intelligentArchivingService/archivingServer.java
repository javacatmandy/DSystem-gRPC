package smart.medical.intelligentArchivingService;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import smart.medical.intelligentArchivingService.IntelligentArchivingServiceGrpc.IntelligentArchivingServiceImplBase;

public class archivingServer extends IntelligentArchivingServiceImplBase{

	public static void main(String[] args) {
		
		archivingServer archivingServer = new archivingServer();
		
		archivingServer.registerService();
		
		//this port number where server will be listen to
		int port = 50097;
		try {
			//create a server
			Server server = ServerBuilder.forPort(port)//listen to 50097
					.addService(archivingServer)//this archivingServer service
					.build()//build
					.start();//start
			
			System.out.println("IntelligentArchivingService Server started, listening on "+port );
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
	
	public StreamObserver<HealthInfoRequest> healthProfile(
			StreamObserver<ProfileNoReply> responseObserver){
		//get the value from the stream of requests of the client
		return new StreamObserver<HealthInfoRequest> () {

			ArrayList<String> list = new ArrayList<>();
			//String[] patient = new String[1];
			@Override
			//get one at a time
			public void onNext(HealthInfoRequest value) {
				// TODO Auto-generated method stub
				
				//System.out.println("receiving patient's info: " +value.getName()+value.getInfo());
				//patient[0] = {value.getName(),value.getGender(), value.getDiagnose()};
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
				
				/*if(!list.isEmpty()) {
					currInfo = currInfo + "is filing completed";
				}else {
					System.out.println("Filing is failed.");
				}*/
				
				ProfileNoReply reply = ProfileNoReply.newBuilder().setMessage(currInfo).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}
			
		};//return statement, don't forget ";"
	}
	
	public void responsibleDoctorInfo(DoctorRequest request,
			StreamObserver<DoctorReply> responseObserver ) {
		System.out.println("receiving DoctorRequest request: "+request.getRequestPatientsDoctor());
		String msg = "The requested patient ";
		
		if(request.getRequestPatientsDoctor().equalsIgnoreCase("Amy")) {
			msg += request.getRequestPatientsDoctor() + "'s responsible doctor is Sean.";
		}else {
			msg += "Other patients' responsible doctor is Michael.";
		}
		
		DoctorReply reply = DoctorReply.newBuilder().setDoctor(msg).build();
		
		  responseObserver.onNext(reply);

	      responseObserver.onCompleted();
	}
	
	
}