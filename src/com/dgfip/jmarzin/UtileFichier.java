package com.dgfip.jmarzin;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by jmarzin-cp on 20/05/2017.
 */
public class UtileFichier {
    static String lit(String nomFichier) throws IOException {
        File fichier = new File (nomFichier);
        if (fichier.exists()) {
            byte[] fileData = new byte[(int) fichier.length()];
            DataInputStream dis = new DataInputStream(new FileInputStream(fichier));
            dis.readFully(fileData);
            dis.close();
            return new String(fileData, Charset.forName("UTF8")).replaceAll("\uFEFF","");
        }
        return null;
    }
    static void lanceAcrobat(String nomFichier) {
        String[] commande = new String[]{"C:\\Program Files\\Adobe\\Reader 10.0\\Reader\\AcroRd32.exe",
                nomFichier};
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(commande);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
    static BaseFont getFonte(String nom) {
        BaseFont fonte = null;
        try {
            fonte = BaseFont.createFont(String.format("C:\\Windows\\Fonts\\%s", nom), BaseFont.WINANSI, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fonte;
    }
    static PdfStamper getStamper(PdfReader lecteurPdf, String nomFichier) {
        PdfStamper stamper = null;
        try {
            stamper = new PdfStamper(lecteurPdf, new FileOutputStream(nomFichier));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stamper;
    }
    static void closeStamper(PdfStamper stamper) {
        try {
            if (stamper != null) {
                stamper.close();
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
