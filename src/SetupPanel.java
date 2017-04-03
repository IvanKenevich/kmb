import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel for the first window of the program.
 * Asks user for the parameters of the truth table and
 * feeds these parameters to the next class.
 * @author Ivan Kenevich
 */
public class SetupPanel extends JPanel {

    private int numInputs;
    private int numOutputs;

    private JLabel mainLabel, numInputsLabel, numOutputsLabel;
    private JTextField numInputsField, numOutputsField;
    private JButton generateButton;

    public SetupPanel() {
        super(new GridBagLayout());
        numInputs = 2;
        numOutputs = 1;

        setupGUI();
        setupListeners();
    }

    private void setupGUI() {
        GridBagConstraints gbc;

        mainLabel = new JLabel();
        mainLabel.setText("Specify input and output count for your Truth Table");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.anchor = GridBagConstraints.WEST;
        this.add(mainLabel, gbc);

        numInputsLabel = new JLabel();
        numInputsLabel.setText("Number of Inputs");
        numInputsLabel.setToolTipText("Switches that you will flick");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        this.add(numInputsLabel, gbc);

        numInputsField = new JTextField();
        numInputsField.setColumns(1);
        numInputsField.setHorizontalAlignment(0);
        numInputsField.setText("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(numInputsField, gbc);

        numOutputsLabel = new JLabel();
        numOutputsLabel.setText("Number of Outputs");
        numOutputsLabel.setToolTipText("Lights, valves and similar stuff");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        this.add(numOutputsLabel, gbc);

        numOutputsField = new JTextField();
        numOutputsField.setColumns(2);
        numOutputsField.setHorizontalAlignment(0);
        numOutputsField.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(numOutputsField, gbc);

        generateButton = new JButton();
        generateButton.setText("Generate");
        generateButton.setToolTipText("Generates an empty truth table template");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(generateButton, gbc);

        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 30;
        this.add(spacer1, gbc);

        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 1;
        gbc.gridheight = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 30;
        this.add(spacer2, gbc);

        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        this.add(spacer3, gbc);

        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 30;
        this.add(spacer4, gbc);

        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 30;
        this.add(spacer5, gbc);

        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 10;
        this.add(spacer6, gbc);

        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 7;
        gbc.weighty = 10.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(spacer7, gbc);

        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 7;
        gbc.weighty = 10.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(spacer8, gbc);
    }

    private void setupListeners() {
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numInputs = Integer.parseInt(numInputsField.getText());
                numOutputs = Integer.parseInt(numOutputsField.getText());
            }
        });
    }

    public int getNumInputs() {
        return numInputs;
    }

    public int getNumOutputs() {
        return numOutputs;
    }

}
