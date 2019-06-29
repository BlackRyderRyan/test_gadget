import java.util.Scanner;

public class SaleSystem {



    public static void main(String args[]) {

        Goods warehouse = new Goods();
        Employees employees = new Employees();

        Scanner input=new Scanner(System.in);

        int host, display, peripheral;
        boolean check_calculate = false;

        String host_number, display_number, peripheral_number;

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

    public static void SaleSystem_function(String host_number, String display_number, String peripheral_number) {

        Goods warehouse = new Goods();
        Employees employees = new Employees();

        int host, display, peripheral;
        boolean check_calculate = false;

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

        if (host != 1 || !check_calculate) {
            employees.saleGoods(warehouse, host, display, peripheral);
        } else {
            System.out.println(employees.calculateCommission());
        }

    }

    public final static boolean isNumeric(String s) {
        if (s != null && !"".equals(s.trim()))
            return s.matches("^[0-9]*$");
        else
            return false;
    }

}
