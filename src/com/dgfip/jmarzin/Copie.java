package com.dgfip.jmarzin;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BadPdfFormatException;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSmartCopy;
import org.yaml.snakeyaml.reader.StreamReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jmarzin-cp on 08/06/2017.
 */
public class Copie {
    private String nom;

    public PdfSmartCopy getPdfSmartCopy() {
        return pdfSmartCopy;
    }

    private PdfSmartCopy pdfSmartCopy;
    private Document document;
    private FileOutputStream fileOutputStream;
    private Boolean resultat;

    Copie(String nom) {
        this.nom = nom;
        this.document = new Document();
        try {
            this.fileOutputStream = new FileOutputStream(nom);
            this.pdfSmartCopy = new PdfSmartCopy(document, fileOutputStream);
            this.document.open();
            resultat = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            resultat = false;
        } catch (DocumentException e) {
            e.printStackTrace();
            resultat = false;
        }
    }
    void ouvrePdf() {
        if (this.pdfSmartCopy.getPageNumber() == 1 &&
                this.getPdfSmartCopy().isPageEmpty()) {
            try {
                this.fileOutputStream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            new File(this.nom).delete();
        } else {
            this.pdfSmartCopy.close();
            UtileFichier.lanceAcrobat(this.nom);

        }
    }
    void pageImpaire() {
        if (this.pdfSmartCopy.getPageNumber() % 2 == 0) {
            try {
                this.pdfSmartCopy.addPage(PageSize.A4, 0);
            } catch (DocumentException e1) {
                e1.printStackTrace();
            }
        }
    }
    void addPage(PdfReader pdfReader, int ipage) {
        PdfImportedPage pageOriginale = this.pdfSmartCopy.getImportedPage(pdfReader, ipage);
        try {
            this.pdfSmartCopy.addPage(pageOriginale);
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (BadPdfFormatException e1) {
            e1.printStackTrace();
        }
    }
}
