package com.nisira.vista.controles;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class NSRTextField  extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NSRTextField() {
		super();
		agregarSelectOnFocus();
	}
	
	@Override
	public void setText(String t) {
		super.setText(t);
		setCaretPosition(0);
	}
	
	public NSRTextField(boolean selectOnFocus){
		super();
		if (selectOnFocus) {
			agregarSelectOnFocus();
		}
	}
	
	public NSRTextField(boolean selectOnFocus, int columns){
		super(columns);
		if (selectOnFocus) {
			agregarSelectOnFocus();
		}
	}
	
	
	private void agregarSelectOnFocus() {
		addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
            	NSRTextField.this.select(0, getText().length());
            }

            @Override
            public void focusLost(FocusEvent e) {
            	NSRTextField.this.select(0, 0);
            }
        });
	}
}
