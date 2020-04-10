package lesson2;

public class Calculator {
  public String doOperation(String x, String y, String op) {

    try {
      int a = Integer.parseInt(x);
      int b = Integer.parseInt(y);
      try {

        if (op.equals("add")) return String.format("%d + %d = %d", a, b, a + b);
        if (op.equals("sub")) return String.format("%d - %d = %d", a, b, a - b);
        if (op.equals("div")) return String.format("%d / %d = %d", a, b, a / b);
        if (op.equals("mul")) return String.format("%d + %d = %d", a, b, a * b);
      } catch (ArithmeticException e) {
        return "you can't divide by 0";
      } catch (NumberFormatException e) {
         return "you can't  cast to int";
      } catch (IllegalArgumentException e) {
        return "Smt went wrong";
      }
    }catch (NumberFormatException e){
      return "no parameter";
    }
    return null;
  }
}
