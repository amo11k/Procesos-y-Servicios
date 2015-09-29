package ejercicios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;

public class PSShellInterfaz extends JFrame {

	private JPanel contentPane;
	private JTextField comando;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PSShellInterfaz frame = new PSShellInterfaz();
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
	public PSShellInterfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIntroduceElComando = new JLabel("Introduce el comando aquí:");
		lblIntroduceElComando.setBounds(31, 12, 209, 27);
		contentPane.add(lblIntroduceElComando);
		
		comando = new JTextField();
		comando.setBounds(31, 48, 194, 19);
		contentPane.add(comando);
		comando.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(31, 99, 388, 164);
		contentPane.add(textArea);
		
		JButton btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcessBuilder pb = new ProcessBuilder(comando.getText());
				try {
					Process process = pb.start();
					int retorno = process.waitFor();
					textArea.setText("La ejecución de " +comando.getText() + " devuelve " + retorno);
					textArea.setText(textArea.getText()+"\n"+"Salida del proceso " +comando.getText() + ":");
					InputStream is = process.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);
					String line;
					while ((line = br.readLine()) != null) {
						textArea.setText(textArea.getText()+"\n"+line);
					}
				} catch (IOException ex) {
					textArea.setText("Excepción de E/S!!");
					System.exit(-1);

				} catch (InterruptedException ex) {
					textArea.setText("El proceso hijo finalizó de forma incorrecta");
					System.exit(-1);

				}
			}
		});
		btnEjecutar.setBounds(276, 32, 117, 25);
		contentPane.add(btnEjecutar);
		
		
	}
}
