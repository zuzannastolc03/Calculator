import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Objects;

public class Frame extends JFrame implements ActionListener{
    Logic logic = new Logic();
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
    JButton comma = new JButton();
    JButton backspace = new JButton();
    JButton delete = new JButton();
    String labelText = "";
    JLabel label = new JLabel(labelText, SwingConstants.RIGHT);
    ArrayList<JButton> numericalButtonsList = new ArrayList<>();
    ArrayList<JButton> operationalButtonsList = new ArrayList<>();
    Boolean lastEquationWasEquality = false;
    Character[] mathematicalOperators = {'+', '-', 'x', '/'};

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

        createButton(equal, "=", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(FIRST_COLUMN_X_COORDINATE , 6*FIRST_ROW_Y_COORDINATE+5*JBUTTON_HEIGHT), panel, operationalButtonsList);
        createButton(zero, "0", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(2*FIRST_COLUMN_X_COORDINATE + SMALL_JBUTTON_WIDTH, 6*FIRST_ROW_Y_COORDINATE+5*JBUTTON_HEIGHT), panel, numericalButtonsList);
        createButton(comma, ".", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(3*FIRST_COLUMN_X_COORDINATE + 2*SMALL_JBUTTON_WIDTH, 6*FIRST_ROW_Y_COORDINATE+5*JBUTTON_HEIGHT), panel, numericalButtonsList);
        createButton(addition, "+", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(4*FIRST_COLUMN_X_COORDINATE + 3*SMALL_JBUTTON_WIDTH, 6*FIRST_ROW_Y_COORDINATE+5*JBUTTON_HEIGHT), panel, operationalButtonsList);
        createButton(one, "1", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(FIRST_COLUMN_X_COORDINATE, 5*FIRST_ROW_Y_COORDINATE+4*JBUTTON_HEIGHT), panel, numericalButtonsList);
        createButton(two, "2", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(2*FIRST_COLUMN_X_COORDINATE + SMALL_JBUTTON_WIDTH, 5*FIRST_ROW_Y_COORDINATE+4*JBUTTON_HEIGHT), panel, numericalButtonsList);
        createButton(three, "3", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(3*FIRST_COLUMN_X_COORDINATE + 2*SMALL_JBUTTON_WIDTH, 5*FIRST_ROW_Y_COORDINATE+4*JBUTTON_HEIGHT), panel, numericalButtonsList);
        createButton(subtraction, "-", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(4*FIRST_COLUMN_X_COORDINATE + 3*SMALL_JBUTTON_WIDTH, 5*FIRST_ROW_Y_COORDINATE+4*JBUTTON_HEIGHT), panel, operationalButtonsList);
        createButton(four, "4", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(FIRST_COLUMN_X_COORDINATE, 4*FIRST_ROW_Y_COORDINATE+3*JBUTTON_HEIGHT), panel, numericalButtonsList);
        createButton(five, "5", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(2*FIRST_COLUMN_X_COORDINATE + SMALL_JBUTTON_WIDTH, 4*FIRST_ROW_Y_COORDINATE+3*JBUTTON_HEIGHT), panel, numericalButtonsList);
        createButton(six, "6", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(3*FIRST_COLUMN_X_COORDINATE + 2*SMALL_JBUTTON_WIDTH, 4*FIRST_ROW_Y_COORDINATE+3*JBUTTON_HEIGHT), panel, numericalButtonsList);
        createButton(multiplication, "x", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(4*FIRST_COLUMN_X_COORDINATE + 3*SMALL_JBUTTON_WIDTH, 4*FIRST_ROW_Y_COORDINATE+3*JBUTTON_HEIGHT), panel, operationalButtonsList);
        createButton(seven, "7", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(FIRST_COLUMN_X_COORDINATE, 3*FIRST_ROW_Y_COORDINATE+2*JBUTTON_HEIGHT), panel, numericalButtonsList);
        createButton(eight, "8", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(2*FIRST_COLUMN_X_COORDINATE + SMALL_JBUTTON_WIDTH, 3*FIRST_ROW_Y_COORDINATE+2*JBUTTON_HEIGHT), panel, numericalButtonsList);
        createButton(nine, "9", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(3*FIRST_COLUMN_X_COORDINATE + 2*SMALL_JBUTTON_WIDTH, 3*FIRST_ROW_Y_COORDINATE+2*JBUTTON_HEIGHT), panel, numericalButtonsList);
        createButton(division, "/", SMALL_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(4*FIRST_COLUMN_X_COORDINATE + 3*SMALL_JBUTTON_WIDTH, 3*FIRST_ROW_Y_COORDINATE+2*JBUTTON_HEIGHT), panel, operationalButtonsList);
        createButton(delete, "CE", BIG_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(FIRST_COLUMN_X_COORDINATE, 2*FIRST_ROW_Y_COORDINATE+JBUTTON_HEIGHT), panel, operationalButtonsList);
        createButton(backspace, "⌫", BIG_JBUTTON_WIDTH, JBUTTON_HEIGHT, new Point2D.Double(3*FIRST_COLUMN_X_COORDINATE + 2*SMALL_JBUTTON_WIDTH, 2*FIRST_ROW_Y_COORDINATE+JBUTTON_HEIGHT), panel, operationalButtonsList);

        for(JButton button: numericalButtonsList){
            button.addActionListener(this);
        }
        for(JButton button: operationalButtonsList){
            button.addActionListener(this);
        }

