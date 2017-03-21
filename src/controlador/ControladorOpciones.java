package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;

import com.nisira.Inicio;
import com.nisira.utils.nisiracore.Constantes;
import com.nisira.vista.formularios.documentos.AbstractDocList;
import com.nisira.vista.formularios.maestros.AbstractMaestroList;
import com.scrollabledesktop.JScrollableDesktopPane;

public class ControladorOpciones {

	private JScrollableDesktopPane desktopPane;
	
	public ActionListener actionAbrirFormulario(final String lista, final String documento) {
		try {
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						abrirFormulario(lista, documento);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			};
		} catch (Exception e) {
			return null;
		}
	}
	public ActionListener actionAbrirFormulario(final String opcion) {
		try {
			return new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						abrirFormulario(opcion);
					} catch (InstantiationException | IllegalAccessException
							| ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			};
		} catch (Exception e) {
			return null;
		}
	}
	private void abrirFormulario(String urlListaClase, String urlDocumentoClase)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Object obj = Class.forName(urlListaClase).newInstance();
		
		if (obj instanceof AbstractMaestroList) {
			AbstractMaestroList frame = (AbstractMaestroList) obj; 
			frame.setInstancia(urlDocumentoClase);
			frame.setVisible(true);
			
			getDesktopPane().add(frame);
			try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		} else {
			AbstractDocList frame = (AbstractDocList) obj; 
					frame.setInstancia(urlDocumentoClase);
			frame.setVisible(true);
			
			getDesktopPane().add(frame);
			try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}			
		}
		
	}
	
	private void abrirFormulario(String urlClase) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		JInternalFrame frame = (JInternalFrame) Class.forName(urlClase).newInstance();
		frame.setVisible(true);
		try {
			if(revisarActivo(frame)){
				getDesktopPane().add(frame);
				frame.setSelected(true);
			}
		} catch (PropertyVetoException e) {
			Constantes.messageLog("Error:","Controlador Operaciones->abrirFormulario()" );
			e.printStackTrace();
		}
	}
	
	private boolean revisarActivo(JInternalFrame frmentrada){
		boolean valor=true;
		try {
			Constantes.messageLog("Entrada",frmentrada.getTitle());
//			for (JInternalFrame frm : Inicio.desktoppane.getDesktopMediator().getAllFrames()) {
//				Constantes.messageLog("desktopPane",frm.getTitle());
//			}
			int count=0;
			for (JInternalFrame frm : getDesktopPane().getDesktopMediator().getAllFrames()) {
				Constantes.messageLog("desktopPane",frm.getTitle());
				if (frm.getTitle().trim().equalsIgnoreCase(frmentrada.getTitle().trim())) {
					Constantes.messageLog("Se encuentra activo",frmentrada.getTitle());
					valor=false;
					getDesktopPane().getDesktopMediator().getAllFrames()[count].setSelected(true);
					break;
//					 UtilMensajes.mensaje_alterta("SOLO_UN_FORMULARIO");
				}
				count++;
			}
		 } catch (Exception e) {
			 // TODO Auto-generated catch block
			 Constantes.messageLog("Error:","Controlador Operaciones->revisarActivo()" );
			 e.printStackTrace();
		 }
		
		return valor;
	}
//	public ActionListener returnAction(final String opcion) {
//		try {
//			return new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent arg0) {
//					try {
//						iniciarFormulario(opcion);
//					} catch (InstantiationException | IllegalAccessException
//							| ClassNotFoundException e) {
//						e.printStackTrace();
//					}
//				}
//			};
//		} catch (Exception e) {
//			return null;
//		}
//	}

//	private void iniciarFormulario(String clase) throws InstantiationException,
//			IllegalAccessException, ClassNotFoundException {
//		String urlClase = "com.nisira.vista.formularios." + clase.trim();
//		JInternalFrame frame = (JInternalFrame) Class.forName(urlClase)
//				.newInstance();
//		frame.setVisible(true);
//		getDesktopPane().add(frame);
//		try {
//			frame.setSelected(true);
//		} catch (PropertyVetoException e) {
//			e.printStackTrace();
//		}
//	}

	public JScrollableDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public void setDesktopPane(JScrollableDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
	}
}