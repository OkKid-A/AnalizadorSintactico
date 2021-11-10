        package Lexico.Tokens;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public enum Simbolo {
    ERROR(-1),
    LETRA(0),
    DIGITO(1),
    PUNCTUA(2),
    OPERADORES(3),
    GROUPING(4),
    PUNTO(5),
    SPACE(6),
    COMILLAS(7);

    int tipo;

    Simbolo(int tipo){
        this.tipo = tipo;
    }

    public static Simbolo definirTipo(char parte){
        if ((isLetter(parte) && parte!='ñ')||parte=='_'||parte=='-'){
            return LETRA;
        }
        if(isDigit(parte)){
            return DIGITO;
        }
        if (parte=='-'){
            return PUNCTUA;
        }
        if (parte=='('||parte==')'){
            return GROUPING;
        }
        if (parte=='+'||parte=='*'){
            return OPERADORES;
        }
        if (parte=='.'){
            return PUNTO;
        }
        if (parte == ' '|| parte == '\n'||parte == '\r'){
            return SPACE;
        }
        if (parte == '"'){
            return COMILLAS;
        }
        return ERROR;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
