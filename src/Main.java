import javax.swing.*;

/**
 * Created by Ivan on 3/9/2017.
 */
public class Main {
    public static void main(String[] args) {
        TruthTable tt = new TruthTable(4,2);
        JFrame frame = new JFrame("Truth Table");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.add(tt);
        frame.setVisible(true);
    }
}
