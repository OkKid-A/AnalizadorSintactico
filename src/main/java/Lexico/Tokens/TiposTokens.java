package Lexico.Tokens;

public enum TiposTokens {
    IDENTIFICADOR(0),
    NUMERO(1),
    STRING(2),
    RESERVADA(3),
    OPERADOR(4),
    COMENTARIO(5),
    ESPACIOS(6),
    PARENTESIS(7),
    ERROR(-1);

    int tipo;

    TiposTokens(int tipo) {
        this.tipo = tipo;
    }

    public static TiposTokens TiposTokens(int tipo) {
        switch (tipo) {
            case 0:
                return IDENTIFICADOR;
            case 1:
                return NUMERO;
            case 2:
                return STRING;
            case 3:
                return RESERVADA;
            case 4:
                return OPERADOR;
            case 5:
                return COMENTARIO;
            case 6:
                return ESPACIOS;
            case 7:
                return PARENTESIS;
            default:
                return ERROR;
        }
    }

}

