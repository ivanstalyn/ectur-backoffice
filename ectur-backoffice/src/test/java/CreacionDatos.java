
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.ectur.controlador.CatalogoControlador;
import com.ectur.controlador.DetalleCatalogoControlador;
import com.ectur.controlador.EmpresaControlador;
import com.ectur.controlador.ProductoControlador;
import com.ectur.controlador.UsuarioControlador;
import com.ectur.controlador.impl.CatalogoControladorImpl;
import com.ectur.controlador.impl.DetalleCatalogoControladorImpl;
import com.ectur.controlador.impl.EmpresaControladorImpl;
import com.ectur.controlador.impl.ProductoControladorImpl;
import com.ectur.controlador.impl.UsuarioControladorImpl;
import com.ectur.modelo.entidad.Catalogo;
import com.ectur.modelo.entidad.DetalleCatalogo;
import com.ectur.modelo.entidad.Empresa;
import com.ectur.modelo.entidad.Usuario;

/* PRIMERO SE DEBE EJECUTAR ESTE TEST CASE PARA LLENAR LA BASE CON DATOS */ 

class CreacionDatos {
	
	private CatalogoControlador catalogoController = new CatalogoControladorImpl();
	private DetalleCatalogoControlador detalleCatalogoController = new DetalleCatalogoControladorImpl();
	private EmpresaControlador empresaController = new EmpresaControladorImpl();
	private ProductoControlador productoController = new ProductoControladorImpl();
	private UsuarioControlador usuarioController = new UsuarioControladorImpl();
	
	@Test
	void test() {

		System.out.println("==================Creación de datos.===============================");
		
		Empresa empresa = new Empresa();
		empresa.setNombre("ECTUR");
		empresaController.insertar(empresa);
		empresa.setNombre("VIAJEROS SA");
		empresaController.insertar(empresa);
		empresa.setNombre("TURISMO VIAJES SA");
		empresaController.insertar(empresa);
		
		Catalogo catalogo = new Catalogo();
		catalogo.setNombre("ROLES");
		catalogoController.insertar(catalogo);
		
		catalogo = catalogoController.buscarPorId(1);
		DetalleCatalogo dc = new DetalleCatalogo();
		dc.setCatalogo(catalogo);
		dc.setNombre("ADMINISTRADOR");
		detalleCatalogoController.insertar(dc);
		dc.setCatalogo(catalogo);
		dc.setNombre("USUARIO");
		detalleCatalogoController.insertar(dc);
		
		catalogo.setNombre("GENERO");
		catalogoController.insertar(catalogo);
		dc.setCatalogo(catalogo);
		dc.setNombre("MASCULINO");
		detalleCatalogoController.insertar(dc);
		dc.setCatalogo(catalogo);
		dc.setNombre("FEMENINO");
		detalleCatalogoController.insertar(dc);
		dc.setCatalogo(catalogo);
		dc.setNombre("OTRO");
		detalleCatalogoController.insertar(dc);
		
		catalogo.setNombre("ESTADOS");
		catalogoController.insertar(catalogo);
		dc.setCatalogo(catalogo);
		dc.setNombre("RECIBIDO");
		detalleCatalogoController.insertar(dc);
		dc.setCatalogo(catalogo);
		dc.setNombre("EN PROGRESO");
		detalleCatalogoController.insertar(dc);
		dc.setCatalogo(catalogo);
		dc.setNombre("RESPONDIDO");
		detalleCatalogoController.insertar(dc);
		
		try {
			Usuario user = new Usuario();
			user.setNombres("Ivan");
			user.setApellidos("Muela");
			user.setIdentificacion("id12345");
			user.setTelefono("0998123456");
			user.setEmail("ivanstalyn@correo.com");
			user.setFoto("foto01");
			user.setPassword("clave1234");
			user.setUsername("admin");
			user.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("1978-06-07"));
			user.setFechaCreacion(new Date(System.currentTimeMillis()));
			user.setEmpresa(empresaController.buscarPorId(1)); //ECTUR
			user.setRol(detalleCatalogoController.buscarPorId(1)); //ADMINISTRADOR
			user.setGenero(detalleCatalogoController.buscarPorId(3)); //masculino
			usuarioController.insertar(user);
			
			user.setNombres("Gregory");
			user.setApellidos("Bonilla");
			user.setIdentificacion("id12347");
			user.setTelefono("0998654321");
			user.setEmail("gregori@correo.com");
			user.setFoto("foto02");
			user.setPassword("clave1234");
			user.setUsername("gbonilla");
			user.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("2001-08-12"));
			user.setFechaCreacion(new Date(System.currentTimeMillis()));
			user.setEmpresa(empresaController.buscarPorId(1)); //ECTUR
			user.setRol(detalleCatalogoController.buscarPorId(2)); //ADMINISTRADOR
			user.setGenero(detalleCatalogoController.buscarPorId(3)); //masculino
			usuarioController.insertar(user);
			
			
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
	
		
		

		
		System.out.println("Tareas terminadas.");

		
	}

}
