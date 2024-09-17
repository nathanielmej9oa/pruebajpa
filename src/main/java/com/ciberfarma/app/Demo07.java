package com.ciberfarma.app;

import java.util.List;

import com.ciberfarma.model.Tipo;
import com.ciberfarma.model.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Demo07 {
 
	public static void main(String[] args) {
		EntityManagerFactory conexion = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = conexion.createEntityManager();
	
	List<Tipo> lstTipos = em.createNativeQuery("select * from tb_tipos", Tipo.class).
			getResultList();	
	for (Tipo t : lstTipos) {
		System.out.println("Tipo de Usuario: " + t.getDescripcion());
		System.out.println("-----------");
		for (Usuario u: t.getLstUsuarios()) {
			System.out.println("Nombre:" + u.getNom_usua() + "" + u.getApe_usua());
			System.out.println("Correo:" + u.getClave());
			System.out.println("-----------");
		}
	}
	
	List<Tipo>lstTipos2 = em.createQuery("select u from_tipo u").getResultList();
	}
}
