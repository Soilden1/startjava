class Calculator {
    
    public static void main(String[] args) {
        int num1 = 6;
        int num2 = 2;
        char sign = '^';
        int resault = 1;

        if (sign == '+') {
            resault = num1 + num2;
        } else if (sign == '-') {
            resault = num1 - num2;
        } else if (sign == '*') {
            resault = num1 * num2;
        } else if (sign == '/') {
            resault = num1 / num2;
        } else if (sign == '%') {
            resault = num1 % num2;
        } else if (sign == '^') {
            for (int i = 1; i <= num2; i++) {
                resault *= num1;
            }
        }

        System.out.println(num1 + " " + sign + " " + num2 + " = " + resault);
    }
}