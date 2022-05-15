import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.ectur.controlador.EmpleadoControlador;
import com.ectur.controlador.MascotaControlador;
import com.ectur.controlador.PropietarioControlador;
import com.ectur.controlador.RazaControlador;
import com.ectur.controlador.RegistroAdopcionControlador;
import com.ectur.controlador.impl.EmpleadoControladorImpl;
import com.ectur.controlador.impl.MascotaControladorImpl;
import com.ectur.controlador.impl.PropietarioControladorImpl;
import com.ectur.controlador.impl.RazaControladorImpl;
import com.ectur.controlador.impl.RegistroAdopcionControladorImpl;
import com.ectur.modelo.entidad.Empleado;
import com.ectur.modelo.entidad.Mascota;
import com.ectur.modelo.entidad.Propietario;
import com.ectur.modelo.entidad.Raza;
import com.ectur.modelo.entidad.RegistroAdopcion;

/* PRIMERO SE DEBE EJECUTAR ESTE TEST CASE PARA LLENAR LA BASE CON DATOS */ 

class CreacionDatos {
	
	private RazaControlador razaController = new RazaControladorImpl();
	private MascotaControlador mascotaController = new MascotaControladorImpl();
	private EmpleadoControlador empleadoController = new EmpleadoControladorImpl();
	private PropietarioControlador propietarioController = new PropietarioControladorImpl();
	private RegistroAdopcionControlador regAdopController = new RegistroAdopcionControladorImpl();
	

	@Test
	void test() {

		System.out.println("==================Creación de datos.===============================");

		System.out.println("=================================================");
		System.out.println("Creando 5 razas de perros...");

		Raza razaPastorAleman = new Raza();
		razaPastorAleman.setNombre("Pastor Aleman");
		razaController.insertar(razaPastorAleman);
		
		Raza razaPastorIngles = new Raza();
		razaPastorIngles.setNombre("Pastor Inglés");
		razaController.insertar(razaPastorIngles);
		
		Raza razaSchnauzer = new Raza();
		razaSchnauzer.setNombre("Schnauzer");
		razaController.insertar(razaSchnauzer);
		
		Raza razaTerrier = new Raza();
		razaTerrier.setNombre("Terrier");
		razaController.insertar(razaTerrier);
		
		Raza razaChiguagua = new Raza();
		razaChiguagua.setNombre("Chiguagua");
		razaController.insertar(razaChiguagua);
		System.out.println("5 razas creadas: ok!");

		System.out.println("=================================================");
		System.out.println("Creando 5 mascotas...");
		Mascota nuevaMascota1 = new Mascota();
		Mascota nuevaMascota2 = new Mascota();
		Mascota nuevaMascota3 = new Mascota();
		Mascota nuevaMascota4 = new Mascota();
		Mascota nuevaMascota5 = new Mascota();
		
		try {	
			
			nuevaMascota1.setNombre("Tita");
			nuevaMascota1.setSexo("F");
			nuevaMascota1.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("2010-03-23"));
			nuevaMascota1.setRaza(razaSchnauzer);
			mascotaController.insertar(nuevaMascota1);
			
			nuevaMascota2.setNombre("Negro");
			nuevaMascota2.setSexo("M");
			nuevaMascota2.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("2010-03-22"));
			nuevaMascota2.setRaza(razaPastorIngles);
			mascotaController.insertar(nuevaMascota2);
			
