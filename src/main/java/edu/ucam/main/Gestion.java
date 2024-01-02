package edu.ucam.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// CLASE PARA LAS PRUEBAS
public class Gestion {
    protected static List<Clase> clases = new ArrayList<>();
    protected static Scanner escaner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú:");
            System.out.println("1. Crear una clase");
            System.out.println("2. Agregar un estudiante a una clase");
            System.out.println("3. Eliminar un estudiante de una clase");
            System.out.println("4. Asignar un profesor a una clase");
            System.out.println("5. Eliminar un profesor de una clase");
            System.out.println("6. Imprimir información de una clase");
            System.out.println("7. Listar información de todas las clases");
            System.out.println("8. Salir");

            System.out.print("Ingrese su elección: ");
            int eleccion = escaner.nextInt();
            escaner.nextLine(); // Consumir el carácter de nueva línea

            switch (eleccion) {
                case 1:
                    System.out.println(crearClase());
                    break;
                case 2:
                    System.out.println(agregarEstudianteAClase());
                    break;
                case 3:
                    System.out.println(eliminarEstudianteDeClase());
                    break;
                case 4:
                    System.out.println(asignarProfesorAClase());
                    break;
                case 5:
                    System.out.println(eliminarProfesorDeClase());
                    break;
                case 6:
                    System.out.println(imprimirInformacionDeClase());
                    break;
                case 7:
                    System.out.println(listarInformacionDeTodasLasClases());
                    break;
                case 8:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
                    break;
            }
        }
    }
    
    protected static boolean existeAlumnoEnClase(String nombreAlumno) {
        for (Clase clase : clases) {
            for (Estudiante estudiante : clase.getEstudiantes()) {
                if (estudiante.getNombre().equals(nombreAlumno)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected static Estudiante referenciaAlumnoEnClase(String nombreAlumno) {
        for (Clase clase : clases) {
            for (Estudiante estudiante : clase.getEstudiantes()) {
                if (estudiante.getNombre().equals(nombreAlumno)) {
                    return estudiante;
                }
            }
        }
        return null;
    }

    protected static String crearClase() {
        System.out.print("Ingrese el nombre de la clase: ");
        String nombreClase = escaner.nextLine();

        Clase nuevaClase = new Clase(nombreClase);
        clases.add(nuevaClase);

        return "Clase creada exitosamente.";
    }
    
    protected static String crearClase(String nombreClase) {
        //System.out.print("Ingrese el nombre de la clase: ");
        //String nombreClase = escaner.nextLine();

        Clase nuevaClase = new Clase(nombreClase);
        clases.add(nuevaClase);

        return "Clase creada exitosamente.";
    }
    protected static Clase crearClase(String nombreClase,String a) {
        //System.out.print("Ingrese el nombre de la clase: ");
        //String nombreClase = escaner.nextLine();

        Clase nuevaClase = new Clase(nombreClase);
        clases.add(nuevaClase);

        return nuevaClase;
    }

    protected static String agregarEstudianteAClase() {
        System.out.print("Ingrese el nombre de la clase: ");
        String nombreClase = escaner.nextLine();

        Clase claseSeleccionada = encontrarClasePorNombre(nombreClase);
        if (claseSeleccionada == null) {
            return "Clase no encontrada.";
        }

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombreEstudiante = escaner.nextLine();

        Estudiante nuevoEstudiante = new Estudiante(nombreEstudiante, claseSeleccionada);
        claseSeleccionada.agregarEstudiante(nuevoEstudiante);

        return "Estudiante añadido a la clase exitosamente.";
    }
    

    protected static String agregarEstudianteAClase(String nombreClase,String nombreEstudiante) {
        //System.out.print("Ingrese el nombre de la clase: ");
       
        Clase claseSeleccionada = encontrarClasePorNombre(nombreClase);
        if (claseSeleccionada == null) {
            return "Clase no encontrada.";
        }

        //System.out.print("Ingrese el nombre del estudiante: ");
        //String nombreEstudiante = escaner.nextLine();

        Estudiante nuevoEstudiante = new Estudiante(nombreEstudiante, claseSeleccionada);
        claseSeleccionada.agregarEstudiante(nuevoEstudiante);

        return "Estudiante añadido a la clase exitosamente.";
    }

    protected static String eliminarEstudianteDeClase() {
        System.out.print("Ingrese el nombre de la clase: ");
        String nombreClase = escaner.nextLine();

        Clase claseSeleccionada = encontrarClasePorNombre(nombreClase);
        if (claseSeleccionada == null) {
            return "Clase no encontrada.";
        }

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombreEstudiante = escaner.nextLine();

        Estudiante estudianteAEliminar = encontrarEstudiantePorNombre(claseSeleccionada, nombreEstudiante);
        if (estudianteAEliminar == null) {
            return "Estudiante no encontrado en la clase.";
        }

        claseSeleccionada.eliminarEstudiante(estudianteAEliminar);

        return "Estudiante eliminado de la clase exitosamente.";
    }

    protected static String asignarProfesorAClase() {
        System.out.print("Ingrese el nombre de la clase: ");
        String nombreClase = escaner.nextLine();

        Clase claseSeleccionada = encontrarClasePorNombre(nombreClase);
        if (claseSeleccionada == null) {
            return "Clase no encontrada.";
        }

        System.out.print("Ingrese el nombre del profesor: ");
        String nombreProfesor = escaner.nextLine();

        Profesor nuevoProfesor = new Profesor(nombreProfesor, claseSeleccionada);
        claseSeleccionada.asignarProfesor(nuevoProfesor);

        return "Profesor asignado a la clase exitosamente.";
    }

    protected static String eliminarProfesorDeClase() {
        System.out.print("Ingrese el nombre de la clase: ");
        String nombreClase = escaner.nextLine();

        Clase claseSeleccionada = encontrarClasePorNombre(nombreClase);
        if (claseSeleccionada == null) {
            return "Clase no encontrada.";
        }

        claseSeleccionada.eliminarProfesor();

        return "Profesor eliminado de la clase exitosamente.";
    }

    protected static String imprimirInformacionDeClase() {
        System.out.print("Ingrese el nombre de la clase: ");
        String nombreClase = escaner.nextLine();

        Clase claseSeleccionada = encontrarClasePorNombre(nombreClase);
        if (claseSeleccionada == null) {
            return "Clase no encontrada.";
        }

        return claseSeleccionada.obtenerInformacionDeClase();
    }

    protected static String listarInformacionDeTodasLasClases() {
        StringBuilder informacion = new StringBuilder();
        informacion.append("Información de todas las Clases:\n");
        for (Clase clase : clases) {
            informacion.append(clase.obtenerInformacionDeClase()).append("\n");
        }
        return informacion.toString();
    }

    protected static Clase encontrarClasePorNombre(String nombreClase) {
        for (Clase claseObj : clases) {
            if (claseObj.getNombreClase().equals(nombreClase)) {
                return claseObj;
            }
        }
        return null;
    }

    protected static Estudiante encontrarEstudiantePorNombre(Clase claseObj, String nombreEstudiante) {
        for (Estudiante estudiante : claseObj.getEstudiantes()) {
            if (estudiante.getNombre().equals(nombreEstudiante)) {
                return estudiante;
            }
        }
        return null;
    }
    public int[] obtenerInformacionDeTodasLasClases() {
        List<Integer> informacion = new ArrayList<>();

        for (Clase clase : clases) {
            // Modifica esto según la estructura de la información de la clase
            informacion.add(clase.getEstudiantes().size());
        }

        // Convierte la lista a un array de enteros
        return informacion.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Clase {
    protected String nombreClase;
    protected ArrayList<Estudiante> estudiantes;
    protected Profesor profesor;

    public Clase(String nombreClase) {
        this.nombreClase = nombreClase;
        this.estudiantes = new ArrayList<>();
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        estudiantes.remove(estudiante);
    }

    public void asignarProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void eliminarProfesor() {
        this.profesor = null;
    }

    public String obtenerInformacionDeClase() {
        StringBuilder informacion = new StringBuilder();
        informacion.append("Nombre de la Clase: ").append(nombreClase).append("\n");
        informacion.append("Estudiantes:\n");
        informacion.append(obtenerInformacionEstudiantes());
        if (profesor != null) {
            informacion.append("Profesor: ").append(profesor.getNombre()).append("\n");
        } else {
            informacion.append("Ningún profesor asignado.\n");
        }
        return informacion.toString();
    }

    public String obtenerInformacionEstudiantes() {
        StringBuilder informacion = new StringBuilder();
        for (Estudiante estudiante : estudiantes) {
            informacion.append("- ").append(estudiante.getNombre()).append("\n");
        }
        return informacion.toString();
    }

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
    
    

}

class Estudiante {
    protected String nombre;
    protected Clase claseAsignada;

    public Estudiante(String nombre, Clase claseAsignada) {
        this.nombre = nombre;
        this.claseAsignada = claseAsignada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Clase getClaseAsignada() {
        return claseAsignada;
    }
}

class Profesor {
    protected String nombre;
    protected Clase claseAsignada;

    public Profesor(String nombre, Clase claseAsignada) {
        this.nombre = nombre;
        this.claseAsignada = claseAsignada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Clase getClaseAsignada() {
        return claseAsignada;
    }
}


