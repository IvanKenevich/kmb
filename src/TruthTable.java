import javax.swing.*;
import java.awt.*;

public class TruthTable extends JPanel{
    private int numVars; // The number of 'switches' in the circuit
    private int numOutputs; // Number of desirable outputs
    private JTextField[][] outputs;
    private int width, height;

    private int tableOriginX, tableOriginY;
    private int tableCellSize;

    private int textOffsetX, textOffsetY;
    private int textFieldOffsetX, textFieldOffsetY;

    private  JTextField test,test2;

    private boolean[][] truthTable;

    public TruthTable (int variableCount, int outputCount) {
        super(null);
        numVars = variableCount;
        numOutputs = outputCount;

        width = numVars + numOutputs;
        height = (int) Math.pow(2,numVars);

        tableOriginX = 10;
        tableOriginY = 10;
        tableCellSize = 30;

        textOffsetX = (int) (tableCellSize / 2.5);
        textOffsetY = (int) (tableCellSize / 1.5);

        textFieldOffsetX = 2;
        textFieldOffsetY = 2;

        outputs = new JTextField[height][numOutputs];
        truthTable = new boolean[height][width];

        populate();
        setOutputsToTrue();
        repaint();
        setupGUI();
    }

    private void setupGUI() {
        for (int row = 0; row<height; row++) {
            for (int col = 0; col<numOutputs; col++) {
                outputs[row][col] = new JTextField("",1);
                outputs[row][col].setSize(28,28);
                outputs[row][col].setLocation(tableOriginX + (col + numVars) * tableCellSize + textFieldOffsetX,
                        tableOriginY + row * tableCellSize + textFieldOffsetY);
                this.add(outputs[row][col]);
            }
        }
    }

    /*
        The algorithm is similar to the one a human would use.
        It fills out the table in a column-major order, always starting with 0 (false)
        and alternating it with 1 (true) in cycles whose length is a power of two,
        with exponent decremented in each new column.
     */
    private void populate() {
        int switchingIndex, switchingIndexIncrement;
        boolean value;
        for (int col = 0; col<numVars; col++) {
            switchingIndexIncrement = (int) Math.pow(2,numVars-col-1);
            switchingIndex = switchingIndexIncrement;
            value = false;
            for (int row = 0; row<height; row++) {
                if (row == switchingIndex) {
                    value = !value;
                    switchingIndex += switchingIndexIncrement;
                }
                truthTable[row][col] = value;
            }
        }
    }

    public boolean getOutput (int row, int col) {
        return truthTable[row][col];
    }
    public void setOutput (int row, int col, boolean value) {
        truthTable[row][col] = value;
    }
    private void setOutputsToTrue (){
        for (int col = numVars; col<width; col++) {
            for (int row = 0; row<height; row++) {
                truthTable[row][col] = true;
            }
        }
    }

    @Override
    public String toString () {
        String output = "";
        for (int row = 0; row<height; row++) {
            output+="\n";
            for (int col = 0; col < width; col++) {
                if (truthTable[row][col])
                    output+="1 ";
                else
                    output+="0 ";
            }
        }
        return output;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.black);

//                                     RECTANGLE-BASED DRAWING OF THE TABLE
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                g.drawRect(tableOriginX + col * tableCellSize,
                           tableOriginY + row * tableCellSize, tableCellSize, tableCellSize);
                if (col<numVars) {
                    if (truthTable[row][col])
                        g.drawString("1", tableOriginX + col * tableCellSize + textOffsetX,
                                tableOriginY + row * tableCellSize + textOffsetY);
                    else
                        g.drawString("0", tableOriginX + col * tableCellSize + textOffsetX,
                                tableOriginY + row * tableCellSize + textOffsetY);
                }
            }
        }
    }
}