import Lexico.AnalizadorLexico;
import Lexico.Estado;
import UI.VentanaPrincipal;

import javax.swing.*;
import java.util.ArrayList;

public class Start {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ArrayList<Estado> estados = new ArrayList<Estado>();
                estados.add(new Estado(0,new int[]{2,3,5,6,7,5}));
                VentanaPrincipal introduccion = new VentanaPrincipal(new AnalizadorLexico(estados));
            }
        });
    }
}
