package Lexico.Tokens;

import java.awt.*;

public class Token {

    private TiposTokens tipo;
    private String lexema;
    private Object valorRelativo;
    private Dimension posicion;

    public Token(String lexema, int tipo, Dimension posicion) {
        this.lexema = lexema;
        this.tipo = TiposTokens.TiposTokens(tipo);
        this.posicion = posicion;
    }

    public TiposTokens getTipo() {
        return tipo;
    }

    public void setTipo(TiposTokens tipo) {
        this.tipo = tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public Dimension getPosicion() {
        return posicion;
    }

    public void setPosicion(Dimension posicion) {
        this.posicion = posicion;
    }
}
