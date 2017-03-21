package com.nisira.vista.formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JWindow;
import javax.swing.border.LineBorder;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import com.nisira.utils.nisiracore.Constantes;
public class FrmTooltip extends JWindow{
	private final JPanel contentPanel = new JPanel();
	// create jeditorpane
    JEditorPane jEditorPane; //= new JEditorPane();
	int numPisos;
	long timer;
	Thread hilo;
	int pisoAlerta;
	int tiempoCierre;
	final String hiloPiso = "threadAlertaPiso";
	ThreadGroup threadGroup;
	Color origen;
	Color alert;
	private final JButton btnNewButton = new JButton("New button");
    public static void main(String[] args) {
        try {
        	Point punto=MouseInfo.getPointerInfo().getLocation();
        	int numPisos=6;
        	long timer=500;
        	int pisoAlerta=5;
        	int tiempoCierre=15;
        	//FrmTooltip dialog = new FrmTooltip(,punto.x,punto.y,Color.CYAN,Color.WHITE,timer,tiempoCierre,numPisos,pisoAlerta);
            //cdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FrmTooltip(Window mainWindow,int x,int y,Color original,Color alerta,long timerR,int timerC,int numPisos,int numPisoAlerta) {
    	/***********************ACTUALIZAR PARAMETROS**************************/
    	super(mainWindow);
    	this.timer=timerR;
    	this.tiempoCierre=timerC;
    	this.origen=original;
    	this.alert=alerta;
    	this.numPisos=numPisos;
    	this.pisoAlerta=numPisoAlerta;
    	/**********************************************************************/
    	
//    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	setUndecorated(true);
    	
        // evita cambio de tamaño
//        setResizable(false);
        // título del diáolog
//        setTitle("UBICACIÓN");
        // dimensiones que ocupa en la pantalla
        setBounds(x, y, 300, 300);
        // capa que contendrá todo
	//        getContentPane().setLayout(new BorderLayout());
        // borde de la ventan
//        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        // pone el panel centrado
        jEditorPane = new JEditorPane();
        jEditorPane.setEditable(false);
        HTMLEditorKit kit = new HTMLEditorKit();
        jEditorPane.setEditorKit(kit);
        jEditorPane.setSize(300, 100);
     // add some styles to the html
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
        styleSheet.addRule("h1 {color: blue;text-align: center;margin: 0px;}");
        styleSheet.addRule("h2 {color: #ff0000;}");
        styleSheet.addRule("p {font : 10px monaco; color : black; background-color : #fafafa;margin: 0px; }");
        
        // create some simple html as a string
        String htmlString = "<html>\n"
                          + "<body>\n"
                          + "<h1>Pisos</h1>\n"
                          + "<p>Contenido</p>\n"
                          + "</body>\n";
     // create a document, set it on the jeditorpane, then add the html
        Document doc = kit.createDefaultDocument();
        jEditorPane.setDocument(doc);
        jEditorPane.setText(htmlString);
        
        getContentPane().add(jEditorPane, BorderLayout.CENTER);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        // sin capas para poder posicionar los elementos por coordenadas 
        
        contentPanel.setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setAutoscrolls(true);
//        scrollPane.setBounds(10, 11, 424, 146);
        contentPanel.add(scrollPane);
        btnNewButton.setBounds(201, 132, 89, 23);
        
        contentPanel.add(btnNewButton);
        JButton boto=null;
//    	boto.setBackground(co);
        int tamanio=50;
    	for(int i=2;i<numPisos+2;i++){
    		boto =new JButton("PISO "+((numPisos+2)-i));
    		boto.setBackground(original);
    		boto.setBounds(0,i*tamanio,300, tamanio);
        	boto.setContentAreaFilled(false);
        	boto.setOpaque(true);
        	boto.setBorder(new LineBorder(new Color(0, 0, 0)));
        	boto.setVisible(true);
        	boto.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
//					if(((JButton)e.getSource()).getBackground()==Color.blue){
//						((JButton)e.getSource()).setBackground(Color.WHITE);
//					}
//					else
//						((JButton)e.getSource()).setBackground(Color.blue);
				}
			});
        	boto.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					// TODO Auto-generated method stub
//					if(((JButton)e.getSource()).getBackground()==original){
//						((JButton)e.getSource()).setBackground(alerta);
//					}
//					else
//						((JButton)e.getSource()).setBackground(original);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					// TODO Auto-generated method stub
//					if(((JButton)e.getSource()).getBackground()==original){
//						((JButton)e.getSource()).setBackground(alerta);
//					}
//					else
//						((JButton)e.getSource()).setBackground(original);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});
        	contentPanel.add(boto);
    	}
    	contentPanel.revalidate();
    	contentPanel.repaint();
    	AlertPiso();
    }
    public void FinalizarAlert(){
//    	Fade.JFrameFadeOut(1f, 0f, 0.1f, 50, this,Fade.EXIT);
    	this.hide();
    	this.dispose();
    	cerrarHilo();
    }
    public void cerrarHilo(){
    	threadGroup = Thread.currentThread ().getThreadGroup ();
		Thread [] listaHilo= new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(listaHilo, true);
		for(int i=0;i<listaHilo.length;i++){
			Constantes.log.info(listaHilo[i].getName());
			if(listaHilo[i].getName().equals(hiloPiso)){
				listaHilo[i].stop();
				break;
			}
		}
    }
    public void AlertPiso() {
    	AlertPiso ej = new AlertPiso();
		hilo = new Thread(ej,hiloPiso);
		hilo.start();
		Constantes.log.info(hilo.getName());
//		new Thread(ej).start();
	}
    public void alertaPiso(){
    	for(int i=1;i<contentPanel.getComponentCount();i++){
    		JButton obj =(JButton)contentPanel.getComponent(i);
    		if((contentPanel.getComponentCount()-i)==pisoAlerta){
    			if(obj.getBackground()==origen){
					((JButton)obj).setBackground(alert);
				}
				else
					obj.setBackground(origen);
    		}
    	}
    }
    class AlertPiso implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			int i=0;
			while(i<tiempoCierre){
				alertaPiso();
				try {
					i++;
					Thread.sleep(timer);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			FinalizarAlert();
		}
    	
    }
}
