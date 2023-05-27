public class Logic {
    String zeroWarning = "You can't divide by 0!";
    public String addition(float a, float b){
        return String.valueOf(a+b);
    }
    public String subtraction(float a, float b){
        return String.valueOf(a-b);
    }
    public String multiplication(float a, float b){
        return String.valueOf(a*b);
    }
    public String division(float a, float b){
        if(b!=0){
            return String.valueOf(a/b);
        }
        else{
            return zeroWarning;
        }
    }
    public String equal(String equation){
        String result = "";
        for(int i=0; i<equation.length(); i++){
            switch (equation.charAt(i)) {
                case '+' -> result = addition(Float.parseFloat(equation.substring(0, i)), Float.parseFloat(equation.substring(i+1)));
                case '-' -> result = subtraction(Float.parseFloat(equation.substring(0, i)), Float.parseFloat(equation.substring(i+1)));
                case 'x' -> result = multiplication(Float.parseFloat(equation.substring(0, i)), Float.parseFloat(equation.substring(i+1)));
                case '/' -> result = division(Float.parseFloat(equation.substring(0, i)), Float.parseFloat(equation.substring(i+1)));
            }
        }
        return result;
    }
}
