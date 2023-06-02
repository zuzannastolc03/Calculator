import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Frame extends JFrame implements ActionListener {
    Logic logic = new Logic();
    final static int MAP_DIMENSION = 400;
    final static int BUTTON_WIDTH = 90;
    final static int BUTTON_HEIGHT = 60;
    final static int FIRST_COLUMN_X_COORDINATE = ((MAP_DIMENSION - 4 * BUTTON_WIDTH) / 5);
    final static int FIRST_ROW_Y_COORDINATE = ((MAP_DIMENSION - 6 * BUTTON_HEIGHT) / 7);
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
    JButton leftParentheses = new JButton();
    JButton rightParentheses = new JButton();
    String labelText = "";
    JLabel label = new JLabel(labelText, SwingConstants.RIGHT);
    ArrayList<JButton> numericalButtonsArray = new ArrayList<>();
    ArrayList<JButton> operationalButtonsArray = new ArrayList<>();
    Boolean lastEquationWasEquality = false;
    char[] mathematicalOperators = {'/', 'x', '+', '-'};
    char[] parentheses = {'(', ')'};
    char[] numbers;
    boolean parenthesesOpened = false;


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

        createButton(equal, "=", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(FIRST_COLUMN_X_COORDINATE, 6 * FIRST_ROW_Y_COORDINATE + 5 * BUTTON_HEIGHT), panel, operationalButtonsArray);
        createButton(zero, "0", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(2 * FIRST_COLUMN_X_COORDINATE + BUTTON_WIDTH, 6 * FIRST_ROW_Y_COORDINATE + 5 * BUTTON_HEIGHT), panel, numericalButtonsArray);
        createButton(comma, ".", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(3 * FIRST_COLUMN_X_COORDINATE + 2 * BUTTON_WIDTH, 6 * FIRST_ROW_Y_COORDINATE + 5 * BUTTON_HEIGHT), panel, numericalButtonsArray);
        createButton(addition, "+", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(4 * FIRST_COLUMN_X_COORDINATE + 3 * BUTTON_WIDTH, 6 * FIRST_ROW_Y_COORDINATE + 5 * BUTTON_HEIGHT), panel, operationalButtonsArray);
        createButton(one, "1", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(FIRST_COLUMN_X_COORDINATE, 5 * FIRST_ROW_Y_COORDINATE + 4 * BUTTON_HEIGHT), panel, numericalButtonsArray);
        createButton(two, "2", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(2 * FIRST_COLUMN_X_COORDINATE + BUTTON_WIDTH, 5 * FIRST_ROW_Y_COORDINATE + 4 * BUTTON_HEIGHT), panel, numericalButtonsArray);
        createButton(three, "3", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(3 * FIRST_COLUMN_X_COORDINATE + 2 * BUTTON_WIDTH, 5 * FIRST_ROW_Y_COORDINATE + 4 * BUTTON_HEIGHT), panel, numericalButtonsArray);
        createButton(subtraction, "-", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(4 * FIRST_COLUMN_X_COORDINATE + 3 * BUTTON_WIDTH, 5 * FIRST_ROW_Y_COORDINATE + 4 * BUTTON_HEIGHT), panel, operationalButtonsArray);
        createButton(four, "4", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(FIRST_COLUMN_X_COORDINATE, 4 * FIRST_ROW_Y_COORDINATE + 3 * BUTTON_HEIGHT), panel, numericalButtonsArray);
        createButton(five, "5", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(2 * FIRST_COLUMN_X_COORDINATE + BUTTON_WIDTH, 4 * FIRST_ROW_Y_COORDINATE + 3 * BUTTON_HEIGHT), panel, numericalButtonsArray);
        createButton(six, "6", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(3 * FIRST_COLUMN_X_COORDINATE + 2 * BUTTON_WIDTH, 4 * FIRST_ROW_Y_COORDINATE + 3 * BUTTON_HEIGHT), panel, numericalButtonsArray);
        createButton(multiplication, "x", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(4 * FIRST_COLUMN_X_COORDINATE + 3 * BUTTON_WIDTH, 4 * FIRST_ROW_Y_COORDINATE + 3 * BUTTON_HEIGHT), panel, operationalButtonsArray);
        createButton(seven, "7", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(FIRST_COLUMN_X_COORDINATE, 3 * FIRST_ROW_Y_COORDINATE + 2 * BUTTON_HEIGHT), panel, numericalButtonsArray);
        createButton(eight, "8", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(2 * FIRST_COLUMN_X_COORDINATE + BUTTON_WIDTH, 3 * FIRST_ROW_Y_COORDINATE + 2 * BUTTON_HEIGHT), panel, numericalButtonsArray);
        createButton(nine, "9", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(3 * FIRST_COLUMN_X_COORDINATE + 2 * BUTTON_WIDTH, 3 * FIRST_ROW_Y_COORDINATE + 2 * BUTTON_HEIGHT), panel, numericalButtonsArray);
        createButton(division, "/", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(4 * FIRST_COLUMN_X_COORDINATE + 3 * BUTTON_WIDTH, 3 * FIRST_ROW_Y_COORDINATE + 2 * BUTTON_HEIGHT), panel, operationalButtonsArray);
        createButton(leftParentheses, "(", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(FIRST_COLUMN_X_COORDINATE, 2 * FIRST_ROW_Y_COORDINATE + BUTTON_HEIGHT), panel, numericalButtonsArray);
        createButton(rightParentheses, ")", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(2 * FIRST_COLUMN_X_COORDINATE + BUTTON_WIDTH, 2 * FIRST_ROW_Y_COORDINATE + BUTTON_HEIGHT), panel, numericalButtonsArray);
        createButton(delete, "CE", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(3 * FIRST_COLUMN_X_COORDINATE + 2 * BUTTON_WIDTH, 2 * FIRST_ROW_Y_COORDINATE + BUTTON_HEIGHT), panel, operationalButtonsArray);
        createButton(backspace, "⌫", BUTTON_WIDTH, BUTTON_HEIGHT, new Point2D.Double(4 * FIRST_COLUMN_X_COORDINATE + 3 * BUTTON_WIDTH, 2 * FIRST_ROW_Y_COORDINATE + BUTTON_HEIGHT), panel, operationalButtonsArray);

        for (JButton button : numericalButtonsArray) {
            button.addActionListener(this);
        }
        for (JButton button : operationalButtonsArray) {
            button.addActionListener(this);
        }

        numbers = new char[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (char) (i + '0');
        }

        label.setText(labelText);
        label.setSize(MAP_DIMENSION - 2 * FIRST_COLUMN_X_COORDINATE, BUTTON_HEIGHT);
        label.setBackground(Color.WHITE);
        label.setFont(new Font("Cuckoo", Font.PLAIN, 25));
        label.setFocusable(false);
        label.setLocation(FIRST_COLUMN_X_COORDINATE, FIRST_ROW_Y_COORDINATE);
        label.setOpaque(true);
        panel.add(label);
    }

    public static void createButton(JButton button, String text, int width, int height, Point2D location, JPanel panel, ArrayList<JButton> buttonsList) {
        button.setText(text);
        button.setSize(width, height);
        button.setBackground(Color.WHITE);
        button.setFont(new Font("Cuckoo", Font.PLAIN, 25));
        button.setFocusable(false);
        button.setLocation((int) location.getX(), (int) location.getY());
        button.setOpaque(true);
        panel.add(button);
        buttonsList.add(button);
    }

    public void clearTextField() {
        labelText = "";
        label.setText(labelText);
    }

    public void updateTextField(JButton button) {
        labelText = labelText + button.getText();
        label.setText(labelText);
    }

    public char getLastCharacter(String labelText) {
        return labelText.charAt(labelText.length() - 1);
    }

    public boolean compareTheLastCharacterToArrayItems(String text, char[] array) {
        boolean tempStatus = false;
        if (text.length() > 0) {
            for (Character character : array) {
                if (Objects.equals(getLastCharacter(text), character)) {
                    tempStatus = true;
                    break;
                }
            }
        }
        return tempStatus;
    }

    public boolean checkIfAStringContainsAnElementOfAnArray(String text, char[] array) {
        boolean tempStatus = false;
        if (text.length() > 0) {
            for (Character character : array) {
                if (text.contains(character.toString())) {
                    tempStatus = true;
                    break;
                }
            }
        }
        return tempStatus;
    }

    public boolean checkAStringForDotsExistence(String text, char[] operators) {
        boolean tempStatus = false;
        String regEx = "[" + String.valueOf(operators) + "]";
        if (text.length() > 0) {
            if (text.split(regEx)[text.split(regEx).length - 1].contains(".")) {
                tempStatus = true;
            }
        }
        return tempStatus;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (label.getText().length() < 26) {
            for (JButton button : numericalButtonsArray) {
                if (e.getSource() == button) {
                    if (Objects.equals(label.getText(), logic.zeroWarning)) {
                        clearTextField();
                    } else {
                        switch (button.getText()) {
                            case "." -> {
                                if (!label.getText().isEmpty() && compareTheLastCharacterToArrayItems(label.getText(), numbers)) {
                                    if (!label.getText().contains(".") || (label.getText().contains(".") && checkIfAStringContainsAnElementOfAnArray(label.getText(), mathematicalOperators) && !checkAStringForDotsExistence(label.getText(), mathematicalOperators))) {
                                        updateTextField(button);
                                    }
                                }
                            }
                            case "(" -> {
                                if (label.getText().isEmpty() || compareTheLastCharacterToArrayItems(label.getText(), mathematicalOperators)) {
                                    parenthesesOpened = true;
                                    updateTextField(button);
                                }
                            }
                            case ")" -> {
                                if (compareTheLastCharacterToArrayItems(label.getText(), numbers) && label.getText().chars().filter(ch -> ch == '(').count() > label.getText().chars().filter(ch -> ch == ')').count()) {
                                    parenthesesOpened = false;
                                    updateTextField(button);
                                }
                            }
                            default -> {
                                if (lastEquationWasEquality) {
                                    clearTextField();
                                    lastEquationWasEquality = false;
                                }
                                updateTextField(button);
                            }
                        }
                    }
                }
            }
        }
        if (label.getText().length() < 28) {
            for (JButton button : operationalButtonsArray) {
                if (e.getSource() == button) {
                    if (Objects.equals(label.getText(), logic.zeroWarning)) {
                        clearTextField();
                    } else {
                        switch (button.getText()) {
                            case "+", "-", "x", "/" -> {
                                if (Objects.equals(label.getText(), logic.zeroWarning)) {
                                    clearTextField();
                                } else {
                                    if ((!label.getText().isEmpty() && ((compareTheLastCharacterToArrayItems(label.getText(), numbers)) || (compareTheLastCharacterToArrayItems(label.getText(), parentheses))) && !parenthesesOpened) || ((compareTheLastCharacterToArrayItems(label.getText(), parentheses) || label.getText().isEmpty()) && Objects.equals(button.getText(), "-"))) {
                                        lastEquationWasEquality = false;
                                        updateTextField(button);
                                    }
                                }
                            }
                            case "=" -> {
                                if (checkIfAStringContainsAnElementOfAnArray(label.getText(), mathematicalOperators)) {
                                    if (!label.getText().isEmpty() && !compareTheLastCharacterToArrayItems(label.getText(), mathematicalOperators) && !Objects.equals(getLastCharacter(label.getText()), '.') && Objects.equals(label.getText().chars().filter(ch -> ch == '(').count(), label.getText().chars().filter(ch -> ch == ')').count())) {
                                        labelText = logic.equal(labelText, mathematicalOperators);
                                        label.setText(labelText);
                                        lastEquationWasEquality = true;
                                    }
                                }
                            }
                            case "CE" -> clearTextField();
                            case "⌫" -> {
                                if (!label.getText().isEmpty()) {
                                    if (lastEquationWasEquality) {
                                        clearTextField();
                                    } else {
                                        labelText = labelText.substring(0, labelText.length() - 1);
                                        label.setText(labelText);
                                    }
                                }
                            }
                            default -> throw new IllegalStateException("Unexpected value: " + button.getText());
                        }
                    }
                }
            }
        }
    }
}
