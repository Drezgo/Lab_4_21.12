
import java.util.Random;
import java.util.Scanner;

class Wallet3 {
    //Створюю клас з рахунками всіх карток
    static private double activeBalanceUAH = 0;
    static double activeBalanceUSD;
    static {
        activeBalanceUSD=0; //<<<<<<<<<<------------------------3
    }
    private static double activeBalanceEUR = 0;
    static private double exchangeUSD = 36.93;
    private double exchangeEUR = 39.33;
    //створюю (клас)об'єкт для унікального 16-значного коду
    static StringBuilder uniCode = new StringBuilder();
    Random random = new Random();
    Scanner scan = new Scanner(System.in);


    //конструктор
    Wallet3(double activeBalanceUAH, double activeBalanceUSD, double activeBalanceEUR, double exchangeUSD, double exchangeEUR) {
        this.activeBalanceUAH = activeBalanceUAH;
        this.activeBalanceUSD = activeBalanceUSD;
        this.activeBalanceEUR = activeBalanceEUR;
        this.exchangeUSD = exchangeUSD;
        this.exchangeEUR = exchangeEUR;
    }

    Wallet3() {
    }

    //Створення початкового балансу та 16-значного коду
    int inputBalance(double BalanceUAH) {
        activeBalanceUAH = BalanceUAH;
        for (int i=1; i<17; i++ ) {
            int randNum = random.nextInt(10);
            uniCode.append(randNum);
            if (i%4==0) uniCode.append(' ');
        }
        return 0;
    }


    //типізований параметризований метод
    double buy10USD(double volume) {
        activeBalanceUAH -= volume * exchangeUSD;
        activeBalanceUSD += 10;
        return volume * exchangeUSD;
    }
    static int buy10USD(int volume) { //<-----------------------------3
        activeBalanceUAH -= volume * exchangeUSD;
        activeBalanceUSD += 10;
        return (int) (volume * exchangeUSD);
    }


    //Статистика кожної ітерації(перевантажений метод)
    static void statistics() {
        System.out.println("_____________________________3ій гаманець_____________________________________________________");
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
        this.activeBalanceUSD =  activeBalanceUSD;
    }

    public void setActiveBalanceEUR(double activeBalanceEUR) {
        this.activeBalanceEUR = activeBalanceEUR;
    }

    public void setExchangeUSD(double exchangeUSD) {
        this.exchangeUSD = 2.0 * exchangeUSD; //<<<<<<<<-------------------------
    }

    public void setExchangeEUR(double exchangeEUR) {
        this.exchangeEUR = exchangeEUR;
    }
}

