package com.nisira.vista.formularios;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.Closeable;
import java.io.IOException;

import javax.swing.FocusManager;

import com.nisira.Inicio;
import com.nisira.vista.controles.JTextFieldMovil;
import com.nisira.vista.controles.JTextLabelPanel;
import com.sun.media.jfxmediaimpl.MediaDisposer.Disposable;

import sun.awt.WindowClosingListener;

public class FrmMWGeneralPatos extends AbstractFrmWindowMovil implements MouseMotionListener,MouseListener,WindowListener{
	int mx,my;
	public FrmMWGeneralPatos(Window mainWindow,String title){
		super(mainWindow,title);
		addMouseMotionListener(this);
		addMouseListener(this);
		addWindowListener(this);
	}

	@Override
	public void save() {}
	@Override
	public void reset() {}
	@Override
	public void cancel() {
		this.dispose();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if((e.getModifiersEx())!=0){
			setLocation(e.getXOnScreen(), e.getYOnScreen());
			/*SACAR EL FOCUS*/
			closeMasivoPop();
//			if(FocusManager.getCurrentManager().getFocusOwner()!=null){
//				JTextFieldMovil field=(JTextFieldMovil)FocusManager.getCurrentManager().getFocusOwner();
//				field.pop.setVisible(false);
//			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	public static void main(String[] args) {
		FrmMWGeneralPatos frm= new FrmMWGeneralPatos(Inicio.mainF,"Prueba");
		frm.setSize(new Dimension(400, 400));
		frm.setMinimumSize(new Dimension(400, 400));
		frm.setLocation(10, 10);
		frm.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("mousePressed");
		if(e.getButton()== MouseEvent.BUTTON1){
			my=e.getY();
			mx=e.getX();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	/*METODOS NUEVOS*/
	public void closeMasivoPop(){
		if(listField.size()>0){
			for(JTextLabelPanel zonafield: listField){
				zonafield.textField.methodCloseKeyboard();
			}
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("windowClosing");
		closeMasivoPop();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("windowClosed");
		closeMasivoPop();
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
