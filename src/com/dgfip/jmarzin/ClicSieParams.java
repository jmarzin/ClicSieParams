package com.dgfip.jmarzin;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.sun.org.apache.regexp.internal.RE;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jacquesmarzin on 20/05/2017.
 */
public class ClicSieParams {

    static LinkedList<TypeActe> listeTypesActes;
    static LinkedList<TypeDocument> listeTypesDocumentsOrdonnes;
    static int rangListeTypesActes;
    static int rangListeTypesDocumentsOrdonnes;
    static ClicSieParams params;

    private JPanel panel;
    private JLabel lnomActe;
    private JLabel lClicEsiPlus;
    private JLabel lUtiliseLO;
    private JLabel lMaxPages;
    private JCheckBox clicEsiPlusActe;
    private JCheckBox utiliseLOActe;
    private JTextField maxPagesActe;
    private JLabel lActe;
    private JLabel lTypeDocument;
    private JLabel lNom;
    private JTextField nom;
    private JPanel principal;
    private JLabel lNomTypeActe;
    private JTextField nomTypeActe;
    private JButton typeActePrec;
    private JButton typeActeSuiv;
    private JButton typeDocumentPrec;
    private JButton typeDocumentSuiv;
    private JLabel lRangTypeActe;
    private JTextField rangTypeActe;
    private JLabel lChaineType;
    private JTextField chaineType;
    private JButton testChaineType;
    private JLabel lRegexCle;
    private JTextField regexpCle;
    private JButton testRegexpCle;
    private JButton vueButton;
    private JLabel lChaineSousPlis;
    private JTextField chaineSousPlis;
    private JButton testChaineSousPlis;
    private JLabel lChaineService;
    private JTextField chaineService;
    private JButton testChaineService;
    private JLabel lPrefixeCle;
    private JButton testPrefixeCle;
    private JTextField prefixeCle;
    private JCheckBox plusieursPages;
    private JLabel lPlusieursPage;
    private JLabel lPageImpaire;
    private JCheckBox pageImpaire;
    private JLabel lRotation;
    private JTextField rotation;
    private JButton testRotation;
    private JLabel lVersoInsere;
    private JButton testVersoInsere;
    private JTextField versoInsere;
    private JLabel lAdresseExp;
    private JLabel lAdresseExpBasGauche;
    private JLabel lAdrExpBGx;
    private JTextField adresseExpBasGaucheX;
    private JLabel lAdrExpBGy;
    private JTextField adresseExpBasGaucheY;
    private JButton testAdresseExp;
    private JLabel lAdrExpHD;
    private JLabel lAdrExpHDx;
    private JTextField adresseExpHautDroiteX;
    private JLabel lAdrExpHDy;
    private JTextField adresseExpHautDroiteY;
    private JLabel lDeleteExp;
    private JButton testDeleteExp;
    private JCheckBox deleteExp;
    private JLabel lAdresseDest;
    private JButton testAdresseDest;
    private JLabel lAdrDestBG;
    private JLabel lAdrDestBGx;
    private JTextField adresseDestBasGaucheX;
    private JLabel lAdrDestBGy;
    private JTextField adresseDestBasGaucheY;
    private JLabel lAdrDestHD;
    private JLabel lAdrDestHDx;
    private JTextField adresseDestHautDroiteX;
    private JLabel lAdrDestHDy;
    private JTextField adresseDestHautDroiteY;
    private JLabel lDeleteDest;
    private JButton testDeleteDest;
    private JCheckBox deleteDest;
    private JLabel lPlaceDate;
    private JButton testPlaceDate;
    private JLabel lPlaceDateX;
    private JTextField placeDateX;
    private JLabel lPlaceDateY;
    private JTextField placeDateY;
    private JLabel lPlaceSignature;
    private JLabel lPlaceSignatureX;
    private JButton testPlaceSignature;
    private JTextField placeSignatureX;
    private JLabel lPlaceSignatureY;
    private JTextField placeSignatureY;
    private JLabel lAvecGrade;
    private JButton testAvecGrade;
    private JCheckBox avecGrade;
    private JTextField nomActe;
    private JTextField fichierTest;
    private JLabel lFichierTest;
    private JButton fileChoose;
    private JButton delTypeActe;
    private JButton insTypeActe;
    private JButton delTypeDocument;
    private JButton insTypeDocument;
    private JButton enregistreLeFichier;
    private JButton abandonne;

