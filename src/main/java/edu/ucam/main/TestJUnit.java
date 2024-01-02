package edu.ucam.main;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

public class TestJUnit {
	
	
		@BeforeClass 
		public static void crearRecursosCompartidos(){
	        // Configuración global, por ejemplo, inicializar el Scanner
			Gestion.escaner = new Scanner(System.in);
	        System.out.println("BEFORECLASS: Configuracion global aplicada\n");
	        System.out.println("\n-------\n");
	    }
		
		@Before
	    public void inicializarLista() {
			System.out.println("BEFORE: Lista predeterminada de clases y estudiantes \n");
	        System.out.println("\n-------\n");
	        Clase clase1 = new Clase("Matemáticas");
	        Clase clase2 = new Clase("Historia");
	        Estudiante estudiante1 = new Estudiante("Juan", clase1);
	        Estudiante estudiante2 = new Estudiante("María", clase2);

	        clase1.agregarEstudiante(estudiante1);
	        clase2.agregarEstudiante(estudiante2);
	        Gestion.clases.add(clase1);
	        Gestion.clases.add(clase2);
	    }

		@Test
		public void testCrearClase() {
			System.out.println("testCrearClase\n-------\n");
			String a="Clase creada exitosamente.";
			Gestion gestion=new Gestion();
			assertEquals(a,gestion.crearClase("A"));
		}
		
		@Test
		public void testAgregarEstudianteClase() {
			System.out.println("testAgregarEstudianteClase\n-------\n");
			Gestion gestion=new Gestion();
			String a="Estudiante añadido a la clase exitosamente.";
			Estudiante estudiante = new Estudiante("Luis",gestion.crearClase("Naturales","0"));
			assertEquals(a, gestion.agregarEstudianteAClase("Naturales", "Luis"));
		}
		
		@Test
		public void testAgregarProfesorClase() {
			System.out.println("testAgregarProfesorClase\n-------\n");
			Gestion gestion=new Gestion();
			String a="Profesor asignado a la clase exitosamente.";
			assertEquals(a, gestion.asignarProfesorAClase());
		}
		
		@Test
		public void testEliminarProfesorClase() {
			System.out.println("testEliminarProfesorClase\n-------\n");
			Gestion gestion=new Gestion();
			String a="Profesor eliminado de la clase exitosamente.";
			assertEquals(a, gestion.eliminarProfesorDeClase());
		}
		
		
		@Test
		public void testExisteAlumnoEnClase_A() {
			System.out.println("testExisteAlumnoEnClase_A\n-------\n");
			Gestion gestion=new Gestion();
			Estudiante estudiante = new Estudiante("Juan Estopa",gestion.crearClase("Letras","0"));
			gestion.agregarEstudianteAClase("Letras", "Juan Estopa");
			assertFalse(gestion.existeAlumnoEnClase("Juan Estopa"));
		}
		
		@Test
		public void testReferenciaAlumnoEnClase_A() {
			System.out.println("testReferenciaAlumnoEnClase_A\n-------\n");
			Gestion gestion=new Gestion();
			Estudiante estudiante = new Estudiante("J T",gestion.crearClase("IT","0"));
			gestion.agregarEstudianteAClase("IT", "J T");
			assertNull(gestion.referenciaAlumnoEnClase("J T"));
		}
		
		@Test
		public void testReferenciaAlumnoEnClase_B() {
			System.out.println("testReferenciaAlumnoEnClase_B\n-------\n");
			Gestion gestion=new Gestion();
			String clase= "Ciencias";
			String nombre="John Connor";
			gestion.crearClase(clase);
			gestion.agregarEstudianteAClase(clase,nombre);
			assertNotNull(gestion.referenciaAlumnoEnClase(nombre));
		}
		
		@Test
		public void testReferenciaAlumnoEnClase_C() {
			System.out.println("testReferenciaAlumnoEnClase_C\n-------\n");
			String clase= "Ciencias";
			String nombre="John AA";
			Gestion gestion=new Gestion();
			Estudiante estudiante =gestion.referenciaAlumnoEnClase(nombre);
			
			assertSame(estudiante,gestion.referenciaAlumnoEnClase(nombre));
		}
		
		@Test
		public void testReferenciaAlumnoEnClase_D() {
			System.out.println("testReferenciaAlumnoEnClase_D\n-------\n");
			String clase= "Ciencias";
			String nombre="John Estopa";
			Gestion gestion=new Gestion();
			Estudiante estudiante = new Estudiante("Juan Estopa",gestion.crearClase("Letras","0"));
		
			assertNotSame(estudiante,gestion.referenciaAlumnoEnClase(nombre));
		}
		
		@Test
		public void testImprimirInformacionClase() {
			System.out.println("testImprimirInformacionClase\n-------\n");
			Gestion gestion=new Gestion();
			String a="Clase no encontrada.";
			assertNotSame(a, gestion.imprimirInformacionDeClase());
		}
		
		public void testImprimirClaseNombre() {
			System.out.println("testImprimirClaseNombre\n-------\n");
			Gestion gestion=new Gestion();
			assertNotSame(null, gestion.encontrarClasePorNombre("Naturales"));
		}
		
		@Test
		public void testCompararInformacionDeTodasLasClases() {
			System.out.println("testCompararInformacionDeTodasLasClases\n-------\n");
	        Gestion gestion = new Gestion();
	        
	        int[] actual = gestion.obtenerInformacionDeTodasLasClases();

	        int[] expected = {1, 2, 3}; 

	        // Compara los arrays
	        assertArrayEquals(expected, actual);		
	        }
		
		@AfterClass
	    public static void cerrarRecursosCompartidos() {
			System.out.println("AFTERCLASS: Cierre de Scanner \n");
	        System.out.println("\n-------\n");
			Gestion.escaner.close();
	    }
		
		@After
	    public void desmontarGestion() {
			System.out.println("AFTER: Registro log de los resultados de lista y estado del sistema reestablecido \n");
	        System.out.println("\n-------\n");
			 // Registra los resultados de la lista
	        registrarResultadosDeLista();

	        // Restablece el estado del sistema
	        restablecerEstadoDelSistema();
	    }
		private String registrarResultadosDeLista() {
			System.out.println("Registrando resultados de la lista...\n");
			StringBuilder informacion = new StringBuilder();
	        informacion.append("Información de todas las Clases:\n");
	        for (Clase clase : Gestion.clases) {
	            informacion.append(clase.obtenerInformacionDeClase()).append("\n");
	        }
	        return informacion.toString();

	    }
		private void restablecerEstadoDelSistema() {
		    Gestion.clases.clear(); 
		    Gestion.escaner.close(); 
		    Gestion.escaner = new Scanner(System.in); 
		    System.out.println("Estado del sistema restablecido.\n");
		}

		
}
