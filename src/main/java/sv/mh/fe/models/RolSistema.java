package sv.mh.fe.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Rol")
public class RolSistema {
	@Id
	public ObjectId _id;
	
	private String nombre;
	private String codigo;
	private String descripcion;
	private RolSistema rolSuperior;
	private Boolean activio;
	private List<RolSistemaPermiso> permiso;
	
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
	public RolSistema getRolSuperior() {
		return rolSuperior;
	}
	public void setRolSuperior(RolSistema rolSuperior) {
		this.rolSuperior = rolSuperior;
	}
	public List<RolSistemaPermiso> getPermiso() {
		return permiso;
	}
	public void setPermiso(List<RolSistemaPermiso> permiso) {
		this.permiso = permiso;
	}
	
}
