package rmi;

import java.rmi.RemoteException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application  {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("../mvc/vue/conjugaison.fxml"));
		primaryStage.setTitle("Serveur conjugaison");
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(root,600,400));
		primaryStage.show();
	}
	
	public static void main(String[] args) throws RemoteException {
		launch(args);
	}
	
}
