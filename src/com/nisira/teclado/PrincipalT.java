package com.nisira.teclado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class PrincipalT implements ComponentListener{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	JPopupMenu pop;
	JKeyboardPane teclado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalT window = new PrincipalT();
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
	public PrincipalT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 424, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(45dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(100dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(181dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Prueba 1");
		frame.getContentPane().add(lblNewLabel, "4, 6");
		
		textField = new JTextField();
		frame.getContentPane().add(textField, "6, 6, 2, 1, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prueba 2");
		frame.getContentPane().add(lblNewLabel_1, "4, 10, left, default");
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1, "6, 10, fill, default");
		textField_1.setColumns(10);
		
		textField.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent arg0) {
				pop = new JPopupMenu();
				teclado=new JKeyboardPane(textField,pop);
				pop.add(teclado);
				pop.setVisible(true);
//				pop.setLocation(textField.getLocationOnScreen().x+112, textField.getLocationOnScreen().y-1);
				pop.setLocation(textField.getLocationOnScreen().x+20, textField.getLocationOnScreen().y+20);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				pop.setVisible(false);
			}
			
		});
		textField_1.addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent arg0) {
				pop = new JPopupMenu();
				teclado=new JKeyboardPane(textField_1,pop);
				pop.add(teclado);
				pop.setVisible(true);
				pop.setLocation(textField_1.getLocationOnScreen().x+20, textField_1.getLocationOnScreen().y+20);
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				pop.setVisible(false);
			}
			
		});
		frame.addComponentListener(this);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Moviendo ...");
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
