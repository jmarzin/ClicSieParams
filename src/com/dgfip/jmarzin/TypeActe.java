package com.dgfip.jmarzin;

import java.util.*;

import static com.dgfip.jmarzin.ClicSieParams.listeTypesActes;
import static com.dgfip.jmarzin.ClicSieParams.params;

/**
 * Created by jmarzin-cp on 16/05/2017.
 */
public class TypeActe {

    private String nom;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String paramNom() {
        return String.format("nom: %s%n", nom);
    }

    private boolean utiliseLO = false;
    public boolean isUtiliseLO() {
        return utiliseLO;
    }
    public void setUtiliseLO(boolean utiliseLO) {
        this.utiliseLO = utiliseLO;
    }
    public String paramUtiliseLO() {
        if (utiliseLO) {
            return String.format("utiliseLO: true%n");
        } else {
            return "";
        }
    }

    private int maxPages = 0;
    public int getMaxPages() {
        return maxPages;
    }
    public void setMaxPages(int maxPages) {
        this.maxPages = maxPages;
    }
    public String paramMaxPages() {
        if (maxPages > 0) {
            return String.format("maxPages: %d%n",maxPages);
        } else {
            return "";
        }
    }

    private boolean clicEsiPlus = true;
    public boolean isClicEsiPlus() {
        return clicEsiPlus;
    }
    public void setClicEsiPlus(boolean clicEsiPlus) {
        this.clicEsiPlus = clicEsiPlus;
    }
    public String paramClicEsiPlus() {
        if (clicEsiPlus) {
             return "";
        } else {
            return String.format("clicEsiPlus: false%n");
        }
    }

    private static Map<String,TypeActe> dico = new HashMap<String, TypeActe>();
    public static Map<String, TypeActe> getDico() {
        return dico;
    }
    public static void setDico(Map<String, TypeActe> dico) {
        TypeActe.dico = dico;
    }

    private static LinkedList<TypeActe> liste = new LinkedList<TypeActe>();
    public static LinkedList<TypeActe> getListe() {
        return liste;
    }

    TypeActe(){
    }

    static Collection<TypeActe> values() {
        return dico.values();
    }

    static TypeActe get(String nom){
        assert (dico.containsKey(nom));
        return dico.get(nom);
    }

    LinkedList<TypeDocument> typeCourriersOrdonnes() {
        Map<Integer, TypeDocument> dicoTypesParActe = new HashMap<Integer, TypeDocument>();
        //complement au rang dans le type d'Acte pour éviter de perdre les doublons
        int i = 0;
        for(String entree : TypeDocument.getDico().keySet()) {
            if (TypeDocument.getDico().get(entree).getNomTypeActe().equals(this.getNom())) {
                dicoTypesParActe.put(TypeDocument.getDico().get(entree).getRangTypeActe()*1000 + i,TypeDocument.getDico().get(entree));
            }
            i++;
        }
        Object[] cles = dicoTypesParActe.keySet().toArray();
        Arrays.sort(cles);
        LinkedList<TypeDocument> typeDocumentList = new LinkedList<TypeDocument>();
        for(Object cle : cles) {
            typeDocumentList.add(dicoTypesParActe.get(cle));
        }
        return typeDocumentList;
    }

    static List<Erreur> erreurs(List<Erreur> listeErreurs) {
        return listeErreurs;
    }
}
