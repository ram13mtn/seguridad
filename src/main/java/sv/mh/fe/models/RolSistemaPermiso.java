package sv.mh.fe.models;

import java.util.List;

public class RolSistemaPermiso {

	private OpcionSistema opcionSistema;
	private List<AccionSistema> acciones;

	public RolSistemaPermiso() {
	}

	public OpcionSistema getOpcionSistema() {
		return opcionSistema;
	}

	public void setOpcionSistema(OpcionSistema opcionSistema) {
		this.opcionSistema = opcionSistema;
	}

	public List<AccionSistema> getAcciones() {
		return acciones;
	}

	public void setAcciones(List<AccionSistema> acciones) {
		this.acciones = acciones;
	}

}
