import javax.swing.*;
import java.awt.*;

public class TruthTable {
    public int numInputs; // The number of 'switches' in the circuit
    public int numOutputs; // Number of desirable outputs
    public int width, height;


    private boolean[][] table;

    public TruthTable(int numberOfInputs, int numberOfOutputs) {
        numInputs = numberOfInputs;
        numOutputs = numberOfOutputs;

        width = numInputs + numOutputs;
        height = (int) Math.pow(2, numInputs);

        table = new boolean[height][width];

        populate();
        setOutputsToTrue();
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
        for (int col = 0; col < numInputs; col++) {
            switchingIndexIncrement = (int) Math.pow(2, numInputs - col - 1);
            switchingIndex = switchingIndexIncrement;
            value = false;
            for (int row = 0; row < height; row++) {
                if (row == switchingIndex) {
                    value = !value;
                    switchingIndex += switchingIndexIncrement;
                }
                table[row][col] = value;
            }
        }
    }

    public boolean getValue(int row, int col) {
        return table[row][col];
    }

    public void setValue(int row, int col, boolean value) {
        table[row][col] = value;
    }

    private void setOutputsToTrue() {
        for (int col = numInputs; col < width; col++) {
            for (int row = 0; row < height; row++) {
                table[row][col] = true;
            }
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (int row = 0; row < height; row++) {
            output += "\n";
            for (int col = 0; col < width; col++) {
                if (table[row][col])
                    output += "1 ";
                else
                    output += "0 ";
            }
        }
        return output;
    }

}