package business;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import dataStructures.*;
import processes.ReadData;

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI_isLogged extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel contentPane;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height - 37;
	User currentUser;
	ProductDatabase productDatabase;
	
	public GUI_isLogged(User currentUser , ProductDatabase productDatabase) {
		
		if(currentUser == null)
			currentUser = new Client("Error", "No-pass", "noMail@noMail.com");
		else
			this.currentUser = currentUser;
		
		this.productDatabase = productDatabase;
		
		
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
		container.setPreferredSize(new Dimension(w, 3*h));
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
		
		
		//User Card
		JPanel userPanel = new JPanel();
		myColor = Color.decode("#16a085");
		userPanel.setBackground(myColor);
		userPanel.setBounds(855, 10, w/3, 3*h/22);
		userPanel.setLayout(null);
		headerPanel.add(userPanel);
		
		JLabel userPhoto = new JLabel();
		userPhoto.setBounds(23, 17, 105, 105);
		ImageIcon userIcon = new javax.swing.ImageIcon(getClass().getResource("/img/defaultUser.png"));
				
		if(currentUser.userPhoto != null)
			userIcon = currentUser.userPhoto;
		
		Image imgUserPhoto = userIcon.getImage();
		Image newUserPhoto = imgUserPhoto.getScaledInstance(userPhoto.getWidth(), userPhoto.getHeight(), Image.SCALE_SMOOTH);
		userIcon = new ImageIcon(newUserPhoto);
		userPhoto.setIcon(userIcon);
		userPanel.add(userPhoto);
		
		JLabel lblLogUsername = new JLabel(currentUser.username);
		lblLogUsername.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblLogUsername.setForeground(Color.WHITE);
		lblLogUsername.setBounds(150, 17, 140, 30);
		userPanel.add(lblLogUsername);
		
		JLabel lblLogEmail = new JLabel(currentUser.email);
		lblLogEmail.setFont(new Font("Bahnschrift", Font.ITALIC, 11));
		lblLogEmail.setForeground(Color.BLACK);
		lblLogEmail.setBounds(150, 44, 150, 20);
		userPanel.add(lblLogEmail);
		

		JButton logOutButton = new JButton("Log Out");
		logOutButton.setBounds(150, 63, 100, 18);
		logOutButton.setForeground(Color.BLACK);
		logOutButton.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		myColor = Color.decode("#f1c40f");
		logOutButton.setBackground(myColor);
		userPanel.add(logOutButton);
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIHome guiHome = new GUIHome();
				guiHome.frame.setVisible(true);
				dispose();
			}
		});
		
		
		if(currentUser instanceof Client) {
			ImageIcon shpC = new javax.swing.ImageIcon(getClass().getResource("/img/ShoppingCart.png"));
			Image imgShpC = shpC.getImage();
			Image newShpC = imgShpC.getScaledInstance(37, 37, Image.SCALE_SMOOTH);
			shpC = new ImageIcon(newShpC);	
			JButton shpCButton = new JButton(shpC);
			shpCButton.setBounds(320, 20, 50, 50);
			myColor = Color.decode("#f1c40f");
			shpCButton.setBackground(myColor);
			userPanel.add(shpCButton);
			final Client auxUser = (Client) currentUser;
			final ProductDatabase fProductDatabase = productDatabase;
			shpCButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIShoppingCart guiCart = new GUIShoppingCart(auxUser, fProductDatabase );
					guiCart.setVisible(true);
					dispose();
				}
			});
			ImageIcon settings = new javax.swing.ImageIcon(getClass().getResource("/img/Settings.png"));
			Image imgSettings = settings.getImage();
			Image newSettings = imgSettings.getScaledInstance(37, 37, Image.SCALE_SMOOTH);
			settings = new ImageIcon(newSettings);
			JButton settingsButton = new JButton(settings);
			settingsButton.setBounds(390, 20, 50, 50);
			myColor = Color.decode("#f1c40f");
			settingsButton.setBackground(myColor);
			userPanel.add(settingsButton);
			logOutButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIHome guiHome = new GUIHome();
					guiHome.frame.setVisible(true);
					dispose();
				}
			});
		}
		
		if(currentUser instanceof Administrator) {
			ImageIcon admin = new javax.swing.ImageIcon(getClass().getResource("/img/admin.png"));
			Image imgAdmin = admin.getImage();
			Image newAdmin = imgAdmin.getScaledInstance(37, 37, Image.SCALE_SMOOTH);
			admin = new ImageIcon(newAdmin);	
			JButton shpCButton = new JButton(admin);
			shpCButton.setBounds(320, 20, 50, 50);
			myColor = Color.decode("#f1c40f");
			shpCButton.setBackground(myColor);
			userPanel.add(shpCButton);
			final Administrator auxUser = (Administrator) currentUser;
			shpCButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIAdmin adminGUI = new GUIAdmin();
					adminGUI.setVisible(true);
					dispose();
				}
			});
			
			ImageIcon settings = new javax.swing.ImageIcon(getClass().getResource("/img/Settings.png"));
			Image imgSettings = settings.getImage();
			Image newSettings = imgSettings.getScaledInstance(37, 37, Image.SCALE_SMOOTH);
			settings = new ImageIcon(newSettings);
			JButton settingsButton = new JButton(settings);
			settingsButton.setBounds(390, 20, 50, 50);
			myColor = Color.decode("#f1c40f");
			settingsButton.setBackground(myColor);
			userPanel.add(settingsButton);
			logOutButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIHome guiHome = new GUIHome();
					guiHome.frame.setVisible(true);
					dispose();
				}
			});
			
		}
		
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
		User finalUser = currentUser;
		final ProductDatabase fProductDatabase = productDatabase;
		seeMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIProduct guiProd = new GUIProduct(finalProduct, finalUser, fProductDatabase);
				guiProd.setVisible(true);
			}
			});
		}
		
	}
	
}
