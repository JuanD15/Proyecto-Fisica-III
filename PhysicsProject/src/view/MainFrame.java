package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Juan David Carrillo Parra
 */
public class MainFrame extends JFrame {

    private JLabel heading;
    private JLabel txtForce;
    private JLabel txtArea;
    private JLabel txtResult;
    private JPanel calculatePanel;
    private JPanel buttonsPanel;
    private JTextField inputForce;
    private JTextField inputArea;
    private JTextField outputResult;
    private JButton calculate;
    private JButton convert;

    public MainFrame(ActionListener listener) {
        super("Proyecto Fisica");
        this.setBackground(Color.LIGHT_GRAY);
        this.initComponents(listener);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new BorderLayout());
        this.initCPanel();
        this.add(heading, BorderLayout.NORTH);
        this.add(calculatePanel, BorderLayout.CENTER);
        this.initBPanel(listener);
        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

    private void initCPanel() {
        heading = new JLabel("<HTML><H2>Calculadora de Presiones</H2></HTML>");
        txtForce = new JLabel("<HTML><H3>Ingrese la fuerza (N)</H3></HTML>");
        txtArea = new JLabel("<HTML><H3>Ingrese el area (m^2)</H3></HTML>");
        txtResult = new JLabel("<HTML><H3>La presion es igual a </H3></HTML>");
        calculatePanel = new JPanel(new GridLayout(3, 2));
        buttonsPanel = new JPanel(new GridLayout(1, 2));
        inputForce = new JTextField(15);
        inputArea = new JTextField(15);
        outputResult = new JTextField(15);
        outputResult.setEnabled(false);
        calculatePanel.add(txtForce);
        calculatePanel.add(inputForce);
        calculatePanel.add(txtArea);
        calculatePanel.add(inputArea);
        calculatePanel.add(txtResult);
        calculatePanel.add(outputResult);
    }

    private void initBPanel(ActionListener listener) {
        calculate = new JButton("<HTML><H3>Calcular</H3></HTML>");
        calculate.addActionListener(listener);
        calculate.setActionCommand("calculate");
        convert = new JButton("<HTML><H3>Convertir unidades</H3></HTML>");
        convert.addActionListener(listener);
        convert.setActionCommand("convert");
        buttonsPanel.add(calculate);
        buttonsPanel.add(convert);
    }

    public String getForce() {
        return inputForce.getText();
    }

    public String getArea() {
        return inputArea.getText();
    }

    public void setResult(String message) {
        outputResult.setText(message);
    }
    
    
}
