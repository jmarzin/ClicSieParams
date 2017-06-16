package com.dgfip.jmarzin;

import java.util.*;

public class TypeDocument {

    private String fichierTest = "";
    String getFichierTest() {
        return fichierTest;
    }
    void setFichierTest(String fichierTest) {
        this.fichierTest = fichierTest;
    }

    private String nom = null;
    String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    String paramNom() {
        return String.format("nom: %s%n",nom);
    }

    private String nomTypeActe = null;
    String getNomTypeActe() {
        return nomTypeActe;
    }
    public void setNomTypeActe(String nomTypeActe) {
        this.nomTypeActe = nomTypeActe;
    }
    String paramNomTypeActe() {
        return String.format("nomTypeActe: %s%n", nomTypeActe);
    }

    private int rangTypeActe = 1;
    int getRangTypeActe() {
        return rangTypeActe;
    }
    public void setRangTypeActe(int rangTypeActe) {
        this.rangTypeActe = rangTypeActe;
    }
    String paramRangTypeActe() {
        if (rangTypeActe == 1) {
            return "";
        } else {
            return String.format("rangTypeActe: %d%n",rangTypeActe);
        }
    }
    private String chaineType = "";
    String getChaineType() {
        return chaineType;
    }
    public void setChaineType(String chaineType) {
        this.chaineType = chaineType;
    }
    String paramChaineType() {
        if (chaineType.isEmpty()) {
            return "";
        } else {
            return String.format("chaineType: %s%n", encadre(chaineType));
        }
    }

    private String regexpCle = "";
    String getRegexpCle() {
        return regexpCle;
    }
    public void setRegexpCle(String regexpCle) {
        this.regexpCle = regexpCle;
    }
    String paramRegexpCle() {
        if (regexpCle == null) {
            return String.format("regexpCle: null%n");
        } else if (regexpCle.isEmpty()) {
            return "";
        } else {
            return String.format("regexpCle: %s%n", encadre(regexpCle));
        }
    }

    private String prefixeCle = "";
    String getPrefixeCle() {
        return prefixeCle;
    }
    public void setPrefixeCle(String prefixeCle) {
        this.prefixeCle = prefixeCle;
    }
    String paramPrefixeCle() {
        if (prefixeCle == null) {
            return String.format("prefixeCle: null%n");
        } else if (prefixeCle.isEmpty()) {
            return "";
        } else {
            return String.format("prefixeCle: %s%n", encadre(prefixeCle));
        }
    }

    private String chaineSousPlis = "";
    String getChaineSousPlis() {
        return chaineSousPlis;
    }
    public void setChaineSousPlis(String chaineSousPlis) {
        this.chaineSousPlis = chaineSousPlis;
    }
    String paramChaineSousPlis() {
        if (chaineSousPlis == null) {
            return String.format("chaineSousPlis: null%n");
        } else if (chaineSousPlis.isEmpty()) {
            return "";
        } else {
            return String.format("chaineSousPlis: %s%n", encadre(chaineSousPlis));
        }
    }

    private String chaineService = null;
    String getChaineService() {
        return chaineService;
    }
    public void setChaineService(String chaineService) {
        this.chaineService = chaineService;
    }
    String paramChaineService() {
        if (chaineService == null) {
            return "";
        } else if (chaineService.isEmpty()) {
            return String.format("chaineService: ''%n");
        } else {
            return String.format("chaineService: %s%n", encadre(chaineService));
        }
    }

    private boolean plusieursPages = false;
    boolean isPlusieursPages() {
        return plusieursPages;
    }
    public void setPlusieursPages(boolean plusieursPages) {
        this.plusieursPages = plusieursPages;
    }
    String paramPlusieursPages() {
        if (plusieursPages) {
            return String.format("plusieursPages: true%n");
        } else {
            return "";
        }
    }

    private boolean pageImpaire = true;
    boolean isPageImpaire() {
        return pageImpaire;
    }
    public void setPageImpaire(boolean pageImpaire) {
        this.pageImpaire = pageImpaire;
    }
    String paramPageImpaire() {
        if (pageImpaire) {
            return "";
        } else {
            return String.format("pageImpaire: false%n");
        }
    }

