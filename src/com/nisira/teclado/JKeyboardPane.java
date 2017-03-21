package com.nisira.teclado;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import com.nisira.vista.barras.PanelBarraMaestro;

public class JKeyboardPane extends JPanel{
	JTextField txt;
	String teclas[]={
			"1","2","A","B","C",
			"3","4","D","E","F",
			"5","6","G","H","I",
			"7","8","J","K","L",
			"9","0","M","N","O",
			"[CE]","[C]","P","Q","R",
			"ESP",".","S","T","U",
			"ESC","","V","W","X",
			"","","Y","Z"
	};
		
	ArrayList<JButton> botones=new ArrayList<JButton>();
	JPanel pletras,pespacio;
	JPopupMenu contenedor;
	private static final int _ancho = 40;
    private static final int _alto = 40;
	
	public JKeyboardPane(JTextField t,JPopupMenu x){
		
		txt=t;
		contenedor = x;
		pletras=new JPanel();
		setLayout(new BorderLayout());
		pletras.setLayout(new GridLayout(9,5,0,0));
		ActionListener accion=new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String start;
				String end;
				int focus;
				JButton b=(JButton)e.getSource();
				focus = txt.getSelectionStart();
				if(!b.getText().equalsIgnoreCase(" ")){
					start=txt.getText().substring(0, txt.getSelectionStart());
					end=txt.getText().substring(txt.getSelectionStart(), txt.getText().length());
					if(b.getText().equalsIgnoreCase("[CE]")){
						if(txt.getText().length()>0 & start.length()>0){
//							txt.setText(txt.getText().substring(0, txt.getText().length()-1));
							txt.setText(start.substring(0,start.length()-1)+end);
							focus-=2;
						}else
							focus-=1;
					}else if(b.getText().equalsIgnoreCase("[C]")){
						txt.setText("");
					}else if(b.getText().equalsIgnoreCase("ESC")){
						contenedor.setVisible(false);
					}else if(b.getText().equalsIgnoreCase("ESP")){
//						txt.setText(txt.getText()+" ");
						txt.setText(start+" "+end);
					}
					else{
//						System.out.println(txt.getSelectionStart());
						txt.setText(start+b.getText()+end);
					}
				}
				txt.select(focus+1, focus+1);
//				else if(b.getText().equalsIgnoreCase("")){
//					txt.setText(txt.getText()+" ");
//				}
			}
		};
		for(int i=0;i<teclas.length;i++){
			if(teclas[i].equalsIgnoreCase("")){
				JLabel l=new JLabel();
				pletras.add(l);
			}else{
				JButton b=new JButton(teclas[i]);
				b.addActionListener(accion);
				pletras.add(b);
				botones.add(b);
			}
		}
		pespacio=new JPanel(new GridLayout(1,3));
		pespacio.add(new JLabel());
		pespacio.add(new JLabel());
		add(pletras);
		add(pespacio,BorderLayout.SOUTH);
		
	}

}
