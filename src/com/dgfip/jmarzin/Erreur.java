package com.dgfip.jmarzin;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Erreur {
    String getNomTypeActe() {
        return nomTypeActe;
    }

    private String nomTypeActe;

    String getNomTypeDocument() {
        return nomTypeDocument;
    }

    String getMessage() {
        return message;
    }

    List<JTextField> getChampsTexte() {
        return champsTexte;
    }

    List<JButton> getBoutons() {
        return boutons;
    }

    List<JCheckBox> getCasesACocher() {
        return casesACocher;
    }

    Object getObjetFocus() {
        return objectFocus;
    }

    private Object objectFocus;

    private String nomTypeDocument;
    private String message;
    private List<JTextField> champsTexte = new ArrayList<JTextField>();
    private List<JButton> boutons = new ArrayList<JButton>();
    private List<JCheckBox> casesACocher = new ArrayList<JCheckBox>();
    Erreur(String nomTypeActe, String nomTypeDocument, String message, JTextField champTexte, JButton bouton,
           JCheckBox caseACocher, Object objetFocus) {
        this.nomTypeActe = nomTypeActe;
        this.nomTypeDocument = nomTypeDocument;
        this.message = message;
        if(champTexte != null) this.champsTexte.add(champTexte);
        if(bouton != null) this.boutons.add(bouton);
        if(caseACocher != null) this.casesACocher.add(caseACocher);
        this.objectFocus = objetFocus;
    }
//    void add(JTextField champTexte) {
//        champsTexte.add(champTexte);
//    }
//    void add(JButton bouton) {
//        boutons.add(bouton);
//    }
//    void add(JCheckBox caseACocher) {
//        casesACocher.add(caseACocher);
//    }
}
