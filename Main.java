
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws CalculatorException {
        String t1 = "human";
        String t2 = "business";

        CreditInfo data = new CreditInfo();
        Calculator calc = new Calculator();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму кредита, ежемесячный платеж, процент и тип клиента через пробел:");
        String scString = scanner.nextLine();
        String information[] = scString.split(" ");
        data.setCreditInfo(information);


        if (data.getCreditInfoLength(information) == 4) {
            information = null;
            try {
                boolean Human;
                Human = t1.equalsIgnoreCase(data.getClientType()); //игнорируем регистр
                boolean Business;
                Business = t2.equalsIgnoreCase(data.getClientType());
                if (Human || Business) {
                    if (calc.getInformation(data) == 1) {
                        calc.getCalculation(data);
                    }
                } else throw new CalculatorException("Некорректный тип клиента, выберите Human или Business");
            } catch (NumberFormatException t) {
                t.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException t) {
                t.printStackTrace();
            } catch (NullPointerException t) {
                t.printStackTrace();
            }
        } else throw new CalculatorException("Мало информации");
    }
}
