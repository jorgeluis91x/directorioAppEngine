package center.innovus.directorioapp.domain;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;


@Entity
public class Categoria {
	
	@Id
	private long idCategoria;	 
	 
	@Index
	private String nombreCategoria;

	public Categoria() {
		// TODO Auto-generated constructor stub
	}
	public Categoria(final long id, final String nombre){
		this.idCategoria = id;
		this.nombreCategoria = nombre;
	}
	public long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	 public String getWebsafeKey(){
		 return Key.create(Usuario.class,idCategoria).getString();
	 }

}
