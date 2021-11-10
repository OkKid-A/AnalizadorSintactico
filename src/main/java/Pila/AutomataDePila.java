package Pila;

import Sintactico.NoTerminal;

import java.util.ArrayList;

public class AutomataDePila {

    private ArrayList<NoTerminal> pila;
    private int size;

    public AutomataDePila(){
        pila = new ArrayList<NoTerminal>();
        size = 0;
    }

    public void push(NoTerminal noTerminal){
        pila.add(noTerminal);
        size =+ 1;
    }

    public NoTerminal pop(){
        if (size>0){
            NoTerminal noTerminal = pila.get(size);
            pila.remove(size);
            size =- 1;
            return noTerminal;
        }
        return null;
    }

    public void shift(String terminal){
        NoTerminal analizable = pop();
        analizable.getSiguientes();
    }
}
