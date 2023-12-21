public class Credit extends Wallet2{
//    double stavka;


    public Credit(double activeBalanceUAH1, double activeBalanceUSD1, double activeBalanceEUR1, double exchangeEUR1, double exchangeUSD1, double activeBalanceUAH2, double activeBalanceUSD2, double activeBalanceEUR2) {
        super(activeBalanceUAH1, activeBalanceUSD1, activeBalanceEUR1, exchangeEUR1, exchangeUSD1, activeBalanceUAH2, activeBalanceUSD2, activeBalanceEUR2);
    }

    void methodCredit(){
        methodWallet2();
        System.out.println("Перевірка в'язку з четвертим гаманцем");
    }

    void test () {
        CreditDemo cd = new CreditDemo();
        cd.creditDemoMethod();
    }

    class CreditDemo{
        void creditDemoMethod(){
            System.out.println("Перевірка в'язку з ВКЛАДЕНИМ четвертим гаманцем");
            methodCredit();
        }
    }
}
