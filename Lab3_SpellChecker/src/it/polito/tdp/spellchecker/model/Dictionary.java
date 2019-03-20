package it.polito.tdp.spellchecker.model;

import java.util.*;
import java.io.*;

public class Dictionary {
	public List<String> dizionario = new LinkedList<String>();

	public void loadDictionary(String language) {

		try {
			FileReader fr = new FileReader("rsc/" + language + ".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				dizionario.add(word);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file");
		}

	}

	public List<RichWord> spellCheckText(List<String> inputTextList) {
		List<RichWord> parole = new LinkedList<RichWord>();
		boolean trovato = false;
		for (String s : inputTextList) {
			for (String sd : dizionario) {
				if (s.equals(sd)) {
					trovato = true;
				}

			}
			RichWord parola = new RichWord(s, trovato);
			parole.add(parola);
		}
		return parole;

	}

}
