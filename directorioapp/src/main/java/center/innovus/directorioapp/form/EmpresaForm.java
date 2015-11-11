package center.innovus.directorioapp.form;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.Email;
import com.google.appengine.api.datastore.GeoPt;


public class EmpresaForm {
	
	 
	 private String nombre;
	 private String descripcion; 
	 private String urlLogo;
	 private List<String> telefonos = new ArrayList<>(0);
	 private List<String> faxs = new ArrayList<>(0);
	 private List<String> celulares = new ArrayList<>(0);
	 private String categoria;
	 private int prioridad;
	 private String facebook;
	 private String twitter;
	 private String instagram;
	 private Email email;
	 private GeoPt ubicacion;
	 private String direccion;
	 private String urlPagina;
	public EmpresaForm() {
		
	}
	public EmpresaForm(String nombre,
			String descripcion, String urlLogo, List<String> telefonos,
			List<String> faxs, List<String> celulares, String categoria,
			int prioridad, String facebook, String twitter, String instagram,
			Email email, GeoPt ubicacion, String direccion, String urlPagina) {
	
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.urlLogo = urlLogo;
		this.telefonos = telefonos;
		this.faxs = faxs;
		this.celulares = celulares;
		this.categoria = categoria;
		this.prioridad = prioridad;
		this.facebook = facebook;
		this.twitter = twitter;
		this.instagram = instagram;
		this.email = email;
		this.ubicacion = ubicacion;
		this.direccion = direccion;
		this.urlPagina = urlPagina;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrlLogo() {
		return urlLogo;
	}
	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}
	public List<String> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(List<String> telefonos) {
		this.telefonos = telefonos;
	}
	public List<String> getFaxs() {
		return faxs;
	}
	public void setFaxs(List<String> faxs) {
		this.faxs = faxs;
	}
	public List<String> getCelulares() {
		return celulares;
	}
	public void setCelulares(List<String> celulares) {
		this.celulares = celulares;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public GeoPt getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(GeoPt ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getUrlPagina() {
		return urlPagina;
	}
	public void setUrlPagina(String urlPagina) {
		this.urlPagina = urlPagina;
	}
	
	
	 
	 
	 

}
