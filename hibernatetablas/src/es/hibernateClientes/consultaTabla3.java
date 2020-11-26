package es.hibernateClientes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class consultaTabla3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(Detalles_cliente.class)
				.buildSessionFactory();

		Session miSession=miFactory.openSession();

		try {
			
			miSession.beginTransaction();
			Detalles_cliente detalleDeCliente=miSession.get(Detalles_cliente.class,1);
			System.out.println(detalleDeCliente);
			System.out.println(detalleDeCliente.getElClinte());
			System.out.println("elimina en cascada");
			miSession.delete(detalleDeCliente);
			
			
			miSession.getTransaction().commit();
		
		}catch(Exception e){
			e.printStackTrace();
				
			}
			
		finally {
			miSession.close();
			miFactory.close();
		}
			}

		

	}


