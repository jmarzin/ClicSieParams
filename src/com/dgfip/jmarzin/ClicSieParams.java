package com.dgfip.jmarzin;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.pdfcleanup.PdfCleanUpLocation;
import com.itextpdf.text.pdf.pdfcleanup.PdfCleanUpProcessor;
import org.apache.commons.io.IOUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClicSieParams {

    static LinkedList<TypeActe> listeTypesActes;
    static LinkedList<TypeDocument> listeTypesDocumentsOrdonnes;
    static int rangListeTypesActes;
    static int rangListeTypesDocumentsOrdonnes;
    static ClicSieParams params;
    private static String repertoire = "";
    private static LecteurParametres lecteurParametres;
    private JPanel panel;
    private JLabel lnomActe;
    private JLabel lClicEsiPlus;
    private JLabel lUtiliseLO;
    private JLabel lMaxPages;
    private JCheckBox clicEsiPlusActe;
    private JCheckBox utiliseLOActe;
    public JTextField maxPagesActe;
    private JLabel lActe;
    private JLabel lTypeDocument;
    private JLabel lNom;
    public JTextField nom;
    private JPanel principal;
    private JLabel lNomTypeActe;
    public JTextField nomTypeActe;
    private JButton typeActePrec;
    private JButton typeActeSuiv;
    private JButton typeDocumentPrec;
    private JButton typeDocumentSuiv;
    private JLabel lRangTypeActe;
    public JTextField rangTypeActe;
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
    private JLabel lPrefixeCle;
    private JTextField prefixeCle;
    private JCheckBox plusieursPages;
    private JLabel lPlusieursPage;
    private JLabel lPageImpaire;
    private JCheckBox pageImpaire;
    private JLabel lRotation;
    private JComboBox rotation;
    private JButton testRotation;
    private JLabel lVersoInsere;
    private JButton testVersoInsere;
    private JTextField versoInsere;
    private JLabel lAdresseExp;
    private JLabel lAdresseExpBasGauche;
    private JLabel lAdrExpBGx;
    public JTextField adresseExpBasGaucheX;
    private JLabel lAdrExpBGy;
    public JTextField adresseExpBasGaucheY;
    private JButton testAdresseExp;
    private JLabel lAdrExpHD;
    private JLabel lAdrExpHDx;
    public JTextField adresseExpHautDroiteX;
    private JLabel lAdrExpHDy;
    public JTextField adresseExpHautDroiteY;
    private JLabel lDeleteExp;
    private JButton testDeleteExp;
    private JCheckBox deleteExp;
    private JLabel lAdresseDest;
    private JButton testAdresseDest;
    private JLabel lAdrDestBG;
    private JLabel lAdrDestBGx;
    public JTextField adresseDestBasGaucheX;
    private JLabel lAdrDestBGy;
    public JTextField adresseDestBasGaucheY;
    private JLabel lAdrDestHD;
    private JLabel lAdrDestHDx;
    public JTextField adresseDestHautDroiteX;
    private JLabel lAdrDestHDy;
    public JTextField adresseDestHautDroiteY;
    private JLabel lDeleteDest;
    private JButton testDeleteDest;
    private JCheckBox deleteDest;
    private JLabel lPlaceDate;
    private JButton testPlaceDate;
    private JLabel lPlaceDateX;
    public JTextField placeDateX;
    private JLabel lPlaceDateY;
    public JTextField placeDateY;
    private JLabel lPlaceSignature;
    private JLabel lPlaceSignatureX;
    private JButton testPlaceSignature;
    public JTextField placeSignatureX;
    private JLabel lPlaceSignatureY;
    public JTextField placeSignatureY;
    private JLabel lAvecGrade;
    private JCheckBox avecGrade;
    public JTextField nomActe;
    private JTextField fichierTest;
    private JLabel lFichierTest;
    private JButton fileChoose;
    private JButton delTypeActe;
    private JButton insTypeActe;
    private JButton delTypeDocument;
    private JButton insTypeDocument;
    private JButton enregistreLeFichier;
    private JButton abandonne;
    private JButton quoiNomActe;
    private JButton quoiClicEsiPlus;
    private JButton quoiUtiliseLO;
    private JButton quoiMaxPages;
    private JButton quoiFichierTest;
    private JButton quoiNom;
    private JButton quoiNomTypeActe;
    private JButton quoiRangTypeActe;
    private JButton quoiChaineType;
    private JButton quoiRegexpCle;
    private JButton quoiPrefixeCle;
    private JButton quoiChaineSousPlis;
    private JButton quoiChaineService;
    private JButton quoiPlusieursPages;
    private JButton quoiPagesImpaires;
    private JButton quoiRotation;
    private JButton quoiVersoInsere;
    private JButton quoiAdresseExp;
    private JButton quoiDeleteExp;
    private JButton quoiAdresseDest;
    private JButton quoiDeleteDest;
    private JButton quoiPlaceDate;
    private JButton quoiPlaceSignature;
    private JButton quoiAvecGrade;
    private JButton testPlusieursPages;
    private JButton testPageImpaire;

    public ClicSieParams() {

        enregistreLeFichier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getData();
                List<Erreur> listeErreurs = erreurs();
                if (listeErreurs.isEmpty()) {
                    lecteurParametres.ecritDonnees();
                    System.exit(0);
                } else {
                    afficheErreur(listeErreurs.get(0));
                }
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
        abandonne.setVerifyInputWhenFocusTarget(false);

        typeActeSuiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rangListeTypesActes++;
                listeTypesDocumentsOrdonnes = TypeActe.get(listeTypesActes.get(rangListeTypesActes).getNom()).typeCourriersOrdonnes();
                rangListeTypesDocumentsOrdonnes = 0;
                nomActe.requestFocus();
                setData();
            }
        });

        typeActePrec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rangListeTypesActes--;
                listeTypesDocumentsOrdonnes = TypeActe.get(listeTypesActes.get(rangListeTypesActes).getNom()).typeCourriersOrdonnes();
                rangListeTypesDocumentsOrdonnes = 0;
                nomActe.requestFocus();
                setData();
            }
        });

        insTypeActe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getData();
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
                nomActe.requestFocus();
                rangListeTypesDocumentsOrdonnes = 0;
                listeTypesDocumentsOrdonnes = typeActe.typeCourriersOrdonnes();
                setData();
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
                    setData();
                }
            }
        });
        delTypeActe.setVerifyInputWhenFocusTarget(false);

        nomActe.setInputVerifier(new NomActeObligatoire());

        maxPagesActe.setInputVerifier(new NumeriquePositif());

        typeDocumentPrec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getData();
                rangListeTypesDocumentsOrdonnes--;
                nom.requestFocus();
                setData();
            }
        });

        typeDocumentSuiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getData();
                rangListeTypesDocumentsOrdonnes++;
                nom.requestFocus();
                setData();
            }
        });

        insTypeDocument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getData();
                TypeDocument typeDocument = new TypeDocument();
                typeDocument.setNom("nouveau type de document");
                typeDocument.setNomTypeActe(listeTypesActes.get(rangListeTypesActes).getNom());
                TypeDocument.getDico().put(typeDocument.getNom(),typeDocument);
                nomActe.requestFocus();
                listeTypesDocumentsOrdonnes = listeTypesActes.get(rangListeTypesActes).typeCourriersOrdonnes();
                setData();
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
                    nomActe.requestFocus();
                    setData();
                }
            }
        });
        delTypeDocument.setVerifyInputWhenFocusTarget(false);

        fileChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier test", "pdf");
                final JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(repertoire));
                fileChooser.setFileFilter(filter);
                int returnVal = fileChooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    fichierTest.setText(fileChooser.getSelectedFile().getAbsolutePath());
                    repertoire = fileChooser.getSelectedFile().getParent();
                }
            }
        });

        vueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PdfReader lecteurPdf = fichierTest();
                if (lecteurPdf != null) {
                    String chaine = getChaine(lecteurPdf, 1);
                    lecteurPdf.close();
                    UtileFichier.lanceAcrobat(fichierTest.getText());
                    JTextArea textArea = new JTextArea(20, 60);
                    textArea.setText(chaine);
                    textArea.setEditable(true);
                    // wrap a scrollpane around it
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    // display them in a message dialog
                    JOptionPane.showMessageDialog(null, scrollPane, "Texte contenu dans la 1ere page",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        nom.setInputVerifier(new NomDocumentObligatoire());

        nomTypeActe.setInputVerifier(new ControleNomTypeActe());

        rangTypeActe.setInputVerifier(new ControleRangTypeActe());

        chaineType.setInputVerifier(new NomActeObligatoire());

        regexpCle.setInputVerifier(new ObligatoireSaufVerso());

        testChaineType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PdfReader lecteurPdf = fichierTest();
                String chaine = getChaine(lecteurPdf,1);
                Pattern pattern = Pattern.compile(params.chaineType.getText(), Pattern.MULTILINE | Pattern.DOTALL);
                Matcher matcher = pattern.matcher(chaine);
                if(matcher.matches()) {
                    chaineType.setBackground(Color.WHITE);
                    testChaineType.setForeground(Color.GREEN);
                    JOptionPane.showMessageDialog(null, "Le fichier est correctement identifié",
                            "Succès", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    chaineType.setBackground(Color.RED);
                    testChaineType.setForeground(Color.RED);
                    JOptionPane.showMessageDialog(null, "Le fichier n'est pas identifié",
                            "Echec", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        testRegexpCle.setInputVerifier(new ObligatoireSaufVerso());

        testRegexpCle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PdfReader lecteurPdf = fichierTest();
                String message = "";
                assert lecteurPdf != null;
                for (int ipage = 1; ipage <= lecteurPdf.getNumberOfPages(); ipage++) {
                    String chaine = getChaine(lecteurPdf,ipage);
                    String cle = getCle(chaine, regexpCle.getText());
                    message = String.format("%s%s", message, String.format("La clé de la page %d est %s.\n", ipage, cle));
                }
                gereConfirmation(message, regexpCle, testRegexpCle, prefixeCle);
            }
        });


        testChaineSousPlis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PdfReader lecteurPdf = fichierTest();
                StringBuilder message = new StringBuilder();
                assert lecteurPdf != null;
                for (int ipage = 1; ipage <= lecteurPdf.getNumberOfPages(); ipage++) {
                    String chaine = getChaine(lecteurPdf, ipage);
                    String cle = getCle(chaine, regexpCle.getText());
                    if (!chaineSousPlis.getText().equals("null") && chaine.contains(chaineSousPlis.getText()) &&
                            !cle.isEmpty()) {
                        message.append(String.format("La page %d sera mise dans le fichier SousPlis.\n", ipage));
                    } else if (!chaineService.getText().equals("null") && chaine.contains(chaineService.getText()) &&
                            !cle.isEmpty()) {
                        message.append(String.format("La page %d sera mise dans le fichier Service.\n", ipage));
                    } else {
                        message.append(String.format("La page %d sera mise dans le même fichier en fonction\n     du paramètre plusieursPages:.\n", ipage));
                    }
                }
                gereConfirmation(message.toString(), chaineSousPlis, testChaineSousPlis, chaineService);
            }
        });

        testPlusieursPages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PdfReader lecteurPdf = fichierTest();
                StringBuilder message = new StringBuilder();
                assert lecteurPdf != null;
                for (int ipage = 1; ipage <= lecteurPdf.getNumberOfPages(); ipage++) {
                    String chaine = getChaine(lecteurPdf, ipage);
                    String cle = getCle(chaine, regexpCle.getText());
                    if (!chaineSousPlis.getText().equals("null") && chaine.contains(chaineSousPlis.getText()) &&
                            !cle.isEmpty()) {
                        message.append(String.format("La page %d sera mise dans le fichier SousPlis.\n", ipage));
                    } else if (!chaineService.getText().equals("null") && chaine.contains(chaineService.getText()) &&
                            !cle.isEmpty()) {
                        message.append(String.format("La page %d sera mise dans le fichier Service.\n", ipage));
                    } else if (plusieursPages.isSelected()){
                        message.append(String.format("La page %d sera mise dans le même fichier.\n", ipage));
                    } else {
                        message.append(String.format("La page %d ne sera mise dans aucun fichier.\n", ipage));
                    }
                }
                gereConfirmation(message.toString(), plusieursPages, testPlusieursPages);
            }
        });

        testPageImpaire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PdfReader lecteurPdf = fichierTest();
                StringBuilder message = new StringBuilder();
                int nbPagesSousPlis = 0;
                int nbPagesService = 0;
                String dernierFichier = "";
                assert lecteurPdf != null;
                for (int ipage = 1; ipage <= lecteurPdf.getNumberOfPages(); ipage++) {
                    String chaine = getChaine(lecteurPdf, ipage);
                    String cle = getCle(chaine, regexpCle.getText());
                    if (!chaineSousPlis.getText().equals("null") && chaine.contains(chaineSousPlis.getText()) &&
                            !cle.isEmpty()) {
                        dernierFichier = "SousPlis";
                        if (nbPagesSousPlis % 2 == 1) {
                            nbPagesSousPlis++;
                            message.append(String.format("Page %d du fichier SousPlis blanche.\n", nbPagesSousPlis));
                        }
                        nbPagesSousPlis++;
                        message.append(String.format("La page %d sera mise dans le fichier SousPlis (page %d).\n", ipage, nbPagesSousPlis));
                    } else if (!chaineService.getText().equals("null") && chaine.contains(chaineService.getText()) &&
                            !cle.isEmpty()) {
                        dernierFichier = "Service";
                        if (nbPagesService % 2 == 1) {
                            nbPagesService++;
                            message.append(String.format("Page %d du fichier Service blanche.\n", nbPagesService));
                        }
                        nbPagesService++;
                        message.append(String.format("La page %d sera mise dans le fichier Service (page %d).\n", ipage, nbPagesService));
                    } else if (plusieursPages.isSelected()){
                        if (dernierFichier.equals("SousPlis")) {
                            nbPagesSousPlis++;
                            message.append(String.format("La page %d sera mise dans le fichier SousPlis (page %d).\n", ipage, nbPagesSousPlis));
                        } else {
                            nbPagesService++;
                            message.append(String.format("La page %d sera mise dans le fichier Service (page %d).\n", ipage, nbPagesService));
                        }
                    } else {
                        message.append(String.format("La page %d ne sera mise dans aucun fichier.\n", ipage));
                    }
                }
                gereConfirmation(message.toString(), pageImpaire, testPageImpaire);
            }
        });

        testRotation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PdfReader lecteurPdf = fichierTest();
                if (lecteurPdf != null) {
                    construitFichier(lecteurPdf,0);
                }
                assert lecteurPdf != null;
                lecteurPdf.close();
                gereConfirmation(null, rotation, testRotation);
            }
        });

        versoInsere.setInputVerifier(new ControleVersoInsere());

        testVersoInsere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isControleVersoInsereNecessaire()) {
                    return;
                }
                PdfReader lecteurPdf = fichierTest();
                if (lecteurPdf == null) {
                    return;
                }
                if (!controleVersoInsere()) {
                    lecteurPdf.close();
                    return;
                }
                construitFichier(lecteurPdf, 1);
                lecteurPdf.close();
                gereConfirmation(null, versoInsere, testVersoInsere);
            }
        });

        adresseDestBasGaucheX.setInputVerifier(new ControleX());
        adresseDestBasGaucheY.setInputVerifier(new ControleY());
        adresseDestHautDroiteX.setInputVerifier(new ControleX());
        adresseDestHautDroiteY.setInputVerifier(new ControleY());

        testAdresseDest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isTestAdresseUtile(adresseDestBasGaucheX, adresseDestBasGaucheY,
                        adresseDestHautDroiteX, adresseDestHautDroiteY)) {
                    return;
                }
                PdfReader lecteurPdf = fichierTest();
                if (lecteurPdf == null) {
                    return;
                }
                if (!controleAdresse(adresseDestBasGaucheX, adresseDestBasGaucheY,
                        adresseDestHautDroiteX, adresseDestHautDroiteY, testAdresseDest)) {
                    lecteurPdf.close();
                    return;
                }
                Rectangle rect = construitRect(adresseDestBasGaucheX, adresseDestBasGaucheY,
                        adresseDestHautDroiteX, adresseDestHautDroiteY);
                String message = recupereAdresse(lecteurPdf, rect);
                lecteurPdf.close();
                gereConfirmation(message, adresseDestBasGaucheX, adresseDestBasGaucheY,
                        adresseDestHautDroiteX, adresseDestHautDroiteY, testAdresseDest);
            }
        });

        testDeleteDest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PdfReader lecteurPdf = fichierTest();
                if (lecteurPdf == null) {
                    return;
                }
                if (!isTestAdresseUtile(adresseDestBasGaucheX, adresseDestBasGaucheY,
                        adresseDestHautDroiteX, adresseDestHautDroiteY)) {
                    lecteurPdf.close();
                    return;
                }
                if (!controleAdresse(adresseDestBasGaucheX, adresseDestBasGaucheY,
                        adresseDestHautDroiteX, adresseDestHautDroiteY, testAdresseDest)) {
                    lecteurPdf.close();
                    return;
                }
                clicEsi(lecteurPdf, 1);
                lecteurPdf.close();
                gereConfirmation(null, deleteDest, testDeleteDest);
            }
        });

        adresseExpBasGaucheX.setInputVerifier(new ControleX());
        adresseExpBasGaucheY.setInputVerifier(new ControleY());
        adresseExpHautDroiteX.setInputVerifier(new ControleX());
        adresseExpHautDroiteY.setInputVerifier(new ControleY());

        testAdresseExp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isTestAdresseUtile(adresseExpBasGaucheX, adresseExpBasGaucheY,
                        adresseExpHautDroiteX, adresseExpHautDroiteY)) {
                    return;
                }
                PdfReader lecteurPdf = fichierTest();
                if (lecteurPdf == null) {
                    return;
                }
                if (!controleAdresse(adresseExpBasGaucheX, adresseExpBasGaucheY,
                        adresseExpHautDroiteX, adresseExpHautDroiteY, testAdresseExp)) {
                    lecteurPdf.close();
                    return;
                }
                Rectangle rect = construitRect(adresseExpBasGaucheX, adresseExpBasGaucheY,
                        adresseExpHautDroiteX, adresseExpHautDroiteY);
                String message = recupereAdresse(lecteurPdf, rect);
                lecteurPdf.close();
                gereConfirmation(message, adresseExpBasGaucheX, adresseExpBasGaucheY,
                        adresseExpHautDroiteX, adresseExpHautDroiteY, testAdresseExp);
            }
        });

        testDeleteExp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isTestAdresseUtile(adresseExpBasGaucheX, adresseExpBasGaucheY,
                        adresseExpHautDroiteX, adresseExpHautDroiteY)) {
                    return;
                }
                PdfReader lecteurPdf = fichierTest();
                if (lecteurPdf == null) {
                    return;
                }
                if (!controleAdresse(adresseDestBasGaucheX, adresseDestBasGaucheY,
                        adresseDestHautDroiteX, adresseDestHautDroiteY, testAdresseDest)) {
                    lecteurPdf.close();
                    return;
                }
                if (!controleAdresse(adresseExpBasGaucheX, adresseExpBasGaucheY,
                        adresseExpHautDroiteX, adresseExpHautDroiteY, testAdresseExp)) {
                    lecteurPdf.close();
                    return;
                }
                clicEsi(lecteurPdf, 2);
                lecteurPdf.close();
                gereConfirmation(null, deleteExp, testDeleteExp);
            }
        });

        placeDateX.setInputVerifier(new ControleX());
        placeDateY.setInputVerifier(new ControleY());

        testPlaceDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (placeDateX.getText().isEmpty() && placeDateY.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "La place n'est pas définie. Le test est inutile !",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!(new ControleX().controle(placeDateX)) || !(new ControleY().controle(placeDateY))) {
                    testPlaceDate.setForeground(Color.RED);
                    return;
                }
                PdfReader lecteurPdf = fichierTest();
                if (lecteurPdf == null) {
                    return;
                }
                if (!controleAdresse(adresseDestBasGaucheX, adresseDestBasGaucheY,
                        adresseDestHautDroiteX, adresseDestHautDroiteY, testAdresseDest)) {
                    lecteurPdf.close();
                    return;
                }
                if (!controleAdresse(adresseExpBasGaucheX, adresseExpBasGaucheY,
                        adresseExpHautDroiteX, adresseExpHautDroiteY, testAdresseExp)) {
                    lecteurPdf.close();
                    return;
                }
                clicEsi(lecteurPdf, 3);
                lecteurPdf.close();
                gereConfirmation(null, placeDateX, placeDateY, testPlaceDate);
            }
        });

        placeSignatureX.setInputVerifier(new ControleX());
        placeSignatureY.setInputVerifier(new ControleY());

        testPlaceSignature.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (placeSignatureX.getText().isEmpty() && placeSignatureY.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "La place n'est pas définie. Le test est inutile !",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!(new ControleX().controle(placeSignatureX)) || !(new ControleY().controle(placeSignatureY))) {
                    testPlaceSignature.setForeground(Color.RED);
                    return;
                }
                PdfReader lecteurPdf = fichierTest();
                if (lecteurPdf == null) {
                    return;
                }
                if (!controleAdresse(adresseDestBasGaucheX, adresseDestBasGaucheY,
                        adresseDestHautDroiteX, adresseDestHautDroiteY, testAdresseDest)) {
                    lecteurPdf.close();
                    return;
                }
                if (!controleAdresse(adresseExpBasGaucheX, adresseExpBasGaucheY,
                        adresseExpHautDroiteX, adresseExpHautDroiteY, testAdresseExp)) {
                    lecteurPdf.close();
                    return;
                }
                if (!(new ControleX().controle(placeDateX)) || !(new ControleY().controle(placeDateY))) {
                    testPlaceDate.setForeground(Color.RED);
                    return;
                }
                clicEsi(lecteurPdf, 4);
                lecteurPdf.close();
                gereConfirmation(null, placeSignatureX, placeSignatureY, avecGrade, testPlaceSignature);
            }
        });

        quoiNomActe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("nomActe");
            }
        });
        quoiClicEsiPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("clicEsiPlus");
            }
        });
        quoiUtiliseLO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("utiliseLO");
            }
        });
        quoiMaxPages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("maxPages");
            }
        });
        quoiFichierTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("fichierTest");
            }
        });
        quoiNom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("nom");
            }
        });
        quoiNomTypeActe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("nomTypeActe");
            }
        });
        quoiRangTypeActe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("rangTypeActe");
            }
        });
        quoiChaineType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("chaineType");
            }
        });
        quoiRegexpCle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("regexpCle");
            }
        });
        quoiPrefixeCle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("prefixeCle");
            }
        });
        quoiChaineSousPlis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("chaineSousPlis");
            }
        });
        quoiChaineService.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("chaineService");
            }
        });
        quoiPlusieursPages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("plusieursPages");
            }
        });
        quoiPagesImpaires.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("pagesImpaires");
            }
        });
        quoiRotation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("rotation:");
            }
        });
        quoiVersoInsere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("versoInsere");
            }
        });
        quoiAdresseExp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("adresseExp");
            }
        });
        quoiDeleteExp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("deleteExp");
            }
        });
        quoiAdresseDest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("adresseDest");
            }
        });
        quoiDeleteDest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("deleteDest");
            }
        });
        quoiPlaceDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("placeDate");
            }
        });
        quoiPlaceSignature.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("placeSignature");
            }
        });
        quoiAvecGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aide("avecGrade");
            }
        });
        nomActe.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (nomActe.getText().isEmpty()) {
                    nomActe.setBackground(Color.RED);
                    nomActe.requestFocus();
                    JOptionPane.showMessageDialog(null,
                            "Le nom du type d'acte est obligatoire",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    nomActe.setBackground(Color.WHITE);
                }
            }
        });
    }
    private void gereConfirmation(String message, JComponent... components) {
        String[] options = {"Non","Oui"};
        Object objet;
        if (message == null) {
            objet = "Cela vous convient-il ?";
        } else {
            JTextArea textArea = new JTextArea(20, 60);
            textArea.setText(message + "\n\n Cela vous convient-il ?");
            textArea.setEditable(true);
            // wrap a scrollpane around it
            objet = new JScrollPane(textArea);
        }
        int dialogResult = JOptionPane.showOptionDialog(null,
                objet ,"Confirmation",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
                null,options,0);
        if(dialogResult == 1){
            for(JComponent component: components) {
                if (component.getClass().equals(JButton.class)) {
                    component.setForeground(Color.GREEN);
                } else {
                    component.setBackground(Color.WHITE);
                }
            }
        } else {
            for(JComponent component: components) {
                if (component.getClass().equals(JButton.class)) {
                    component.setForeground(Color.RED);
                } else {
                    component.setBackground(Color.RED);
                }
            }
        }
    }

    private void afficheErreur(Erreur erreur) {
        int i = 0;
        while (i < listeTypesActes.size() && !listeTypesActes.get(i).getNom().equals(erreur.getNomTypeActe())) {
            i++;
        }
        rangListeTypesActes = i;
        listeTypesDocumentsOrdonnes = TypeActe.get(listeTypesActes.get(rangListeTypesActes).getNom()).typeCourriersOrdonnes();
        i = 0;
        if(erreur.getNomTypeDocument() != null) {
            while (i < listeTypesDocumentsOrdonnes.size() &&
                    !listeTypesDocumentsOrdonnes.get(i).getNom().equals(erreur.getNomTypeDocument())) {
                i++;
            }
        }
        rangListeTypesDocumentsOrdonnes = i;
        setData();
        for(JTextField champTexte : erreur.getChampsTexte()){
            champTexte.setBackground(Color.RED);
        }
        for(JCheckBox caseACocher : erreur.getCasesACocher()) {
            caseACocher.setBackground(Color.RED);
        }
        for(JButton bouton : erreur.getBoutons()) {
            bouton.setForeground(Color.RED);
        }
        ((JComponent) erreur.getObjetFocus()).requestFocus();
        JOptionPane.showMessageDialog(null,
                erreur.getMessage(),
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
    }
    private List<Erreur> erreurs() {
        List<Erreur> listeErreurs = new ArrayList<Erreur>();
        listeErreurs = TypeActe.erreurs(listeErreurs);
        listeErreurs = TypeDocument.erreurs(listeErreurs);
        return listeErreurs;
    }
    private void clicEsi(PdfReader lecteurPdf, int option) {
        BaseFont bf = UtileFichier.getFonte("arial.ttf");
        Font arial8 = new Font(bf,8);
        Font arial10 = new Font(bf, 10);
        bf = UtileFichier.getFonte("OCR-B10BT.TTF");
        Font ocr10 = new Font(bf, 10);
        String nomFichier = fichierTest.getText().replaceAll("\\.pdf", "__Clic.pdf");
        PdfStamper stamper = UtileFichier.getStamper(lecteurPdf, nomFichier);
        Rectangle rectDest;
        String[] adresseDest = null;
        Rectangle rectExp;
        String[] adresseExp = null;
        List<PdfCleanUpLocation> cleanUpLocations = new ArrayList<PdfCleanUpLocation>();
        if (!adresseDestBasGaucheX.getText().isEmpty()) {
            rectDest = construitRect(adresseDestBasGaucheX, adresseDestBasGaucheY,
                adresseDestHautDroiteX, adresseDestHautDroiteY);
            adresseDest = recupereAdresse(lecteurPdf, rectDest).split("\n");
            if (deleteDest.isSelected()) {
                cleanUpLocations.add(new PdfCleanUpLocation(1, rectDest));
            }
        }
        if (!adresseExpBasGaucheX.getText().isEmpty() && option > 1) {
            rectExp = construitRect(adresseExpBasGaucheX, adresseExpBasGaucheY,
                adresseExpHautDroiteX, adresseExpHautDroiteY);
            adresseExp = recupereAdresse(lecteurPdf, rectExp).split("\n");
            if (deleteExp.isSelected()) {
                cleanUpLocations.add(new PdfCleanUpLocation(1, rectExp));
            }
        }
        if (deleteDest.isSelected() || (option > 1 && deleteExp.isSelected())) {
            effaceAdresse(cleanUpLocations, stamper);
        }
        if (!adresseExpBasGaucheX.getText().isEmpty()) {
            placeAdresse(stamper, 730f, 10f, adresseExp, arial8);
        }
        if (!adresseDestBasGaucheX.getText().isEmpty() && option > 1) {
            placeAdresse(stamper, 650f, 12f, adresseDest, ocr10);
        }
        if (option > 2 && !placeDateX.getText().isEmpty()) {
            assert stamper != null;
            PdfContentByte canvas = stamper.getOverContent(1);
            Date now = Calendar.getInstance().getTime();
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
                    new Phrase(new SimpleDateFormat("dd/MM/yyyy").format(now),arial10),
                   Float.valueOf(params.placeDateX.getText())*72f/25.4f,
                   842f - Float.valueOf(params.placeDateY.getText())*72f/25.4f,0);
        }
        if (option > 3) {
            String[] signature = new String[] {"Le contrôleur des finances publiques", "Paul Durand"};
            int idep = 1;
            if(avecGrade.isSelected()) {
                idep = 0;
            }
            int inc = 0;
            assert stamper != null;
            PdfContentByte canvas = stamper.getOverContent(1);
            for(int i=idep; i < signature.length; i++) {
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
                        new Phrase(signature[i], arial10),
                        Float.valueOf(params.placeSignatureX.getText())*72f/25.4f,
                        842f - Float.valueOf(params.placeSignatureY.getText())*72f/25.4f + inc,0);
                inc -= 11;
            }
        }
        UtileFichier.closeStamper(stamper);
        lecteurPdf.close();
        UtileFichier.lanceAcrobat(nomFichier);
    }

    private void placeAdresse(PdfStamper stamper, Float y, Float espace, String[] adresse, Font ocr10) {
        PdfContentByte canvas = stamper.getOverContent(1);
        for (String ligne : adresse) {
            if (!ligne.startsWith("CS ")) {
                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
                        new Phrase(ligne, ocr10), 300f, y, 0);
                y -= espace;
            }
        }
    }

    private void effaceAdresse(List<PdfCleanUpLocation> cleanUpLocations, PdfStamper stamper) {
        PdfCleanUpProcessor cleaner = new PdfCleanUpProcessor(cleanUpLocations, stamper);
        try {
            cleaner.cleanUp();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        cleanUpLocations.clear();
    }
    private Rectangle construitRect(JTextField x1, JTextField y1, JTextField x2, JTextField y2) {
        return new Rectangle(Float.valueOf(x1.getText())*72f/25.4f,
                842f - Float.valueOf(y1.getText())*72f/25.4f,
                Float.valueOf(x2.getText())*72f/25.4f,
                842f - Float.valueOf(y2.getText())*72f/25.4f);
    }
    private String recupereAdresse(PdfReader lecteurPdf, Rectangle rectangle) {
        RegionTextRenderFilter filter = new RegionTextRenderFilter(rectangle);
        FilteredTextRenderListener strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
        try {
            return PdfTextExtractor.getTextFromPage(lecteurPdf, 1, strategy);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private boolean isTestAdresseUtile(JTextField x1, JTextField y1, JTextField x2, JTextField y2) {
        if (x1.getText().isEmpty() &&
                y1.getText().isEmpty() &&
                x2.getText().isEmpty() &&
                y2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Le rectangle n'est pas défini. Le test est inutile !",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    private boolean controleAdresse(JTextField x1, JTextField y1, JTextField x2, JTextField y2, JButton test) {
        if (x1.getText().isEmpty() && y1.getText().isEmpty() && x2.getText().isEmpty() && y2.getText().isEmpty()) {
            return true;
        }
        ControleX controleX = new ControleX();
        ControleY controleY = new ControleY();
        if (!controleX.controle(x1) || !controleY.controle(y1) || !controleX.controle(x2) || !controleY.controle(y2)) {
            test.setForeground(Color.RED);
            return false;
        }
        test.setForeground(Color.BLACK);
        return true;
    }

    private boolean isControleVersoInsereNecessaire() {
        if(versoInsere.getText().equals("null")) {
            JOptionPane.showMessageDialog(null,
                    "L'option n'est pas demandée. Le test est inutile !",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    private boolean controleVersoInsere() {
        if (TypeDocument.get(versoInsere.getText()).getFichierTest().isEmpty()) {
            params.versoInsere.setBackground(Color.RED);
            params.testVersoInsere.setForeground(Color.RED);
            JOptionPane.showMessageDialog(null,
                    "Le type de document spécifié n'a pas de fichier test !",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        versoInsere.setBackground(Color.WHITE);
        testVersoInsere.setForeground(Color.GREEN);
        return true;
    }

    private void construitFichier(PdfReader lecteurPdf, int option) {
        Copie sousPlis = new Copie(params.fichierTest.getText().replaceAll("\\.pdf", "__SousPlis.pdf"));
        Copie service = new Copie(params.fichierTest.getText().replaceAll("\\.pdf", "__Service.pdf"));
        Copie dernierFichier = null;
        Lecteur lecteurVerso = null;
        if (option > 0) {
            lecteurVerso = new Lecteur(TypeDocument.get(params.versoInsere.getText()).getNom());
        }
        for (int ipage = 1; ipage <= lecteurPdf.getNumberOfPages(); ipage++) {
            String chaine = getChaine(lecteurPdf, ipage);
            String cle = getCle(chaine, params.regexpCle.getText());
            //Récupère la rotation actuelle de la page pour tourner la page correctement
            PdfDictionary pageP = lecteurPdf.getPageN(ipage);
            PdfNumber rotate = pageP.getAsNumber(PdfName.ROTATE);
            if (rotate == null) {
                pageP.put(PdfName.ROTATE, new PdfNumber((String) params.rotation.getSelectedItem()));
            } else {
                pageP.put(PdfName.ROTATE, new PdfNumber((rotate.intValue() +
                        Integer.valueOf((String) params.rotation.getSelectedItem()) % 360)));
            }
            if (!params.chaineSousPlis.getText().equals("null") && chaine.contains(params.chaineSousPlis.getText()) &&
                    !cle.isEmpty()) {
                dernierFichier = sousPlis;
                dernierFichier.pageImpaire();
                dernierFichier.addPage(lecteurPdf, ipage);
                if (lecteurVerso != null) {
                    dernierFichier.addPage(lecteurVerso.getPdfReader(), 1);
                }
            } else if (!params.chaineService.getText().equals("null") && chaine.contains(params.chaineService.getText()) &&
                    !cle.isEmpty()) {
                dernierFichier = service;
                dernierFichier.pageImpaire();
                dernierFichier.addPage(lecteurPdf, ipage);
            } else if (params.plusieursPages.isSelected()) {
                assert dernierFichier != null;
                dernierFichier.addPage(lecteurPdf, ipage);
            }
        }
        sousPlis.ouvrePdf();
        service.ouvrePdf();
    }

    private void aide(String champ) {
        BufferedInputStream resource = (BufferedInputStream) ClicSieParams.class.getResourceAsStream(String.format("/com/dgfip/jmarzin/aide/%s.html", champ));
        String message = "";
        try {
            message = IOUtils.toString(resource, "UTF-8");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        JTextPane texte = new JTextPane();
        texte.setContentType( "text/html" );
        texte.setText(String.format("<html>Aide pour le champ <b>%s:</b>\n\n%s</html>", champ, message));
        // wrap a scrollpane around it
        JScrollPane scrollPane = new JScrollPane(texte);
        // display them in a message dialog
        JOptionPane.showMessageDialog(null, scrollPane, "Aide",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private String getCle(String chaine, String regexpCle) {
        StringBuilder cle = new StringBuilder();
        Pattern pattern = Pattern.compile(regexpCle, Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(chaine);
        if (matcher.matches()) {
            cle = new StringBuilder(params.nomTypeActe.getText() + "_" + params.prefixeCle.getText());
            for(int i = 1; i <= matcher.groupCount(); i++) {
                cle.append(matcher.group(i));
            }
        }
        return cle.toString().replaceAll(" ", "");
    }

    private PdfReader fichierTest() {
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

    private String getChaine(PdfReader lecteurPdf, int page) {
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
        fileChooser.setCurrentDirectory(new File(repertoire));
        fileChooser.setDialogTitle("Sélectionner le fichier des paramètres");
        int returnVal = fileChooser.showOpenDialog(null);
        if(returnVal != JFileChooser.APPROVE_OPTION) {
            System.exit(0);
        }
        repertoire = fileChooser.getSelectedFile().getParent();
        lecteurParametres = new LecteurParametres(fileChooser.getSelectedFile().getAbsolutePath());
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
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        params.rotation.addItem("0");
        params.rotation.addItem("90");
        params.rotation.addItem("180");
        params.rotation.addItem("270");
        params.nomActe.requestFocus();
        setData();
        frame.setVisible(true);
    }

    private static void setData() {
        TypeActe typeActe = listeTypesActes.get(rangListeTypesActes);
        params.nomActe.setText(typeActe.getNom());
        params.utiliseLOActe.setSelected(typeActe.isUtiliseLO());
        params.clicEsiPlusActe.setSelected(typeActe.isClicEsiPlus());
        params.maxPagesActe.setText(String.valueOf(typeActe.getMaxPages()));
        params.typeActePrec.setEnabled(rangListeTypesActes > 0);
        params.typeActeSuiv.setEnabled(rangListeTypesActes < listeTypesActes.size() - 1);
        params.delTypeActe.setEnabled(listeTypesActes.size() > 1);
        TypeDocument typeDocument = listeTypesDocumentsOrdonnes.get(rangListeTypesDocumentsOrdonnes);
        params.fichierTest.setText(typeDocument.getFichierTest());
        params.fichierTest.setBackground(Color.WHITE);
        params.vueButton.setForeground(Color.BLACK);
        params.nom.setText(typeDocument.getNom());
        params.nomTypeActe.setText(typeDocument.getNomTypeActe());
        params.rangTypeActe.setText(String.valueOf(typeDocument.getRangTypeActe()));
        params.chaineType.setText(typeDocument.getChaineType());
        params.chaineType.setBackground(Color.WHITE);
        params.testChaineType.setForeground(Color.BLACK);
        params.regexpCle.setText(typeDocument.getRegexpCle());
        params.regexpCle.setBackground(Color.WHITE);
        params.testRegexpCle.setForeground(Color.BLACK);
        params.prefixeCle.setText(typeDocument.getPrefixeCle());
        params.prefixeCle.setBackground(Color.WHITE);
        params.chaineSousPlis.setText(typeDocument.getChaineSousPlis());
        params.chaineSousPlis.setBackground(Color.WHITE);
        params.testChaineSousPlis.setForeground(Color.BLACK);
        params.chaineService.setText(typeDocument.getChaineService() == null ? "null" : typeDocument.getChaineService());
        params.chaineService.setBackground(Color.WHITE);
        params.plusieursPages.setSelected(typeDocument.isPlusieursPages());
        params.plusieursPages.setBackground(Color.WHITE);
        params.testPlusieursPages.setForeground(Color.BLACK);
        params.pageImpaire.setSelected(typeDocument.isPageImpaire());
        params.pageImpaire.setBackground(Color.WHITE);
        params.testPageImpaire.setForeground(Color.BLACK);
        params.rotation.setSelectedItem(String.valueOf(typeDocument.getRotation()));
        params.versoInsere.setText(typeDocument.getVersoInsere() == null ? "null" : typeDocument.getVersoInsere());
        if (typeDocument.getAdresseExp() == null) {
            params.adresseExpBasGaucheX.setText("");
            params.adresseExpBasGaucheY.setText("");
            params.adresseExpHautDroiteX.setText("");
            params.adresseExpHautDroiteY.setText("");
        } else {
            Map<String, Map<String, Double>> adresse =
                    (Map<String, Map<String, Double>>) typeDocument.getAdresseExp();
            params.adresseExpBasGaucheX.setText(String.valueOf(adresse.get("basGauche").get("x")));
            params.adresseExpBasGaucheY.setText(String.valueOf(adresse.get("basGauche").get("y")));
            params.adresseExpHautDroiteX.setText(String.valueOf(adresse.get("hautDroite").get("x")));
            params.adresseExpHautDroiteY.setText(String.valueOf(adresse.get("hautDroite").get("y")));
        }
        params.deleteExp.setSelected(typeDocument.isDeleteExp());
        if (typeDocument.getAdresseDest() == null) {
            params.adresseDestBasGaucheX.setText("");
            params.adresseDestBasGaucheY.setText("");
            params.adresseDestHautDroiteX.setText("");
            params.adresseDestHautDroiteY.setText("");
        } else {
            Map<String, Map<String, Double>> adresse =
                    (Map<String, Map<String, Double>>) typeDocument.getAdresseDest();
            params.adresseDestBasGaucheX.setText(String.valueOf(adresse.get("basGauche").get("x")));
            params.adresseDestBasGaucheY.setText(String.valueOf(adresse.get("basGauche").get("y")));
            params.adresseDestHautDroiteX.setText(String.valueOf(adresse.get("hautDroite").get("x")));
            params.adresseDestHautDroiteY.setText(String.valueOf(adresse.get("hautDroite").get("y")));
        }
        params.deleteDest.setSelected(typeDocument.isDeleteDest());
        if(typeDocument.getPlaceDate() == null) {
            params.placeDateX.setText("");
            params.placeDateY.setText("");
        } else {
            params.placeDateX.setText(String.valueOf(typeDocument.getPlaceDate().get("x")));
            params.placeDateY.setText(String.valueOf(typeDocument.getPlaceDate().get("y")));
        }
        if(typeDocument.getPlaceSignature() == null) {
            params.placeSignatureX.setText("");
            params.placeSignatureY.setText("");
        } else {
            params.placeSignatureX.setText(String.valueOf(typeDocument.getPlaceSignature().get("x")));
            params.placeSignatureY.setText(String.valueOf(typeDocument.getPlaceSignature().get("y")));
        }
        params.avecGrade.setSelected(typeDocument.isAvecGrade());
        params.typeDocumentPrec.setEnabled(rangListeTypesDocumentsOrdonnes > 0);
        params.typeDocumentSuiv.setEnabled(rangListeTypesDocumentsOrdonnes < listeTypesDocumentsOrdonnes.size() - 1);
        params.delTypeDocument.setEnabled(listeTypesDocumentsOrdonnes.size() > 1);
    }

    private void getData() {
        TypeActe typeActe = listeTypesActes.get(rangListeTypesActes);
        typeActe.setNom(params.nomActe.getText());
        typeActe.setUtiliseLO(params.utiliseLOActe.isSelected());
        typeActe.setClicEsiPlus(params.clicEsiPlusActe.isSelected());
        typeActe.setMaxPages(params.maxPagesActe.getText().isEmpty() ? 0 : Integer.parseInt(params.maxPagesActe.getText()));
        TypeActe.getDico().remove(listeTypesActes.get(rangListeTypesActes).getNom());
        TypeActe.getDico().put(typeActe.getNom(),typeActe);
        TypeDocument typeDocument = listeTypesDocumentsOrdonnes.get(rangListeTypesDocumentsOrdonnes);
        typeDocument.setFichierTest(params.fichierTest.getText());
        typeDocument.setNom(params.nom.getText());
        typeDocument.setNomTypeActe(params.nomTypeActe.getText());
        typeDocument.setRangTypeActe(Integer.parseInt(params.rangTypeActe.getText()));
        typeDocument.setChaineType(params.chaineType.getText());
        typeDocument.setRegexpCle(params.regexpCle.getText());
        typeDocument.setPrefixeCle(params.prefixeCle.getText());
        typeDocument.setChaineSousPlis(params.chaineSousPlis.getText().equals("null") ? null : params.chaineSousPlis.getText());
        typeDocument.setChaineService(params.chaineService.getText().equals("null") ? null : typeDocument.getChaineService());
        typeDocument.setPlusieursPages(params.plusieursPages.isSelected());
        typeDocument.setPageImpaire(params.pageImpaire.isSelected());
        typeDocument.setRotation((Integer.valueOf(params.rotation.getSelectedItem().toString())));
        typeDocument.setVersoInsere(params.versoInsere.getText());
        Map<String, Map<String, Float>> adresse = new HashMap<String, Map<String, Float>>();
        Map<String, Float> rubrique = new HashMap<String, Float>();
        if (params.adresseExpBasGaucheX.getText().isEmpty()) {
            typeDocument.setAdresseExp(null);
        } else {
            rubrique.put("x", Float.valueOf(params.adresseExpBasGaucheX.getText()));
            rubrique.put("y", params.adresseExpBasGaucheY.getText().isEmpty() ? 0.0f :
                    Float.valueOf(params.adresseExpBasGaucheY.getText()));
            adresse.put("basGauche", rubrique);
            rubrique = new HashMap<String, Float>();
            rubrique.put("x", params.adresseExpHautDroiteX.getText().isEmpty() ? 0.0f :
                    Float.valueOf(params.adresseExpHautDroiteX.getText()));
            rubrique.put("y", params.adresseExpHautDroiteY.getText().isEmpty() ? 0.0f :
                    Float.valueOf(params.adresseExpHautDroiteY.getText()));
            adresse.put("hautDroite", rubrique);
            typeDocument.setAdresseExp(adresse);
        }
        typeDocument.setDeleteExp(params.deleteExp.isSelected());
        if (params.adresseDestBasGaucheX.getText().isEmpty()) {
            typeDocument.setAdresseDest(null);
        } else {
            rubrique = new HashMap<String, Float>();
            rubrique.put("x", Float.valueOf(params.adresseDestBasGaucheX.getText()));
            rubrique.put("y", params.adresseDestBasGaucheY.getText().isEmpty() ? 0.0f :
                    Float.valueOf(params.adresseDestBasGaucheY.getText()));
            adresse = new HashMap<String, Map<String, Float>>();
            adresse.put("basGauche", rubrique);
            rubrique = new HashMap<String, Float>();
            rubrique.put("x", params.adresseDestHautDroiteX.getText().isEmpty() ? 0.0f :
                    Float.valueOf(params.adresseDestHautDroiteX.getText()));
            rubrique.put("y", params.adresseDestHautDroiteY.getText().isEmpty() ? 0.0f :
                    Float.valueOf(params.adresseDestHautDroiteY.getText()));
            adresse.put("hautDroite", rubrique);
            typeDocument.setAdresseDest(adresse);
        }
        typeDocument.setDeleteDest(params.deleteDest.isSelected());
        if (params.placeDateX.getText().isEmpty()) {
            typeDocument.setPlaceDate(null);
        } else {
            rubrique = new HashMap<String, Float>();
            rubrique.put("x", Float.valueOf(params.placeDateX.getText()));
            rubrique.put("y", params.placeDateY.getText().isEmpty() ? 0.0f :
                    Float.valueOf(params.placeDateY.getText()));
            typeDocument.setPlaceDate(rubrique);
        }
        if (params.placeSignatureX.getText().isEmpty()) {
            typeDocument.setPlaceSignature(null);
        } else {
            rubrique = new HashMap<String, Float>();
            rubrique.put("x", Float.valueOf(params.placeSignatureX.getText()));
            rubrique.put("y", params.placeSignatureY.getText().isEmpty() ? 0.0f :
                    Float.valueOf(params.placeSignatureY.getText()));
            typeDocument.setPlaceSignature(rubrique);
        }
        typeDocument.setAvecGrade(params.avecGrade.isSelected());
        TypeDocument.getDico().remove(listeTypesDocumentsOrdonnes.get(rangListeTypesDocumentsOrdonnes).getNom());
        TypeDocument.getDico().put(typeDocument.getNom(),typeDocument);
    }
}
