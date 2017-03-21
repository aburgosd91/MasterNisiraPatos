package com.nisira.vista.formularios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public abstract class AbstractDialog extends JDialog{
	public final JPanel contentPanel = new JPanel();
	public static JButton btnSiguiente;
	public static JButton btnCerrar;
	private static final long serialVersionUID = 1L;
    public AbstractDialog(String title,String botonIngresa,String botonCancela){
        // evita cambio de tamaño
        setResizable(false);
        // título del diáolog
        setTitle(title);
        // dimensiones que ocupa en la pantalla
        setBounds(100, 100, 450, 229);
        // capa que contendrá todo
        getContentPane().setLayout(new BorderLayout());
        // borde de la ventan
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        // pone el panel centrado
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        // sin capas para poder posicionar los elementos por coordenadas 
        contentPanel.setLayout(null);
        {
            // aquí se pone el JTextArea dentro de un JScrollPane 
            // para que tenga barras de desplazamiento
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(10, 11, 424, 146);
            contentPanel.add(scrollPane);
        }
        {
            // a continuación tenemos los botones clásicos 'Vale' y 'Cancela'
            // éste código lo ha generado Eclipse...
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
            	btnSiguiente = new JButton(botonIngresa);
            	btnSiguiente.addActionListener(new ActionListener() {
            		@Override
            		public void actionPerformed(ActionEvent e) {
                        // aquí van las acciones al hacer click en Vale
                        // envía el diálogo al recolector de basura de Java
                        dispose();
                    }
                });
            	btnSiguiente.setActionCommand(botonIngresa);
                buttonPane.add(btnSiguiente);
                getRootPane().setDefaultButton(btnSiguiente);
            }
            {
                JButton cancelButton = new JButton("Cancelar");
                cancelButton.addActionListener(new ActionListener() {
                	@Override
                	public void actionPerformed(ActionEvent arg0) {
                        // aquí van las acciones al hacer click en Vale
                        // envía el diálogo al recolector de basura de Java
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancelar");
                buttonPane.add(cancelButton);
            }
        }
    }

}
