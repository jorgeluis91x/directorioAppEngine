package center.innovus.directorioapp.spi;

import static center.innovus.directorioapp.service.OfyService.factory;
import static center.innovus.directorioapp.service.OfyService.ofy;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Work;

import center.innovus.directorioapp.Constants;
import center.innovus.directorioapp.domain.Categoria;

@Api(
        name = "directorioAdmin",
        version = "v1",
        scopes = { Constants.EMAIL_SCOPE },
        clientIds = { Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID,
                Constants.API_EXPLORER_CLIENT_ID},
        audiences = {Constants.ANDROID_AUDIENCE},
        description = "Doomi Central API que solo podra usar el administrador"
            
)
public class ApiAdmin {
	
	//Api  para crear un Grupo Padre
	  @ApiMethod(name="crearCategoria",path="crearCategoria",httpMethod=HttpMethod.POST)
	  public Categoria crearCategoria(@Named("nombreCategoria")final String nombreCategoria){
		//creamos datos para crear el grupo padre Key e id
		  final Key<Categoria> categoriaKey=factory().allocateId(Categoria.class);
		  final long categoriaId=categoriaKey.getId();
		  //inicia una transaccion
		  Categoria categoria =ofy().transact(new Work<Categoria>(){
			  @Override
	          public Categoria run(){
				  //agregamos el grupo a la base de datos
				  Categoria categoria = new Categoria(categoriaId,nombreCategoria);
				  ofy().save().entities(categoria).now();
				  return categoria;
			  }  
		  });
		  return categoria;
	  }

}
