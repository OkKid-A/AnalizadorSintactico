package Lector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Lector {

    private Reader lectorBase;
    private BufferedReader lectorBuff;

    public Lector() {
    }

    public ArrayList<String> leerDocumentoPorLineas(BufferedReader red) {
        ArrayList<String> objetosLeidos = new ArrayList<>();
        try {
            lectorBuff = red;
            String linea = lectorBuff.readLine();
            while (linea != null) {
                objetosLeidos.add(linea);
                linea = lectorBuff.readLine();
            }
            lectorBuff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objetosLeidos;
    }

    public char[] fetchFullText(String filePath){
        String leida = "";
        char[] leidaPartida = null;
        try {
            Path fileAsPath = Path.of(filePath);
            leida = Files.readString(fileAsPath);
            leidaPartida = leida.toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return leidaPartida;
    }
}