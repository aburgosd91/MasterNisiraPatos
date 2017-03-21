package com.nisira.vista.formularios;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import com.nisira.core.NisiraORMException;
import com.nisira.dao.CONFIGACTIVIDADESDao;
import com.nisira.entidad.CONFIGACTIVIDADES;
import com.nisira.vista.controles.JTextLabelComboMovil;
import com.nisira.vista.controles.JTextLabelPanel;
import com.scrollabledesktop.BaseInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMWConfActividades extends BaseInternalFrame{
	public List<JTextLabelPanel> listField;
	public JPanel header;
	public JScrollPane confScrollPanell;
	public JPanel conflist;
	List<CONFIGACTIVIDADES> lca = new ArrayList<CONFIGACTIVIDADES>();
	public FrmMWConfActividades() {
		super();
		setSize(new Dimension(450, 450));
		setPreferredSize(new Dimension(300, 300));
		setOpaque(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Configuracion de Actividades");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{34, 377, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);		
		header = new JPanel();
		GridBagConstraints gbc_header = new GridBagConstraints();
		gbc_header.insets = new Insets(0, 0, 5, 0);
		gbc_header.fill = GridBagConstraints.BOTH;
		gbc_header.gridx = 0;
		gbc_header.gridy = 0;
		getContentPane().add(header, gbc_header);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cl = conflist.getComponentCount();
				for(int i = 0;i<cl;i++){
					JTextLabelComboMovil t =(JTextLabelComboMovil) conflist.getComponent(i);
					JPanel j = (JPanel)t.getComponent(0);
					JLabel lb = (JLabel) j.getComponent(0);
					JComboBox cb = (JComboBox) j.getComponent(1);
					for(CONFIGACTIVIDADES lc: lca){
						if(lb.getText().equalsIgnoreCase(lc.getDESCRIPCION())){
							lc.setTIPO(cb.getSelectedIndex());
							try {
								(new CONFIGACTIVIDADESDao()).mezclar(1, lc);
							} catch (NisiraORMException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
					}
				}
//				
			}
		});
		header.add(btnGuardar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		header.add(btnCerrar);		
		
		confScrollPanell = new JScrollPane();
		GridBagConstraints gbc_confScrollPanell = new GridBagConstraints();
		gbc_confScrollPanell.fill = GridBagConstraints.BOTH;
		gbc_confScrollPanell.gridx = 0;
		gbc_confScrollPanell.gridy = 1;
		getContentPane().add(confScrollPanell, gbc_confScrollPanell);
		
		conflist = new JPanel();
		confScrollPanell.setViewportView(conflist);
		conflist.setLayout(new GridLayout(0, 1, 0, 0));
		
		try {
			lca= (new CONFIGACTIVIDADESDao()).listar(1);
		} catch (NisiraORMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cargarRow(lca);
	}
	public void cargarRow(List<CONFIGACTIVIDADES> lca){		
		int pos = 0;
		for(CONFIGACTIVIDADES ca : lca){
			JTextLabelComboMovil j = new JTextLabelComboMovil(ca);
			conflist.add(j);
		}
	}
}
