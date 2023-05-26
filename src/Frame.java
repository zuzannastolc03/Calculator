import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class Frame extends JFrame {
    final static int MAP_DIMENSION = 400;
    final static int SMALL_JBUTTON_WIDTH = 90;
    final static int JBUTTON_HEIGHT = 60;
    final static int FIRST_COLUMN_X_COORDINATE = (int)((MAP_DIMENSION-4*SMALL_JBUTTON_WIDTH)/5);
    final static int FIRST_ROW_Y_COORDINATE = (int)((MAP_DIMENSION-6*JBUTTON_HEIGHT)/7);
    final static int BIG_JBUTTON_WIDTH = 2*SMALL_JBUTTON_WIDTH + FIRST_COLUMN_X_COORDINATE;
    JPanel panel = new JPanel();
    JButton zero = new JButton();
    JButton one = new JButton();
    JButton two = new JButton();
    JButton three = new JButton();
    JButton four = new JButton();
    JButton five = new JButton();
    JButton six = new JButton();
    JButton seven = new JButton();
    JButton eight = new JButton();
    JButton nine = new JButton();
    JButton addition = new JButton();
    JButton subtraction = new JButton();
    JButton multiplication = new JButton();
    JButton division = new JButton();
    JButton equal = new JButton();
    JButton coma = new JButton();
    JButton backspace = new JButton();
    JButton delete = new JButton();
    Label label;
    Frame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Calculator");

        panel.setPreferredSize(new Dimension(MAP_DIMENSION, MAP_DIMENSION));
        panel.setBackground(Color.GRAY);
        panel.setOpaque(true);
        panel.setLayout(null);

        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        createButton(equal, "=", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(FIRST_COLUMN_X_COORDINATE , 6*FIRST_ROW_Y_COORDINATE+5*JBUTTON_HEIGHT), panel);
        createButton(zero, "0", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(2*FIRST_COLUMN_X_COORDINATE + SMALL_JBUTTON_WIDTH, 6*FIRST_ROW_Y_COORDINATE+5*JBUTTON_HEIGHT), panel);
        createButton(coma, ",", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(3*FIRST_COLUMN_X_COORDINATE + 2*SMALL_JBUTTON_WIDTH, 6*FIRST_ROW_Y_COORDINATE+5*JBUTTON_HEIGHT), panel);
        createButton(addition, "+", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(4*FIRST_COLUMN_X_COORDINATE + 3*SMALL_JBUTTON_WIDTH, 6*FIRST_ROW_Y_COORDINATE+5*JBUTTON_HEIGHT), panel);
        createButton(one, "1", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(FIRST_COLUMN_X_COORDINATE, 5*FIRST_ROW_Y_COORDINATE+4*JBUTTON_HEIGHT), panel);
        createButton(two, "2", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(2*FIRST_COLUMN_X_COORDINATE + SMALL_JBUTTON_WIDTH, 5*FIRST_ROW_Y_COORDINATE+4*JBUTTON_HEIGHT), panel);
        createButton(three, "3", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(3*FIRST_COLUMN_X_COORDINATE + 2*SMALL_JBUTTON_WIDTH, 5*FIRST_ROW_Y_COORDINATE+4*JBUTTON_HEIGHT), panel);
        createButton(subtraction, "-", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(4*FIRST_COLUMN_X_COORDINATE + 3*SMALL_JBUTTON_WIDTH, 5*FIRST_ROW_Y_COORDINATE+4*JBUTTON_HEIGHT), panel);
        createButton(four, "4", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(FIRST_COLUMN_X_COORDINATE, 4*FIRST_ROW_Y_COORDINATE+3*JBUTTON_HEIGHT), panel);
        createButton(five, "5", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(2*FIRST_COLUMN_X_COORDINATE + SMALL_JBUTTON_WIDTH, 4*FIRST_ROW_Y_COORDINATE+3*JBUTTON_HEIGHT), panel);
        createButton(six, "6", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(3*FIRST_COLUMN_X_COORDINATE + 2*SMALL_JBUTTON_WIDTH, 4*FIRST_ROW_Y_COORDINATE+3*JBUTTON_HEIGHT), panel);
        createButton(multiplication, "x", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(4*FIRST_COLUMN_X_COORDINATE + 3*SMALL_JBUTTON_WIDTH, 4*FIRST_ROW_Y_COORDINATE+3*JBUTTON_HEIGHT), panel);
        createButton(seven, "7", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(FIRST_COLUMN_X_COORDINATE, 3*FIRST_ROW_Y_COORDINATE+2*JBUTTON_HEIGHT), panel);
        createButton(eight, "8", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(2*FIRST_COLUMN_X_COORDINATE + SMALL_JBUTTON_WIDTH, 3*FIRST_ROW_Y_COORDINATE+2*JBUTTON_HEIGHT), panel);
        createButton(nine, "9", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(3*FIRST_COLUMN_X_COORDINATE + 2*SMALL_JBUTTON_WIDTH, 3*FIRST_ROW_Y_COORDINATE+2*JBUTTON_HEIGHT), panel);
        createButton(division, "/", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(4*FIRST_COLUMN_X_COORDINATE + 3*SMALL_JBUTTON_WIDTH, 3*FIRST_ROW_Y_COORDINATE+2*JBUTTON_HEIGHT), panel);
        createButton(delete, "CE", BIG_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(FIRST_COLUMN_X_COORDINATE, 2*FIRST_ROW_Y_COORDINATE+JBUTTON_HEIGHT), panel);
        createButton(backspace, "<---", BIG_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(3*FIRST_COLUMN_X_COORDINATE + 2*SMALL_JBUTTON_WIDTH, 2*FIRST_ROW_Y_COORDINATE+JBUTTON_HEIGHT), panel);


    }
    public static void createButton(JButton button, String text, int width, int height, Point2D location, JPanel panel){
        button.setText(text);
        button.setSize(width, height);
        button.setBackground(Color.WHITE);
        button.setFont(new Font("Cuckoo", Font.PLAIN, 25));
        button.setFocusable(false);
        button.setLocation((int)location.getX(), (int)location.getY());
        button.setOpaque(true);
        panel.add(button);
    }
}
