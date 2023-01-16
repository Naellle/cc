
public class CreditInfo {
    private double summa; //сумма
    private double rate; //процент
    private double pay; //платеж
    private String clientType; //тип

    public void setCreditInfo(String scString[]) { //вводные данные

        summa = Double.parseDouble(scString[0]);  //парсим
        pay = Double.parseDouble(scString[1]);
        rate = Double.parseDouble(scString[2]);
        clientType = scString[3];
    }

    public double getCreditInfoLength(String scString[]) {
        return scString.length;
    }

    public double getSumma() {
        return summa;
    }

    public double getRate() {
        return rate;
    }

    public double getPay() {
        return pay;
    }

    public String getClientType() {
        return clientType;
    }
}