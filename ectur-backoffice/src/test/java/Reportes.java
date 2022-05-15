
import java.util.List;

import javax.persistence.Tuple;

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

class Reportes {
	
	private RazaControlador razaController = new RazaControladorImpl();
	private MascotaControlador mascotaController = new MascotaControladorImpl();
	private EmpleadoControlador empleadoController = new EmpleadoControladorImpl();
	private PropietarioControlador propietarioController = new PropietarioControladorImpl();
	private RegistroAdopcionControlador regAdopController = new RegistroAdopcionControladorImpl();

	@Test
	void test() {
		
		System.out.println("=================================================");
		System.out.println("Prueba de diferentes reportes usando EntityManagerFactory, CriteriaBuilder y CriteriaQuery ");
		
		/*
		 * ENTIDAD RAZA
		 */
		
		System.out.println("=================================================");
		System.out.println("Listar todas la razas de mascotas");
		List<Raza> listaRazas = razaController.listar();
		for (Raza r : listaRazas) {
			System.out.println(r);
		}
		
		System.out.println("=================================================");
		System.out.println("Listar sólo nombres de la razas de mascotas");
		List<Tuple> listaRazasTuple = razaController.listarNombres();
		for (Tuple r : listaRazasTuple) {
			System.out.println(r.get(0));
		}
		
		System.out.println("=================================================");
		System.out.println("Listar todas la razas que empiecen con palabra Pastor");
		listaRazas = razaController.buscarPorNombre("Pastor");
		for (Raza r : listaRazas) {
			System.out.println(r);
		}
		
		System.out.println("=================================================");
		System.out.println("Listar la raza cuyo id es 4");
		Raza razaTerrier = razaController.buscarPorId(4);
		System.out.println(razaTerrier);
		
		/*
		 * ENTIDAD EMPLEADO
		 */
		
		System.out.println("=================================================");
		System.out.println("Listar todos los empleados");
		List<Empleado> listaEmpleados = empleadoController.listar();
		for (Empleado e : listaEmpleados) {
			System.out.println(e);
		}
		
		System.out.println("=================================================");
		System.out.println("Listar todos los empleados TypedQuery");
		List<Empleado> listaEmpleadosTQ = empleadoController.listarTQ();
		for (Empleado e : listaEmpleadosTQ) {
			System.out.println(e);
		}
		
		System.out.println("=================================================");
		System.out.println("Listar sólo nombres de empleados");
		List<Tuple> listaEmpleadosTuple = empleadoController.listarNombres();
		for (Tuple r : listaEmpleadosTuple) {
			System.out.println(r.get(0));
		}
		
		System.out.println("=================================================");
		System.out.println("Buscar empleados cuyo nombre empieza con 'I' ");
		listaEmpleados = empleadoController.buscarPorNombre("I");
		for (Empleado e : listaEmpleados) {
			System.out.println(e);
		}
		
		System.out.println("=================================================");
		System.out.println("Buscar empleado cuya cédula es 1712345524");
		Empleado e = empleadoController.buscarPorCedula("1712345524");
		System.out.println(e);
		
		System.out.println("=================================================");
		System.out.println("Buscar empleado cuyo id es 3");
		Empleado e3 = empleadoController.buscarPorId(3);
		System.out.println(e3);
		
		
		/*
		 * ENTIDAD PROPIETARIO
		 */
		
		System.out.println("=================================================");
		System.out.println("Listar todos los propietarios");
		List<Propietario> listaPropietarios = propietarioController.listar();
		for (Propietario p : listaPropietarios) {
			System.out.println(p);
		}
		
		System.out.println("=================================================");
		System.out.println("Listar nombres de todos los propietarios");
		List<Tuple> listaPropietariosTuple = propietarioController.listarNombres();
		for (Tuple p : listaPropietariosTuple) {
			System.out.println(p.get(0));
		}
		
		System.out.println("=================================================");
		System.out.println("Buscar propietario cuyo nombre empieza con 'R' ");
		listaPropietarios = propietarioController.buscarPorNombre("R");
		for (Propietario p : listaPropietarios) {
			System.out.println(p);
		}
		
		System.out.println("=================================================");
		System.out.println("Buscar propietario cuya cédula es 1752837411");
		Propietario p = propietarioController.buscarPorCedula("1752837411");
		System.out.println(p);
		
		System.out.println("=================================================");
		System.out.println("Buscar propietario cuyo id es 2");
		Propietario pid2 = propietarioController.buscarPorId(2);
		System.out.println(pid2);
		
		/*
		 * ENTIDAD MASCOTA
		 */
		
		System.out.println("=================================================");
		System.out.println("Listar todas las mascotas");
		List<Mascota> listaMascotas = mascotaController.listar();
		for (Mascota m : listaMascotas) {
			System.out.println(m);
		}
		
		System.out.println("=================================================");
		System.out.println("Listar sólo datos básicos de mascotas");
		List<Tuple> listaMascotasTuple = mascotaController.listarDatosBasicos();
		for (Tuple r : listaMascotasTuple) {
			System.out.println("Nombre: "+r.get(0)+" sexo: "+r.get(1));
		}
		
		System.out.println("=================================================");
		System.out.println("Listar todas las mascotas cuyo nombre empieza con N");
		listaMascotas = mascotaController.buscarPorNombre("N");
		for (Mascota m : listaMascotas) {
			System.out.println(m);
		}
		
		System.out.println("=================================================");
		System.out.println("Listar todas las mascotas cuya raza es Terrier ");
		listaMascotas = mascotaController.buscarPorRaza(razaTerrier);
		for (Mascota m : listaMascotas) {
			System.out.println(m);
		}
		
		/*
		 * ENTIDAD Registro Adopción
		 */
		
		System.out.println("=================================================");
		System.out.println("Listar todos los regsitros de adopción");
		List<RegistroAdopcion> listaRegistroAdopciones = regAdopController.listar();
		for (RegistroAdopcion regado : listaRegistroAdopciones) {
			System.out.println(regado);
		}
		
		System.out.println("=================================================");
		System.out.println("Listar todos los regsitros de adopción de raza Terrier");
		listaRegistroAdopciones = regAdopController.buscarPorRaza(razaTerrier);
		for (RegistroAdopcion regado : listaRegistroAdopciones) {
			System.out.println(regado);
		}
		
		System.out.println("=================================================");
		System.out.println("Listar todos los regsitros de adopción de un propietario (id 2)");
		listaRegistroAdopciones = regAdopController.buscarPorPropietario(pid2);
		for (RegistroAdopcion regado : listaRegistroAdopciones) {
			System.out.println(regado);
		}
		
		
		System.out.println("=================================================");
		System.out.println("Listar todos los regsitros de adopción realizados por empleado (id 2)");
		listaRegistroAdopciones = regAdopController.buscarPorEmpleado(e3);
		for (RegistroAdopcion regado : listaRegistroAdopciones) {
			System.out.println(regado);
		}
				
	
	}

}
