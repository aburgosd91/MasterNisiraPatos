package com.nisira.vista.controles;

import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.SwingConstants;

import com.nisira.teclado.JKeyboardPane;

public class JTextFieldPasswordMovil extends JPasswordField implements FocusListener,KeyListener{
	public JPopupMenu pop;
	public JKeyboardPane teclado;
	public JTextFieldPasswordMovil(){
		super();
		setHorizontalAlignment(SwingConstants.RIGHT);
		setFont(new Font("Arial", Font.BOLD, 14));
		addFocusListener(this);
		addKeyListener(this);
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("focusGained");
		methodKeyboard();
	}
	@Override
	public void focusLost(FocusEvent e) {
//		System.out.println("focusLost");
		// TODO Auto-generated method stub
		methodCloseKeyboard();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		methodClosePopMenu(e);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		methodUppercase(e);
	}
	public void ordenfocus(){}
	/*****************************COMPLEMENTARY METHOD********************************/
	public void methodClosePopMenu(KeyEvent e){
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ESCAPE){
			methodCloseKeyboard();
		}
	    else if(code == KeyEvent.VK_ENTER){
	    	ordenfocus();
	    }
	}
	public void methodUppercase(KeyEvent e){
		if (e.getSource() == this) {
            char c = e.getKeyChar();
            if(Character.isLowerCase(c)){
            	String cad=(""+c).toUpperCase();
            	c=cad.charAt(0);
            	e.setKeyChar(c);
            }
        }
	}
	public void methodKeyboard(){
		if(pop==null){
			pop = new JPopupMenu();
		}
		if(teclado==null){
			teclado=new JKeyboardPane(this,pop);
			pop.add(teclado);
		}
		pop.setVisible(true);
		pop.setLocation(this.getLocationOnScreen().x, this.getLocationOnScreen().y+this.getHeight());
	}
	public void methodCloseKeyboard(){
		if(pop!=null)
			pop.setVisible(false);
	}
}
