package com.dgfip.jmarzin;

import sun.misc.Regexp;

import javax.swing.*;
import java.lang.reflect.Type;
import java.util.*;

import static com.dgfip.jmarzin.ClicSieParams.listeTypesActes;
import static com.dgfip.jmarzin.ClicSieParams.params;
import static com.dgfip.jmarzin.ClicSieParams.rangListeTypesDocumentsOrdonnes;

/**
 * Created by jmarzin-cp on 13/05/2017.
 */
public class TypeDocument {

    private String fichierTest = "";
    public String getFichierTest() {
        return fichierTest;
    }

    public void setFichierTest(String fichierTest) {
        this.fichierTest = fichierTest;
    }

    private String nom = null;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String paramNom() {
        return String.format("nom: %s%n",nom);
    }

    private String nomTypeActe = null;
    public String getNomTypeActe() {
        return nomTypeActe;
    }
    public void setNomTypeActe(String nomTypeActe) {
        this.nomTypeActe = nomTypeActe;
    }
    public String paramNomTypeActe() {
        return String.format("nomTypeActe: %s%n", nomTypeActe);
    }

    private int rangTypeActe = 1;
    public int getRangTypeActe() {
        return rangTypeActe;
    }
    public void setRangTypeActe(int rangTypeActe) {
        this.rangTypeActe = rangTypeActe;
    }
    public String paramRangTypeActe() {
        if (rangTypeActe == 1) {
            return "";
        } else {
            return String.format("rangTypeActe: %d%n",rangTypeActe);
        }
    }
    private String chaineType = "";
    public String getChaineType() {
        return chaineType;
    }
    public void setChaineType(String chaineType) {
        this.chaineType = chaineType;
    }
    public String paramChaineType() {
        if (chaineType.isEmpty()) {
            return "";
        } else {
            return String.format("chaineType: %s%n", encadre(chaineType));
        }
    }

    private String regexpCle = "";
    public String getRegexpCle() {
        return regexpCle;
    }
    public void setRegexpCle(String regexpCle) {
        this.regexpCle = regexpCle;
    }
    public String paramRegexpCle() {
        if (regexpCle == null) {
            return String.format("regexpCle: null%n");
        } else if (regexpCle.isEmpty()) {
            return "";
        } else {
            return String.format("regexpCle: %s%n", encadre(regexpCle));
        }
    }

    private String prefixeCle = "";
    public String getPrefixeCle() {
        return prefixeCle;
    }
    public void setPrefixeCle(String prefixeCle) {
        this.prefixeCle = prefixeCle;
    }
    public String paramPrefixeCle() {
        if (prefixeCle == null) {
            return String.format("prefixeCle: null%n");
        } else if (prefixeCle.isEmpty()) {
            return "";
        } else {
            return String.format("prefixeCle: %s%n", encadre(prefixeCle));
        }
    }

    private String chaineSousPlis = "";
    public String getChaineSousPlis() {
        return chaineSousPlis;
    }
    public void setChaineSousPlis(String chaineSousPlis) {
        this.chaineSousPlis = chaineSousPlis;
    }
    public String paramChaineSousPlis() {
        if (chaineSousPlis == null) {
            return String.format("chaineSousPlis: null%n");
        } else if (chaineSousPlis.isEmpty()) {
            return "";
        } else {
            return String.format("chaineSousPlis: %s%n", encadre(chaineSousPlis));
        }
    }

    private String chaineService = null;
    public String getChaineService() {
        return chaineService;
    }
    public void setChaineService(String chaineService) {
        this.chaineService = chaineService;
    }
    public String paramChaineService() {
        if (chaineService == null) {
            return "";
        } else if (chaineService.isEmpty()) {
            return String.format("chaineService: ''%n");
        } else {
            return String.format("chaineService: %s%n", encadre(chaineService));
        }
    }

    private boolean plusieursPages = false;
    public boolean isPlusieursPages() {
        return plusieursPages;
    }
    public void setPlusieursPages(boolean plusieursPages) {
        this.plusieursPages = plusieursPages;
    }
    public String paramPlusieursPages() {
        if (plusieursPages) {
            return String.format("plusieursPages: true%n");
        } else {
            return "";
        }
    }

    private boolean pageImpaire = true;
    public boolean isPageImpaire() {
        return pageImpaire;
    }
    public void setPageImpaire(boolean pageImpaire) {
        this.pageImpaire = pageImpaire;
    }
    public String paramPageImpaire() {
        if (pageImpaire) {
            return "";
        } else {
            return String.format("pageImpaire: false%n");
        }
    }

    private int rotation = 0;
    public int getRotation() {
        return rotation;
    }
    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
    public String paramRotation() {
        if (rotation == 0) {
            return "";
        } else {
            return String.format("rotation: %d%n", rotation);
        }
    }

