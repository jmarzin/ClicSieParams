package com.dgfip.jmarzin;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by jmarzin-cp on 20/05/2017.
 */
public class UtileFichier {
    static String[] lit(String nomFichier) throws IOException {
        File fichier = new File (nomFichier);
        if (fichier.exists()) {
            byte[] fileData = new byte[(int) fichier.length()];
            DataInputStream dis = new DataInputStream(new FileInputStream(fichier));
            dis.readFully(fileData);
            dis.close();
            return new String(fileData, Charset.forName("UTF8")).replaceAll("\uFEFF","").split("\n");
        }
        return null;
    }
}
