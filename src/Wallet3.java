
import java.util.Random;
import java.util.Scanner;

class Wallet3 extends Wallet2 {             //<<<<<<<<<<<-------------------------------
    //Створюю клас з рахунками всіх карток
    static private double activeBalanceUAH3 = 0;
    static double activeBalanceUSD3;
    static {
        activeBalanceUSD3 =0; //<<<<<<<<<<------------------------3
    }
    private static double activeBalanceEUR3 = 0;
    static private double exchangeUSD3 = 36.93;
    private double exchangeEUR3 = 39.33;
    //створюю (клас)об'єкт для унікального 16-значного коду
    static StringBuilder uniCode = new StringBuilder();
    Random random = new Random();
    Scanner scan = new Scanner(System.in);


    //конструктор
    Wallet3(double activeBalanceUAH3, double activeBalanceUSD3, double activeBalanceEUR3, double exchangeUSD3, double exchangeEUR3) {
        this.activeBalanceUAH3 = activeBalanceUAH3;
        this.activeBalanceUSD3 = activeBalanceUSD3;
        this.activeBalanceEUR3 = activeBalanceEUR3;
        this.exchangeUSD3 = exchangeUSD3;
        this.exchangeEUR3 = exchangeEUR3;
    }

    Wallet3() {
    }

    //Створення початкового балансу та 16-значного коду
    int inputBalance(double BalanceUAH) {
        activeBalanceUAH3 = BalanceUAH;
        for (int i=1; i<17; i++ ) {
            int randNum = random.nextInt(10);
            uniCode.append(randNum);
            if (i%4==0) uniCode.append(' ');
        }
        return 0;
    }


    //типізований параметризований метод
    public double buy10USD(double volume) {
        activeBalanceUAH3 -= volume * exchangeUSD3;
        activeBalanceUSD3 += 10;
        return volume * exchangeUSD3;
    }
    public int buy10USD(int volume) { //<-----------------------------3
        activeBalanceUAH3 -= volume * exchangeUSD3;
        activeBalanceUSD3 += 10;
        return (int) (volume * exchangeUSD3);
    }


    //Статистика кожної ітерації(перевантажений метод)
    public void statistics() {
        System.out.println("_____________________________3ій гаманець_____________________________________________________");
        System.out.println("Ваш унікальний код рахунку: " + uniCode.toString());
        System.out.println("Баланс Вашої крартки: " + (double) Math.round(activeBalanceUAH3 * 100) /100 + " гривень");
        System.out.println("Баланс Вашої 1 валютної крартки: " + activeBalanceUSD3 + " $");
        System.out.println("Баланс Вашої 2 валютної крартки: " + activeBalanceEUR3 + " €");
        System.out.println();
    }

    //______GET___&___SET____
    public double getActiveBalanceUAH1() {
        return activeBalanceUAH3;
    }

    public double getActiveBalanceUSD1() {
        return activeBalanceUSD3;
    }

    public double getActiveBalanceEUR1() {
        return activeBalanceEUR3;
    }

    public double getExchangeUSD1() {
        return exchangeUSD3;
    }

    public double getExchangeEUR1() {
        return exchangeEUR3;
    }

    public void setActiveBalanceUAH1(double activeBalanceUAH1) {
        this.activeBalanceUAH3 = activeBalanceUAH1;
    }

    public void setActiveBalanceUSD1(double activeBalanceUSD1) {
        this.activeBalanceUSD3 = activeBalanceUSD1;
    }

    public void setActiveBalanceEUR1(double activeBalanceEUR1) {
        this.activeBalanceEUR3 = activeBalanceEUR1;
    }

    public void setExchangeUSD1(double exchangeUSD1) {
        this.exchangeUSD3 = 2.0 * exchangeUSD1; //<<<<<<<<-------------------------
    }

    public void setExchangeEUR1(double exchangeEUR1) {
        this.exchangeEUR3 = exchangeEUR1;
    }
}

