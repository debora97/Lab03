package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
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
	public List<String> listaParoleAgg = new LinkedList<String>();

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
	void doClearText(ActionEvent event) {
		txtCorrette.clear();
		txtTesto.clear();
		txtNumeroCorrette.clear();
		txtTempo.clear();

	}

	@FXML
	void doSpellCheck(ActionEvent event) {
		txtCorrette.clear();
		txtNumeroCorrette.clear();
		int cont = 0;
		listaParoleAgg.clear();
		
		lingua = this.txtlanguage.getValue();
		if (lingua.equals("English") || lingua.equals("Italian"))
			model.loadDictionary(lingua);
		
		testoAgg = txtTesto.getText().toLowerCase();
		testoAgg = testoAgg.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
		String[] parole = testoAgg.split(" ");
		for (int i = 0; i < parole.length; i++) {
			listaParoleAgg.add(parole[i].trim());
		}
		
		List<RichWord> paroleRich = new LinkedList<RichWord>(model.spellCheckText(listaParoleAgg));
		 //List<RichWord> paroleErrate=new LinkedList<RichWord>();
		 //par.addAll(Arrays.asList(parole.split("\\s+")));
		for (RichWord rw : paroleRich) {
			if (rw.isGiusto() == false) {
				cont++;
				
				
				txtCorrette.appendText(rw.getParolaInserita() + " \n");
				
			}
		}
		txtNumeroCorrette.appendText("The text contains" + cont + "errors");
           double numero = (System.nanoTime());
				txtTempo.appendText(Double.toString(numero));
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
