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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GUIAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int w = screenSize.width; 
	private int h = screenSize.height - 40;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAdmin frame = new GUIAdmin();
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
	public GUIAdmin() {
		
		Color myColor;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 3, screenSize.width, screenSize.height - 40);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		myColor = Color.decode("#7f8c8d");
		contentPane.setBackground(myColor);
		contentPane.setLayout(null);	
		

		JPanel panel_1 = new JPanel();
		myColor = Color.decode("#f1c40f");
		panel_1.setBackground(myColor);
		panel_1.setBounds(0, 3*h/22, w, h/22);
		contentPane.add(panel_1);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(0, 255, 255));
		layeredPane.setBounds(0, 0, 1350, 99);
		contentPane.add(layeredPane);
		myColor = Color.decode("#27ae60");
		
		JPanel panel_4 = new JPanel();
		myColor = Color.decode("#f39c12");
		panel_4.setBackground(myColor);
		panel_4.setBounds(0, 0, w/10, 3*h/22);
		layeredPane.add(panel_4);
		
		JLabel logo = new JLabel(); 
		logo.setBounds(21, 0, 105, 105);
		ImageIcon i = new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"));
		Image img = i.getImage();
		Image newImg = img.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		panel_4.setLayout(null);
		logo.setIcon(image);
		panel_4.add(logo);
		
		JPanel panel_5 = new JPanel();
		myColor = Color.decode("#f39c12");
		panel_5.setBackground(myColor);
		panel_5.setBounds(w/10, 0, w/8, 3*h/22);
		layeredPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel name = new JLabel("HERMES");
		name.setForeground(new Color(0, 0, 0));
		name.setBounds(10, 29, 134, 45);
		name.setVerticalAlignment(SwingConstants.BOTTOM);
		name.setFont(new Font("Segoe UI", Font.BOLD, 33));
		panel_5.add(name);
		
		JPanel panel = new JPanel();
		myColor = Color.decode("#1abc9c");
		panel.setBackground(myColor);
		panel.setBounds(0, 0, w, 3*h/22);
		layeredPane.add(panel);
	}

}
