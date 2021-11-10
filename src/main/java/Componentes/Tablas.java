package Componentes;

import Lexico.Tokens.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Tablas {

    public Tablas() {

    }

    public static JTable getjTable(String[][] datosFilas, String[] datosHeader) {
        DefaultTableModel tableModel = new DefaultTableModel(datosFilas, datosHeader) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable jTable = new JTable(datosFilas, datosHeader);
        jTable.setModel(tableModel);
        return jTable;
    }

    public static JTable crearTablaResultados(ArrayList<Token> resultados) {
        Token[] resultadosToken = listarTokens(resultados);
        System.out.println(resultados.size());
        String[] headerErrores = new String[]{"Tipo de Token","Lexema", "Fila", "Columna"};
        String[][] datosErrores = crearListadoResultado(resultadosToken);
        return getjTable(datosErrores,headerErrores);
    }

    public static String[][] crearListadoResultado(Token[] tokens){
        String[][] datosEnteros = new String[tokens.length][];
        for (int k = 0; k < tokens.length;k++){
            datosEnteros[k] = new String[]{String.valueOf(tokens[k].getTipo()),tokens[k].getLexema(), String.valueOf(tokens[k].getPosicion().getWidth()),
                    String.valueOf(tokens[k].getPosicion().getHeight())};
        }
        return datosEnteros;
    }

    public static String[][] crearListadoErrores(Token[] tokens){
        String[][] datosEnteros = new String[tokens.length][];
        for (int k = 0; k < tokens.length;k++){
            datosEnteros[k] = new String[]{tokens[k].getLexema(), String.valueOf(Integer.valueOf((int) tokens[k].getPosicion().getWidth())),
                    String.valueOf(tokens[k].getPosicion().getHeight())};
        }
        return datosEnteros;
    }

    public static JTable crearTablas(ArrayList<Token> errores) {
        Token[] erroresToken = listarTokens(errores);
        String[] headerErrores = new String[]{"Lexema erroneo", "Fila", "Columna"};
        String[][] datosErrores = crearListadoErrores(erroresToken);
        return getjTable(datosErrores,headerErrores);
    }

    public static String[] listarLexema(Token[] tokens) {
        String[] lexemas = new String[tokens.length];
        for (int k = 0; k < tokens.length; k++) {
            lexemas[k] = tokens[k].getLexema();
        }
        return lexemas;
    }

    public static String[] listarX(Token[] tokens) {
        String[] dimensionesX = new String[tokens.length];
        for (int k = 0; k < tokens.length; k++) {
            dimensionesX[k] = String.valueOf(tokens[k].getPosicion().getWidth());
        }
        return dimensionesX;
    }

    public static String[] listarY(Token[] tokens) {
        String[] dimensionesY = new String[tokens.length];
        for (int k = 0; k < tokens.length; k++) {
            dimensionesY[k] = String.valueOf(tokens[k].getPosicion().getHeight());
        }
        return dimensionesY;
    }

    public static String[] listarTipos(Token[] tokens){
        String[] tiposTokens = new String[tokens.length];
        for (int k = 0; k < tokens.length;k++){
            tiposTokens[k] = String.valueOf(tokens[k].getTipo());
        }
        return tiposTokens;
    }

    public static Token[] listarTokens(ArrayList<Token> tokens){
        Token[] tokens1 = new Token[tokens.size()];
        for (int k = 0; k < tokens.size();k++){
            tokens1[k] = tokens.get(k);
        }
        return tokens1;
    }
}
