package it.polito.tdp.spellchecker.controller;

import java.net.URL;
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

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lab3;

    @FXML
    private ComboBox<?> txtlanguage;

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

    }

    @FXML
    void doSpellCheck(ActionEvent event) {

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
	}
}
