package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SpellCheckerController {
	private Dictionary model;
	private String lingua;
	private String testoAgg;
	public List<String> listaParoleAgg= new LinkedList<String>();
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lab3;

    @FXML
    private ComboBox<String> txtlanguage;

    @FXML
    private TextArea txtTesto;

    @FXML
    private TextArea txtCorrette;

    @FXML
    private TextField txtNumeroCorrette;

    @FXML
    private TextField txtTempo;
    
    @FXML
    void doLanguage(ActionEvent event) {
    	lingua= this.txtlanguage.getValue();
    	if(lingua.equals("English") || lingua.equals("Italian") )
    	model.loadDictionary(lingua);

    }

    @FXML
    void doClearText(ActionEvent event) {

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	testoAgg=txtTesto.getText().toLowerCase();
    	testoAgg =testoAgg.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	String[ ] parole =testoAgg.split(" ");
    	for(int i=0; i<parole.length; i++) {
    		listaParoleAgg.add(parole[i].trim());
    	}
    	model.spellCheckText(listaParoleAgg);
    	//par.addAll(Arrays.asList(parole.split("\\s+")));
    	
    	

    }

    @FXML
    void initialize() {
        assert lab3 != null : "fx:id=\"lab3\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtlanguage != null : "fx:id=\"txtlanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtCorrette != null : "fx:id=\"txtCorrette\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtNumeroCorrette != null : "fx:id=\"txtNumeroCorrette\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }
    public void setModel(Dictionary model) {
		this.model = model;
		txtlanguage.getItems().addAll("English", "Italian");
	}
}
