package com.nisira.vista.formularios;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.FormatStyle;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JWindow;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import com.nisira.Inicio;
import com.nisira.vista.controles.FormatStyleText;
import com.scrollabledesktop.BaseInternalFrame;

import java.awt.BorderLayout;
import java.awt.Color;

public class FrmTooltipOverlay extends JWindow  {
	private int cx;
	private int cy;
	private int width;
	private int height;
	private String contenido;
	private JTextPane panel;
	public FrmTooltipOverlay(Window mainWindow,int cx,int cy,int width,int height,String contenido) {
		super(mainWindow);
		/********CONFIGURACIONES*******/
		this.cx=cx;
		this.cy=cy;
		this.width=width;
		this.height=height;
		this.contenido=contenido;
		/*************************************/
		setBounds(this.cx, this.cy, this.width, this.height);
		getContentPane().setSize(new Dimension(this.width, this.height));
		getContentPane().setPreferredSize(new Dimension(this.width, this.height));
//		((BasicInternalFrameUI)this.getUI()).setNorthPane(null); //retirar o painel superior
//		setBorder(null);
//		setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
	    
	    panel = new JTextPane(FormatStyleText.documento){
	    	public void paintComponent(Graphics g){
	    		Dimension tamanio=getSize();
	    		ImageIcon imagenFondo = new ImageIcon(new ImageIcon(FrmSysZona.class
						.getResource("/resources/Overlay1.png")).getImage()
						.getScaledInstance(tamanio.width, tamanio.height, java.awt.Image.SCALE_DEFAULT)
						);
	    		g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width-5,tamanio.height-5,null);
	    		setOpaque(false);
	    		super.paintComponent(g);
	    	}
	    };
	    panel.setEditable(false);
	    JButton btnClose = new JButton("X");
	    panel.setLayout(null);
	    btnClose.setBounds(this.width-75, 25, 45, 25);
	    btnClose.setOpaque(false);
	    btnClose.setContentAreaFilled(false);
	    btnClose.setBorderPainted(false);
	    btnClose.setBorder(null);
	    btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Closed();
			}
		});
	    panel.add(btnClose);
	    getContentPane().add(panel, BorderLayout.CENTER);
//	    setLocationRelativeTo(null);
	    /**/
	    InsetarText(contenido);
	 // Create the StyleContext, the document and the pane
	    this.pack();
	    
	}
	public void InsetarText(String info){
		try {
			this.panel.setText("");
			FormatStyleText.documento.insertString(0, info, FormatStyleText.p1_Format_BlackArialSize13());
			FormatStyleText.documento.setParagraphAttributes(3, 1, FormatStyleText.h1_Format_BlackArialSize16Bold(), false);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Closed(){
		this.setVisible(false);
	}
	public void showOverlay(){
		InsetarText(this.contenido);
		setBounds(this.cx-(this.width/2)+5, this.cy-this.height+10, this.width, this.height);
		show();
//		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		FrmTooltipOverlay windows= new FrmTooltipOverlay(Inicio.mainF,300,300,300,200,"");
		windows.show();
	}

	public int getCx() {
		return cx;
	}

	public void setCx(int cx) {
		this.cx = cx;
	}

	public int getCy() {
		return cy;
	}

	public void setCy(int cy) {
		this.cy = cy;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
}
