public class Credit extends Wallet2{
//    double stavka;
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
