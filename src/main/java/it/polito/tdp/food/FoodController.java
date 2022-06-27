/**
 * Sample Skeleton for 'Food.fxml' Controller Class
 */

package it.polito.tdp.food;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.food.model.Food;
import it.polito.tdp.food.model.FoodAdiacente;
import it.polito.tdp.food.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FoodController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtPorzioni"
    private TextField txtPorzioni; // Value injected by FXMLLoader

    @FXML // fx:id="txtK"
    private TextField txtK; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalisi"
    private Button btnAnalisi; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalorie"
    private Button btnCalorie; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="boxFood"
    private ComboBox<Food> boxFood; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	// pulisco l'area di testo
    	txtResult.clear();
    	
    	// controllo il num di porzioni
    	int nPorzioni = 0;
    	try {
    		nPorzioni = Integer.parseInt(this.txtPorzioni.getText());
    	}
    	catch(NumberFormatException e) {
    		e.printStackTrace();
    		this.txtResult.setText("Errore: devi prima inserire un valore intero per le porzioni.");
    		return;
    	}
    	
    	// creo il grafo
    	this.model.creaGrafo(nPorzioni);
    	
    	// popolo il menu a tendina con i cibi
    	this.boxFood.getItems().clear();
    	this.boxFood.getItems().addAll(this.model.getVertici());
    	
    	// stampo un messaggio
    	txtResult.appendText(String.format("Grafo creato con %d vertici e %d archi.", 
    			this.model.nVertici(), this.model.nArchi()));
    }
    
    @FXML
    void doCalorie(ActionEvent event) {
    	// pulisco l'area di testo
    	txtResult.clear();
    	
    	// controllo il grafo
    	if(!this.model.isGrafoCreato()) {
    		this.txtResult.setText("Errore: devi prima creare il grafo.");
    		return;
    	}
    	
    	// controllo il cibo
    	Food cibo = this.boxFood.getValue();
    	if(cibo == null) {
    		this.txtResult.setText("Errore: devi prima selezionare un cibo.");
    		return;
    	}
    	// trovo i cibi adiacenti
    	List<FoodAdiacente> adiacenti = this.model.getAdiacenti(cibo);
    	
    	// stampo il risultato
    	txtResult.appendText("Cibi adiacenti:\n");
    	if(adiacenti.size() == 0) {
    		this.txtResult.appendText("nessuno.");
    	}
    	for(FoodAdiacente f : adiacenti) {
    		this.txtResult.appendText(f + "\n");
    	}
    }

    @FXML
    void doSimula(ActionEvent event) {
    	txtResult.clear();
    	txtResult.appendText("Simulazione...");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtPorzioni != null : "fx:id=\"txtPorzioni\" was not injected: check your FXML file 'Food.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnAnalisi != null : "fx:id=\"btnAnalisi\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnCalorie != null : "fx:id=\"btnCalorie\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Food.fxml'.";
        assert boxFood != null : "fx:id=\"boxFood\" was not injected: check your FXML file 'Food.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Food.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
