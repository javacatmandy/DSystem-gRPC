// Name of the package where all the generated files are present.
package smart.medical.realTimeMonitoringService;
//required java packages for the program.
import java.util.Iterator;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import smart.medical.realTimeMonitoringService.RealTimeMonitoringServiceGrpc.RealTimeMonitoringServiceBlockingStub;
import smart.medical.realTimeMonitoringService.RealTimeMonitoringServiceGrpc.RealTimeMonitoringServiceStub;
//Client need not to extend any other class (GRPC related code) here 
public class monitoringClient {

	// Creating stubs for establishing the connection with server.
	// Blocking stub
	private static RealTimeMonitoringServiceBlockingStub blockingStub;
	// Asynch stub
	private static RealTimeMonitoringServiceStub asyncStub;
	// The main method will have the logic for client.
	public static void main(String[] args) throws Exception{
	// First a channel is being created to the server from client. 
	//Here, we provide the server name (localhost) and port (50096).			
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50096)
				.usePlaintext()
				.build();
		//create the client stub using the newly created channel. here are 
		//two types of stubs, the blockingStub will wait until all the server 
		//response finished, the asyncstub will not wait, it will register an 
		//observer to receive the response
		blockingStub = RealTimeMonitoringServiceGrpc.newBlockingStub(channel);
		asyncStub = RealTimeMonitoringServiceGrpc.newStub(channel);
		
		//rpc call with Asynchronous stub
		System.out.println("real Time Monitoring Service start to check");
		realTimeHeartbeatDetectionAsync();
		//second rpc method
		System.out.println("low Blood Oxygen Alert Service start");
		lowBloodOxygenAlert();
		
		//closing the channel once message has been passed.
		channel.shutdown();
	}
	//unary rpc
	//single request 'req' and single reply 'response', they communicate between server and client
	public static void lowBloodOxygenAlert() {
		// First creating a request message. Here, the message contains a number in setNum
		LowBloodOxygenAlertRequest req = LowBloodOxygenAlertRequest.newBuilder().setNum((float) 0.93).build();
		//  Calling a remote RPC method using blocking stub defined in main method. req is the message we want to pass.
		AlertReply response = blockingStub.lowBloodOxygenAlert(req);

		//response contains the output from the server side. Here, we are printing the value contained by response. 
		System.out.println(response.getMessage());
	}

	//server stream rpc in Async stub
	public static void realTimeHeartbeatDetectionAsync() {
		// TODO Auto-generated method stub
		// First creating a request message. Here, the message contains time range message as defined in proto
		HeartbeatRequest request = HeartbeatRequest.newBuilder().setTime(60).build();
		// Handling the stream from server using onNext (logic for handling each message in stream), 
		//onError, onCompleted (logic will be executed after the completion of stream)
			StreamObserver<HeartbeatReply> responseObserver = new StreamObserver<HeartbeatReply>() {

				@Override
				public void onNext(HeartbeatReply value) {
					// TODO Auto-generated method stub
					System.out.println("receiving heart beat:"+ value.getResult());
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					t.printStackTrace();
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					System.out.println("Stream is completed");
				}
				
			};
		// Here, we are calling the Remote realTimeHeartbeatDetection method. On receiving the message from server the onNext, onError, onCompleted will be called (as defined above). 
			asyncStub.realTimeHeartbeatDetection(request, responseObserver);
			try {
				Thread.sleep(10000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		
	}

}
