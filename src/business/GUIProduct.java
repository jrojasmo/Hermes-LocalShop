package business;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class GUIProduct extends JFrame {

	public Product currentProduct ;
	public User currentUser;
	private JPanel contentPane;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width;
	private int h = screenSize.height - 37;

	/**
	 * Create the frame.
	 */
	public GUIProduct(Product currentProduct, User currentUser, ProductDatabase productDatabase) {
		
		if(currentProduct == null)
			currentProduct = new Product("Error", 0, Float.parseFloat("0.0"));
		else
			this.currentProduct = currentProduct;
		
		
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
		
		//USER CARD
		this.currentUser = currentUser;
		
		//PRODUCT EX
		JPanel productPanel = new JPanel();
		myColor = Color.decode("#95a5a6");
		productPanel.setBackground(myColor);
		productPanel.setBounds(w/7, 4*h/22, w-2*w/7, h-4*h/22);
		container.add(productPanel);
		productPanel.setLayout(null);
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(750, 515, 70, 30);
		okButton.setForeground(Color.BLACK);
		okButton.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		myColor = Color.decode("#f1c40f");
		okButton.setBackground(myColor);
		productPanel.add(okButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIHome guiHome = new GUIHome();
				guiHome.frame.setVisible(true);
				dispose();
			}
		});
		if(currentUser instanceof Client) {
			ImageIcon shpC = new javax.swing.ImageIcon(getClass().getResource("/img/addToCart.png"));
			Image imgShpC = shpC.getImage();
			Image newShpC = imgShpC.getScaledInstance(37, 37, Image.SCALE_SMOOTH);
			shpC = new ImageIcon(newShpC);	
			JButton shpCButton = new JButton(shpC);
			shpCButton.setBounds(655, 515, 70, 30);
			myColor = Color.decode("#f1c40f");
			shpCButton.setBackground(myColor);
			productPanel.add(shpCButton);
			final Client auxUser = (Client) currentUser;
			final Product fProduct = currentProduct;
			final ProductDatabase fProductDatabase = productDatabase;
			shpCButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(fProduct.getQuantity() != 0) {
						((Client) currentUser).cart.addProduct(fProduct);
						final Product newP = new Product(fProduct.name, fProduct.quantity - 1, fProduct.price, fProduct.description, fProduct.tag, fProduct.productPhoto);
						fProductDatabase.editProduct(fProduct, newP);
						GUI_isLogged guiHome = new GUI_isLogged(auxUser, fProductDatabase);
						guiHome.setVisible(true);
					}
					dispose();
				}
			});
		}
		
		
		ImageIcon iProduct = new javax.swing.ImageIcon(getClass().getResource("/img/defaultProduct.jpg"));
		if(currentProduct.productPhoto != null)
			iProduct = currentProduct.productPhoto;
		
		Image imgProduct = iProduct.getImage();
		
				
		JLabel namelbl = new JLabel(currentProduct.getName());
		namelbl.setVerticalAlignment(SwingConstants.TOP);
		namelbl.setFont(new Font("Bahnschrift", Font.BOLD, 40));
		namelbl.setBounds(81, 70, 641, 97);
		productPanel.add(namelbl);
		
		JLabel idlbl = new JLabel("ID: " + currentProduct.getId());
		idlbl.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		idlbl.setBounds(91, 459, 224, 14);
		productPanel.add(idlbl);
		
		JLabel lblPrice = new JLabel("$ "+currentProduct.getPrice());
		lblPrice.setForeground(new Color(50, 205, 50));
		lblPrice.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblPrice.setBounds(81, 180, 114, 27);
		productPanel.add(lblPrice);
		
		JLabel lblQuantity = new JLabel(currentProduct.getQuantity() +" in Stock");
		lblQuantity.setFont(new Font("Bahnschrift", Font.BOLD | Font.ITALIC, 24));
		lblQuantity.setBounds(81, 207, 184, 33);
		productPanel.add(lblQuantity);
		
		JLabel lblDescription = new JLabel(currentProduct.getDescription());
		lblDescription.setVerticalAlignment(SwingConstants.TOP);
		lblDescription.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblDescription.setBounds(81, 252, 346, 196);
		productPanel.add(lblDescription);
		
		JLabel lblImg = new JLabel("");
		lblImg.setBounds(474, 173, 346, 290);
		Image newImgProduct = imgProduct.getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageProduct = new ImageIcon(newImgProduct);
		lblImg.setIcon(imageProduct);
		productPanel.add(lblImg);
		
		JLabel lbltag = new JLabel("[" + currentProduct.getTag().key + "]");
		lbltag.setForeground(new Color(30, 144, 255));
		lbltag.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		lbltag.setBounds(81, 155, 207, 27);
		productPanel.add(lbltag);
	}
}
