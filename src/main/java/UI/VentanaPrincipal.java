package UI;

import Lexico.AnalizadorLexico;
import Componentes.Tablas;
import Lector.Lector;
import Lexico.AnalizadorLexico;
import Lexico.Tokens.Token;
import Lexico.Tokens.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static UI.Ventana.TITLE;

public class VentanaPrincipal extends JFrame {

    private JPanel panelPrincipal;
    private JPanel textoEntradaPanel;
    private JTextArea areaEntrada;
    private JTextArea lineasTextoArea;
    private JScrollPane textPane;
    private JPanel textoInternoPanel;
    private JButton cargarArchivoButton;
    private JButton procesarTextoButton;
    private JPanel mostrarProcesoPanel;
    private JTextArea procesoTextArea;
    private JPanel resultadosPanel;
    private JTable erroresTable;
    private JTable resultadosTable;
    private JScrollPane erroresPane;
    private JScrollPane resultadosPane;
    private Lector lector;
    private String textoPrincipal;
    private AnalizadorLexico analizadorLexico;
    private ArrayList<Token> tokens;
    private ArrayList<Token> errores;
    public VentanaPrincipal(AnalizadorLexico automata) {
        lector = new Lector();
        this.analizadorLexico = automata;
        escribirNumeroLinea();
        fixComponents(this, panelPrincipal);
        setButtons();
    }

    public void setButtons() {
        cargarArchivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser haciaArchivo = new JFileChooser();
                haciaArchivo.showSaveDialog(null);
                textoPrincipal = String.valueOf(lector.fetchFullText(haciaArchivo.getSelectedFile().getAbsolutePath()));
                areaEntrada.setText(textoPrincipal);
                escribirNumeroLinea();
            }
        });
        procesarTextoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean conErrores = analizadorLexico.evaluarTexto(areaEntrada.getText());
                resultadosPanel.removeAll();
                resultadosPanel.setLayout(new GridLayout());
                if (!conErrores){
                    resultadosTable = Tablas.crearTablaResultados(analizadorLexico.getResultados());
                    resultadosPane.removeAll();
                    resultadosPane = new JScrollPane(resultadosTable);
                    resultadosPane.add(resultadosTable);
                    resultadosPane.setVisible(true);
                    resultadosPane.getViewport().add(resultadosTable);
                    resultadosTable.repaint();
                    resultadosPanel.add(resultadosPane);
                } else {
                    erroresTable = Tablas.crearTablas(analizadorLexico.getErrores());
                    erroresPane.removeAll();
                    erroresPane = new JScrollPane(erroresTable);
                    erroresPane.add(erroresTable);
                    erroresPane.setVisible(true);
                    erroresPane.getViewport().add(erroresTable);
                    erroresTable.repaint();
                    resultadosPanel.add(erroresPane);
                }
                resultadosPanel.repaint();
                redundar().repaint();
                redundar().revalidate();
            }
        });
    }

    public void escribirNumeroLinea() {
        areaEntrada.getDocument().addDocumentListener(new DocumentListener() {
            public String enumerarLineas() {
                int ultimaLinea = areaEntrada.getDocument().getLength();
                Element raiz = areaEntrada.getDocument().getDefaultRootElement();
                String linea = "1" + System.getProperty("line.separator");
                for (int i = 2; i < raiz.getElementIndex(ultimaLinea) + 2; i++) {
                    linea += i + System.getProperty("line.separator");
                }
                return linea;
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                lineasTextoArea.setText(enumerarLineas());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                lineasTextoArea.setText(enumerarLineas());

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                lineasTextoArea.setText(enumerarLineas());

            }
        });
    }

    private void fixComponents(JFrame frame, JPanel panel) {
        frame.add(panel);
        frame.setTitle(TITLE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    private void createUIComponents() {
        textoInternoPanel = new JPanel();
        textoInternoPanel.setLayout(new BorderLayout());
        areaEntrada = new JTextArea();
        lineasTextoArea = new JTextArea("1");
        lineasTextoArea.setEditable(false);
        lineasTextoArea.setFocusable(false);
        textoInternoPanel.add(lineasTextoArea, BorderLayout.WEST);
        textPane = new JScrollPane();
        textoInternoPanel.add(textPane, BorderLayout.EAST);
        textPane.getViewport().add(areaEntrada);
        textPane.setRowHeaderView(lineasTextoArea);
    }

    private JFrame redundar(){
        return this;
    }
}
