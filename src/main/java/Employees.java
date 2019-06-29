public class Employees {

    private int sales_of_host;
    private int sales_of_display;
    private int sales_of_peripheral;

    private int total_amount_of_sales;

    private double commission;

    Employees(){
        sales_of_host = 0;
        sales_of_display = 0;
        sales_of_peripheral = 0;

        total_amount_of_sales = 0;

        commission = 0;
    }

    private void Sale_Host(Goods Goods, int num){
        if (Goods.getIs_host_saling()){
            Goods.Sale_Host(num);
            if (Goods.getIs_host_saling()) {
                sales_of_host = sales_of_host + num;
                total_amount_of_sales = total_amount_of_sales + Goods.getHost_price() * num;
                System.out.println("员工  销售了     " + num + "   个   主机！     当前主机总销售量：   " + Goods.getHost_sale() + "    个");
            }
            else System.out.println("主机商品已脱销，下月请早！");
        }
        else System.out.println("主机商品已脱销，下月请早！");
    }

    private void Sale_Display(Goods Goods, int num){
        if (Goods.getIs_display_saling()){
            Goods.Sale_Display(num);
            if (Goods.getIs_display_saling()){
                sales_of_display = sales_of_display + num;
                total_amount_of_sales = total_amount_of_sales + Goods.getDisplay_price() * num;
                System.out.println("员工  销售了     " + num +"   个   显示器！     当前显示器总销售量：   " + Goods.getDisplay_sale() + "    个");
            }
            else System.out.println("显示器商品已脱销，下月请早！");
        }
        else System.out.println("显示器商品已脱销，下月请早！");
    }

    private void Sale_Peripheral(Goods Goods, int num){
        if (Goods.getIs_peripheral_saling()){
            Goods.Sale_Peripheral(num);
            if (Goods.getIs_peripheral_saling()){
                sales_of_peripheral = sales_of_peripheral + num;
                total_amount_of_sales = total_amount_of_sales + Goods.getPeripheral_price() * num;
                System.out.println("员工  销售了     " + num +"   个   外设！     当前外设总销售量：   " + Goods.getPeripheral_sale() + "    个");
            }
            else System.out.println("外设商品已脱销，下月请早！");
        }
        else System.out.println("外设商品已脱销，下月请早！");
    }

    public void saleGoods(Goods Goods, int host_number, int display_number, int peripheral_number){
        Goods.Check_One_By_One();
        if (host_number > 0) Sale_Host(Goods, host_number);
        if (display_number > 0) Sale_Display(Goods, display_number);
        if (peripheral_number > 0) Sale_Peripheral(Goods, peripheral_number);
    }

    public double calculateCommission(){
        if (sales_of_host > 0 && sales_of_display > 0 && sales_of_peripheral > 0){
            if (total_amount_of_sales <= 1000) commission = total_amount_of_sales * 0.1;
            else if (total_amount_of_sales > 1800) commission = total_amount_of_sales * 0.2;
            else commission = total_amount_of_sales * 0.15;
        }

        return commission;
    }
}
