package smart.medical.appointmentService;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import smart.medical.appointmentService.SmartAppointmentServiceGrpc.SmartAppointmentServiceImplBase;

public class AppointmentServer extends SmartAppointmentServiceImplBase{

	public static void main(String[] args) {
		
		AppointmentServer appointmentServer = new AppointmentServer();
		
		appointmentServer.registerService();
		
		//this port number where server will be listen to
		int port = 50095;
		try {
			//create a server
			Server server = ServerBuilder.forPort(port)//listen to 50072
					.addService(appointmentServer)//this smartBuildingServer service
					.build()//build
					.start();//start
			//System.out.println("currAirQuality method START===server1");
			System.out.println("SmartAppoint Server started, listening on "+port );
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
	
	public StreamObserver<AppointmentInfoRequest> mobileAppointment(
			StreamObserver<AppointmentInfoReply> responseObserver){
		//get the value from the stream of requests of the client
		return new StreamObserver<AppointmentInfoRequest> () {

			ArrayList<String> list = new ArrayList<>();
			@Override
			//get one at a time
			public void onNext(AppointmentInfoRequest value) {
				// TODO Auto-generated method stub
				
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
				
				
				//
				responseObserver.onCompleted();
			}
			
		};//return statement, don't forget ";"
	}
	/*
	public StreamObserver<AirPuriRequest> openCloseAirPurifier (
			StreamObserver<AirPuriReply> responseObserver){
				return new StreamObserver<AirPuriRequest>() {

					@Override
					public void onNext(AirPuriRequest value) {
						// TODO Auto-generated method stub
						System.out.println("receiving openCloseAirPurifier method: " + value.getVal());
						String pmCheck = value.getVal();
						String msg = "";
						if (pmCheck.equalsIgnoreCase("pm2.5")) {
							if(value.getFigure()<= 180) {
								msg = pmCheck+" level in the air is: "+value.getFigure()+", it's within the healthy range and the purifier remains off";
							}
							else {
								msg = pmCheck+" level in the air is: "+value.getFigure()+", it's exceeds healthy range and the purifier is on";
								
							}
						}
						AirPuriReply reply = AirPuriReply.newBuilder().setMessage(msg).build();
						
						responseObserver.onNext(reply);
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onCompleted() {
						// TODO Auto-generated method stub
						responseObserver.onCompleted();
					}
					
				};
		
	}*/
	
}
