package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import mvc.modele.VerbeConjugue;

/**
 * Classe permettant de démarrer le serveur de conjugaison
 */
public class Serveur {

	public static void main (String[] argv) {
		try {
			int port = 1338;
			LocateRegistry.createRegistry(port);
			
			Naming.rebind("rmi://localhost:"+port+"/conjugaison", new VerbeConjugue());
			
			System.out.println ("Serveur de conjugaison prêt!");
		} catch (Exception e) {
			System.out.println ("Erreur serveur : " + e);
		}
	}
	
}
