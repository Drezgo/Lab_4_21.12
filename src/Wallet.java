

import java.util.Random;
import java.util.Scanner;

class Wallet {
    Wallet2 wallet2 = new Wallet2();
    Wallet3 wallet3 = new Wallet3();
    //Створюю клас з рахунками всіх карток
    private double activeBalanceUAH = 0;
    private double activeBalanceUSD = 0;
    private double activeBalanceEUR = 0;
    final double exchangeUSD = 36.93;
    final double exchangeEUR = 39.33;
    //створюю (клас)об'єкт для унікального 16-значного коду
    StringBuilder uniCode = new StringBuilder();
    Random random = new Random();
    Scanner scan = new Scanner(System.in);


    //конструктори
    Wallet(double activeBalanceUAH, double activeBalanceUSD, double activeBalanceEUR) {
        this.activeBalanceUAH = activeBalanceUAH;
        this.activeBalanceUSD = activeBalanceUSD;
        this.activeBalanceEUR = activeBalanceEUR;
//        this.exchangeUSD = exchangeUSD;
//        this.exchangeEUR = exchangeEUR;
    }

    Wallet() {
    }

    //Створення початкового балансу та 16-значного коду
    Wallet inputBalance() {
        System.out.print("Введіть суму на яку хочете поповнити баланс картки (у UAH) : ");
        activeBalanceUAH=scan.nextDouble();
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
        activeBalanceUAH -= volume;
        activeBalanceUSD = (double) Math.round(volume / exchangeUSD * 100) /100;
        return activeBalanceUSD;
    }

    //конвертація
    double convertToEUR() {
        System.out.print("Введіть суму яку хочете конвертувати (у UAH) : ");
        double volume=scan.nextDouble();
        activeBalanceUAH -= volume;
        activeBalanceEUR = (double) Math.round(volume / exchangeEUR * 100) /100;
        return activeBalanceEUR;
    }

    //типізований параметризований метод
    double buy10USD(double volume) {
        activeBalanceUAH -= volume * exchangeUSD;
        activeBalanceUSD += 10;
        return volume * exchangeUSD;
    }
    int buy10USD(int volume) {
        activeBalanceUAH -= volume * exchangeUSD;
        activeBalanceUSD += 10;
        return (int) (volume * exchangeUSD);
    }

    boolean isRivne() {
        return wallet2.getActiveBalanceUSD() == wallet3.getExchangeUSD();
    }

    //Статистика кожної ітерації (перевантажений метод)
    void statistics() {
        System.out.println();
        System.out.println("__________________________ "+exchangeUSD+" $ / "+exchangeEUR+" € ________________________________");
        System.out.println("Ваш унікальний код рахунку: " + uniCode.toString());
        System.out.println("Баланс Вашої крартки: " + (double) Math.round(activeBalanceUAH * 100) /100 + " гривень");
        System.out.println("Баланс Вашої 1ої валютної крартки: " + activeBalanceUSD + " $");
        System.out.println("Баланс Вашої 2ої валютної крартки: " + activeBalanceEUR + " €");
        System.out.println();
    }

    //______GET___&___SET____
    public double getActiveBalanceUAH() {
        return activeBalanceUAH;
    }

    public double getActiveBalanceUSD() {
        return activeBalanceUSD;
    }

    public double getActiveBalanceEUR() {
        return activeBalanceEUR;
    }

    public double getExchangeUSD() {
        return exchangeUSD;
    }

    public double getExchangeEUR() {
        return exchangeEUR;
    }

    public void setActiveBalanceUAH(double activeBalanceUAH) {
        this.activeBalanceUAH = activeBalanceUAH;
    }

    public void setActiveBalanceUSD(double activeBalanceUSD) {
        this.activeBalanceUSD = activeBalanceUSD;
    }

    public void setActiveBalanceEUR(double activeBalanceEUR) {
        this.activeBalanceEUR = activeBalanceEUR;
    }

//    public void setExchangeUSD(double exchangeUSD) {
//        this.exchangeUSD = exchangeUSD;
//    }
//
//    public void setExchangeEUR(double exchangeEUR) {
//        this.exchangeEUR = exchangeEUR;
//    }
}
