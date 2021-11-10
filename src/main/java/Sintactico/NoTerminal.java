package Sintactico;

import java.util.ArrayList;

public class NoTerminal {

    private ArrayList<NoTerminal> produccion;
    private boolean esTerminal;
    private String terminal;
    private ArrayList<String> primeros;
    private ArrayList<String> siguientes;

    public NoTerminal(ArrayList<NoTerminal> produccion){
        this.produccion = produccion;
    }

    public NoTerminal(String terminal) {
        this.terminal = terminal;
    }
    

    public ArrayList<String> getSiguientes() {
        return siguientes;
    }

    public void setSiguientes(ArrayList<String> siguientes) {
        this.siguientes = siguientes;
    }

    public ArrayList<NoTerminal> getProduccion() {
        return produccion;
    }

    public void setProduccion(ArrayList<NoTerminal> produccion) {
        this.produccion = produccion;
    }

    public boolean isEsTerminal() {
        return esTerminal;
    }

    public void setEsTerminal(boolean esTerminal) {
        this.esTerminal = esTerminal;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public ArrayList<String> getPrimeros() {
        return primeros;
    }

    public void setPrimeros(ArrayList<String> primeros) {
        this.primeros = primeros;
    }
}