			nuevaMascota3.setNombre("Pepito");
			nuevaMascota3.setSexo("M");
			nuevaMascota3.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("2012-06-18"));
			nuevaMascota3.setRaza(razaChiguagua);
			mascotaController.insertar(nuevaMascota3);
			
			nuevaMascota4.setNombre("Darsy");
			nuevaMascota4.setSexo("F");
			nuevaMascota4.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("2017-07-21"));
			nuevaMascota4.setRaza(razaChiguagua);
			mascotaController.insertar(nuevaMascota4);
			
			nuevaMascota5.setNombre("Neron");
			nuevaMascota5.setSexo("M");
			nuevaMascota5.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-14"));
			nuevaMascota5.setRaza(razaTerrier);
			mascotaController.insertar(nuevaMascota5);

			System.out.println("5 mascotas creadas: ok!");
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
		
		
		System.out.println("=================================================");
		System.out.println("Creando 3 empleados...");
		
		Empleado empIvanMartinez = new Empleado();
		Empleado empEulaliaTipan = new Empleado();
		Empleado empSandraCastro = new Empleado();
		
		try {
		
			
			empIvanMartinez.setCedula("1712345678");
			empIvanMartinez.setNombre("Ivan Martinez");
			empIvanMartinez.setSexo("M");
			empIvanMartinez.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("1986-03-24"));
			empleadoController.insertar(empIvanMartinez);
			
			
			empEulaliaTipan.setCedula("1712345524");
			empEulaliaTipan.setNombre("Eulalia Tipan");
			empEulaliaTipan.setSexo("F");
			empEulaliaTipan.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("1995-06-09"));
			empleadoController.insertar(empEulaliaTipan);
			
			
			empSandraCastro.setCedula("1717453682");
			empSandraCastro.setNombre("Sandra Castro");
			empSandraCastro.setSexo("F");
			empSandraCastro.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("1980-08-14"));
			empleadoController.insertar(empSandraCastro);
			System.out.println("3 empleados creados: ok!");
			
		
		}catch(Exception e) {
			System.out.print(e);
		}
		
		System.out.println("=================================================");
		System.out.println("Creando 5 propietarios de mascotas...");
		Propietario proIvanMuela = new Propietario();
		Propietario proDanielEspinoza = new Propietario();
		Propietario proPamelaEspinoza = new Propietario();
		Propietario proRafaelaMuela = new Propietario();
		Propietario proRuthFlor = new Propietario();
		
		try {
		
			
			proIvanMuela.setCedula("1783627481");
			proIvanMuela.setNombre("Ivan Muela");
			proIvanMuela.setSexo("M");
			proIvanMuela.setCelular("0998123645");
			proIvanMuela.setDirecion("Los Chillos");
			proIvanMuela.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("1978-06-07"));
			proIvanMuela.setEmail("ivanstalyn@gmail.com");
			propietarioController.insertar(proIvanMuela);

			
			proDanielEspinoza.setCedula("1777654822");
			proDanielEspinoza.setNombre("Daniel Espinoza");
			proDanielEspinoza.setSexo("M");
			proDanielEspinoza.setCelular("0982637188");
			proDanielEspinoza.setDirecion("Los Chillos");
			proDanielEspinoza.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("1999-07-07"));
			proDanielEspinoza.setEmail("daniel.espinoza@gmail.com");
			propietarioController.insertar(proDanielEspinoza);
			
			
			proPamelaEspinoza.setCedula("1729473600");
			proPamelaEspinoza.setNombre("Pamela Espinoza");
			proPamelaEspinoza.setSexo("F");
			proPamelaEspinoza.setCelular("0987377675");
			proPamelaEspinoza.setDirecion("Los Chillos");
			proPamelaEspinoza.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("1977-02-15"));
			proPamelaEspinoza.setEmail("pamela.espinoza@gmail.com");
			propietarioController.insertar(proPamelaEspinoza);
			
			
			proRafaelaMuela.setCedula("1752837411");
			proRafaelaMuela.setNombre("Rafaela Muela");
			proRafaelaMuela.setSexo("F");
			proRafaelaMuela.setCelular("0988762366");
			proRafaelaMuela.setDirecion("Cumabaya");
			proRafaelaMuela.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("2000-11-01"));
			proRafaelaMuela.setEmail("rafaela.muela@gmail.com");
			propietarioController.insertar(proRafaelaMuela);
			
			
			proRuthFlor.setCedula("1812765736");
			proRuthFlor.setNombre("Ruth Flor");
			proRuthFlor.setSexo("F");
			proRuthFlor.setCelular("0987123567");
			proRuthFlor.setDirecion("Cumabaya");
			proRuthFlor.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("1956-04-29"));
			proRuthFlor.setEmail("ruth.flor@gmail.com");
			propietarioController.insertar(proRuthFlor);
			
			System.out.println("5 propietarios creados: ok!");
		
		}catch(Exception e) {
			System.out.print(e);
		}
		
		
		System.out.println("=================================================");
		System.out.println("Creando 5 adopciones de mascotas...");
		
		RegistroAdopcion regAdop01 = new RegistroAdopcion();
		RegistroAdopcion regAdop02 = new RegistroAdopcion();
		RegistroAdopcion regAdop03 = new RegistroAdopcion();
		RegistroAdopcion regAdop04 = new RegistroAdopcion();
		RegistroAdopcion regAdop05 = new RegistroAdopcion();
		
		try {
			
			regAdop01.setFechaAdopcion(new Date());
			regAdop01.setPropietario(proRuthFlor);
			regAdop01.setEmpleado(empSandraCastro);
			regAdop01.setMascota(nuevaMascota1);
			regAdopController.insertar(regAdop01);
			
			regAdop02.setFechaAdopcion(new Date());
			regAdop02.setPropietario(proDanielEspinoza);
			regAdop02.setEmpleado(empSandraCastro);
			regAdop02.setMascota(nuevaMascota2);
			regAdopController.insertar(regAdop02);

			regAdop03.setFechaAdopcion(new Date());
			regAdop03.setPropietario(proIvanMuela);
			regAdop03.setEmpleado(empEulaliaTipan);
			regAdop03.setMascota(nuevaMascota3);
			regAdopController.insertar(regAdop03);

			regAdop04.setFechaAdopcion(new Date());
			regAdop04.setPropietario(proRafaelaMuela);
			regAdop04.setEmpleado(empEulaliaTipan);
			regAdop04.setMascota(nuevaMascota4);
			regAdopController.insertar(regAdop04);

			regAdop05.setFechaAdopcion(new Date());
			regAdop05.setPropietario(proPamelaEspinoza);
			regAdop05.setEmpleado(empIvanMartinez);
			regAdop05.setMascota(nuevaMascota5);
			regAdopController.insertar(regAdop05);
			
			System.out.println("5 registros de adopciones creados: ok!");

			
		}catch(Exception e) {
			System.out.print(e);
		}
		
		System.out.println("Tareas terminadas.");

		
	}

}