    public ClicSieParams() {

        typeActeSuiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rangListeTypesActes++;
                listeTypesDocumentsOrdonnes = TypeActe.get(listeTypesActes.get(rangListeTypesActes).getNom()).typeCourriersOrdonnes();
                rangListeTypesDocumentsOrdonnes = 0;
                params.nomActe.requestFocus();
                setData(params);
            }
        });
        typeActePrec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rangListeTypesActes--;
                listeTypesDocumentsOrdonnes = TypeActe.get(listeTypesActes.get(rangListeTypesActes).getNom()).typeCourriersOrdonnes();
                rangListeTypesDocumentsOrdonnes = 0;
                params.nomActe.requestFocus();
                setData(params);
            }
        });
        abandonne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Oui","Non"};
                int dialogResult = JOptionPane.showOptionDialog(null,
                        "Vous voulez vraiment abandonner ?","Attention",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,
                        null,options,0);
                if(dialogResult == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        typeDocumentPrec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rangListeTypesDocumentsOrdonnes--;
                params.nom.requestFocus();
                setData(params);
            }
        });
        typeDocumentSuiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rangListeTypesDocumentsOrdonnes++;
                params.nom.requestFocus();
                setData(params);
            }
        });
        insTypeActe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Après","Avant"};
                int dialogResult = JOptionPane.showOptionDialog(null,
                        "Où placer le nouveau type d'acte ?","Attention",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,
                        null,options,0);
                int index = dialogResult == 0 ? rangListeTypesActes + 1 : rangListeTypesActes;
                TypeActe typeActe = new TypeActe();
                typeActe.setNom("nouveau type d'acte");
                listeTypesActes.add(index, typeActe);
                TypeActe.getDico().put(typeActe.getNom(),typeActe);
                rangListeTypesActes = index;
                TypeDocument typeDocument = new TypeDocument();
                typeDocument.setNom("nouveau type de document");
                typeDocument.setNomTypeActe("nouveau type d'acte");
                TypeDocument.getDico().put(typeDocument.getNom(),typeDocument);
                params.nomActe.requestFocus();
                rangListeTypesDocumentsOrdonnes = 0;
                listeTypesDocumentsOrdonnes = typeActe.typeCourriersOrdonnes();
                setData(params);
            }
        });
        delTypeActe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Non","Oui"};
                int dialogResult = JOptionPane.showOptionDialog(null,
                        "Vous voulez vraiment supprimer ce type d'acte ?","Attention",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,
                        null,options,0);
                if(dialogResult == 1){
                    List<String> clesASupprimer = new ArrayList<String>();
                    for (String cle : TypeDocument.getDico().keySet()) {
                        if(TypeDocument.getDico().get(cle).getNomTypeActe().equals(
                                listeTypesActes.get(rangListeTypesActes).getNom())) {
                                    clesASupprimer.add(cle);
                        }
                    }
                    for (String cle : clesASupprimer) {
                        TypeDocument.getDico().remove(cle);
                    }
                    TypeActe.getDico().remove(listeTypesActes.get(rangListeTypesActes).getNom());
                    listeTypesActes.remove(rangListeTypesActes);
                    if(rangListeTypesActes >= listeTypesActes.size()) {
                        rangListeTypesActes--;
                    }
                    listeTypesDocumentsOrdonnes = listeTypesActes.get(rangListeTypesActes).typeCourriersOrdonnes();
                    rangListeTypesDocumentsOrdonnes = 0;
                    setData(params);
                }
            }
        });
        insTypeDocument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TypeDocument typeDocument = new TypeDocument();
                typeDocument.setNom("nouveau type de document");
                typeDocument.setNomTypeActe(listeTypesActes.get(rangListeTypesActes).getNom());
                TypeDocument.getDico().put(typeDocument.getNom(),typeDocument);
                params.nomActe.requestFocus();
                listeTypesDocumentsOrdonnes = listeTypesActes.get(rangListeTypesActes).typeCourriersOrdonnes();
                setData(params);
            }
        });
        delTypeDocument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Non","Oui"};
                int dialogResult = JOptionPane.showOptionDialog(null,
                        "Vous voulez vraiment supprimer ce type de document ?","Attention",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,
                        null,options,0);
                if(dialogResult == 1){
                    TypeDocument.getDico().remove(listeTypesDocumentsOrdonnes.get(rangListeTypesDocumentsOrdonnes).getNom());
                    listeTypesDocumentsOrdonnes.remove(rangListeTypesDocumentsOrdonnes);
                    if(rangListeTypesDocumentsOrdonnes >= listeTypesDocumentsOrdonnes.size()) {
                        rangListeTypesDocumentsOrdonnes--;
                    }
                    setData(params);
                }
            }
        });
        fileChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier test", "pdf");
                final JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(filter);
                int returnVal = fileChooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    params.fichierTest.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });
        vueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PdfReader lecteurPdf = fichierTest();
                String chaine = getChaine(lecteurPdf, 1);
                JTextArea textArea = new JTextArea(20, 60);
                textArea.setText(chaine);
                textArea.setEditable(true);
                // wrap a scrollpane around it
                JScrollPane scrollPane = new JScrollPane(textArea);
                // display them in a message dialog
                JOptionPane.showMessageDialog(null, scrollPane, "Texte contenu dans la 1ere page",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        testChaineType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PdfReader lecteurPdf = fichierTest();
                String chaine = getChaine(lecteurPdf,1);
                Pattern pattern = Pattern.compile(params.chaineType.getText(), Pattern.MULTILINE | Pattern.DOTALL);
                Matcher matcher = pattern.matcher(chaine);
                if(matcher.matches()) {
                    params.chaineType.setBackground(Color.WHITE);
                    params.testChaineType.setForeground(Color.GREEN);
                    JOptionPane.showMessageDialog(null, "Le fichier est correctement identifié",
                            "Succès", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    params.chaineType.setBackground(Color.RED);
                    params.testChaineType.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, "Le fichier n'est pas identifié",
                            "Echec", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    PdfReader fichierTest() {
        if (params.fichierTest.getText().isEmpty()) {
            params.fichierTest.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null,
                "Aucun fichier n'est indiqué !",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
            return null;
        }
        File fichier = new File(params.fichierTest.getText());
        if (!fichier.exists()) {
            params.fichierTest.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null,
                "Le fichier n'existe pas !",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
            return null;
        }
        PdfReader lecteurPdf;
        try {
            lecteurPdf = new PdfReader(fichier.getAbsolutePath());
        } catch (IOException e1) {
            e1.printStackTrace();
            params.fichierTest.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null,
                "Le fichier n'existe pas !",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
            return null;
        }
        params.fichierTest.setBackground(Color.WHITE);
        return lecteurPdf;
    }

    String getChaine(PdfReader lecteurPdf, int page) {
        String chaine = "";
        try {
            chaine = PdfTextExtractor.getTextFromPage(lecteurPdf, page);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chaine;
    }

    public static void main(String[] args) {
        //Choix du fichier de paramètres
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier Paramètres", "params");
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Sélectionner le fichier des paramètres");
        int returnVal = fileChooser.showOpenDialog(null);
        if(returnVal != JFileChooser.APPROVE_OPTION) {
            System.exit(0);
        }
        LecteurParametres lecteurParametres = new LecteurParametres(fileChooser.getSelectedFile().getAbsolutePath());
        if(lecteurParametres.isErreur()) {
            JOptionPane.showMessageDialog(null,
                    "Le fichier ClicSie.params est absent.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        listeTypesActes = TypeActe.getListe();
        rangListeTypesActes = 0;
        listeTypesDocumentsOrdonnes = TypeActe.get(listeTypesActes.get(rangListeTypesActes).getNom()).typeCourriersOrdonnes();
        rangListeTypesDocumentsOrdonnes = 0;

        JFrame frame = new JFrame("Paramétrage");
        params = new ClicSieParams();
        frame.setContentPane(params.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        params.nomActe.requestFocus();
        setData(params);
        frame.setVisible(true);
    }

    public static void setData(ClicSieParams data) {
        TypeActe typeActe = listeTypesActes.get(rangListeTypesActes);
        data.nomActe.setText(typeActe.getNom());
        data.utiliseLOActe.setSelected(typeActe.isUtiliseLO());
        data.clicEsiPlusActe.setSelected(typeActe.isClicEsiPlus());
        data.maxPagesActe.setText(String.valueOf(typeActe.getMaxPages()));
        data.typeActePrec.setEnabled(rangListeTypesActes > 0);
        data.typeActeSuiv.setEnabled(rangListeTypesActes < listeTypesActes.size() - 1);
        data.delTypeActe.setEnabled(listeTypesActes.size() > 1);
        TypeDocument typeDocument = listeTypesDocumentsOrdonnes.get(rangListeTypesDocumentsOrdonnes);
        data.fichierTest.setText(typeDocument.getFichierTest());
        data.nom.setText(typeDocument.getNom());
        data.nomTypeActe.setText(typeDocument.getNomTypeActe());
        data.rangTypeActe.setText(String.valueOf(typeDocument.getRangTypeActe()));
        data.chaineType.setText(typeDocument.getChaineType());
        data.regexpCle.setText(typeDocument.getRegexpCle());
        data.prefixeCle.setText(typeDocument.getPrefixeCle());
        data.chaineSousPlis.setText(typeDocument.getChaineSousPlis());
        data.chaineService.setText(typeDocument.getChaineService() == null ? "null" : typeDocument.getChaineService());
        data.plusieursPages.setSelected(typeDocument.isPlusieursPages());
        data.pageImpaire.setSelected(typeDocument.isPageImpaire());
        data.rotation.setText(String.valueOf(typeDocument.getRotation()));
        data.versoInsere.setText(typeDocument.getVersoInsere() == null ? "null" : typeDocument.getVersoInsere());
        if (typeDocument.getAdresseExp() == null) {
            data.adresseExpBasGaucheX.setText("");
            data.adresseExpBasGaucheY.setText("");
            data.adresseExpHautDroiteX.setText("");
            data.adresseExpHautDroiteY.setText("");
        } else {
            LinkedHashMap<String, LinkedHashMap<String, Double>> adresse =
                    (LinkedHashMap<String, LinkedHashMap<String, Double>>) typeDocument.getAdresseExp();
            data.adresseExpBasGaucheX.setText(String.valueOf(adresse.get("basGauche").get("x")));
            data.adresseExpBasGaucheY.setText(String.valueOf(adresse.get("basGauche").get("y")));
            data.adresseExpHautDroiteX.setText(String.valueOf(adresse.get("hautDroite").get("x")));
            data.adresseExpHautDroiteY.setText(String.valueOf(adresse.get("hautDroite").get("y")));
        }
        data.deleteExp.setSelected(typeDocument.isDeleteExp());
        if (typeDocument.getAdresseDest() == null) {
            data.adresseDestBasGaucheX.setText("");
            data.adresseDestBasGaucheY.setText("");
            data.adresseDestHautDroiteX.setText("");
            data.adresseDestHautDroiteY.setText("");
        } else {
            LinkedHashMap<String, LinkedHashMap<String, Double>> adresse =
                    (LinkedHashMap<String, LinkedHashMap<String, Double>>) typeDocument.getAdresseDest();
            data.adresseDestBasGaucheX.setText(String.valueOf(adresse.get("basGauche").get("x")));
            data.adresseDestBasGaucheY.setText(String.valueOf(adresse.get("basGauche").get("y")));
            data.adresseDestHautDroiteX.setText(String.valueOf(adresse.get("hautDroite").get("x")));
            data.adresseDestHautDroiteY.setText(String.valueOf(adresse.get("hautDroite").get("y")));
        }
        data.deleteDest.setSelected(typeDocument.isDeleteDest());
        if(typeDocument.getPlaceDate() == null) {
            data.placeDateX.setText("");
            data.placeDateY.setText("");
        } else {
            data.placeDateX.setText(String.valueOf(typeDocument.getPlaceDate().get("x")));
            data.placeDateY.setText(String.valueOf(typeDocument.getPlaceDate().get("y")));
        }
        if(typeDocument.getPlaceSignature() == null) {
            data.placeSignatureX.setText("");
            data.placeSignatureY.setText("");
        } else {
            data.placeSignatureX.setText(String.valueOf(typeDocument.getPlaceSignature().get("x")));
            data.placeSignatureY.setText(String.valueOf(typeDocument.getPlaceSignature().get("y")));
        }
        data.avecGrade.setSelected(typeDocument.isAvecGrade());
        data.typeDocumentPrec.setEnabled(rangListeTypesDocumentsOrdonnes > 0);
        data.typeDocumentSuiv.setEnabled(rangListeTypesDocumentsOrdonnes < listeTypesDocumentsOrdonnes.size() - 1);
        data.delTypeDocument.setEnabled(listeTypesDocumentsOrdonnes.size() > 1);
    }

    public void getData(ClicSieParams data) {
    }

    public boolean isModified(ClicSieParams data) {
        return false;
    }
}
