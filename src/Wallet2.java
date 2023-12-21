
import java.util.Random;
import java.util.Scanner;

class Wallet2 extends Wallet{         //<<<<<<<<<<<-------------------------------
    //Створюю клас з рахунками всіх карток
    private double activeBalanceUAH2 = 0;
    private double activeBalanceUSD2 = 0;
    private double activeBalanceEUR2 = 0;
    //створюю (клас)об'єкт для унікального 16-значного коду
    StringBuilder uniCode = new StringBuilder();
    Random random = new Random();
    Scanner scan = new Scanner(System.in);


    //конструктори
    public Wallet2(double activeBalanceUAH2, double activeBalanceUSD2, double activeBalanceEUR2, double exchangeUSD1, double exchangeEUR1) {
        this.activeBalanceUAH2 = activeBalanceUAH2;
        this.activeBalanceUSD2 = activeBalanceUSD2;
        this.activeBalanceEUR2 = activeBalanceEUR2;
    }

    //    4 лаб   5 завдання super

    public Wallet2(double activeBalanceUAH1, double activeBalanceUSD1, double activeBalanceEUR1, double exchangeEUR1, double exchangeUSD1, double activeBalanceUAH2, double activeBalanceUSD2, double activeBalanceEUR2) {
        super(activeBalanceUAH1, activeBalanceUSD1, activeBalanceEUR1, exchangeEUR1, exchangeUSD1);
        this.activeBalanceUAH2 = activeBalanceUAH2;
        this.activeBalanceUSD2 = activeBalanceUSD2;
        this.activeBalanceEUR2 = activeBalanceEUR2;
    }

    Wallet2(){

    }



    //Створення початкового балансу та 16-значного коду
    private void inputBalance(double bal) {
        activeBalanceUAH2 =bal;
        for (int i=1; i<17; i++ ) {
            int randNum = random.nextInt(10);
            uniCode.append(randNum);
            if (i % 4 == 0) uniCode.append(' ');
        }
    }


    void methodWallet2(){
        methodWallet();
        System.out.println("Перевірка в'язку з другим гаманцем");
    }

    //типізований параметризований метод
    public double buy10USD(double volume) {
        activeBalanceUAH2 -= volume * exchangeUSD1;
        activeBalanceUSD2 += 10;
        return volume * exchangeUSD1;
    }
    public int buy10USD(int volume) {
        activeBalanceUAH2 -= volume * exchangeUSD1;
        activeBalanceUSD2 += 10;
        return (int) (volume * exchangeUSD1);
    }


    //Статистика кожної ітерації(перевантажений метод)
    public void statistics() {
        System.out.println("_____________________________2ий гаманець_____________________________________________________");
        System.out.println("Ваш унікальний код рахунку: " + uniCode.toString());
        System.out.println("Баланс Вашої крартки: " + (double) Math.round(activeBalanceUAH2 * 100) /100 + " гривень");
        System.out.println("Баланс Вашої 1 валютної крартки: " + activeBalanceUSD2 + " $");
        System.out.println("Баланс Вашої 2 валютної крартки: " + activeBalanceEUR2 + " €");
        System.out.println();
    }


    //______GET___&___SET____
    public double getActiveBalanceUAH1() {
        return activeBalanceUAH2;
    }

    public double getActiveBalanceUSD1() {
        return activeBalanceUSD2;
    }

    public double getActiveBalanceEUR1() {
        return activeBalanceEUR2;
    }

    public double getExchangeUSD1() {
        return exchangeUSD1;
    }

    public double getExchangeEUR1() {
        return exchangeEUR1;
    }

    public void setActiveBalanceUAH1(double activeBalanceUAH1) {
        this.activeBalanceUAH2 = activeBalanceUAH1;
    }

    public void setActiveBalanceUSD1(double activeBalanceUSD1) {
        this.activeBalanceUSD2 = activeBalanceUSD1;
    }

    public void setActiveBalanceEUR1(double activeBalanceEUR1) {
        this.activeBalanceEUR2 = activeBalanceEUR1;
    }

    public void setExchangeUSD1(double exchangeUSD1) {
        this.exchangeUSD1 = exchangeUSD1;
    }

    public void setExchangeEUR1(double exchangeEUR1) {
        this.exchangeEUR1 = exchangeEUR1;
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

