

import java.util.Random;
import java.util.Scanner;

class Wallet2 {
    //Створюю клас з рахунками всіх карток
    private double activeBalanceUAH = 0;
    private double activeBalanceUSD = 0;
    private double activeBalanceEUR = 0;
    private double exchangeUSD = 36.93;
    private double exchangeEUR = 39.33;
    //створюю (клас)об'єкт для унікального 16-значного коду
    StringBuilder uniCode = new StringBuilder();
    Random random = new Random();
    Scanner scan = new Scanner(System.in);


    //конструктор
    Wallet2(double activeBalanceUAH, double activeBalanceUSD, double activeBalanceEUR, double exchangeUSD, double exchangeEUR) {
        this.activeBalanceUAH = activeBalanceUAH;
        this.activeBalanceUSD = activeBalanceUSD;
        this.activeBalanceEUR = activeBalanceEUR;
        this.exchangeUSD = exchangeUSD;
        this.exchangeEUR = exchangeEUR;
    }

    Wallet2() {
    }

    //Створення початкового балансу та 16-значного коду
    private int inputBalance(double bal) {
        activeBalanceUAH=bal;
        for (int i=1; i<17; i++ ) {
            int randNum = random.nextInt(10);
            uniCode.append(randNum);
            if (i%4==0) uniCode.append(' ');
        }
        return 0;
    }


    //типізований параметризований метод
    private double buy10USD(double volume) {
        activeBalanceUAH -= volume * exchangeUSD;
        activeBalanceUSD += 10;
        return volume * exchangeUSD;
    }
    private int buy10USD(int volume) {
        activeBalanceUAH -= volume * exchangeUSD;
        activeBalanceUSD += 10;
        return (int) (volume * exchangeUSD);
    }


    //Статистика кожної ітерації(перевантажений метод)
    private void statistics() {
        System.out.println("_____________________________2ий гаманець_____________________________________________________");
        System.out.println("Ваш унікальний код рахунку: " + uniCode.toString());
        System.out.println("Баланс Вашої крартки: " + (double) Math.round(activeBalanceUAH * 100) /100 + " гривень");
        System.out.println("Баланс Вашої 1 валютної крартки: " + activeBalanceUSD + " $");
        System.out.println("Баланс Вашої 2 валютної крартки: " + activeBalanceEUR + " €");
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

    public void setExchangeUSD(double exchangeUSD) {
        this.exchangeUSD = exchangeUSD;
    }

    public void setExchangeEUR(double exchangeEUR) {
        this.exchangeEUR = exchangeEUR;
    }

    //___ІНКАПСУЛЬОВАНІ МЕТОДИ____________
    public void inputBalanceDemo(double bal){ //<<<<<<<<<<<<<--------------------------2
        inputBalance(bal);
    }
    public double buy10USDDemo(double volume){
        return buy10USD(volume);
    }
    public double buy10USDDemo(int volume){
        return buy10USD(volume);
    }
    public void statisticsDemo(){
        statistics();
    }

}

