package sv.mh.fe.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import sv.mh.fe.constantes.TipoOpcion;

@Document("Opcion")
public class OpcionSistema {
	@Id
	public ObjectId _id;	
	public String nombre;
	public String codigo;
	public String descripcion;
	public TipoOpcion tipoOpcion;
	public OpcionSistema opcionSuperior;
	public Boolean activio;
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getActivio() {
		return activio;
	}
	public void setActivio(Boolean activio) {
		this.activio = activio;
	}
	public TipoOpcion getTipoOpcion() {
		return tipoOpcion;
	}
	public void setTipoOpcion(TipoOpcion tipoOpcion) {
		this.tipoOpcion = tipoOpcion;
	}
	public OpcionSistema getOpcionSuperior() {
		return opcionSuperior;
	}
	public void setOpcionSuperior(OpcionSistema opcionSuperior) {
		this.opcionSuperior = opcionSuperior;
	}

}
