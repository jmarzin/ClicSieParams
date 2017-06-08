package com.dgfip.jmarzin;

import com.itextpdf.text.pdf.PdfReader;

import java.io.IOException;

/**
 * Created by jacquesmarzin on 08/06/2017.
 */
public class Lecteur {
    private PdfReader pdfReader = null;
    private String nom;

    public PdfReader getPdfReader() {
        return pdfReader;
    }

    Lecteur(String nomfichier) {
        this.nom = nomfichier;
        if (!nomfichier.isEmpty()) {
            try {
                this.pdfReader = new PdfReader(TypeDocument.get(nomfichier).getFichierTest());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
