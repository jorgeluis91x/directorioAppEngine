package center.innovus.directorioapp.form;

import com.google.appengine.api.datastore.Email;


public class UsuarioForm {
	
	private String identificacion;
	private String nombres;
	private String apellidos;
	private Email email;
	private String password;
	private String telefono;
	private String direccion;
	
	public UsuarioForm(){
		
	}
	
	public UsuarioForm(String identificacion, String nombres, String apellidos,
			Email email, String password, String telefono, String direccion) {
		
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.direccion = direccion;
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

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	
	

}
