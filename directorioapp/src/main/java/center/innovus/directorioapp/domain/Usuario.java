package center.innovus.directorioapp.domain;

import center.innovus.directorioapp.form.UsuarioForm;
import com.google.appengine.api.datastore.Email;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Entity;


@Entity
public class Usuario {

	@Id
	private long idUsuario;
	
	@Index
	private String password;
	
	@Index
	private Email email;

	@Index
	private String identificacion;
	@Index
	private String nombres;
	@Index
	private String apellidos;	
	
	private String telefono;
	
	private String direccion;
	
	public Usuario(){}
	
	public Usuario(long idUser,UsuarioForm usuarioForm){
		
			this.idUsuario = idUser;
			this.ActualizaConUsuarioForm(usuarioForm);
	
	}
	
	
	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void ActualizaConUsuarioForm(final UsuarioForm usuarioForm){
		
		this.identificacion=usuarioForm.getIdentificacion();
		this.nombres=usuarioForm.getNombres();
		this.apellidos=usuarioForm.getApellidos();
		this.telefono =usuarioForm.getTelefono();
		this.email = usuarioForm.getEmail();
		this.password = usuarioForm.getPassword();
		this.direccion = usuarioForm.getDireccion();
	
	}	
	
	 public String getWebsafeKey(){
		 return Key.create(Usuario.class,idUsuario).getString();
	 }
	
	
	
}
