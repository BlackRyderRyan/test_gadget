public class Goods {

    private int host_price;
    private int display_price;
    private int peripheral_price;

    private int host_sale;
    private int display_sale;
    private int peripheral_sale;

    private int host_most_sale;
    private int display_most_sale;
    private int peripheral_most_sale;

    private boolean is_host_saling;
    private boolean is_display_saling;
    private boolean is_peripheral_saling;

    Goods(){
        //价格
        host_price = 25;
        display_price = 30;
        peripheral_price = 45;


        //销量
        host_sale = 0;
        display_sale = 0;
        peripheral_sale = 0;


        //销售上限
        host_most_sale = 70;
        display_most_sale = 80;
        peripheral_most_sale = 90;

        //是否能够继续销售
        is_host_saling = true;
        is_display_saling = true;
        is_peripheral_saling = true;

        //continue_to_sale = true;
    }

    public void Check_One_By_One() {
        if (host_sale > host_most_sale) is_host_saling = false;
        if (display_sale> display_most_sale) is_display_saling = false;
        if (peripheral_sale > peripheral_most_sale) is_peripheral_saling = false;
    }

    public void Sale_Host(int num){
        if (is_host_saling) {
            host_sale = host_sale + num;
            Check_One_By_One();
        }
        else System.out.println("主机商品已脱销，下月请早！");
    }

    public void Sale_Display(int num){
        if (is_display_saling) {
            display_sale = display_sale + num;
            Check_One_By_One();
        }
        else System.out.println("显示器商品已脱销，下月请早！");
    }

    public void Sale_Peripheral(int num){
        if (is_peripheral_saling) {
            peripheral_sale = peripheral_sale + num;
            Check_One_By_One();
        }
        else System.out.println("外设商品已脱销，下月请早");
    }



    public boolean getIs_host_saling(){return is_host_saling;}
    public boolean getIs_display_saling(){return is_display_saling;}
    public boolean getIs_peripheral_saling(){return is_peripheral_saling;}

    public int getHost_price(){return host_price;}
    public int getDisplay_price(){return display_price;}
    public int getPeripheral_price(){return peripheral_price;}

    public int getHost_sale(){return host_sale;}
    public int getDisplay_sale(){return display_sale;}
    public int getPeripheral_sale(){return peripheral_sale;}
}