    private int rotation = 0;
    int getRotation() {
        return rotation;
    }
    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
    String paramRotation() {
        if (rotation == 0) {
            return "";
        } else {
            return String.format("rotation: %d%n", rotation);
        }
    }

    private String versoInsere = null;
    String getVersoInsere() {
        return versoInsere;
    }
    public void setVersoInsere(String versoInsere) {
        this.versoInsere = versoInsere;
    }
    String paramVersoInsere() {
        if (versoInsere == null) {
            return "";
        } else {
            return String.format("versoInsere: %s%n", versoInsere);
        }
    }


    private Object adresseExp = null;
    Object getAdresseExp() {
        return adresseExp;
    }
    public void setAdresseExp(Object adresseExp) {
        this.adresseExp = adresseExp;
    }
    String paramAdresseExp() {
        if (adresseExp == null) {
            return "";
        } else {
            return paramRect("adresseExp", adresseExp);
        }
    }

    private boolean deleteExp = false;
    boolean isDeleteExp() {
        return deleteExp;
    }
    public void setDeleteExp(boolean deleteExp) {
        this.deleteExp = deleteExp;
    }
    String paramDeleteExp() {
        if (deleteExp) {
            return String.format("deleteExp: true%n");
        } else {
            return "";
        }
    }

    private Object adresseDest = null;
    Object getAdresseDest() {
        return adresseDest;
    }
    public void setAdresseDest(Object adresseDest) {
        this.adresseDest = adresseDest;
    }
    String paramAdresseDest() {
        if (adresseDest == null) {
            return "";
        } else {
            return paramRect("adresseDest", adresseDest);
        }
    }
    private boolean deleteDest = false;
    boolean isDeleteDest() {
        return deleteDest;
    }
    public void setDeleteDest(boolean deleteDest) {
        this.deleteDest = deleteDest;
    }
    String paramDeleteDest() {
        if (deleteDest) {
            return String.format("deleteDest: true%n");
        } else {
            return "";
        }
    }

    private Map<String,Float> placeDate = null;
    Map<String,Float> getPlaceDate() {
        return placeDate;
    }
    public void setPlaceDate(Map<String,Float> placeDate) {
        this.placeDate = placeDate;
    }
    String paramPlaceDate() {
        if (placeDate == null) {
            return "";
        } else {
            return paramPlace("placeDate", placeDate);
        }
    }

    private Map<String,Float> placeSignature = null;
    Map<String, Float> getPlaceSignature() {
        return placeSignature;
    }
    public void setPlaceSignature(Map<String, Float> placeSignature) {
        this.placeSignature = placeSignature;
    }
    String paramPlaceSignature() {
        if (placeSignature == null) {
            return "";
        } else {
            return paramPlace("placeSignature", placeSignature);
        }
    }

    private boolean avecGrade = true;
    boolean isAvecGrade() {
        return avecGrade;
    }
    public void setAvecGrade(boolean avecGrade) {
        this.avecGrade = avecGrade;
    }
    String paramAvecGrade() {
        if (avecGrade) {
            return "";
        } else {
            return String.format("avecGrade: false%n");
        }
    }

    private static Map<String,TypeDocument> dico = new HashMap<String, TypeDocument>();
    static Map<String, TypeDocument> getDico() {
        return dico;
    }
    //public static void setDico(Map<String, TypeDocument> dico) {
    //    TypeDocument.dico = dico;
    //}

    TypeDocument(){
    }

    static TypeDocument get(String nom){
        assert (dico.containsKey(nom));
        return dico.get(nom);
    }

//    boolean isVerso() {
//        for(TypeDocument type : values()) {
//            if(type.getVersoInsere() != null && type.getVersoInsere().equals(nom)) {
//                return true;
//            }
//        }
//        return false;
//    }
    private String encadre(String chaine) {
        String retour;
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

//    private static Collection<TypeDocument> values() {
//        return dico.values();
//    }

    static List<Erreur> erreurs(List<Erreur> listeErreurs) {
        return listeErreurs;
    }
}
