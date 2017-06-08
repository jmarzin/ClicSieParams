package com.dgfip.jmarzin;

import com.itextpdf.text.Rectangle;
import org.yaml.snakeyaml.Yaml;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
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
            lignes = UtileFichier.lit(nomFichier).split("\n");
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
            texteFichier += String.format("--- !!com.dgfip.jmarzin.TypeActe%n") +
                    typeActe.paramNom() +
                    typeActe.paramUtiliseLO() +
                    typeActe.paramMaxPages() +
                    typeActe.paramClicEsiPlus();
            ClicSieParams.listeTypesDocumentsOrdonnes = TypeActe.get(typeActe.getNom()).typeCourriersOrdonnes();
            String chaine = "";
            for (TypeDocument typeDocument:ClicSieParams.listeTypesDocumentsOrdonnes) {
                texteFichier += String.format("--- !!com.dgfip.jmarzin.TypeDocument%n") +
                        typeDocument.paramNom() +
                        typeDocument.paramNomTypeActe() +
                        typeDocument.paramRangTypeActe() +
                        typeDocument.paramChaineType() +
                        typeDocument.paramRegexpCle() +
                        typeDocument.paramPrefixeCle() +
                        typeDocument.paramChaineSousPlis() +
                        typeDocument.paramChaineService() +
                        typeDocument.paramPlusieursPages() +
                        typeDocument.paramPageImpaire() +
                        typeDocument.paramRotation() +
                        typeDocument.paramVersoInsere() +
                        typeDocument.paramAdresseExp() +
                        typeDocument.paramDeleteExp() +
                        typeDocument.paramAdresseDest() +
                        typeDocument.paramDeleteDest() +
                        typeDocument.paramPlaceDate() +
                        typeDocument.paramPlaceSignature() +
                        typeDocument.paramAvecGrade();
            }
        }
        File fichier = new File(this.nomFichier);
        fichier.renameTo(new File(nomFichier.replaceAll(".params", ".bak")));
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fichier);
            byte[] b = texteFichier.getBytes(Charset.forName("UTF8"));
            outputStream.write(b);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}