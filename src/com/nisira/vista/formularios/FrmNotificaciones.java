package com.nisira.vista.formularios;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.soap.Text;

import com.nisira.dao.DGENERACIONCODIGOSDao;
import com.nisira.dao.GENERACIONCODIGOSDao;
import com.nisira.dao.NOTIFICACIONDao;
import com.nisira.entidad.DGENERACIONCODIGOS;
import com.nisira.entidad.GENERACIONCODIGOS;
import com.nisira.entidad.NOTIFICACION;
import com.nisira.entidad.NotitficaSP;
import com.nisira.entidad.PACKINGLIST;
import com.nisira.vista.celleditor.TxtSysFormulario;
import com.nisira.vista.controles.MaestroTableModel;
import com.nisira.vista.controles.NSRTable;
import com.nisira.vista.controles.NSRTableModel;
import com.nisira.vista.formularios.maestros.AbstractMaestro;

import core.inicio.ConfigInicial;

import javax.swing.JTextArea;

public class FrmNotificaciones extends AbstractMaestro {

	private static final long serialVersionUID = 1L;
	/***************************** CABECERA ***********************/
	private NotitficaSP Noti = new NotitficaSP();
	private NOTIFICACIONDao notiDao = new NOTIFICACIONDao();
	private List<NotitficaSP> listNoti = new ArrayList<NotitficaSP>();
	/****************************** DETALLE ************************/

	// private GrupoUsuario grupoUsuario;
	//
	// private GrupoUsuarioDao grupoUsuarioDao = new GrupoUsuarioDao();
	// private GrupoUsuarioPrivilegioDao privilegioDao = new
	// GrupoUsuarioPrivilegioDao();
	// private SysFormularioDao formularioDao = new SysFormularioDao();
	// private List<GrupoUsuario> gruposUsuario = new ArrayList<GrupoUsuario>();
	// private List<GrupoUsuarioPrivilegio> privilegios = new
	// ArrayList<GrupoUsuarioPrivilegio>();

	private JTable tblLista;
	private TxtSysFormulario txtFormulario;
	private JTextField textEmpresa;
	private JTextField textFecha;
	private JTextField textMensaje;
	private JTextField textPrioridad;
	public FrmNotificaciones() {
		super("Notificaciones");
		setPreferredSize(new Dimension(555, 425));
		setSize(new Dimension(719, 379));

		getBarra().setFormMaestro(this);

		JScrollPane scrollPane = new JScrollPane();
		Field[] fi = NOTIFICACION.class.getDeclaredFields();
		tblLista = new JTable(new MaestroTableModel(fi));
		scrollPane.setViewportView(tblLista);
		tblLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblEmpresa = new JLabel("Cod. Empresa");
		
		JLabel lblMensaje = new JLabel("Mensaje");
		
		textEmpresa = new JTextField();
		textEmpresa.setEditable(false);
		textEmpresa.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		
		textFecha = new JTextField();
		textFecha.setEditable(false);
		textFecha.setColumns(10);
		
		textMensaje = new JTextField();
		textMensaje.setEditable(false);
		textMensaje.setColumns(10);
		
		JButton btnLeido = new JButton("Leido");
		btnLeido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int seleccion = JOptionPane.showOptionDialog(null, "Al Precionar Aceptar. Usted confirma haber ledido y estar al tanto de su tare asignada",
						"Advertencia", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null,
						new Object[] { "Si", "No" }, "Si");
				if(seleccion==0)
					try {
						notiDao.actualizarEstado(1,getNoti().getIDEMPRESA(),getNoti().getIDPROGRAMAALM(),Integer.valueOf(ConfigInicial.LlenarConfig()[15]),getNoti().getIDNOTIFICACION());
					} catch (NumberFormatException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		
		JLabel lblPrioridad = new JLabel("Prioridad");
		
		textPrioridad = new JTextField();
		textPrioridad.setEditable(false);
		textPrioridad.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(pnlContenido);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmpresa)
						.addComponent(lblMensaje))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textEmpresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(lblFecha)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFecha, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
						.addComponent(textMensaje))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
							.addComponent(btnLeido)
							.addGap(54))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblPrioridad)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textPrioridad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(108))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmpresa)
								.addComponent(textEmpresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFecha)
								.addComponent(textFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrioridad)
								.addComponent(textPrioridad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMensaje)
								.addComponent(textMensaje, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLeido)
							.addGap(25))))
		);
		pnlContenido.setLayout(groupLayout);

		tblLista.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = tblLista.getSelectedRow();
				if (selectedRow >= 0)
					setNoti(getListNoti().get(selectedRow));
				// setGrupoUsuario(getGruposUsuario().get(selectedRow));
				else
					setNoti(null);
				// setGrupoUsuario(null);
				llenar_datos();
			}
		});
		MaestroTableModel model = (MaestroTableModel) tblLista.getModel();
		iniciar();
		// getDetalleTM().setEditar(true);


	}
	
	@Override
	public void nuevo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anular() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void grabar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void llenar_datos() {
		textEmpresa.setText(String.valueOf(getNoti().getIDEMPRESA()));
		textFecha.setText(getNoti().getFECHACREACION() != null
				? Noti.getFECHACREACION().toGMTString() : "");
		textMensaje.setText(getNoti().getMENSAJE());
		textPrioridad.setText(String.valueOf(getNoti().getPRIORIDAD()));
	}

	@Override
	public void llenar_lista() {
		tblLista.setFillsViewportHeight(true);
		MaestroTableModel model = (MaestroTableModel) tblLista.getModel();
		model.limpiar();
		for (NotitficaSP pl : getListNoti()) {
			model.addRow(new Object[] { pl.getIDEMPRESA(),pl.getIDNOTIFICACION(),pl.getMENSAJE(), pl.getFECHACREACION(),pl.getPRIORIDAD(),pl.getFECHAENVIO(),pl.getESTADO() == 1 ? "Activo" : "Inactivo"});
		}
		if (getListNoti().size() > 0) {
			System.out.println(getListNoti().get(0));
			setNoti(getListNoti().get(0));
			tblLista.setRowSelectionInterval(0, 0);
		}
		
	}

	@Override
	public void llenar_tablas() {
//		notiDao.listar(1, "", "");
		setListNoti(notiDao.verNotif(1, ConfigInicial.LlenarConfig()[8],
				ConfigInicial.LlenarConfig()[15]));
		
	}

	@Override
	public void vista_edicion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vista_noedicion() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void llenarDesdeVista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limpiarVista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValidaVista() {
		// TODO Auto-generated method stub
		return false;
	}

	public NotitficaSP getNoti() {
		return Noti;
	}

	public void setNoti(NotitficaSP noti) {
		Noti = noti;
	}

	public List<NotitficaSP> getListNoti() {
		return listNoti;
	}

	public void setListNoti(List<NotitficaSP> listNoti) {
		this.listNoti = listNoti;
	}

	@Override
	public void llenarPorId(Object id) {
		// TODO Auto-generated method stub
		
	}
}
