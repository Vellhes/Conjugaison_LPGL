package mvc.controlleur;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mvc.modele.VerbeInterface;

/**
 * Controlleur de la fenêtre de conjugaison
 */
public class ConjugaisonController implements Initializable {

	@FXML
    private AnchorPane pane_connexion;

    @FXML
    private TextField tf_IP;

    @FXML
    private TextField tf_port;
    
    @FXML
    private TextField tf_verbe;

    @FXML
    private Button btn_valider;

    @FXML
    private Button btn_quitter;

    @FXML
    private AnchorPane pane_conjuguer;

    @FXML
    private Label lbl_result;

    @FXML
    private Button btn_conjuguer;

    @FXML
    private Button btn_quitter1;
    
    @FXML
    private ComboBox<String> cmb_temps;

    private VerbeInterface obj = null;
    
    private Alert alert;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pane_conjuguer.setVisible(false);
		pane_connexion.setVisible(true);
		tf_IP.setText("");
		tf_port.setText("");
		tf_verbe.setText("");
		lbl_result.setText("");
		String present = "Présent";
		String futur = "Futur";
		String passeCompose = "Passé Composé";
		cmb_temps.getItems().clear();
		cmb_temps.getItems().add(present);
		cmb_temps.getItems().add(futur);
		cmb_temps.getItems().add(passeCompose);
		
		/**
		 * mise en place des événèments clavier pour le panneau de connexion
		 */
		pane_connexion.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if(ke.getCode().equals(KeyCode.ESCAPE)) {
					quitter();
				}else if(ke.getCode().equals(KeyCode.ENTER)) {
					connexion();
				}
			}
		});
		
		/**
		 * mise en place des événèments clavier pour le panneau de conjugaison
		 */
		pane_conjuguer.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if(ke.getCode().equals(KeyCode.ESCAPE)) {
					quitter();
				}else if(ke.getCode().equals(KeyCode.ENTER)) {
					conjuguer();
				}
			}
		});
	}

	
	/**
	 * Méthode permettant de connecter le client au serveur grâce à l'IP et au port
	 * si la connexion réussi, on affiche le panneau de conjugaison
	 */
	@FXML
	private void connexion() {
		String IP, port;
		IP = tf_IP.getText();
		port = tf_port.getText();
	    try {
			obj = (VerbeInterface) Naming.lookup("rmi://"+IP+":"+port+"/conjugaison");
			pane_conjuguer.setVisible(true);
			pane_connexion.setVisible(false);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Erreur de connexion");
	        alert.setHeaderText(null);
	    	alert.setContentText("Connexion impossible, veuillez vérifier vos informations puis réessayer.");
	    	alert.showAndWait();
		}
	}
	
	/**
	 * Méthode permettant de conjuguer un verbe et de l'afficher
	 */
	@FXML
	private void conjuguer() {
		String verbe, temps, result;
		result = "";
		verbe = tf_verbe.getText();
		temps = cmb_temps.getValue();
		ArrayList<String> listeVerbe = new ArrayList<String>();
		if(obj != null) {
			try {
				listeVerbe = obj.conjuge(temps, verbe);
				for(int i = 0 ; i < listeVerbe.size() ; i++) {
					String v = listeVerbe.get(i);
					result = result + v + "\n";
				}
				lbl_result.setText(result);
			} catch (RemoteException e) {
				alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Erreur de connexion");
		        alert.setHeaderText(null);
		    	alert.setContentText("Aucune connexion n'est en cours, veuillez redémarrer l'application et vous reconnecter.");
		    	alert.showAndWait();
			}
		}
	}
	
	/**
	 * Méthode permettant de quitter l'application et de la fermer
	 */
	@FXML
	private void quitter() {
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Quitter l'application");
		alert.setHeaderText(null);
		alert.setContentText("Vous êtes sur le point de quitter l'application ConjugOmax, vos informations ne seront pas enregistrées");
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get() == ButtonType.OK) {
			Stage stage = (Stage) pane_connexion.getScene().getWindow();
			stage.close();
		}		
	}
    
}
