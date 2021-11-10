package Lexico;


import Lexico.Tokens.Simbolo;

public class Estado {

    private int numero;
    private boolean finalizacion;
    private int tipoFinal;
    private Simbolo needed;
    private int[] siguientes;

    public Estado(int numero, int tipoFinal, int[] siguientes) {
        this.numero = numero;
        finalizacion = true;
        this.tipoFinal = tipoFinal;
        this.siguientes = siguientes;
    }

    public Estado(int numero, int[] siguientes) {
        this.numero = numero;
        this.siguientes = siguientes;
        finalizacion = false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(boolean finalizacion) {
        this.finalizacion = finalizacion;
    }

    public int getTipoFinal() {
        return tipoFinal;
    }

    public void setTipoFinal(int tipoFinal) {
        this.tipoFinal = tipoFinal;
    }

    public Simbolo getNeeded() {
        return needed;
    }

    public void setNeeded(Simbolo needed) {
        this.needed = needed;
    }

    public int[] getSiguientes() {
        return siguientes;
    }

    public void setSiguientes(int[] siguientes) {
        this.siguientes = siguientes;
    }
}
