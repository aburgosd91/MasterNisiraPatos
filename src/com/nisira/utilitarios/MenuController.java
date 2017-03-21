package com.nisira.utilitarios;

import java.util.ArrayList;
import java.util.List;

import com.nisira.core.NisiraORMException;
import com.nisira.dao.SysGrupoDao;
import com.nisira.dao.SysModuloDao;
import com.nisira.dao.SysOpcionDao;
import com.nisira.dao.SysTituloDao;
import com.nisira.entidad.SysGrupo;
import com.nisira.entidad.SysModulo;
import com.nisira.entidad.SysOpcion;
import com.nisira.entidad.SysTitulo;

public class MenuController {
	private static SysModuloDao sysModuloDAO = new SysModuloDao();
	private static SysTituloDao sysTituloDAO = new SysTituloDao();
	private static SysGrupoDao sysGrupoDAO = new SysGrupoDao();
	private static SysOpcionDao sysOpcionDAO = new SysOpcionDao();

	@SuppressWarnings("unused")
	private static List<SysModulo> modulos = new ArrayList<SysModulo>();
	private static List<SysTitulo> titulos = new ArrayList<SysTitulo>();
	private static List<SysGrupo> grupos = new ArrayList<SysGrupo>();
	private static List<SysOpcion> opciones = new ArrayList<SysOpcion>();

	static {
		initMenu();
	}

	public static void initMenu() {
		try {
			modulos = sysModuloDAO.listar(1,true);
			titulos = sysTituloDAO.listar(1,true);
			grupos = sysGrupoDAO.listar(1,true);
			opciones = sysOpcionDAO.listar(1,true);
		} catch (NisiraORMException e) {
			e.printStackTrace();
		}
	}

	public static List<SysTitulo> getTitulosPorModulo(SysModulo modulo) throws NisiraORMException {
		List<SysTitulo> result = new ArrayList<SysTitulo>();

		for (SysTitulo titulo : titulos) {
			if (titulo.getIdModulo().equalsIgnoreCase(modulo.getIdModulo())) {
				result.add(titulo);
				titulo.setGrupos(new ArrayList<SysGrupo>());

				for (SysGrupo grupo : grupos) {
					if (grupo.getIdModulo().equalsIgnoreCase(titulo.getIdModulo())
							&& grupo.getIdTitulo().equalsIgnoreCase(titulo.getIdTitulo())) {
						titulo.getGrupos().add(grupo);

						grupo.setOpciones(new ArrayList<SysOpcion>());
						for (SysOpcion opcion : opciones) {
							if (opcion.getIdModulo().equalsIgnoreCase(grupo.getIdModulo())
									&& opcion.getIdTitulo().equalsIgnoreCase(grupo.getIdTitulo())
									&& opcion.getIdGrupo().equalsIgnoreCase(grupo.getIdGrupo())) {
								grupo.getOpciones().add(opcion);
							}
						}
					}
				}
			}
		}

		return result;

	}
}
