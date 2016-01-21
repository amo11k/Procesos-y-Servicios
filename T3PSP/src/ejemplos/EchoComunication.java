package ejemplos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EchoComunication extends JFrame {

	private JPanel contentPane;
	private JTextField hostField;
	private JTextField portField;
	private JTextField textComunication;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EchoComunication frame = new EchoComunication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EchoComunication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 0, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);

		JLabel lblHost = new JLabel("Host:");
		panel.add(lblHost);

		hostField = new JTextField();
		panel.add(hostField);
		hostField.setColumns(10);

		JLabel lblPuerto = new JLabel("Puerto:");
		panel.add(lblPuerto);

		portField = new JTextField();
		panel.add(portField);
		portField.setColumns(10);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblTexto = new JLabel("Texto:");
		lblTexto.setBounds(12, 28, 44, 15);
		lblTexto.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblTexto);

		textComunication = new JTextField();
		textComunication.setBounds(74, 7, 364, 58);
		panel_1.add(textComunication);
		textComunication.setColumns(10);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);

		JButton btnNewButton = new JButton("CONECTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conectar();
				comunication();
			}
		});
		panel_2.add(btnNewButton);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		textArea = new JTextArea();
		textArea.setBounds(0, 5, 438, 48);
		textArea.setText("ECHO SERVER");
		// txtrEchoServer.setBounds(10, 10, 100, 100);
		panel_3.add(textArea);
	}

	public void conectar() {
		int portNumber = Integer.parseInt(portField.getText());
		
		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket clientSocket = serverSocket.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			try {
				if (serverSocket.accept() != null)
					out.println("La conexión está establecida. Puerto: " + portNumber);
				else
					out.println("La conexión es errónea");
				String inputLine;
				/*while ((inputLine = in.readLine()) != null) {
					out.println(inputLine + " Host: " + clientSocket.getInetAddress().toString() + " Puerto: "
							+ clientSocket.getLocalPort());
				}*/
			} finally {

			}

		} catch (IOException e) {
			System.out.println(
					"Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}

	public void comunication() {
		String hostName = hostField.getText();
		int portNumber = Integer.parseInt(portField.getText());

		try (Socket echoSocket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

			String userInput;
			while ((userInput = textComunication.getText()) != null) {
				out.println(userInput);
				textArea.setText("echo: " + textComunication.getText());
			}
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + hostName);
			System.exit(1);
		}

	}
}
