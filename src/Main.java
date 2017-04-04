import javax.swing.*;

/**
 * Created by Ivan on 3/9/2017.
 */
public class Main {
    public static void main(String[] args) {
        TruthTablePanel ttp = new TruthTablePanel();

        SetupPanel sp = new SetupPanel();

        JFrame frame = new JFrame("Truth Table");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(ttp);
        frame.setVisible(true);
    }
}
