package smart.medical.intelligentArchivingService;

import java.util.Random;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import smart.medical.intelligentArchivingService.IntelligentArchivingServiceGrpc.IntelligentArchivingServiceBlockingStub;
import smart.medical.intelligentArchivingService.IntelligentArchivingServiceGrpc.IntelligentArchivingServiceStub;

public class archivingClient {
	private static IntelligentArchivingServiceBlockingStub blockingStub;
	private static IntelligentArchivingServiceStub asyncStub;
	public static void main(String[] args) throws Exception{
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50097)
				.usePlaintext()
				.build();
		
		blockingStub = IntelligentArchivingServiceGrpc.newBlockingStub(channel);
		asyncStub = IntelligentArchivingServiceGrpc.newStub(channel);
		
		System.out.println("healthProfile method START===");
		healthProfile();
		
		System.out.println("responsibleDoctorInfo method START===");
		responsibleDoctorInfo();
		
		channel.shutdown();
		
	}
	
	

	public static void healthProfile() {
		// TODO Auto-generated method stub
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
		
		StreamObserver<HealthInfoRequest> requestObserve = asyncStub.healthProfile(responseObserver);
		
		try {
			requestObserve.onNext(HealthInfoRequest.newBuilder().setInfo("1001").build());
			requestObserve.onNext(HealthInfoRequest.newBuilder().setName("Amy").build());
			requestObserve.onNext(HealthInfoRequest.newBuilder().setGender("Female").build());
			requestObserve.onNext(HealthInfoRequest.newBuilder().setDiagnose("Fever").build());
			
			System.out.println("sending items.");
			//successfully stream completion
			requestObserve.onCompleted();
			
			Thread.sleep(new Random().nextInt(1000) + 500);
			
			
		}catch(RuntimeException e) {
			e.printStackTrace();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
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