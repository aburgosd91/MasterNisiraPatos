package com.nisira.vista.utilitarios;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.EmptyBorder;

import com.nisira.ModalWindowExample;
import com.nisira.vista.controles.NSRInternalFrame;
import com.nisira.vista.formularios.FrmSysZona;

import javafx.stage.Modality;

import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class ProgressBarDialog extends JWindow {
	public static int width=330;
	public static int height=200;
	public static int tareas;
	public static final int timeTotal=100;
	public static int conteo;
	public static float valor;
	public static float rango;
	public static NSRInternalFrame frame;
	ProgressPaint panel; 
	private final JPanel contentPanel = new JPanel();
	public ProgressBarDialog(Window mainWindow,int tareas,int x ,int y,NSRInternalFrame frame) {
		this(mainWindow,x-(width/2),y-(height/2),frame);
		this.frame=frame;
		this.tareas=tareas-2;
		this.conteo=0;
		this.valor=0F;
		this.rango=this.timeTotal/((float)this.tareas);
	}
	public void execProgress(){
		if(((int)this.valor)<this.timeTotal){
			this.conteo++;
			this.valor+=this.rango;
			System.out.println("Valor : "+this.valor);
			panel.UpdateProgress((int)this.valor);
			panel.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception : "+e.getMessage());
				e.printStackTrace();
			}
			System.out.println("Tarea : "+this.conteo);
		}else{
			System.out.println(" Cerrar Tarea ");
			this.frame.setEnabled(true);
			this.setVisible(false);
			this.frame.toFront();
			this.dispose();
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			int tareas=4;
//			ProgressBarDialog dialog = new ProgressBarDialog(tareas);
//			dialog.setVisible(true);
//			dialog.execProgress();
//			dialog.execProgress();
//			dialog.execProgress();
//			dialog.execProgress();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProgressBarDialog(Window mainWindow,int x , int y,NSRInternalFrame frame) {
		super(mainWindow);
		setPreferredSize(new Dimension(width, height));
		setSize(new Dimension(width, height));
		setMinimumSize(new Dimension(width, height));
//		setBounds(50, 50, 430, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setPreferredSize(new Dimension(50, 50));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		{
			panel = new ProgressPaint();
			contentPanel.add(panel);
		}
		this.frame=frame;
		this.frame.setEnabled(false);
		toFront();
		setLocation(x, y);
	}

}
