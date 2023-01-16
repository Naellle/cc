public class Calculator {

    public int getInformation(CreditInfo CreditInfo) throws CalculatorException {
        if (CreditInfo.getSumma() < 0) {
            throw new CalculatorException("Некорректная информация");
        }
        if (CreditInfo.getPay() < 0) {
            throw new CalculatorException("Некорректная информация");
        }
        if (CreditInfo.getRate() < 0) {
            throw new CalculatorException("Некорректная информация");
        } else {
            if (CreditInfo.getClientType().equalsIgnoreCase("business")) {
                boolean abc;
                abc = ((CreditInfo.getSumma() - (CreditInfo.getPay() * 12)) + (CreditInfo.getSumma() / 100 * CreditInfo.getRate()) - (CreditInfo.getPay() * 12) < CreditInfo.getSumma());
                if (abc) {
                    return 1;
                } else {
                    throw new CalculatorException("Некорректная информация");
                }
            } else if (CreditInfo.getSumma() + (CreditInfo.getSumma() / 100 * CreditInfo.getRate()) - (CreditInfo.getPay() * 12) < CreditInfo.getSumma()) {
                return 1;
            } else {
                throw new CalculatorException("Некорректная информация");
            }
        }
    }

    public void getCalculation(CreditInfo CreditInfo) {
        double s = CreditInfo.getSumma(); //сумма
        double r = CreditInfo.getRate(); //процент
        double p = CreditInfo.getPay(); //платеж
        String client = CreditInfo.getClientType(); //тип
        double sum = 0;
        double result = 0;

        if (client.equalsIgnoreCase("business")) {
            result = s;
            s = result - (p * 12);
        } else {
            result = s + (s / 100 * r);
            sum = sum + (s / 100 * r);
            s = result - (p * 12);
        }

        while (s > 0) {
            result = s + (s / 100 * r);
            sum = sum + (s / 100 * r);
            s = result - (p * 12);
        }
        System.out.println("Итого к оплате: " + result);
        System.out.println("Выгода банка: " + sum);

    }
}
