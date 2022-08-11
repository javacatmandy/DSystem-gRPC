// Name of the package where all the generated files are present.
package smart.medical.intelligentArchivingService;
//required java packages for the program.
import java.util.Random;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import smart.medical.intelligentArchivingService.IntelligentArchivingServiceGrpc.IntelligentArchivingServiceBlockingStub;
import smart.medical.intelligentArchivingService.IntelligentArchivingServiceGrpc.IntelligentArchivingServiceStub;
//Client need not to extend any other class (GRPC related code) here 
public class archivingClient {
	// Creating stubs for establishing the connection with server.
	// Blocking stub
	private static IntelligentArchivingServiceBlockingStub blockingStub;
	// Asynch stub
	private static IntelligentArchivingServiceStub asyncStub;
	// The main method will have the logic for client.
	public static void main(String[] args) throws Exception{
		// First a channel is being created to the server from client. 
		//Here, we provide the server name (localhost) and port (50096).		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50097)
				.usePlaintext()
				.build();
		//create the client stub using the newly created channel. here are 
		//two types of stubs, the blockingStub will wait until all the server 
		//response finished, the asyncstub will not wait, it will register an 
		//observer to receive the response
		blockingStub = IntelligentArchivingServiceGrpc.newBlockingStub(channel);
		asyncStub = IntelligentArchivingServiceGrpc.newStub(channel);
		//rpc call with Asynchronous stub
		System.out.println("healthProfile method START===");
		healthProfile();
		//second rpc call with blockingStub
		System.out.println("responsibleDoctorInfo method START===");
		responsibleDoctorInfo();
		//closing the channel once message has been passed.
		channel.shutdown();
		
	}
	
	
//rpc method client Streaming
	public static void healthProfile() {
		// TODO Auto-generated method stub
		// Handling the stream for client using onNext (logic for handling each message in stream), onError, onCompleted (logic will be executed after the completion of stream)
		StreamObserver<ProfileNoReply> responseObserver = new StreamObserver<ProfileNoReply>() {
			
			@Override
			public void onNext(ProfileNoReply value) {
				// TODO Auto-generated method stub
				
				System.out.println("healthProfile method START " + value.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				//System.out.println("currAirQuality method START===client4");
				System.out.println("stream is completed...receiving healthProfile method.");
				
			}
			
		};
		// Here, we are calling the Remote 'healthProfile' method. Using onNext, client sends a stream of messages.
		StreamObserver<HealthInfoRequest> requestObserve = asyncStub.healthProfile(responseObserver);
		
		try {
			requestObserve.onNext(HealthInfoRequest.newBuilder().setInfo("1001").build());
			requestObserve.onNext(HealthInfoRequest.newBuilder().setName("Amy").build());
			requestObserve.onNext(HealthInfoRequest.newBuilder().setGender("Female").build());
			requestObserve.onNext(HealthInfoRequest.newBuilder().setDiagnose("Fever").build());
			
			System.out.println("sending items.");
			//successfully stream completion
			requestObserve.onCompleted();
			// Sleep for a bit before sending the next one.	
			Thread.sleep(new Random().nextInt(1000) + 500);
			
			
		}catch(RuntimeException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//rpc method unary
	private static void responsibleDoctorInfo() {
		// TODO Auto-generated method stub
		// First creating a request message. Here, the message contains a patient's name in setPatient
		DoctorRequest req = DoctorRequest.newBuilder().setRequestPatientsDoctor("Amy").build();
		//  Calling a remote RPC method using blocking stub defined in main method. req is the message we want to pass.
		DoctorReply response = blockingStub.responsibleDoctorInfo(req);

		//response contains the output from the server side. Here, we are printing the value contained by response. 
		System.out.println(response.getDoctor());
	}

}