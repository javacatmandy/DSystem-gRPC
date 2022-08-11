// Name of the package where all the generated files are present.
package smart.medical.appointmentService;
//required java packages for the program.
import java.util.Random;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import smart.medical.appointmentService.SmartAppointmentServiceGrpc.SmartAppointmentServiceBlockingStub;
import smart.medical.appointmentService.SmartAppointmentServiceGrpc.SmartAppointmentServiceStub;
//Client need not to extend any other class (GRPC related code) here 
public class AppointmentClient {
	// Creating stubs for establishing the connection with server.
	// Blocking stub
	private static SmartAppointmentServiceBlockingStub blockingStub;
	// Asynch stub
	private static SmartAppointmentServiceStub asyncStub;
	// The main method will have the logic for client.
	public static void main(String[] args) throws Exception{
		// First a channel is being created to the server from client. 
		//Here, we provide the server name (localhost) and port (50095).			
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50095)
				.usePlaintext()
				.build();
		//create the client stub using the newly created channel. here are 
		//two types of stubs, the blockingStub will wait until all the server 
		//response finished, the asyncstub will not wait, it will register an 
		//observer to receive the response
		blockingStub = SmartAppointmentServiceGrpc.newBlockingStub(channel);
		asyncStub = SmartAppointmentServiceGrpc.newStub(channel);
		//rpc call with Asynchronous stub
		System.out.println("Appointment method START===");
		mobileAppointment();
		//second rpc method
		System.out.println("OneClickCancellation method START===");
		oneClickCancellation();
		//closing the channel once message has been passed.
		channel.shutdown();
		
	}
	//rpc method unary
	//single request 'req' and single reply 'response', they communicate between server and client
	public static void oneClickCancellation() {
		// First creating a request message. Here, the message contains a string in setVal
		OneClickCancellationRequest req = OneClickCancellationRequest.newBuilder().setCancellation("cancel").build();
		//  Calling a remote RPC method using blocking stub defined in main method. req is the message we want to pass.
		CancellationStatusReply response = blockingStub.oneClickCancellation(req);

		//response contains the output from the server side. Here, we are printing the value contained by response. 
		System.out.println(response.getMessage());
	}
	
	
	//second rpc method Bi-Directional Streaming
	public static void mobileAppointment() {
		// TODO Auto-generated method stub
		// Handling the server stream for client using onNext (logic for handling each message in stream), onError, onCompleted (logic will be executed after the completion of stream)
		StreamObserver<AppointmentInfoReply> responseObserver = 
				new StreamObserver<AppointmentInfoReply>() {

					@Override
					public void onNext(AppointmentInfoReply value) {
						// TODO Auto-generated method stub
						System.out.println("received " + value.getMessage());
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
						t.printStackTrace();
					}

					@Override
					public void onCompleted() {
						// TODO Auto-generated method stub
						System.out.println("server completed.");
					}
				
			
				};
				// Here, we are calling the Remote 'mobileAppointment' method. Using onNext, client sends a stream of messages.
					StreamObserver<AppointmentInfoRequest> requestObserver = asyncStub.mobileAppointment(responseObserver);
				try {
					requestObserver.onNext(AppointmentInfoRequest.newBuilder().setInfo("Date").build());
					requestObserver.onNext(AppointmentInfoRequest.newBuilder().setInfo("Doctor").build());
					requestObserver.onNext(AppointmentInfoRequest.newBuilder().setInfo("Time").build());
					
					System.out.println("sending message");
					// Mark the end of requests
					requestObserver.onCompleted();
					//sleep for a while before sending the next one
					Thread.sleep(new Random().nextInt(2000) + 500);
				} catch(RuntimeException e) {
					e.printStackTrace();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				
	}

}