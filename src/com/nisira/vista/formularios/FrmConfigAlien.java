package com.nisira.vista.formularios;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.text.MaskFormatter;

import org.apache.commons.collections.functors.ConstantTransformer;
import org.bouncycastle.util.test.NumberParsing;

import com.alien.enterpriseRFID.reader.AlienReaderException;
import com.alien.enterpriseRFID.tags.Tag;
import com.nisira.Inicio;
import com.nisira.alien.ComandosRfid;
import com.nisira.alien.ReaderAlien;
import com.nisira.alien.WriterAlien;
import com.nisira.dao.DGENERACIONCODIGOSDao;
import com.nisira.dao.DPROGRAMAALMEJECUCIONDao;
import com.nisira.dao.DZONAALMACENDao;
import com.nisira.dao.DZONADIAGRAMADao;
import com.nisira.dao.DZONADIAGRAMAUBICACIONDao;
import com.nisira.dao.DZONAGENERALDao;
import com.nisira.dao.GENERACIONCODIGOSDao;
import com.nisira.dao.ZONAGENERALDao;
import com.nisira.entidad.CfgTabla;
import com.nisira.entidad.CoordenadaMatriz;
import com.nisira.entidad.DGENERACIONCODIGOS;
import com.nisira.entidad.DPROGRAMAALMEJECUCION;
import com.nisira.entidad.DZONAALMACEN;
import com.nisira.entidad.DZONADIAGRAMA;
import com.nisira.entidad.DZONADIAGRAMAUBICACION;
import com.nisira.entidad.DZONAGENERAL;
import com.nisira.entidad.GENERACIONCODIGOS;
import com.nisira.entidad.ZONAGENERAL;
import com.nisira.utils.nisiracore.Constantes;
import com.nisira.vista.barras.PanelBarraMaestro;
import com.nisira.vista.controles.NSRInternalFrame;

