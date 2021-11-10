package UI;

import javax.swing.*;

public interface Ventana {

    String TITLE = "Automata";

    static void fixComponents(JFrame frame, JPanel panel) {
        frame.add(panel);
        frame.setTitle(TITLE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}
