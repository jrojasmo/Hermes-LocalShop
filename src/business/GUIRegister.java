package business;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIRegister extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel contentPane;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height - 37;
	private JTextField usernameText;
	private JTextField emailText;
	private JPasswordField passwordField;
	private JPasswordField passwordConfField;
 

	/**
	 * Create the contentPanel.
	 */
	public GUIRegister() {
		
		Color myColor;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, screenSize.width, screenSize.height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		myColor = Color.decode("#34495e");
		contentPane.setBackground(myColor);
		contentPane.setLayout(null);
		
		//Container
		JPanel container = new JPanel();
		container.setPreferredSize(new Dimension(w, h));
		myColor = Color.decode("#2c3e50");
		container.setLayout(null);
		container.setBackground(myColor);
		
		//Scroll
		JScrollPane scrollPanelContainer = new JScrollPane();
		scrollPanelContainer.setBounds(0, 0, w, h);
		scrollPanelContainer.setViewportView(container);	
		contentPane.add(scrollPanelContainer);

		////Design/////
		JPanel yellowStripe = new JPanel();
		yellowStripe.setBounds(0, 3*h/22, w, h/22);
		myColor = Color.decode("#f1c40f");
		yellowStripe.setBackground(myColor);
		container.add(yellowStripe);
			
		JLayeredPane header = new JLayeredPane();
		header.setBounds(0, 0, 1350, 99);
		header.setBackground(new Color(0, 255, 255));
		container.add(header);
		myColor = Color.decode("#27ae60");
			
		JPanel logoPanel = new JPanel(); 
		myColor = Color.decode("#f39c12");
		logoPanel.setBackground(myColor);
		logoPanel.setBounds(0, 0, w/10, 3*h/22);
		header.add(logoPanel);
			
		JLabel logo = new JLabel();
		logo.setBounds(21, 0, 105, 105);
		ImageIcon i = new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"));
		Image img = i.getImage();
		Image newImg = img.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		logoPanel.setLayout(null);
		logo.setIcon(image);
		logoPanel.add(logo);
		
		JPanel nameLogoPanel = new JPanel();
		myColor = Color.decode("#f39c12");
		nameLogoPanel.setBackground(myColor);
		nameLogoPanel.setBounds(w/10, 0, w/8, 3*h/22);
		header.add(nameLogoPanel);
		nameLogoPanel.setLayout(null);
		
		JLabel name = new JLabel("HERMES");
		name.setForeground(new Color(0, 0, 0));
		name.setBounds(10, 29, 134, 45);
		name.setVerticalAlignment(SwingConstants.BOTTOM);
		name.setFont(new Font("Segoe UI", Font.BOLD, 33));
		nameLogoPanel.add(name);
			
		JPanel headerPanel = new JPanel();
		myColor = Color.decode("#1abc9c");
		headerPanel.setBackground(myColor);
		headerPanel.setBounds(0, 0, w, 3*h/22);
		header.add(headerPanel);
		headerPanel.setLayout(null);
		
		//REGISTER
		
		JPanel panel_6 = new JPanel();
		myColor = Color.decode("#bdc3c7");
		panel_6.setBackground(myColor);
		panel_6.setBounds(w/2-200, h/5, 400, 100);
		container.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblRegistration = new JLabel("REGISTER");
		lblRegistration.setBounds(60, 21, 283, 47);
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setFont(new Font("Bahnschrift", Font.BOLD, 39));
		panel_6.add(lblRegistration);
		
		JPanel panelForText = new JPanel();
		panelForText.setBackground(new Color(189, 195, 199));
		panelForText.setBounds(w/2-400, 3*h/8, 800, h-4*h/9);
		container.add(panelForText);
		panelForText.setLayout(null);
		
		usernameText = new JTextField();
		usernameText.setBounds(223, 80, 212, 18);
		panelForText.add(usernameText);
		usernameText.setColumns(10);
		
		emailText = new JTextField();
		emailText.setBounds(223, 259, 212, 18);
		panelForText.add(emailText);
		emailText.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(223, 142, 212, 18);
		panelForText.add(passwordField);
		
		passwordConfField = new JPasswordField();
		passwordConfField.setBounds(223, 203, 212, 18);
		panelForText.add(passwordConfField);
		
		JButton registerBtn = new JButton("Register");
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inUsername = usernameText.getText();
				String inEmail = emailText.getText();
				String inPass = new String(passwordField.getPassword());
				String inPassConf = new String(passwordConfField.getPassword());
				if(inUsername.equals("") || inEmail.equals("") || inPass.equals("")) {
					JOptionPane.showMessageDialog(container, "You can't left empty slots");
				} else if(!inUsername.matches("^[A-Za-z0-9_-]{5,20}$")){
					JOptionPane.showMessageDialog(container, "Invalid Username");
					usernameText.setText("");		
				} else if(!inPass.matches("^[A-Za-z0-9_-]{4,20}$")){
					JOptionPane.showMessageDialog(container, "Invalid Password");
					passwordField.setText("");
					passwordConfField.setText("");
				} else if(!inEmail.matches("[-\\w\\.]+@\\w+\\.\\w+")){
					JOptionPane.showMessageDialog(container, "Invalid Email");
					emailText.setText("");
				} else if(!inPass.equals(inPassConf)) {
					JOptionPane.showMessageDialog(container, "Passwords don't match");
					passwordField.setText("");
					passwordConfField.setText("");
				} else {	
					User u = new Client(inUsername, inPass, inEmail);
					GUIHome guiHome = new GUIHome();
					GUIHome.userDatabase.addUser(u);
					JOptionPane.showMessageDialog(container, "Register Success");
					guiHome.frame.setVisible(true);
					usernameText.setText("");
					passwordField.setText("");
					passwordConfField.setText("");
					emailText.setText("");
					dispose();
				}
				
			}
		});
		registerBtn.setForeground(Color.WHITE);
		registerBtn.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		myColor = Color.decode("#2c3e50");
		registerBtn.setBackground(myColor);
		registerBtn.setBounds(572, 307, 105, 44);
		panelForText.add(registerBtn);
		
		JLabel usernamelbl = new JLabel("Your Username");
		usernamelbl.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		usernamelbl.setBounds(223, 37, 148, 32);
		panelForText.add(usernamelbl);
		
		JLabel passlbl = new JLabel("Your Password");
		passlbl.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		passlbl.setBounds(223, 111, 148, 20);
		panelForText.add(passlbl);
		
		JLabel emaillbl = new JLabel("Your email");
		emaillbl.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		emaillbl.setBounds(223, 234, 212, 18);
		panelForText.add(emaillbl);
		
		JLabel confirmpasslbl = new JLabel("Confirm your Password");
		confirmpasslbl.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		confirmpasslbl.setBounds(223, 173, 212, 20);
		panelForText.add(confirmpasslbl);
	}
}
