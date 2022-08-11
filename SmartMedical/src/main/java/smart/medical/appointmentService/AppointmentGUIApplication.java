package smart.medical.appointmentService;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

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
import io.grpc.stub.StreamObserver;
import smart.medical.appointmentService.SmartAppointmentServiceGrpc.SmartAppointmentServiceBlockingStub;
import smart.medical.appointmentService.SmartAppointmentServiceGrpc.SmartAppointmentServiceStub;

public class AppointmentGUIApplication {

	private static SmartAppointmentServiceBlockingStub blockingStub;
	private static SmartAppointmentServiceStub asyncStub;
	
	private ServiceInfo appointmentServiceInfo;
	
	private JFrame frame;
	private JTextField textRequest;
	private JTextField textName;
	private JTextField textGender;
	private JTextField textDiagnose;
	private JTextArea textResponse;
	
	//launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					AppointmentGUIApplication window = new AppointmentGUIApplication();
					window.frame.setVisible(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	//create the application
	public AppointmentGUIApplication() {
		
		String service_type = "_http._tcp.local.";
		discoverOneClickCancellationService(service_type);
			
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50095)
				.usePlaintext()
				.build();
		
		//stub
		blockingStub = SmartAppointmentServiceGrpc.newBlockingStub(channel);
		asyncStub = SmartAppointmentServiceGrpc.newStub(channel);
		
		initialize();
		
		
	}

	private void discoverOneClickCancellationService(String service_type) {
		// TODO Auto-generated method stub
		try {
			// create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			//Add a service listener
			jmdns.addServiceListener(service_type, new ServiceListener() {

				
				@Override
				public void serviceResolved(ServiceEvent event) {
					// TODO Auto-generated method stub
					System.out.println("AppointmentService resolved:" + event.getInfo());
					appointmentServiceInfo = event.getInfo();
					
					int port = appointmentServiceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties...");
					System.out.println("\t port: "+ port);
					System.out.println("\t type: " +event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description: "+ appointmentServiceInfo.getNiceTextString());
					System.out.println("\t host: "+ appointmentServiceInfo.getHostAddresses());
					
				}
				

				@Override
				public void serviceRemoved(ServiceEvent event) {
					// TODO Auto-generated method stub
					System.out.println("Appointment Service removed:" + event.getInfo());
				}


				@Override
				public void serviceAdded(ServiceEvent event) {
					// TODO Auto-generated method stub
					System.out.println("Appointment service added:" + event.getInfo());
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
		
		JLabel lblNewLabel_1 = new JLabel("one click cancel request: cancel or not");
		panel_service_1.add(lblNewLabel_1);
		
		textRequest = new JTextField();
		panel_service_1.add(textRequest);
		textRequest.setColumns(10);
		
		/*
		JLabel lblNewLabel_2 = new JLabel("Patient name");
		panel_service_1.add(lblNewLabel_2);
		
		textName = new JTextField();
		panel_service_1.add(textName);
		textName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Patient gender");
		panel_service_1.add(lblNewLabel_3);
		
		textGender = new JTextField();
		panel_service_1.add(textGender);
		textGender.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Patient diagnose");
		panel_service_1.add(lblNewLabel_4);
		
		textDiagnose = new JTextField();
		panel_service_1.add(textDiagnose);
		textDiagnose.setColumns(10);
		*/
	/*	JLabel lblNewLabel_2 = new JLabel("Number 2");
		panel_service_1.add(lblNewLabel_2);
		
		textNumber2 = new JTextField();
		panel_service_1.add(textNumber2);
		textNumber2.setColumns(10);
		
		
		JComboBox comboOperation = new JComboBox();
		comboOperation.setModel(new DefaultComboBoxModel(new String[] {"ADDITION", "SUBTRACTION", "MULTIPLICATION", "DIVISION"}));
		panel_service_1.add(comboOperation);
	*/
		
		JButton btnCancel = new JButton("File status");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int num1 = Integer.parseInt(textNumber1.getText());
				String item = textRequest.getText();
			/*	String name = textName.getText();
				String gender = textGender.getText();
				String diagnose = textDiagnose.getText();*/
				//int num2 = Integer.parseInt(textNumber2.getText());

				//int index = comboOperation.getSelectedIndex();
				//Operation operation = Operation.forNumber(index);
				OneClickCancellationRequest req = OneClickCancellationRequest.newBuilder().setCancellation(item).build();
				
				
				CancellationStatusReply responseObserver = blockingStub.oneClickCancellation(req);
				textResponse.append("reply: "+ responseObserver.getMessage());
						
				

			}
		});
		panel_service_1.add(btnCancel);
		
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