package com.nisira.vista.formularios;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.FocusManager;

import com.nisira.Inicio;
import com.nisira.vista.controles.JTextFieldMovil;
import com.nisira.vista.controles.JTextLabelPanel;

public class FrmMWRfid extends FrmMWGeneralPatos{
	
	public FrmMWRfid(Window mainWindow,String title){
		super(mainWindow,title);
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		this.dispose();
	}
	
	public void ordenfocus(int tipo){
//		field.pop.setVisible(false);
		if(listField.size()>0){
			switch (tipo) {
			case 1: /*ENTER*/
					JTextFieldMovil field=(JTextFieldMovil)FocusManager.getCurrentManager().getFocusOwner();
					int pos=0;
					for(JTextLabelPanel panel : listField){
						if(panel.textField==field){
							pos= listField.indexOf(panel);
							break;
						}
					}
					/*FOCUS A LA SIGUIENTE CAJA DE TEXTO*/
					if(listField.size()-1== pos)
						pos=0;
					listField.get(pos).textField.requestFocus();
				break;

			default: /*INICIO*/
				listField.get(0).textField.requestFocus();
				break;
			}
			
		}
	}

	public static void main(String[] args) {
		FrmMWRfid frm= new FrmMWRfid(Inicio.mainF,"Prueba");
		frm.setSize(new Dimension(400, 400));
		frm.setMinimumSize(new Dimension(400, 400));
		frm.setLocation(10, 10);
		frm.setVisible(true);
	}
}
