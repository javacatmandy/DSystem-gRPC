package smart.medical.realTimeMonitoringService;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import smart.medical.realTimeMonitoringService.RealTimeMonitoringServiceGrpc.RealTimeMonitoringServiceBlockingStub;
import smart.medical.realTimeMonitoringService.RealTimeMonitoringServiceGrpc.RealTimeMonitoringServiceStub;

public class monitoringGUIApplication {

	private static RealTimeMonitoringServiceBlockingStub blockingStub;
	private static RealTimeMonitoringServiceStub asyncStub;
	
	private ServiceInfo monitoringServiceInfo;
	
	private JFrame frame;
	private JTextField textRequest;
	private JTextArea textResponse;
	
	//launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					monitoringGUIApplication window = new monitoringGUIApplication();
					window.frame.setVisible(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	//create the application
	public monitoringGUIApplication() {
		
		String service_type = "_http._tcp.local.";
		discoverMonitoringService(service_type);
			
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50096)
				.usePlaintext()
				.build();
		
		//stub
		blockingStub = RealTimeMonitoringServiceGrpc.newBlockingStub(channel);
		asyncStub = RealTimeMonitoringServiceGrpc.newStub(channel);
		
		initialize();
	}

	private void discoverMonitoringService(String service_type) {
		// TODO Auto-generated method stub
		try {
			// create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			jmdns.addServiceListener(service_type, new ServiceListener() {

				
				@Override
				public void serviceResolved(ServiceEvent event) {
					// TODO Auto-generated method stub
					System.out.println("monitoring service resolved:" + event.getInfo());
					monitoringServiceInfo = event.getInfo();
					
					int port = monitoringServiceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties...");
					System.out.println("\t port: "+ port);
					System.out.println("\t type: " +event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description: "+ monitoringServiceInfo.getNiceTextString());
					System.out.println("\t host: "+ monitoringServiceInfo.getHostAddresses());
					
				}
				

				@Override
				public void serviceRemoved(ServiceEvent event) {
					// TODO Auto-generated method stub
					System.out.println("Monitoring service removed:" + event.getInfo());
				}


				@Override
				public void serviceAdded(ServiceEvent event) {
					// TODO Auto-generated method stub
					System.out.println("Monitoring service added:" + event.getInfo());
				}
				
			});
			//wait a bit
			Thread.sleep(2000);
			
			jmdns.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Client - Service Controller");
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		JPanel panel_service_1 = new JPanel();
		frame.getContentPane().add(panel_service_1);
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Input time range in second,eg 60");
		panel_service_1.add(lblNewLabel_1);
		
		textRequest = new JTextField();
		panel_service_1.add(textRequest);
		textRequest.setColumns(10);
		
		//textRequest.setActionCommand(null);
		
	/*	JLabel lblNewLabel_2 = new JLabel("Number 2");
		panel_service_1.add(lblNewLabel_2);
		
		textNumber2 = new JTextField();
		panel_service_1.add(textNumber2);
		textNumber2.setColumns(10);
		
		
		JComboBox comboOperation = new JComboBox();
		comboOperation.setModel(new DefaultComboBoxModel(new String[] {"ADDITION", "SUBTRACTION", "MULTIPLICATION", "DIVISION"}));
		panel_service_1.add(comboOperation);
	*/
		
		JButton btnHeartbeatDetection = new JButton("Heartbeat detaction:");
		btnHeartbeatDetection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int num1 = Integer.parseInt(textNumber1.getText());
				int item = Integer.parseInt(textRequest.getText());
				//int num2 = Integer.parseInt(textNumber2.getText());

				//int index = comboOperation.getSelectedIndex();
				//Operation operation = Operation.forNumber(index);
				HeartbeatRequest req = HeartbeatRequest.newBuilder().setTime(item).build();

				try {
					Iterator<HeartbeatReply> replies = blockingStub.realTimeHeartbeatDetection(req);
					
					while(replies.hasNext()) {
						HeartbeatReply temp = replies.next();
						textResponse.append(" " + temp.getResult());
					}
				} catch (StatusRuntimeException e1) {
					e1.printStackTrace();
				}
				
				

			}
		});
		panel_service_1.add(btnHeartbeatDetection);
		
		textResponse = new JTextArea(3, 20);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		//textResponse.setSize(new Dimension(15, 30));
		panel_service_1.add(scrollPane);
		
		
		JPanel panel_service_2 = new JPanel();
		frame.getContentPane().add(panel_service_2);
		
		JPanel panel_service_3 = new JPanel();
		frame.getContentPane().add(panel_service_3);
		
		
		
	}
	
	
	
	
	
	
	
}