package com.nisira.vista.formularios;

import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import com.nisira.utils.nisiracore.Constantes;
import com.nisira.vista.controles.NSRInternalFrame;
import com.nisira.vista.formularios.FrmSysZona.BarcodeTexto;

import gnu.io.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.io.*;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmBalanza extends NSRInternalFrame implements InternalFrameListener{

	private static final long serialVersionUID = 1L;
	static CommPortIdentifier portId;
    static CommPortIdentifier saveportId;
    static Enumeration portList;
    static InputStream inputStream;
    static OutputStream outputStream;
    static BufferedInputStream bufferedInputStream;
    static SerialPort serialPort;
    
    private static final int _ancho = 40;
    private static final int _alto = 40;
    private int posicion;
    private JScrollPane scrollPanePeso;
    private JPanel panelPeso;
    public static void main(String[] args) {
		new FrmBalanza();
	}
    public FrmBalanza() {
    	setTitle("Balanza");
	    int count=0;
	    boolean rotating = false;
        setMaximizable(true);
		setIconifiable(false);
		setClosable(true);
		setVisible(true);
		setResizable(true);
		this.show();
		this.addInternalFrameListener(this);
		
		JLabel lblPeso = new JLabel("PESO");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 46));
		
		scrollPanePeso = new JScrollPane();
		scrollPanePeso.setBorder(UIManager.getBorder("ScrollPane.border"));
		panelPeso = new JPanel();
		panelPeso.setBorder(null);
        scrollPanePeso.setViewportView(panelPeso);
        panelPeso.setLayout(new BoxLayout(panelPeso, BoxLayout.Y_AXIS));
		JButton btnSalir = new JButton("Salir");
		
		JButton btnEmpezar = new JButton("Empezar");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					panelPeso.removeAll();
					panelPeso.repaint();
					double p = capturar();
					BarcodeTexto cajaTexto=new BarcodeTexto(p);
					
					panelPeso.add(cajaTexto);
					panelPeso.revalidate();
					panelPeso.repaint();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(298)
					.addComponent(lblPeso, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(122)
					.addComponent(scrollPanePeso, GroupLayout.PREFERRED_SIZE, 489, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(btnEmpezar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(441)
					.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(lblPeso, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(scrollPanePeso, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEmpezar)
						.addComponent(btnSalir)))
		);
		getContentPane().setLayout(groupLayout);
		pack();
	}

	/**
	 * 
	 */

	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public double capturar() throws Exception {
        boolean gotPort = false;
        String port;
        portList = null;//CommPortIdentifier.getPortIdentifiers();
        String PesoCapturado = "0.00";
        int verdadero = 0;
        System.out.println("CAPTURAR 01");
        //while (!portList.hasMoreElements()) {
            System.out.println("CAPTURAR 02");
            portId = null;//(CommPortIdentifier) portList. .nextElement(); //get next port to check
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                System.out.println("CAPTURAR 03");
                if (portId.getName().equals("COM4")) {
                    System.out.println("CAPTURAR 04");
                    port = portId.getName();
                    gotPort = true;
                }
                if (gotPort == true) {
                    System.out.println("CAPTURAR 05");
                    try {
                        serialPort = (SerialPort) portId.open("..02", 2000);
                    } catch (PortInUseException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("CAPTURAR 05");
                    try {
                        outputStream = serialPort.getOutputStream();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        serialPort.setSerialPortParams(9600,
                                SerialPort.DATABITS_8,
                                SerialPort.STOPBITS_1,
                                SerialPort.PARITY_NONE);
                    } catch (UnsupportedCommOperationException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        inputStream = serialPort.getInputStream();
                        bufferedInputStream = new BufferedInputStream(inputStream);
//                        String s="";
//                        while (bufferedInputStream.available() > 0) {
//                            int dato = bufferedInputStream.read();
//                            s=s+(char)dato;
//                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    serialPort.notifyOnDataAvailable(true);
                    Character c = new Character('$');
                    outputStream.write(c);
                    byte[] readBuffer = new byte[1];
                    boolean read = false;
                    while (!read) {
                        try {
                            PesoCapturado = "";
                            String feedback = "";
                            Thread.sleep(100);
                            int a = 0;
                            verdadero = 0;
                            while (bufferedInputStream.available() > 0) {
                                int numBytes = bufferedInputStream.read(readBuffer);
                                a = a + 1;
                                //if (a==1 && new String(readBuffer).equals("W")){
                                //    verdadero=1;
                                //}
                                //if (a>5 && a<11 && verdadero==1){
                                PesoCapturado += new String(readBuffer);
                                //}
                                read = true;
                            }
                            feedback += PesoCapturado;
                            int length = PesoCapturado.length();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    serialPort.close();
                }
            }
        //}
        System.out.println("PESO CAPTURADO***************************************");
        System.out.println(PesoCapturado);
        double p = 0.0;
        int peso = StringToEnteros(PesoCapturado);
        p=(double)peso/1000;
        //double peso = Double.parseDouble(PesoCapturado.replace(',', '.'));
        System.out.println("PESO CAPTURADO222222222222222222***************************************");
        System.out.println(peso);
        return p;

        //DetalleIngresosalidaalm_PesoRegistrar.setPESO(Double.parseDouble(PesoCapturado));
        //agregarPeso_listaDetalles();
        //  DetalleIngresosalidaalmSeleccionado.setPESO(Double.parseDouble(PesoCapturado)); 
        //  per.setPESO(Double.parseDouble(PesoCapturado));

    }
	public int StringToEnteros(String cadena) {
        int peso = 0;
        int coma = 0;
        try {
            String cadenanum = "";
            boolean ok = false;
            for (int i = 0; i < 51; i++) {
                if(cadena.equals(",")){
                    if(coma==0) {
                         coma = 1;
                         i=i+5;
                    }else{    
                       coma=2;
                    }
                }else{
                    if(coma==1) {
                        if (Character.isDigit(cadena.charAt(i))) {
                            cadenanum = cadenanum + cadena.charAt(i);
                            ok = true;
                       }else{
                            if (ok){
                                i=51;
                                break;
                            }else{
                                cadenanum = "";
                                coma=0;
                                i=i-1;
                            } 
                        }
                    }
                }
            }
            if (ok) {
                peso = Integer.parseInt(cadenanum);
            }
        } catch (Exception e) {
        }

        return peso;
    }	
    public void PesoCero() throws Exception {
        int pesaje = 0;
        while (pesaje != 0) {
//            pesaje = capturar();
        }
    }
    class BarcodeTexto extends JLabel{
    	private static final long serialVersionUID = 1L;
    	public BarcodeTexto(Double peso){
    		this.setText("<html><p style=\"line-height: 150%;font-size:20;\">"+peso.toString()+"</p></html>");
    		this.setVisible(true);
    		this.setSize(60, 200);
    		this.setFont(new Font(null, Font.PLAIN, 12));
    	}
	}

	
}
