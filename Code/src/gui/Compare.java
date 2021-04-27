package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import defaut;
public class Compare {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compare window = new Compare();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Compare() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		
		
		frame.setTitle("CompareTwo");
		frame.setBackground(new Color(25, 25, 112));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 61, 65, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridheight = 3;
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton = new JButton("Random");
		btnNewButton.setBackground(new Color( 	0, 51, 51));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String randomrfam = "";
				try {
					randomrfam = Brin.RandomRfam();
					
					textField_1.setText(randomrfam);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				try {
					randomrfam = Brin.RandomRfam();
					
					textField.setText("This is my new text.");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	    			
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Rfam1 :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 4;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 4;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Rfam2 : ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 5;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 5;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton1 = new JButton("Start");
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = 2;
		
				btnNewButton1.setBackground(new Color( 	0, 51, 51));
				btnNewButton1.setFont(new Font("Arial", Font.BOLD, 14));
				btnNewButton1.setForeground(new Color(255, 255, 255));
				btnNewButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String pfam1 = textField.getText();
						String pfam2 = textField_1.getText();
						
						Brin test2 = new Brin("","");
						Brin test1 = new Brin("","");
						try {
							test2 = Brin.getDataRfam(pfam1);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						try {
							test2 = Brin.getDataRfam(pfam2);
						} catch (IOException e) {
							e.printStackTrace();
						}
			        	System.out.println(test2.parenthesage);
			        	System.out.println(test2.sequence);
			        
				    	Noeud arbre1 = new Noeud();
				    	Noeud arbre2 = new Noeud();
				    	
				    	arbre1 = Noeud.convertToTree(test1.parenthesage);
				    	arbre2 = Noeud.convertToTree(test2.parenthesage);
				    	
				    	System.out.println("\n le plus grand sous arbre commun est : ");
				    	
				    	System.out.println(Noeud.convertToDashBracket(Noeud.comparaison(arbre1, arbre2)));
					}
				});
				gbc.insets = new Insets(0, 0, 0, 5);
				gbc.gridx = 4;
				gbc.gridy = 6;
				panel.add(btnNewButton1, gbc);
	}

}
