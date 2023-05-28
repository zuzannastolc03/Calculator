import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Logic {
    String zeroWarning = "You can't divide by 0!";
    public String addition(BigDecimal a, BigDecimal b){
        return String.valueOf(a.add(b));
    }
    public String subtraction(BigDecimal a, BigDecimal b){
        return String.valueOf(a.subtract(b));
    }
    public String multiplication(BigDecimal a, BigDecimal b){
        return String.valueOf(a.multiply(b));
    }
    public String division(BigDecimal a, BigDecimal b){
        if(!Objects.equals(b, new BigDecimal(0))){
            return String.valueOf((a.divide(b, 10, RoundingMode.HALF_UP)).stripTrailingZeros());
        }
        else{
            return zeroWarning;
        }
    }
    public String equal(String equation){
        String result = "";
        for(int i=0; i<equation.length(); i++){
            switch (equation.charAt(i)) {
                case '+' -> result = addition(new BigDecimal(equation.substring(0, i)), new BigDecimal(equation.substring(i+1)));
                case '-' -> result = subtraction(new BigDecimal(equation.substring(0, i)), new BigDecimal(equation.substring(i+1)));
                case 'x' -> result = multiplication(new BigDecimal(equation.substring(0, i)), new BigDecimal(equation.substring(i+1)));
                case '/' -> result = division(new BigDecimal(equation.substring(0, i)), new BigDecimal(equation.substring(i+1)));
            }
        }
        return result;
    }
}
