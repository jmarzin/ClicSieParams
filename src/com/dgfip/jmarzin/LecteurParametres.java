package com.dgfip.jmarzin;

import com.itextpdf.text.Rectangle;
import org.yaml.snakeyaml.Yaml;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
import java.util.List;

/**
 * Cette classe représente un lecteur de fichier de
 * paramétrage, interprété en yaml.
 *
 * @author Jacques Marzin
 * @version 1.0
 * @since 21 mai 2017
 */
class LecteurParametres {
    /**
     * Indicateur qu'une erreur a été rencontrée
     * pendant la lecture ou l'interprétation
     * du fichier des paramètres.
     */
    private boolean erreur = false;
    boolean isErreur() {
        return erreur;
    }
    /**
     * nom du fichier de paramètres
     */
    private String nomFichier;
    /**
     * Construit le lecteur de paramètres.
     * Les lignes sont lues dans un tableau,
     * transformé en un tableau de chaîne
     * comprenant chacune la structure yaml
     * d'un paramètre. Chaque chaîne est
     * ensuite interprétée.
     *
     * @param nomFichier le fichier des
     *                   paramètres
     */
    LecteurParametres(String nomFichier) {
        //lecture du fichier des paramètres
        this.nomFichier = nomFichier;
        String[] lignes = null;
        try {
            lignes = UtileFichier.lit(nomFichier);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lignes == null) {
            erreur = true;
            return;
        }
        //constitution des chaînes yaml
        int index = -1;
        List<String> parametres = new ArrayList<String>();
        for (String sCurrentLine : lignes) {
            if(sCurrentLine.startsWith("--- ")) {
                parametres.add(sCurrentLine);
                index++;
            } else {
                parametres.set(index,parametres.get(index) + "\n" + sCurrentLine);
            }
        }
        //interprétation des chaînes yaml
        //et mise à jour des structures internes
        //des paramètres interprétés
        Yaml yaml = new Yaml();
        for(String instance : parametres) {
            Object objet = yaml.load(instance);
            if(objet.getClass() == TypeActe.class) {
                TypeActe cT = (TypeActe) objet;
                Map<String, TypeActe> dicoA = TypeActe.getDico();
                dicoA.put(cT.getNom(), cT);
                TypeActe.getListe().add(cT);
            } else {
                TypeDocument cT = (TypeDocument) objet;
                Map<String, TypeDocument> dicoD = TypeDocument.getDico();
                dicoD.put(cT.getNom(), cT);
            }
        }
    }

    static boolean egal(String chaine1, String chaine2) {
        if (chaine1 == null && chaine2 == null) {
            return true;
        }
        if (chaine1 == null || chaine2 == null) {
            return false;
        }
        return chaine1.equals(chaine2);
    }

