import javax.swing.*;
import java.awt.*;

/**
 * Created by kenei135 on 4/4/2017.
 */
public class TruthTablePanel extends JPanel {
    
    public TruthTable truthTable;

    private JTextField[][] outputs;
    private int tableOriginX, tableOriginY;

    private int tableCellSize;
    private int textOffsetX, textOffsetY;
    private int textFieldOffsetX, textFieldOffsetY;

    public TruthTablePanel() {
        super(null);
        
        truthTable = new TruthTable(5,15);
        
        outputs = new JTextField[truthTable.height][truthTable.numOutputs];
        
        tableOriginX = 10;
        tableOriginY = 10;
        tableCellSize = 30;

        textOffsetX = (int) (tableCellSize / 2.5);
        textOffsetY = (int) (tableCellSize / 1.5);

        textFieldOffsetX = 2;
        textFieldOffsetY = 2;
        
        setupGUI();
    }

    private void setupGUI() {
        for (int row = 0; row < truthTable.height; row++) {
            for (int col = 0; col < truthTable.numOutputs; col++) {
                outputs[row][col] = new JTextField("", 1);
                outputs[row][col].setSize(28, 28);
                outputs[row][col].setLocation(tableOriginX + (col + truthTable.numInputs) * tableCellSize + textFieldOffsetX,
                        tableOriginY + row * tableCellSize + textFieldOffsetY);
                this.add(outputs[row][col]);
            }
        }
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.black);

//                                     RECTANGLE-BASED DRAWING OF THE TABLE
        for (int col = 0; col < truthTable.width; col++) {
            for (int row = 0; row < truthTable.height; row++) {
                g.drawRect(tableOriginX + col * tableCellSize,
                        tableOriginY + row * tableCellSize, tableCellSize, tableCellSize);
                if (col < truthTable.numInputs) {
                    if (truthTable.getValue(row, col))
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
