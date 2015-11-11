package center.innovus.directorioapp.domain;

import static center.innovus.directorioapp.service.OfyService.ofy;

import java.util.ArrayList;
import java.util.List;

import center.innovus.directorioapp.form.EmpresaForm;
import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.ApiResourceProperty;
import com.google.appengine.api.datastore.Email;
import com.google.appengine.api.datastore.GeoPt;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

import center.innovus.directorioapp.domain.Empresa;

@Entity
public class Empresa {
	
	 @Id
	 private long idEmpresa;
	 
	 @Parent
	 @ApiResourceProperty(ignored=AnnotationBoolean.TRUE)
	 private Key<Usuario> usuarioKey;
	 
	 @ApiResourceProperty(ignored=AnnotationBoolean.TRUE)
	 private long idUsuario;

	 @Index
	 private String nombre;
	
	 @Index
	 private String descripcion;
	 
	 private String urlLogo;
	
	 	 
	 private List<String> telefonos = new ArrayList<>(0);
	 private List<String> faxs = new ArrayList<>(0);
	 private List<String> celulares = new ArrayList<>(0);
	 
	 @Index
	 private String categoria;
	 
	 @Index
	 private int prioridad;
	 private String facebook;
	 private String twitter;
	 private String instagram;
	 private Email email;
	 
	 @Index
	 private GeoPt ubicacion;
	 
	 @Index
	 private String direccion;
	 private String urlPagina;

	 @Index
	 private Boolean is_active;

	public Empresa() {
		
		// TODO Auto-generated constructor stub
	}
	
	public Empresa(final long idEmpresa,final String websafeKeyUsuario,EmpresaForm empresaForm){
		this.idEmpresa = idEmpresa;
		this.actualizaConEmpresaForm(empresaForm);
		 //creamos llaves padres
	   	 this.usuarioKey =Key.create(websafeKeyUsuario); 
	  
	   	 //creamos padres cn las llaves padres
		 Usuario usuario = ofy().load().key(usuarioKey).now();	 
		 //obtenemos ids padres
		 
		 this.idUsuario = usuario.getIdUsuario();	 
		 this.is_active = true;
		
	}

	public long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Key<Usuario> getUsuarioKey() {
		return usuarioKey;
	}

	public void setUsuarioKey(Key<Usuario> usuarioKey) {
		this.usuarioKey = usuarioKey;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
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

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	
	 public String getWebsafeKey(){
		 return Key.create(usuarioKey, Empresa.class,idEmpresa).getString();
	 }
	 
	 public void actualizaConEmpresaForm(EmpresaForm empresaForm) {
	     this.nombre = empresaForm.getNombre();
	     this.descripcion = empresaForm.getDescripcion();
	     this.urlLogo = empresaForm.getUrlLogo();
		 this.telefonos = empresaForm.getTelefonos();
		 this.faxs = empresaForm.getFaxs();
		 this.celulares = empresaForm.getCelulares();
		 this.categoria = empresaForm.getCategoria();
		 this.prioridad = empresaForm.getPrioridad();
		 this.facebook = empresaForm.getFacebook();
		 this.twitter = empresaForm.getTwitter();
		 this.instagram = empresaForm.getInstagram();
		 this.email = empresaForm.getEmail();
		 this.ubicacion = empresaForm.getUbicacion();
		 this.direccion = empresaForm.getDireccion();
		 this.urlPagina = empresaForm.getUrlPagina();
	     
	         // The initial number of seatsAvailable is the same as maxAttendees.
	         // However, if there are already some seats allocated, we should subtract that numbers.
	         
	 }
	 
	
	
	

}
