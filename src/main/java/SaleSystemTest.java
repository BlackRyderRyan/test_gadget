import org.junit.Test;

import java.util.Scanner;

public class SaleSystemTest {

    Scanner input=new Scanner(System.in);

    private Goods warehouse = new Goods();
    private Employees employees = new Employees();

    private int host, display, peripheral;
    private boolean check_calculate = false;

    private String host_number, display_number, peripheral_number;

    @Test
    public void test_saleSystem() {
        host_number = input.next();
        display_number = input.next();
        peripheral_number = input.next();

        if (host_number.charAt(0) == '-'){
            check_calculate = true;
            StringBuilder strBuilder = new StringBuilder(host_number);
            strBuilder.setCharAt(0, '0');
            host_number= strBuilder.toString();
        }

        if(!isNumeric(host_number)){
            System.out.println("键入主机数目不合法");
            return;
        }
        if(!isNumeric(display_number)){
            System.out.println("键入显示器数目不合法");
            return;
        }
        if(!isNumeric(peripheral_number)){
            System.out.println("键入外设数目不合法");
            return;
        }

        host = Integer.parseInt(host_number);
        display = Integer.parseInt(display_number);
        peripheral = Integer.parseInt(peripheral_number);

        while (host != 1 || !check_calculate){

            employees.saleGoods(warehouse, host, display, peripheral);

            host_number = input.next();
            if (host_number.charAt(0) == '-'){
                check_calculate = true;
                StringBuilder strBuilder = new StringBuilder(host_number);
                strBuilder.setCharAt(0, '0');
                host_number= strBuilder.toString();
            }
            display_number = input.next();
            peripheral_number = input.next();

            if(!isNumeric(host_number)){
                System.out.println("键入主机数目不合法");
                return;
            }
            if(!isNumeric(display_number)){
                System.out.println("键入显示器数目不合法");
                return;
            }
            if(!isNumeric(peripheral_number)){
                System.out.println("键入外设数目不合法");
                return;
            }

            host = Integer.parseInt(host_number);
            display = Integer.parseInt(display_number);
            peripheral = Integer.parseInt(peripheral_number);
        }

        System.out.println(employees.calculateCommission());
    }

    public final static boolean isNumeric(String s) {
        if (s != null && !"".equals(s.trim()))
            return s.matches("^[0-9]*$");
        else
            return false;
    }
}
