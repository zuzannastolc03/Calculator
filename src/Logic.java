import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Logic {
    String zeroWarning = "You can't divide by 0!";

    public String addition(BigDecimal a, BigDecimal b) {
        return String.valueOf(a.add(b));
    }

    public String subtraction(BigDecimal a, BigDecimal b) {
        return String.valueOf(a.subtract(b));
    }

    public String multiplication(BigDecimal a, BigDecimal b) {
        return String.valueOf(a.multiply(b));
    }

    public String division(BigDecimal a, BigDecimal b) {
        if (!Objects.equals(b, new BigDecimal(0))) {
            return String.valueOf((a.divide(b, 10, RoundingMode.HALF_UP)).stripTrailingZeros());
        } else {
            return zeroWarning;
        }
    }

    public String equal(String equation, char[] operators) {
        String result = "";
//        String regEx = "[" + String.valueOf(operators) + "]";
//        ArrayList<Character> occuringSigns = new ArrayList<>();
//        System.out.println(Arrays.toString(equation.split(regEx)));
//        for (int i = 0; i < equation.length(); i++) {
//            switch (equation.charAt(i)) {
//                case '+' -> {
//                    System.out.println("Dodawanie");
//                    occuringSigns.add(equation.charAt(i));
////                    result = addition(new BigDecimal(equation.substring(0, i)), new BigDecimal(equation.substring(i + 1)));
//                }
//                case '-' -> {
//                    System.out.println("Odejmowanie");
//                    occuringSigns.add(equation.charAt(i));
////                    result = subtraction(new BigDecimal(equation.substring(0, i)), new BigDecimal(equation.substring(i + 1)));
//
//                }
//                case 'x' -> {
//                    System.out.println("Mnożenie");
//                    occuringSigns.add(equation.charAt(i));
////                    result = multiplication(new BigDecimal(equation.substring(0, i)), new BigDecimal(equation.substring(i + 1)));
//                }
//                case '/' -> {
//                    System.out.println("Dzielenie");
//                    occuringSigns.add(equation.charAt(i));
////                    result = division(new BigDecimal(equation.substring(0, i)), new BigDecimal(equation.substring(i + 1)));
//                }
//            }
//        }
//        System.out.println(occuringSigns);
        System.out.println(equation);
        return result;
    }
}
