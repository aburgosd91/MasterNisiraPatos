package com.nisira.vista.controles;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.SwingConstants;

import com.nisira.utils.NisiraStringUtils;

public class NSRTextFieldCorrelativo extends NSRTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int total;
	public NSRTextFieldCorrelativo(int total){
		super();
		this.total = total;
		setDocument(new NSRTextFieldLimit(total, true));
		
		setHorizontalAlignment(SwingConstants.RIGHT);
		addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (getText() != null && !getText().trim().isEmpty())
					setText(NisiraStringUtils.padl(getText(), NSRTextFieldCorrelativo.this.total, '0'));
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				selectAll();
			}
		});
	}
	
	public void setValue(Object value){
		if(value == null)
			setText(null);
		else
			setText((String) value);
	}
	
	public void setValue(int value){
		setText(NisiraStringUtils.padl(String.valueOf(value), NSRTextFieldCorrelativo.this.total, '0'));
	}
}