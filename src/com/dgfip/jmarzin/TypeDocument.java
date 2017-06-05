package com.dgfip.jmarzin;

import javax.swing.*;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.dgfip.jmarzin.ClicSieParams.listeTypesActes;
import static com.dgfip.jmarzin.ClicSieParams.params;

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

    //private TypeActe typeActe;
    //public TypeActe getTypeActe() {
    //    return typeActe;
    //}
    //public void setTypeActe(TypeActe typeActe) {
    //    this.typeActe = typeActe;
    //}

    private String nomTypeActe = null;
    public String getNomTypeActe() {
        return nomTypeActe;
    }
    public void setNomTypeActe(String nomTypeActe) {
        this.nomTypeActe = nomTypeActe;
    //    this.typeActe = TypeActe.get(nomTypeActe);
    }

    private int rangTypeActe = 1;
    public int getRangTypeActe() {
        return rangTypeActe;
    }
    public void setRangTypeActe(int rangTypeActe) {
        this.rangTypeActe = rangTypeActe;
    }

    private String chaineType = "";
    public String getChaineType() {
        return chaineType;
    }
    public void setChaineType(String chaineType) {
        this.chaineType = chaineType;
    }

    private String regexpCle = "";
    public String getRegexpCle() {
        return regexpCle;
    }
    public void setRegexpCle(String regexpCle) {
        this.regexpCle = regexpCle;
    }

    private String prefixeCle = "";
    public String getPrefixeCle() {
        return prefixeCle;
    }
    public void setPrefixeCle(String prefixeCle) {
        this.prefixeCle = prefixeCle;
    }

    private String chaineSousPlis = "";
    public String getChaineSousPlis() {
        return chaineSousPlis;
    }
    public void setChaineSousPlis(String chaineSousPlis) {
        this.chaineSousPlis = chaineSousPlis;
    }

    private String chaineService = null;
    public String getChaineService() {
        return chaineService;
    }
    public void setChaineService(String chaineService) {
        this.chaineService = chaineService;
    }

    private boolean plusieursPages = false;
    public boolean isPlusieursPages() {
        return plusieursPages;
    }
    public void setPlusieursPages(boolean plusieursPages) {
        this.plusieursPages = plusieursPages;
    }

    private boolean pageImpaire = true;
    public boolean isPageImpaire() {
        return pageImpaire;
    }
    public void setPageImpaire(boolean pageImpaire) {
        this.pageImpaire = pageImpaire;
    }

    private int rotation = 0;
    public int getRotation() {
        return rotation;
    }
    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    private String versoInsere = null;
    public String getVersoInsere() {
        return versoInsere;
    }
    public void setVersoInsere(String versoInsere) {
        this.versoInsere = versoInsere;
    }

    private Object adresseExp = null;
    public Object getAdresseExp() {
        return adresseExp;
    }
    public void setAdresseExp(Object adresseExp) {
        this.adresseExp = adresseExp;
    }

    private boolean deleteExp = false;
    public boolean isDeleteExp() {
        return deleteExp;
    }
    public void setDeleteExp(boolean deleteExp) {
        this.deleteExp = deleteExp;
    }

    private Object adresseDest = null;
    public Object getAdresseDest() {
        return adresseDest;
    }
    public void setAdresseDest(Object adresseDest) {
        this.adresseDest = adresseDest;
    }

    private boolean deleteDest = false;
    public boolean isDeleteDest() {
        return deleteDest;
    }
    public void setDeleteDest(boolean deleteDest) {
        this.deleteDest = deleteDest;
    }

    private Map<String,Float> placeDate = null;
    public Map<String,Float> getPlaceDate() {
        return placeDate;
    }
    public void setPlaceDate(Map<String,Float> placeDate) {
        this.placeDate = placeDate;
        //if (placeDate != null) {
        //    this.placeDate.put("x", this.placeDate.get("x"));
        //    this.placeDate.put("y", this.placeDate.get("y"));
        //}
    }
    private Map<String,Float> placeSignature = null;
    public Map<String, Float> getPlaceSignature() {
        return placeSignature;
    }
    public void setPlaceSignature(Map<String, Float> placeSignature) {
        this.placeSignature = placeSignature;
        //if (placeSignature != null) {
        //    this.placeSignature.put("x", this.placeSignature.get("x"));
        //    this.placeSignature.put("y", this.placeSignature.get("y"));
        //}
    }
    private boolean avecGrade = true;
    public boolean isAvecGrade() {
        return avecGrade;
    }
    public void setAvecGrade(boolean avecGrade) {
        this.avecGrade = avecGrade;
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
    static Collection<TypeDocument> values() {
        return dico.values();
    }

    static List<Erreur> erreurs(List<Erreur> listeErreurs) {
        return listeErreurs;
    }
}