import core.inicio.ThreadGeneral;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import java.awt.Label;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class FrmConfigAlien extends NSRInternalFrame {
	/*******************************************************/
	
	/***********************************************************************/
	private static final long serialVersionUID = 7755124973019289267L;
    private JPanel panelZona;
    private static final int _ancho = 40;
    private static final int _alto = 40;
    private int posicion;
    private JScrollPane scrollPanelCabecera;
    private JPanel panelCabecera;
    private JLabel lblTag;
    private JList listTags;
    private JTabbedPane tabbedPane;
    private JLabel lblConexion;
    public final int timer=1000;
    public ThreadGroup threadGroup;
    public JButton btnRfid;
    public JButton btnStop;
    private JLabel lblNumTag;
    private JLabel lbltag;
    private JFormattedTextField formatTagId ;
    private JSpinner spinnerAntena;
    private JTextArea textConsole;
	public FrmConfigAlien() {

		setTitle("Alien RFID Gateway v2.26");
	    int count=0;
	    boolean rotating = false;
        setMaximizable(true);
		setIconifiable(false);
		setClosable(true);
		setVisible(true);
		setResizable(true);
		this.show();
		panelZona =new JPanel();
        
        scrollPanelCabecera = new JScrollPane();
        scrollPanelCabecera.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanelCabecera.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPanelCabecera.setBorder(UIManager.getBorder("ScrollPane.border"));
        panelCabecera = new JPanel();
        panelCabecera.setBackground(Color.WHITE);
        panelCabecera.setToolTipText("Controles Rfid");
        panelCabecera.setBorder(null);
        scrollPanelCabecera.setViewportView(panelCabecera);
        
        btnRfid = new JButton("");
        btnRfid.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		treadAccionLecturaRfid();
        	}
        });
        btnRfid.setIcon(new ImageIcon(FrmSysZona.class.getResource("/resources/rfid_tag.png")));
        btnRfid.setToolTipText("On Reader");
        btnRfid.setBorder(UIManager.getBorder("Button.border"));
        btnRfid.setAlignmentY(0.0f);
        btnRfid.setAlignmentX(1.0f);
        
        btnStop = new JButton("");
        btnStop.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		threadGroup = Thread.currentThread ().getThreadGroup ();
        		Thread [] listaHilo= new Thread[threadGroup.activeCount()];
        		threadGroup.enumerate(listaHilo, true);
        		for(int i=0;i<listaHilo.length;i++){
        			Constantes.log.info(listaHilo[i].getName());
        			if(listaHilo[i].getName().contains("Thread_FrmConfigAlien")){
        				ComandosRfid.closeConsole();
        				listaHilo[i].stop();
        				break;
        			}
        		}
        	}
        });
        btnStop.setIcon(new ImageIcon(FrmSysZona.class.getResource("/resources/stop.png")));
        btnStop.setToolTipText("Off Reader");
        btnStop.setBorder(UIManager.getBorder("Button.border"));
        btnStop.setAlignmentY(0.0f);
        btnStop.setAlignmentX(1.0f);
        
        JLabel lblNewLabel = new JLabel("Estado:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        lblConexion = new JLabel("Desconectado...");
        lblConexion.setForeground(Color.RED);
        lblConexion.setBackground(Color.WHITE);
        lblConexion.setFont(new Font("Tahoma", Font.BOLD, 14));
        GroupLayout gl_panelCabecera = new GroupLayout(panelCabecera);
        gl_panelCabecera.setHorizontalGroup(
        	gl_panelCabecera.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panelCabecera.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblConexion, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 379, Short.MAX_VALUE)
        			.addComponent(btnRfid, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnStop, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        gl_panelCabecera.setVerticalGroup(
        	gl_panelCabecera.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_panelCabecera.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panelCabecera.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panelCabecera.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblNewLabel)
        					.addComponent(lblConexion, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        				.addComponent(btnRfid, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnStop, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(25, Short.MAX_VALUE))
        );
        panelCabecera.setLayout(gl_panelCabecera);
        
        DragScrollListener dl = new DragScrollListener(panelZona);
        GroupLayout gl_panelZona = new GroupLayout(panelZona);
        gl_panelZona.setHorizontalGroup(
        	gl_panelZona.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 838, Short.MAX_VALUE)
        );
        gl_panelZona.setVerticalGroup(
        	gl_panelZona.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 513, Short.MAX_VALUE)
        );
        panelZona.setLayout(gl_panelZona);
		panelZona.addMouseListener(dl);
		panelZona.addMouseMotionListener(dl);
        
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        				.addComponent(tabbedPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        				.addComponent(scrollPanelCabecera, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE))
        			.addGap(13))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(scrollPanelCabecera, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(27, Short.MAX_VALUE))
        );
        
        textConsole = new JTextArea();
        textConsole.setEditable(false);
        scrollPane_1.setViewportView(textConsole);
        
        JPanel SingleTagPanel = new JPanel();
        SingleTagPanel.setBackground(Color.BLACK);
        SingleTagPanel.setToolTipText("Single Tag");
        tabbedPane.addTab("SingleTang", null, SingleTagPanel, null);
        
        lblTag = new JLabel("0000 0000 0000 0000 0000 0000");
        lblTag.setForeground(new Color(0, 255, 0));
        lblTag.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JLabel lblNewLabel_1 = new JLabel("EPC");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setForeground(new Color(0, 255, 0));
        
        JLabel label = new JLabel("EPC");
        label.setForeground(Color.GREEN);
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        lblNumTag = new JLabel("0");
        lblNumTag.setForeground(Color.GREEN);
        lblNumTag.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        lbltag = new JLabel("#Tag");
        lbltag.setForeground(Color.GREEN);
        lbltag.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JButton btnProgramEpc = new JButton("Program EPC");
        btnProgramEpc.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		/*GUARDAR RFID*/
        		guardarCodigo();
        	}
        });
        btnProgramEpc.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnProgramEpc.setToolTipText("On Reader");
        btnProgramEpc.setBorder(UIManager.getBorder("Button.border"));
        btnProgramEpc.setAlignmentY(0.0f);
        btnProgramEpc.setAlignmentX(1.0f);
        
        formatTagId = new JFormattedTextField();
        formatTagId.setFont(new Font("Tahoma", Font.BOLD, 12));
        formatTagId.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char charecter = e.getKeyChar();
        		if (Character.isLowerCase(charecter)) {
        			e.setKeyChar(Character.toUpperCase(charecter));
        		}
        	}
        });
        MaskFormatter mf1=null;
		try {
			mf1 = new MaskFormatter("HHHH-HHHH-HHHH-HHHH-HHHH-HHHH");
			mf1.install(formatTagId);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        spinnerAntena = new JSpinner();
        spinnerAntena.setModel(new SpinnerNumberModel(0, 0, 3, 1));
        
        JLabel lblAntena = new JLabel("ANTENA");
        lblAntena.setForeground(Color.GREEN);
        lblAntena.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GroupLayout gl_SingleTagPanel = new GroupLayout(SingleTagPanel);
        gl_SingleTagPanel.setHorizontalGroup(
        	gl_SingleTagPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_SingleTagPanel.createSequentialGroup()
        			.addGroup(gl_SingleTagPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_SingleTagPanel.createSequentialGroup()
        					.addGap(303)
        					.addComponent(lblNewLabel_1))
        				.addGroup(gl_SingleTagPanel.createSequentialGroup()
        					.addGap(195)
        					.addGroup(gl_SingleTagPanel.createParallelGroup(Alignment.TRAILING)
        						.addGroup(gl_SingleTagPanel.createSequentialGroup()
        							.addComponent(lbltag, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(lblNumTag, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addComponent(lblTag, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        				.addGroup(gl_SingleTagPanel.createSequentialGroup()
        					.addGap(29)
        					.addGroup(gl_SingleTagPanel.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_SingleTagPanel.createSequentialGroup()
        							.addComponent(lblAntena)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(spinnerAntena, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_SingleTagPanel.createSequentialGroup()
        							.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(formatTagId, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))))
        			.addGap(235))
        		.addGroup(gl_SingleTagPanel.createSequentialGroup()
        			.addGap(132)
        			.addComponent(btnProgramEpc, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(454, Short.MAX_VALUE))
        );
        gl_SingleTagPanel.setVerticalGroup(
        	gl_SingleTagPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_SingleTagPanel.createSequentialGroup()
        			.addGap(21)
        			.addComponent(lblNewLabel_1)
        			.addGap(18)
        			.addComponent(lblTag, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        			.addGroup(gl_SingleTagPanel.createParallelGroup(Alignment.TRAILING)
        				.addGroup(Alignment.LEADING, gl_SingleTagPanel.createSequentialGroup()
        					.addGap(45)
        					.addGroup(gl_SingleTagPanel.createParallelGroup(Alignment.BASELINE)
        						.addComponent(label, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        						.addComponent(formatTagId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addComponent(btnProgramEpc, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        					.addGap(30)
        					.addGroup(gl_SingleTagPanel.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblAntena, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        						.addComponent(spinnerAntena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addContainerGap())
        				.addGroup(gl_SingleTagPanel.createSequentialGroup()
        					.addGap(11)
        					.addGroup(gl_SingleTagPanel.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lbltag, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNumTag, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
        					.addGap(171))))
        );
        SingleTagPanel.setLayout(gl_SingleTagPanel);
        
        JScrollPane scrollPane = new JScrollPane();
        tabbedPane.addTab("ManyTagsPanel", null, scrollPane, null);
        
        listTags = new JList();
        listTags.setForeground(Color.GREEN);
        listTags.setFont(new Font("Tahoma", Font.PLAIN, 18));
        listTags.setBackground(Color.BLACK);
        scrollPane.setViewportView(listTags);
        getContentPane().setLayout(layout);
        pack();
        verificarConexion();
	}
	
	/**********************THREAD**********************/
	public void guardarCodigo(){
		try {
			if(!formatTagId.getText().trim().equals("")){
				String codigo=formatTagId.getText().trim();
				WriterAlien.escrituraRfidMejora1(codigo,spinnerAntena.getValue().toString());
			}
		} catch (AlienReaderException e) {
			// TODO Auto-generated catch block
			WriterAlien.addConsole(e.getMessage());
//			textConsole.setText(ReaderAlien.getMensajeConsole());
			textConsole.append(ReaderAlien.getMensajeConsole());
			e.printStackTrace();
		}
	}
	public void treadAccionLecturaRfid(){
		LecturaTagThread ej = new LecturaTagThread();
		Thread hilo = new Thread(ej,ThreadGeneral.hilo_FrmConfigAlien_LecturaRfid);
		hilo.start();
		Constantes.log.info(hilo.getName());
	}
	public void treadAccionVerificarConexion(){
		ValidadConexionThread ej = new ValidadConexionThread();
		Thread hilo = new Thread(ej,ThreadGeneral.hilo_FrmConfigAlien_ValidadConexion);
		hilo.start();
		Constantes.log.info(hilo.getName());	
	}
	public void seleccionLecturaRfid(){
		switch (tabbedPane.getSelectedIndex()) {
			case 0:
				accionSingleRfid();
				break;
			case 1:
				accionManyRfid();
				break;
			default:
				break;
		}
	}
	public void accionSingleRfid(){
		List<Tag> listTag;
		try {
			listTag = ReaderAlien.lecturaRfid();
			if(listTag!=null){
				if(listTag.size()>0){
					lblTag.setText(listTag.get(0).getTagID());
					lblNumTag.setText(""+listTag.size());
				}
			}
			textConsole.setText(ReaderAlien.getMensajeConsole());
		} catch (AlienReaderException e) {
			// TODO Auto-generated catch block
			ReaderAlien.addConsole(e.getMessage());
//			textConsole.setText(ReaderAlien.getMensajeConsole());
			textConsole.append(ReaderAlien.getMensajeConsole());
//			ComandosRfid.closeConsole();
			e.printStackTrace();
		}
		
	}
	public void accionManyRfid(){
		List<Tag> listTagLocal;
		try {
			listTagLocal = ReaderAlien.lecturaRfid();
			if(listTagLocal!=null){
				if(listTagLocal.size()>0){
					DefaultListModel modelo = new DefaultListModel();
					for(Tag tag : listTagLocal)
						modelo.addElement(tag.getTagID());
					listTags.setModel(modelo);
				}
			}
//			textConsole.setText(ReaderAlien.getMensajeConsole());
			textConsole.append(ReaderAlien.getMensajeConsole());
			
		} catch (AlienReaderException e) {
			// TODO Auto-generated catch block
			ReaderAlien.addConsole(e.getMessage());
//			textConsole.setText(ReaderAlien.getMensajeConsole());
			textConsole.append(ReaderAlien.getMensajeConsole());
//			ComandosRfid.closeConsole();
			e.printStackTrace();
		}
		
	}
	public void verificarConexion(){
		if(ComandosRfid.isConexionAlien()){
			lblConexion.setText("Conectado...");
			lblConexion.setForeground(Color.GREEN);
	        lblConexion.setBackground(Color.WHITE);
	        btnRfid.setEnabled(true);
	        btnStop.setEnabled(true);
		}else{
			lblConexion.setText("Desconectado...");
			lblConexion.setForeground(Color.RED);
	        lblConexion.setBackground(Color.WHITE);
	        btnRfid.setEnabled(false);
	        btnStop.setEnabled(false);
	        clear();
		}
	}
	public void clear(){
		lblTag.setText("");
		textConsole.setText("");
		listTags.clearSelection();
	}
	class LecturaTagThread implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				seleccionLecturaRfid();
			}
		}
    	
    }
	class ValidadConexionThread implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				verificarConexion();
				try {
					Thread.sleep(timer);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    	
    }
}


