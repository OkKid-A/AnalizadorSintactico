package Lexico;

import Lexico.Tokens.Simbolo;
import Lexico.Tokens.Token;

import java.awt.*;
import java.util.ArrayList;

import static Lexico.Tokens.TiposTokens.ERROR;

public class AnalizadorLexico {

    private ArrayList<Estado> estados;
    private Estado estadoActual;
    private ArrayList<Token> resultados;
    private ArrayList<Token> errores;
    private boolean conErrores;
    private int row;
    private int column;

    public AnalizadorLexico(ArrayList<Estado> estados) {
        this.estados = estados;
        estadoActual = estados.get(0);
    }

    public void avanzarEstado(String lexema, Simbolo simbolo) {
        int[] transiciones = estadoActual.getSiguientes();
        if (simbolo != Simbolo.ERROR && simbolo != Simbolo.SPACE) {
            try {
                estadoActual = estados.get(transiciones[simbolo.getTipo()]);
            } catch (IndexOutOfBoundsException e){
                estadoActual = estados.get(0);
            }
        } else {
            int estadoFinal = 0;
            if (estadoActual.isFinalizacion()) {
                estadoFinal = estadoActual.getTipoFinal();
            } else if (simbolo != Simbolo.SPACE) {
                conErrores = true;
                estadoFinal = -1;
            }
            estadoActual = estados.get(0);
            procesarToken(lexema, estadoFinal);
        }
        System.out.println(estadoActual.getNumero() + "2341234");
    }

    public boolean evaluarTexto(String aEvaluar) {
        column = 1;
        row = 1;
        this.resultados = new ArrayList<Token>();
        this.errores = new ArrayList<Token>();
        ArrayList<Token> tokensEncontrados = new ArrayList<Token>();
        conErrores = false;
        char[] deconstruido = aEvaluar.toCharArray();
        String tmp = "";
        for (int k = 0; k < deconstruido.length; k++) {
            System.out.println(deconstruido[k]);
            try {
                Simbolo simbolo = Simbolo.definirTipo(deconstruido[k]);
                System.out.println(simbolo.getTipo());
                tmp = tmp + deconstruido[k];
                System.out.println(tmp);
                column++;
                if (deconstruido[k] == '\n') {
                    row++;
                    column =1;
                }
                avanzarEstado(tmp, simbolo);

            } catch (NullPointerException e) {
                tmp = "";
            }
        }
        return conErrores;
    }

    public void procesarToken(String lexema, int estadoFinal) throws NullPointerException {
        Token token = new Token(lexema, estadoFinal, new Dimension(row, column));
        if (!lexema.equals(" ")&&!lexema.equals("\n")) {
            if (token.getTipo() == ERROR) {
                errores.add(token);
            } else {
                resultados.add(token);
            }
        }
        throw new NullPointerException();
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }

    public ArrayList<Token> getResultados() {
        return resultados;
    }

    public void setResultados(ArrayList<Token> resultados) {
        this.resultados = resultados;
    }

    public ArrayList<Token> getErrores() {
        return errores;
    }

    public void setErrores(ArrayList<Token> errores) {
        this.errores = errores;
    }

    public boolean isConErrores() {
        return conErrores;
    }

    public void setConErrores(boolean conErrores) {
        this.conErrores = conErrores;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}

