

import java.util.Random;
import java.util.Scanner;

class Wallet {
    Wallet2 wallet2 = new Wallet2();
    Wallet3 wallet3 = new Wallet3();
    //Створюю клас з рахунками всіх карток
    private double activeBalanceUAH1 = 0;
    private double activeBalanceUSD1 = 0;
    private double activeBalanceEUR1 = 0;
    double exchangeUSD1 = 36.93;
    double exchangeEUR1 = 39.33;
    //створюю (клас)об'єкт для унікального 16-значного коду
    StringBuilder uniCode = new StringBuilder();
    Random random = new Random();
    Scanner scan = new Scanner(System.in);


    //конструктори
    public Wallet(double activeBalanceUAH1, double activeBalanceUSD1, double activeBalanceEUR1, double exchangeEUR1, double exchangeUSD1) {
        this.activeBalanceUAH1 = activeBalanceUAH1;
        this.activeBalanceUSD1 = activeBalanceUSD1;
        this.activeBalanceEUR1 = activeBalanceEUR1;
        this.exchangeUSD1 = exchangeUSD1;
        this.exchangeEUR1 = exchangeEUR1;
    }

    Wallet() {
    }

    //Створення початкового балансу та 16-значного коду
    Wallet inputBalance() {
        System.out.print("Введіть суму на яку хочете поповнити баланс картки (у UAH) : ");
        activeBalanceUAH1 =scan.nextDouble();
        for (int i=1; i<17; i++ ) {
            int randNum = random.nextInt(10);
            uniCode.append(randNum);
            if (i%4==0) uniCode.append(' ');
        }
        return null;
    }

    //конвертація
    double convertToUSD() {
        System.out.print("Введіть суму яку хочете конвертувати (у UAH) : ");
        double volume=scan.nextDouble();
        activeBalanceUAH1 -= volume;
        activeBalanceUSD1 = (double) Math.round(volume / exchangeUSD1 * 100) /100;
        return activeBalanceUSD1;
    }

    //конвертація
    double convertToEUR() {
        System.out.print("Введіть суму яку хочете конвертувати (у UAH) : ");
        double volume=scan.nextDouble();
        activeBalanceUAH1 -= volume;
        activeBalanceEUR1 = (double) Math.round(volume / exchangeEUR1 * 100) /100;
        return activeBalanceEUR1;
    }

    //типізований параметризований метод
    double buy10USD(double volume) {
        activeBalanceUAH1 -= volume * exchangeUSD1;
        activeBalanceUSD1 += 10;
        return volume * exchangeUSD1;
    }
    int buy10USD(int volume) {
        activeBalanceUAH1 -= volume * exchangeUSD1;
        activeBalanceUSD1 += 10;
        return (int) (volume * exchangeUSD1);
    }

    boolean isRivne() {
        return wallet2.getActiveBalanceUSD1() == wallet3.getExchangeUSD1();
    }

    //Статистика кожної ітерації (перевантажений метод)
    void statistics() {
        System.out.println();
        System.out.println("__________________________ "+ exchangeUSD1 +" $ / "+ exchangeEUR1 +" € ________________________________");
        System.out.println("Ваш унікальний код рахунку: " + uniCode.toString());
        System.out.println("Баланс Вашої крартки: " + (double) Math.round(activeBalanceUAH1 * 100) /100 + " гривень");
        System.out.println("Баланс Вашої 1ої валютної крартки: " + activeBalanceUSD1 + " $");
        System.out.println("Баланс Вашої 2ої валютної крартки: " + activeBalanceEUR1 + " €");
        System.out.println();
    }

    //______GET___&___SET____
    public double getActiveBalanceUAH1() {
        return activeBalanceUAH1;
    }

    public double getActiveBalanceUSD1() {
        return activeBalanceUSD1;
    }

    public double getActiveBalanceEUR1() {
        return activeBalanceEUR1;
    }

    public double getExchangeUSD1() {
        return exchangeUSD1;
    }

    public double getExchangeEUR1() {
        return exchangeEUR1;
    }

    public void setActiveBalanceUAH1(double activeBalanceUAH1) {
        this.activeBalanceUAH1 = activeBalanceUAH1;
    }

    public void setActiveBalanceUSD1(double activeBalanceUSD1) {
        this.activeBalanceUSD1 = activeBalanceUSD1;
    }

    public void setActiveBalanceEUR1(double activeBalanceEUR1) {
        this.activeBalanceEUR1 = activeBalanceEUR1;
    }

    public void setExchangeUSD1(double exchangeUSD1) {
        this.exchangeUSD1 = exchangeUSD1;
    }

    public void setExchangeEUR1(double exchangeEUR1) {
        this.exchangeEUR1 = exchangeEUR1;
    }
}