        label.setText(labelText);
        label.setSize(MAP_DIMENSION - 2*FIRST_COLUMN_X_COORDINATE, JBUTTON_HEIGHT);
        label.setBackground(Color.WHITE);
        label.setFont(new Font("Cuckoo", Font.PLAIN, 25));
        label.setFocusable(false);
        label.setLocation(FIRST_COLUMN_X_COORDINATE, FIRST_ROW_Y_COORDINATE);
        label.setOpaque(true);
        panel.add(label);
    }
    public static void createButton(JButton button, String text, int width, int height, Point2D location, JPanel panel, ArrayList<JButton> buttonsList){
        button.setText(text);
        button.setSize(width, height);
        button.setBackground(Color.WHITE);
        button.setFont(new Font("Cuckoo", Font.PLAIN, 25));
        button.setFocusable(false);
        button.setLocation((int)location.getX(), (int)location.getY());
        button.setOpaque(true);
        panel.add(button);
        buttonsList.add(button);
    }
    public void clearTextField(){
        labelText = "";
        label.setText(labelText);
    }
    public void upgradeTextField(JButton button){
        labelText = labelText + button.getText();
        label.setText(labelText);
    }
    public char getLastCharacter(String labelText){
        return labelText.charAt(labelText.length()-1);
    }

    public int checkPositionOfAChar(String text, Character ch){
        int position=0;
        for(int i=0; i<text.length(); i++){
            if(text.charAt(i) == ch){
                position = i;
            }
        }
        return position;
    }
    public boolean compareTheLastCharacterToArrayItems(String text) {
        boolean tempStatus=false;
        if(text.length()>0){
            for (Character operator : mathematicalOperators) {
                if (Objects.equals(getLastCharacter(text), operator)) {
                    tempStatus=true;
                    break;
                }
            }
        }
        return !tempStatus;
    }

    public boolean checkIfAStringContainAnElementOfAnArray(String text) {
        boolean tempStatus=false;
        if(text.length()>0){
            for (Character operator : mathematicalOperators) {
                if (text.contains(operator.toString())) {
                    tempStatus = true;
                    break;
                }
            }
        }
        return tempStatus;
    }

    public boolean checkAStringForDotsExistence(String text) {
        boolean tempStatus=false;
        if(text.length()>0){
            for (Character operator : mathematicalOperators) {
                if(checkPositionOfAChar(text, operator) != 0){
                    if (text.substring(checkPositionOfAChar(text, operator)+1).contains(".")) {
                        tempStatus = true;
                        break;
                    }
                }
            }
        }
        return tempStatus;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(label.getText().length()<26){
            for(JButton button: numericalButtonsList){
                if(e.getSource() == button){
                    if(Objects.equals(label.getText(), logic.zeroWarning)) {
                        clearTextField();
                    }
                    else {
                        if(button.getText().equals(".")){
                            if(label.getText().length()>0){
                                if(label.getText().contains(".")){
                                    if(!Objects.equals(getLastCharacter(label.getText()), '.') && compareTheLastCharacterToArrayItems(label.getText())){
                                        if((checkIfAStringContainAnElementOfAnArray(label.getText()) && !checkAStringForDotsExistence(label.getText()))){
                                            upgradeTextField(button);
                                        }
                                    }
                                }
                                else{
                                    upgradeTextField(button);
                                }
                            }
                        }
                        else{
                            if(lastEquationWasEquality){
                                clearTextField();
                                lastEquationWasEquality = false;
                            }
                            upgradeTextField(button);
                        }
                    }
                }
            }
        }
        if (label.getText().length()<28) {
            for(JButton button: operationalButtonsList) {
                if (e.getSource() == button) {
                    if(Objects.equals(label.getText(), logic.zeroWarning)){
                        clearTextField();
                    }
                    else{
                        switch (button.getText()) {
                            case "+", "-", "x", "/" -> {
                                if(labelText.length()>0 && !checkIfAStringContainAnElementOfAnArray(label.getText()) && !Objects.equals(getLastCharacter(label.getText()), '.')){
                                    lastEquationWasEquality = false;
                                    upgradeTextField(button);
                                }
                                else if((checkIfAStringContainAnElementOfAnArray(label.getText()) && !Objects.equals(getLastCharacter(label.getText()), '.') && compareTheLastCharacterToArrayItems(label.getText()))){
                                    lastEquationWasEquality = false;
                                    labelText = logic.equal(labelText);
                                    label.setText(labelText);
                                    if(!Objects.equals(label.getText(), logic.zeroWarning)){
                                        upgradeTextField(button);
                                    }
                                }
                            }
                            case "=" -> {
                                if(checkIfAStringContainAnElementOfAnArray(label.getText())){
                                    if(labelText.length()>0 && compareTheLastCharacterToArrayItems(label.getText()) && !Objects.equals(getLastCharacter(label.getText()), '.')){
                                        labelText = logic.equal(labelText);
                                        label.setText(labelText);
                                        lastEquationWasEquality = true;
                                    }
                                }
                            }
                            case "CE" -> {
                                clearTextField();
                            }
                            case "⌫" -> {
                                if (labelText.length() > 0) {
                                    if(lastEquationWasEquality){
                                        clearTextField();
                                    }
                                    else {
                                        labelText = labelText.substring(0, labelText.length() - 1);
                                        label.setText(labelText);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
