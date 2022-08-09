package smart.medical.realTimeMonitoringService;

import java.util.Iterator;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import smart.medical.realTimeMonitoringService.RealTimeMonitoringServiceGrpc.RealTimeMonitoringServiceBlockingStub;
import smart.medical.realTimeMonitoringService.RealTimeMonitoringServiceGrpc.RealTimeMonitoringServiceStub;

public class monitoringClient {

	private static RealTimeMonitoringServiceBlockingStub blockingStub;
	private static RealTimeMonitoringServiceStub asyncStub;
	
	public static void main(String[] args) throws Exception{
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50096)
				.usePlaintext()
				.build();
		
		blockingStub = RealTimeMonitoringServiceGrpc.newBlockingStub(channel);
		asyncStub = RealTimeMonitoringServiceGrpc.newStub(channel);
		
		//rpc call with Asynchronous stub
		System.out.println("real Time Monitoring Service start to check");
		realTimeHeartbeatDetectionAsync();
		
		//closing the channel
		channel.shutdown();
	}

	public static void realTimeHeartbeatDetectionAsync() {
		// TODO Auto-generated method stub
		HeartbeatRequest request = HeartbeatRequest.newBuilder().setTime(60).build();
		
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
			asyncStub.realTimeHeartbeatDetection(request, responseObserver);
			try {
				Thread.sleep(10000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		
	}
/*
	public static void buildingCheckBlocking() {
		// TODO Auto-generated method stub
		BuildingAirRequest request = BuildingAirRequest.newBuilder().setItem("start check room's condition").build();
		//BuildingAirRequest request = BuildingAirRequest.newBuilder().equals(1).;
		try {
			//iterating each message in replies when calling remote 'buildingAirConditionCheck' rpc method.
			Iterator<BuildingAirReply> replies = blockingStub.buildingAirConditionCheck(request);
			
			while(replies.hasNext()) {
				BuildingAirReply temp = replies.next();
				System.out.println(temp.getMessage());
			}
		}catch (StatusRuntimeException e) {
			e.printStackTrace();
		}
	}*/
}
