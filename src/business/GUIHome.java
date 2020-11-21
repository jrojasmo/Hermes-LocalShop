package business;

import java.awt.Dimension;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import dataStructures.*;
import processes.ReadData;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class GUIHome {

	public static ProductDatabase productDatabase = new ProductDatabase();
	public static UserDatabase userDatabase = new UserDatabase();
	ReadData read = new ReadData();
	User currentUser = null;
	public JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height - 37; 
	private JPasswordField passwordText;
	public boolean isLogged = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					GUIHome window = new GUIHome();
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
	public GUIHome() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Load the Admins
		try(Scanner input = new Scanner(new File("data/dataTest/users.txt"))){	
	  		while(input.hasNextLine()) {
	  			read.readLine(input);
	  			User u = new Administrator(read.colA, read.colB, read.colC);
	  			userDatabase.addUser(u);
	  		}
	  			Client c = new Client("Juan","12345","juanito@gmail.com");
	  			userDatabase.addUser(c);
	  	} catch (IOException e) {
	  	  		System.out.println(e);
	  	}
		//Load the Products
		try(Scanner input = new Scanner(new File("data/dataTest/products.txt"))){	
	  		while(input.hasNextLine()) {
	  			read.readLine(input);
	  			int quantity = Integer.parseInt(read.colB);
	  			float price = Float.parseFloat(read.colC);
	  			Product p = new Product(read.colA, quantity, price);
	  			productDatabase.addProduct(p);
	  		}
	  	} catch (IOException e) {
	  	  		System.out.println(e);
	  	}
			Tag food = new Tag("food","The best food for you!");
			Tag tech = new Tag("tech","The last elemnts");
			Tag home = new Tag("home","Home sweet home");
			ImageIcon pIcon = new javax.swing.ImageIcon(getClass().getResource("/img/p1.jpg"));
			Product k = new Product("Zucaritas", 30, Float.parseFloat("5.99"),"Delicius corn breakfast for be strong and have energy", food, pIcon);
			productDatabase.addProduct(k);
			pIcon = new javax.swing.ImageIcon(getClass().getResource("/img/p2.png"));
			k = new Product("Trululu Candies", 42, Float.parseFloat("1.99"),"Delicius candies, best of the world", food, pIcon);
			productDatabase.addProduct(k);
			pIcon = new javax.swing.ImageIcon(getClass().getResource("/img/p3.jpg"));
			k = new Product("Smarthphone", 10, Float.parseFloat("999.99"),"Best smarthphone, designed by Huahei", tech, pIcon);
			productDatabase.addProduct(k);
			pIcon = new javax.swing.ImageIcon(getClass().getResource("/img/p4.jpg"));
			k = new Product("Camera", 10, Float.parseFloat("799.99"),"120 Megapixels, Full HD 4K UltraPro", tech, pIcon);
			productDatabase.addProduct(k);
			pIcon = new javax.swing.ImageIcon(getClass().getResource("/img/p5.jpg"));
			k = new Product("Blankets", 10, Float.parseFloat("49.99"),"The softest blanket, black, blue , red x5 units", home, pIcon);
			productDatabase.addProduct(k);
		//*/*/*/*/*/*//*//*/**//**//
		Color myColor;
		//Frame
		frame = new JFrame();
		frame.setBounds(0, 0, w, h);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//Container
		JPanel container = new JPanel();
		container.setPreferredSize(new Dimension(w, 3*h));
		myColor = Color.decode("#2c3e50");
		container.setLayout(null);
		container.setBackground(myColor);
		
		//Scroll
		JScrollPane scrollPanelContainer = new JScrollPane();
		scrollPanelContainer.setBounds(0, 0, w, h);
		scrollPanelContainer.setViewportView(container);
		
		frame.getContentPane().add(scrollPanelContainer);

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
		
		//CATEGORIES
		JPanel panelTitleCategories = new JPanel();
		panelTitleCategories.setBounds(0, 4*h/22, w/7, h/22);
		myColor = Color.decode("#2980b9");
		panelTitleCategories.setBackground(myColor);
		container.add(panelTitleCategories);
		
		JLabel lblCategories = new JLabel("CATEGORIES");
		lblCategories.setForeground(new Color(248, 248, 255));
		lblCategories.setFont(new Font("Dubai", Font.BOLD, 17));
		panelTitleCategories.add(lblCategories);
		
		JPanel categoriesSlotsPanel = new JPanel();
		categoriesSlotsPanel.setBounds(0, 5*h/22, w/7, h-5*h/22);
		myColor = Color.decode("#3498db");
		categoriesSlotsPanel.setBackground(myColor);
		container.add(categoriesSlotsPanel);
		categoriesSlotsPanel.setLayout(null);
		
		
		//LOG-IN - REGISTER
		JTextArea userText = new JTextArea();
		userText.setBounds(869, 40, 147, 18);
		headerPanel.add(userText);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(1039, 40, 147, 18);
		headerPanel.add(passwordText);
		
		JButton loginButton = new JButton("Log In");
		loginButton.setForeground(Color.WHITE);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inPass = new String(passwordText.getPassword());
				String inUsername = userText.getText();
				currentUser = userDatabase.consultUser(inUsername, inPass);
				if(currentUser != null) {
					JOptionPane.showMessageDialog(headerPanel, "Log In Success");
					isLogged = true;
				}else {
					JOptionPane.showMessageDialog(headerPanel, "Wrong Username/Password");
				}
				final ProductDatabase fProductDatabase = productDatabase;
				if(isLogged) {
					GUI_isLogged guiLogged = new GUI_isLogged(currentUser, fProductDatabase);
					guiLogged.setVisible(true);
					frame.dispose();
				}else {
					userText.setText("");
					passwordText.setText("");
				}
			}
		});
		loginButton.setBounds(1208, 40, 89, 23);
		loginButton.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		myColor = Color.decode("#2c3e50");
		loginButton.setBackground(myColor);
		headerPanel.add(loginButton);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblUsername.setBounds(869, 23, 81, 14);
		headerPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblPassword.setBounds(1039, 23, 68, 14);
		headerPanel.add(lblPassword);
		
		JButton registerButton = new JButton("Register Now!");
		registerButton.setForeground(Color.WHITE);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIRegister guiRegister = new GUIRegister();
				guiRegister.setVisible(true);
				frame.dispose();
			}
		});
		registerButton.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		myColor = Color.decode("#2c3e50");
		registerButton.setBackground(myColor);
		registerButton.setBounds(1045, 65, 134, 23);
		headerPanel.add(registerButton);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an Account?");
		lblDontHaveAn.setFont(new Font("Bahnschrift", Font.BOLD, 13));
 	    lblDontHaveAn.setBounds(879, 70, 153, 14);
		headerPanel.add(lblDontHaveAn);
			
		///SEACH
		JPanel seachPanel = new JPanel();
		myColor = Color.decode("#34495e");
		seachPanel.setBackground(myColor);
		seachPanel.setBounds(w/7, 4*h/22, w-w/7, 2*h/44);
		container.add(seachPanel);
		seachPanel.setLayout(null);
		
		JLabel lblSeach = new JLabel("Seach!");
		lblSeach.setForeground(new Color(255, 255, 255));
		lblSeach.setBounds(68, 9, 136, 14);
		lblSeach.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		seachPanel.add(lblSeach);
		
		JTextArea seachTextArea = new JTextArea();
		seachTextArea.setBounds(180, 7, 450, 19);
		seachPanel.add(seachTextArea);
		
		JButton okSeachButton = new JButton("OK!");
		okSeachButton.setForeground(Color.BLACK);
		okSeachButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		okSeachButton.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		myColor = Color.decode("#ecf0f1");
		okSeachButton.setBackground(myColor);
		okSeachButton.setBounds(700, 6, 80, 23);
		seachPanel.add(okSeachButton);
		
		//PRODUCTS
		JPanel productPanel = new JPanel();
		myColor = Color.decode("#2c3e50");
		productPanel.setBackground(myColor);
		productPanel.setBounds(w/7, 5*h/22, w-w/7, 3*h - 5*h/22);
		container.add(productPanel);
		productPanel.setLayout(null);
		
		Product[] showcase = productDatabase.toArray();
		for(int rows = 0; rows < showcase.length - 2; rows++)
		for(int j = 0; j < 2; j++) {
		//Unit product
		JLabel productPhoto = new JLabel();
		productPhoto.setBounds(30 + j*575, 30 + rows*200, 175, 175);
		ImageIcon productIcon = new javax.swing.ImageIcon(getClass().getResource("/img/defaultProduct.jpg"));
		if(showcase[j+rows].productPhoto != null)
			productIcon = showcase[j+rows].productPhoto;
		
		Image imgProductPhoto = productIcon.getImage();
		Image newProductPhoto = imgProductPhoto.getScaledInstance(productPhoto.getWidth(), productPhoto.getHeight(), Image.SCALE_SMOOTH);
		productIcon = new ImageIcon(newProductPhoto);
		productPhoto.setIcon(productIcon);
		productPanel.add(productPhoto);
		
		JLabel lblProductName = new JLabel(showcase[j+ rows].name);
		lblProductName.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		lblProductName.setForeground(Color.WHITE);
		lblProductName.setBounds(240 + j*575, 35+ rows*200, 300, 30);
		productPanel.add(lblProductName);
		
		JLabel lblProductTag = new JLabel("[" + showcase[j+ rows].getTag().key + "]");
		lblProductTag.setFont(new Font("Bahnschrift", Font.BOLD, 11));
		lblProductTag.setForeground(Color.WHITE);
		lblProductTag.setBounds(240+ j*575, 91+ rows*200, 60, 20);
		productPanel.add(lblProductTag);
		
		JLabel lblProductPrice = new JLabel("$ " + showcase[j+ rows].getPrice());
		lblProductPrice.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblProductPrice.setForeground(Color.GREEN);
		lblProductPrice.setBounds(240+ j*575, 110+ rows*200, 60, 20);
		productPanel.add(lblProductPrice);
		
		JLabel lblProductNumber = new JLabel("Quantity :" + showcase[j+ rows].getQuantity());
		lblProductNumber.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblProductNumber.setForeground(Color.WHITE);
		lblProductNumber.setBounds(240 + j*575, 130+ rows*200, 100, 20);
		productPanel.add(lblProductNumber);

		JButton seeMore = new JButton("More ...");
		seeMore.setBounds(340 + j*575, 168+ rows*200, 80, 18);
		seeMore.setForeground(Color.BLACK);
		seeMore.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		myColor = Color.decode("#f1c40f");
		seeMore.setBackground(myColor);
		productPanel.add(seeMore);
		Product finalProduct =  showcase[j+ rows];
		final ProductDatabase fProductDatabase = productDatabase;
		seeMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIProduct guiProd = new GUIProduct(finalProduct, currentUser, fProductDatabase);
				guiProd.setVisible(true);
			}
		});
		}
	}
}
