package com.dgfip.jmarzin;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmarzin-cp on 31/05/2017.
 */
public class Erreur {
    public String getNomTypeActe() {
        return nomTypeActe;
    }

    private String nomTypeActe;

    public String getNomTypeDocument() {
        return nomTypeDocument;
    }

    public String getMessage() {
        return message;
    }

    public List<JTextField> getChampsTexte() {
        return champsTexte;
    }

    public List<JButton> getBoutons() {
        return boutons;
    }

    public List<JCheckBox> getCasesACocher() {
        return casesACocher;
    }

    public Object getObjetFocus() {
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
    void add(JTextField champTexte) {
        champsTexte.add(champTexte);
    }
    void add(JButton bouton) {
        boutons.add(bouton);
    }
    void add(JCheckBox caseACocher) {
        casesACocher.add(caseACocher);
    }
}
