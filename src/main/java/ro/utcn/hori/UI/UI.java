package ro.utcn.hori.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UI {
    private JFrame frame;
    private JTextField field1;
    private JTextField result;
    private JTextField field2;
    private JButton computeButton;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplicationButton;
    private JButton divisionButton;
    private JButton integrationButton;
    private JButton derivativeButton;
    private JLabel title;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPanel mainPanel;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JPanel westPanel;
    private JPanel eastPanel;
    private JPanel centerButtonPanel;

    public UI() {
        initComponents();

        editComponentsSettings();

        setPanelLayouts();

        // populate northPanel
        northPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        northPanel.add(title);
        northPanel.add(Box.createRigidArea(new Dimension(0, 40)));

        populateCenterPanel();

        // populate westPanel
        westPanel.add(Box.createRigidArea(new Dimension(20, 0)));

        // populate eastPanel
        eastPanel.add(Box.createRigidArea(new Dimension(20, 0)));

        // add lower level panels to top level container
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(eastPanel, BorderLayout.EAST);

        frame.setSize(400, 400);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        frame = new JFrame();
        field1 = new JTextField();
        field2 = new JTextField();
        result = new JTextField();
        addButton = new JButton("add");
        subtractButton = new JButton("subtract");
        multiplicationButton = new JButton("multiplication");
        divisionButton = new JButton("division");
        integrationButton = new JButton("integration");
        derivativeButton = new JButton("derivative");
        computeButton = new JButton("compute");
        title = new JLabel("Polynomial Calculator", SwingConstants.CENTER);
        label1 = new JLabel("Polynom 1");
        label2 = new JLabel("Polynom 2");
        label3 = new JLabel("Result" );
        mainPanel = new JPanel();
        northPanel = new JPanel();
        centerPanel = new JPanel();
        westPanel = new JPanel();
        eastPanel = new JPanel();
        centerButtonPanel = new JPanel();
    }
    private void editComponentsSettings() {
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setFocusPainted(false);
        subtractButton.setFocusPainted(false);
        multiplicationButton.setFocusPainted(false);
        divisionButton.setFocusPainted(false);
        integrationButton.setFocusPainted(false);
        derivativeButton.setFocusPainted(false);
        computeButton.setFocusPainted(false);
        field1.setFont(new Font("Dialog", Font.PLAIN, 15));
        field2.setFont(new Font("Dialog", Font.PLAIN, 15));
        result.setFont(new Font("Dialog", Font.PLAIN, 15));
        result.setEditable(false);
        title.setFont(new Font("Dialog", Font.BOLD, 16));
    }
    private void setPanelLayouts() {
        centerButtonPanel.setLayout(new GridBagLayout());

        mainPanel.setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.X_AXIS));
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.X_AXIS));
    }
    private void populateCenterPanel() {
        centerPanel.add(label1);
        centerPanel.add(field1);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(label2);
        centerPanel.add(field2);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        GridBagConstraints constr = new GridBagConstraints();
        constr.anchor = GridBagConstraints.CENTER;
        constr.weightx = 1;
        constr.weighty = 1;
        constr.fill = GridBagConstraints.HORIZONTAL;

        constr.gridx = 0;
        constr.gridy = 0;
        centerButtonPanel.add(addButton, constr);

        constr.gridx = 1;
        constr.gridy = 0;
        centerButtonPanel.add(subtractButton, constr);

        constr.gridx = 0;
        constr.gridy = 1;
        centerButtonPanel.add(multiplicationButton, constr);

        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.weightx = 1;
        constr.gridx = 1;
        constr.gridy = 1;
        centerButtonPanel.add(divisionButton, constr);

        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.weightx = 1;
        constr.gridx = 0;
        constr.gridy = 2;
        centerButtonPanel.add(integrationButton, constr);

        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.weightx = 1;
        constr.gridx = 1;
        constr.gridy = 2;
        centerButtonPanel.add(derivativeButton, constr);

        centerPanel.add(centerButtonPanel);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(label3);
        centerPanel.add(result);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    }

    public String getField1Value() {
        return field1.getText();
    }
    public String getField2Value() {
        return field2.getText();
    }
    public void setResult(String s) {
        result.setText(s.length() != 0 ? s : "0");
    }

    public void addAddButtonActionListener(ActionListener al) {
        addButton.addActionListener(al);
    }
    public void addSubtractButtonActionListener(ActionListener al) {
        subtractButton.addActionListener(al);
    }
    public void addMultiplicationButtonActionListener(ActionListener al) {
        multiplicationButton.addActionListener(al);
    }
    public void addDivisionButtonActionListener(ActionListener al) {
        divisionButton.addActionListener(al);
    }
    public void addIntegrationButtonActionListener(ActionListener al) {
        integrationButton.addActionListener(al);
    }
    public void addDerivativeButtonActionListener(ActionListener al) {
        derivativeButton.addActionListener(al);
    }


    public void show() {
        frame.setVisible(true);
    }

}
