package pac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("-CARGANDO LA CONFIGURACIÓN-");
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg
				.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sessionFactory.openSession();
		System.out.println("-CONFIGURACIÓN CARGADA-");

		// Funciones que realizaran los insterts en la BD
		Set<Modulo> alumno_modulo = new HashSet<Modulo>();
		Modulo moduloProgramacionB = new Modulo("Programación B", "M06B");
		Modulo moduloAccesoADatos = new Modulo("Acceso a Datos", "M06");
		Modulo moduloDesarrollo = new Modulo("Desarrollo de aplicaciones moviles", "M08");
		Modulo moduloServicios = new Modulo("Servicios y procesos", "M09");
		Profesor profesorAlvaro = new Profesor("Alvaro", "hombre");
		
		Transaction tx = session.beginTransaction();
		
		// MODULOS
		session.save(moduloProgramacionB);
		session.save(moduloAccesoADatos);
		session.save(moduloDesarrollo);
		session.save(moduloServicios);

		// PROFESORES
		session.save(profesorAlvaro);

		//ALUMNOS
		HashSet <Modulo> alJuan = new HashSet<Modulo>();
		alJuan.add(moduloProgramacionB);
		alJuan.add(moduloAccesoADatos);
		alJuan.add(moduloServicios);
		alJuan.add(moduloDesarrollo);
		Alumno alumnoJuan = new Alumno("Juan", "Espaniola", 26, "Hombre", alJuan);
		session.save(alumnoJuan);
	
		HashSet <Modulo> alPedro = new HashSet<Modulo>();
		alPedro.add(moduloProgramacionB);
		alPedro.add(moduloAccesoADatos);
		alPedro.add(moduloServicios);
		Alumno alumnoPedro = new Alumno("Pedro", "Andorrana", 21, "Hombre", alPedro);
		session.save(alumnoPedro);
		
		HashSet <Modulo> alMarta = new HashSet<Modulo>();
		alMarta.add(moduloServicios);
		alMarta.add(moduloDesarrollo);
		Alumno alumnoMarta = new Alumno("Marta", "Espaniola", 19, "Mujer", alMarta);
		session.save(alumnoMarta);
		
		HashSet <Modulo> alCarla = new HashSet<Modulo>();
		alCarla.add(moduloAccesoADatos);
		alCarla.add(moduloServicios);
		alCarla.add(moduloDesarrollo);
		Alumno alumnoCarla = new Alumno("Carla", "Francesa", 35, "Mujer", alCarla);
		session.save(alumnoCarla);

		
		List<?> listModulo = session.createQuery("FROM Modulo").list();
	    for (int i = 0; i < listModulo.size(); i++) {
	      System.out.println(listModulo.get(i).toString());
	    }
	      
	    List<?> listProfesor = session.createQuery("FROM Profesor").list();
	    for (int i = 0; i < listProfesor.size(); i++) {
	       System.out.println(listProfesor.get(i).toString());
	    }
	    
	    List<?> listAlumno = session.createQuery("FROM Alumno").list();
	    for (int i = 0; i < listAlumno.size(); i++) {
	      System.out.println(listAlumno.get(i).toString());
	    }
	    

		// Uso de commit para instertar los datos
		tx.commit();
		// Cerramos la sesión
		session.close();
		sessionFactory.close();
	}

}