    private String versoInsere = null;
    public String getVersoInsere() {
        return versoInsere;
    }
    public void setVersoInsere(String versoInsere) {
        this.versoInsere = versoInsere;
    }
    public String paramVersoInsere() {
        if (versoInsere == null) {
            return "";
        } else {
            return String.format("versoInsere: %s%n", versoInsere);
        }
    }


    private Object adresseExp = null;
    public Object getAdresseExp() {
        return adresseExp;
    }
    public void setAdresseExp(Object adresseExp) {
        this.adresseExp = adresseExp;
    }
    public String paramAdresseExp() {
        if (adresseExp == null) {
            return "";
        } else {
            return paramRect("adresseExp", adresseExp);
        }
    }

    private boolean deleteExp = false;
    public boolean isDeleteExp() {
        return deleteExp;
    }
    public void setDeleteExp(boolean deleteExp) {
        this.deleteExp = deleteExp;
    }
    public String paramDeleteExp() {
        if (deleteExp) {
            return String.format("deleteExp: true%n");
        } else {
            return "";
        }
    }

    private Object adresseDest = null;
    public Object getAdresseDest() {
        return adresseDest;
    }
    public void setAdresseDest(Object adresseDest) {
        this.adresseDest = adresseDest;
    }
    public String paramAdresseDest() {
        if (adresseDest == null) {
            return "";
        } else {
            return paramRect("adresseDest", adresseDest);
        }
    }
    private boolean deleteDest = false;
    public boolean isDeleteDest() {
        return deleteDest;
    }
    public void setDeleteDest(boolean deleteDest) {
        this.deleteDest = deleteDest;
    }
    public String paramDeleteDest() {
        if (deleteExp) {
            return String.format("deleteDest: true%n");
        } else {
            return "";
        }
    }

    private Map<String,Float> placeDate = null;
    public Map<String,Float> getPlaceDate() {
        return placeDate;
    }
    public void setPlaceDate(Map<String,Float> placeDate) {
        this.placeDate = placeDate;
    }
    public String paramPlaceDate() {
        if (placeDate == null) {
            return "";
        } else {
            return paramPlace("placeDate", placeDate);
        }
    }

    private Map<String,Float> placeSignature = null;
    public Map<String, Float> getPlaceSignature() {
        return placeSignature;
    }
    public void setPlaceSignature(Map<String, Float> placeSignature) {
        this.placeSignature = placeSignature;
    }
    public String paramPlaceSignature() {
        if (placeSignature == null) {
            return "";
        } else {
            return paramPlace("placeSignature", placeSignature);
        }
    }

    private boolean avecGrade = true;
    public boolean isAvecGrade() {
        return avecGrade;
    }
    public void setAvecGrade(boolean avecGrade) {
        this.avecGrade = avecGrade;
    }
    public String paramAvecGrade() {
        if (avecGrade) {
            return "";
        } else {
            return String.format("avecGrade: false%n");
        }
    }

    private static Map<String,TypeDocument> dico = new HashMap<String, TypeDocument>();
    public static Map<String, TypeDocument> getDico() {
        return dico;
    }
    public static void setDico(Map<String, TypeDocument> dico) {
        TypeDocument.dico = dico;
    }

    TypeDocument(){
    }

    static TypeDocument get(String nom){
        assert (dico.containsKey(nom));
        return dico.get(nom);
    }

    boolean isVerso() {
        for(TypeDocument type : values()) {
            if(type.getVersoInsere() != null && type.getVersoInsere().equals(nom)) {
                return true;
            }
        }
        return false;
    }
    private String encadre(String chaine) {
        String retour = "";
        if (chaine.contains(":")) {
            if (chaine.contains("'")) {
                retour = ('"' + chaine + '"').replaceAll(new String("\\"), "\\\\");
            } else {
                retour = "'" + chaine + "'";
            }
        } else {
            retour = chaine;
        }
        return retour;
    }

    private String paramRect(String texte, Object adresse) {
        Map<String, Map<String, Float>> rect = (Map<String, Map<String, Float>>) adresse;
        return String.format(Locale.ROOT,
                "%s:%n  basGauche:%n    x: %.1f%n    y: %.1f%n  hautDroite:%n    x: %.1f%n    y: %.1f%n",
                texte,
                rect.get("basGauche").get("x"),
                rect.get("basGauche").get("y"),
                rect.get("hautDroite").get("x"),
                rect.get("hautDroite").get("y"));
    }
    private String paramPlace(String texte, Map<String, Float> place) {
        return String.format(Locale.ROOT,
                "%s:%n  x: %.1f%n  y: %.1f%n",
                texte,
                place.get("x"),
                place.get("y"));
    }

    static Collection<TypeDocument> values() {
        return dico.values();
    }

    static List<Erreur> erreurs(List<Erreur> listeErreurs) {
        return listeErreurs;
    }
}
