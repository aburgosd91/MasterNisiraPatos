package com.nisira;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.EmptyBorder;

public class SplashScreen extends JWindow {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SplashScreen screen = new SplashScreen();
//		screen.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public SplashScreen() {
//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("splashscreen_gestionplanta_proyect.png"));
		
		
		//		System.out.println(img.toString()+ img.getIconWidth() + img.getIconHeight());
		contentPane =(JPanel)getContentPane();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
		Image image = img.getImage(); // transform it 
		Image newimg = image.getScaledInstance(400, 230,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		img = new ImageIcon(newimg);
		contentPane.add(new JLabel(img),BorderLayout.CENTER);
		setSize(400,230);
		setLocationRelativeTo(null);
		setVisible(true);
		try{
			Thread.sleep(4000);
		}catch(Exception e){
			e.printStackTrace();
		}
		setVisible(false);
		this.dispose();
		
//		setContentPane(contentPane);
	}

}