    void ecritDonnees() {
        String texteFichier = "";
        TypeActe typeActe1 = new TypeActe();
        TypeDocument typeDocument1 = new TypeDocument();
        for (TypeActe typeActe: ClicSieParams.listeTypesActes) {
            texteFichier += "--- !!com.dgfip.jmarzin.TypeActe\n";
            texteFichier += String.format("nom: %s\n", typeActe.getNom());
            if (typeActe.isUtiliseLO() != typeActe1.isUtiliseLO()) {
                texteFichier += String.format("utiliseLO: %s\n",typeActe.isUtiliseLO());
            }
            if (typeActe.getMaxPages() != typeActe1.getMaxPages()) {
                texteFichier += String.format("maxPages: %d\n", typeActe.getMaxPages());
            }
            if (typeActe.isClicEsiPlus() != typeActe1.isClicEsiPlus()) {
                texteFichier += String.format("clicEsiPlus: %s\n", typeActe.isClicEsiPlus());
            }
            ClicSieParams.listeTypesDocumentsOrdonnes = TypeActe.get(typeActe.getNom()).typeCourriersOrdonnes();
            for (TypeDocument typeDocument:ClicSieParams.listeTypesDocumentsOrdonnes) {
                texteFichier += "--- !!com.dgfip.jmarzin.TypeDocument\n";
                texteFichier += String.format("nom: %s\n", typeDocument.getNom());
                texteFichier += String.format("nomTypeActe: %s\n", typeDocument.getNomTypeActe());
                if (typeDocument.getRangTypeActe() != typeDocument1.getRangTypeActe()) {
                    texteFichier += String.format("rangTypeActe: %d\n", typeDocument.getRangTypeActe());
                }
                if (!egal(typeDocument.getChaineType(), typeDocument1.getChaineType())) {
                    texteFichier += String.format("chaineType: %s\n",typeDocument.getChaineType());
                }
                if (!egal(typeDocument.getRegexpCle(), typeDocument1.getRegexpCle())) {
                    texteFichier += String.format("regexpCle: %s\n",typeDocument.getRegexpCle());
                }
                if (!egal(typeDocument.getPrefixeCle(), typeDocument1.getPrefixeCle())) {
                    texteFichier += String.format("prefixeCle: %s\n",typeDocument.getPrefixeCle());
                }
                if (!egal(typeDocument.getChaineSousPlis(), typeDocument1.getChaineSousPlis())) {
                    texteFichier += String.format("chaineSousPlis: %s\n",typeDocument.getChaineSousPlis());
                }
                if (!egal(typeDocument.getChaineService(), typeDocument1.getChaineService())) {
                    texteFichier += String.format("chaineService: %s\n",typeDocument.getChaineService());
                }
                if (typeDocument.isPlusieursPages() != typeDocument1.isPlusieursPages()) {
                    texteFichier += String.format("plusieursPages: %s\n",typeDocument.isPlusieursPages());
                }
                if (typeDocument.isPageImpaire() != typeDocument1.isPageImpaire()) {
                    texteFichier += String.format("pageImpaire: %s\n", typeDocument.isPageImpaire());
                }
                if (typeDocument.getRotation() != typeDocument1.getRotation()) {
                    texteFichier += String.format("rotation: %d\n", typeDocument.getRotation());
                }
                if (!egal(typeDocument.getVersoInsere(), typeDocument1.getVersoInsere())) {
                    texteFichier += String.format("versoInsere: %s\n", typeDocument.getVersoInsere());
                }
                if (typeDocument.getAdresseExp() != null) {
                    Map<String, Map<String, Float>> adresse = (Map<String, Map<String, Float>>) typeDocument.getAdresseExp();
                    texteFichier += String.format(Locale.ROOT,
                            "adresseExp:\n  basGauche:\n    x: %.1f\n    y: %.1f\n  hautDroite:\n    x: %.1f\n    y: %.1f\n",
                            adresse.get("basGauche").get("x"),
                            adresse.get("basGauche").get("y"),
                            adresse.get("hautDroite").get("x"),
                            adresse.get("hautDroite").get("y"));
                }
                if (typeDocument.isDeleteExp() != typeDocument1.isDeleteExp()) {
                    texteFichier += String.format("deleteExp: %s\n", typeDocument.isDeleteExp());
                }
                if (typeDocument.getAdresseDest() != null) {
                    Map<String, Map<String, Float>> adresse = (Map<String, Map<String, Float>>) typeDocument.getAdresseDest();
                    texteFichier += String.format(Locale.ROOT,
                            "adresseDest:\n  basGauche:\n    x: %.1f\n    y: %.1f\n  hautDroite:\n    x: %.1f\n    y: %.1f\n",
                            adresse.get("basGauche").get("x"),
                            adresse.get("basGauche").get("y"),
                            adresse.get("hautDroite").get("x"),
                            adresse.get("hautDroite").get("y"));
                }
                if (typeDocument.isDeleteDest() != typeDocument1.isDeleteDest()) {
                    texteFichier += String.format("deleteDest: %s\n", typeDocument.isDeleteDest());
                }
                if(typeDocument.getPlaceDate() != null) {
                    texteFichier += String.format(Locale.ROOT,"placeDate:\n  x: %.1f\n  y: %.1f\n",
                            typeDocument.getPlaceDate().get("x"),
                            typeDocument.getPlaceDate().get("y"));
                }
                if (typeDocument.getPlaceSignature() != null) {
                    texteFichier += String.format(Locale.ROOT,"placeSignature:\n  x: %.1f\n  y: %.1f\n",
                            typeDocument.getPlaceSignature().get("x"),
                            typeDocument.getPlaceSignature().get("y"));
                }
                if (typeDocument.isAvecGrade() != typeDocument1.isAvecGrade()) {
                    texteFichier += String.format("avecGrade: %s\n", typeDocument.isAvecGrade());
                }
            }
        }
        //new File(this.nomFichier).renameTo(new File(nomFichier.replaceAll(".params", ".bak")));
        System.out.println(texteFichier);
    }
}