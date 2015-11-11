package center.innovus.directorioapp.spi;

import static center.innovus.directorioapp.service.OfyService.factory;
import static center.innovus.directorioapp.service.OfyService.ofy;
import javax.inject.Named;
import center.innovus.directorioapp.Constants;
import center.innovus.directorioapp.domain.Empresa;
import center.innovus.directorioapp.domain.Usuario;
import center.innovus.directorioapp.form.EmpresaForm;
import center.innovus.directorioapp.form.UsuarioForm;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Work;

@Api(
        name = "directorioEmpresa",
        version = "v1",
        scopes = { Constants.EMAIL_SCOPE },
        clientIds = { Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID,
                Constants.API_EXPLORER_CLIENT_ID},
        audiences = {Constants.ANDROID_AUDIENCE},
        description = "Doomi Central API que solo podra usar el administrador"
            
)

public class ApiEmpresa {
	//Api  para crear un Usuario
	  @ApiMethod(name="crearUsuario",path="crearUsuario",httpMethod=HttpMethod.POST)
	  public Usuario crearUsuario(final UsuarioForm uf){
		//
		  final Key<Usuario> usuarioKey=factory().allocateId(Usuario.class);
		  final long usuarioId=usuarioKey.getId();
		  //inicia una transaccion
		  Usuario usuario =ofy().transact(new Work<Usuario>(){
			  @Override
	          public Usuario run(){
				  //agregamos  a la base de datos
				  Usuario usuario = new Usuario(usuarioId,uf);
				  ofy().save().entities(usuario).now();
				  return usuario;
			  }  
		  });
		  return usuario;
	  }

	//Api  para crear un Empresa
	  @ApiMethod(name="crearEmpresa",path="crearEmpresa",httpMethod=HttpMethod.POST)
	  public Empresa crearEmpresa(@Named("websafeKeyUsuario")final String websafekeyUsuario, final EmpresaForm ef){
		//
		  final Key<Usuario> usuarioKey=Key.create(websafekeyUsuario);
		  final Usuario usuario = ofy().load().key(usuarioKey).now();
		  
		  final Key<Empresa> empresaKey=factory().allocateId(usuarioKey,Empresa.class);
		  final long empresaId=empresaKey.getId();
		  
		  //inicia una transaccion
		  Empresa empresa =ofy().transact(new Work<Empresa>(){
			  @Override
	          public Empresa run(){
				  //agregamos  a la base de datos
				  Empresa empresa = new Empresa(empresaId,websafekeyUsuario,ef);
				  ofy().save().entities(empresa,usuario).now();
				  return empresa;
			  }  
		  });
		  return empresa;
	  }
}
