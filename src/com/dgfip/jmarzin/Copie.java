package com.dgfip.jmarzin;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BadPdfFormatException;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSmartCopy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Copie {
    private String nom;

    private PdfSmartCopy pdfSmartCopy;

    private FileOutputStream fileOutputStream;

    private Boolean ok;
    Boolean isOk() {
        return ok;
    }

    Copie(String nom) {
        this.nom = nom;
        Document document = new Document();
        try {
            this.fileOutputStream = new FileOutputStream(nom);
            this.pdfSmartCopy = new PdfSmartCopy(document, fileOutputStream);
            document.open();
            ok = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            ok = false;
        } catch (DocumentException e) {
            e.printStackTrace();
            ok = false;
        }
    }
    void ouvrePdf() {
        if (this.pdfSmartCopy.getPageNumber() == 1 &&
                this.pdfSmartCopy.isPageEmpty()) {
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
