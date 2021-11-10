package Sintactico;

import java.util.LinkedList;

public class Nodo {

    private NoTerminal noTerminalNodo;
    private LinkedList<Nodo> hijos;
    private boolean tieneHijos;

    public Nodo(){

    }

    public NoTerminal getTerminalNodo() {
        return noTerminalNodo;
    }

    public void setTerminalNodo(NoTerminal noTerminalNodo) {
        this.noTerminalNodo = noTerminalNodo;
    }

    public LinkedList<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(LinkedList<Nodo> hijos) {
        this.hijos = hijos;
    }
}
