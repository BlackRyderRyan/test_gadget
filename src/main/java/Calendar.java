import java.util.Scanner;

public class Calendar {

    public static void main(String[] args) {
        //合法的日期输入
        Scanner input=new Scanner(System.in);
        System.out.println("请输入年份:");

        String Year=input.next();
        System.out.println("请输入月份:");
        String Month=input.next();
        System.out.println("请输入日期:");
        String Day=input.next();

        calendarFunction(Year, Month, Day);
    }

    public static void calendarFunction(String Year, String Month, String Day) {
        //输入类型判断
        if(!isNumeric(Year)){
            System.out.println("年格式不合法");
            return;
        }
        if(!isNumeric(Month)){
            System.out.println("月格式不合法");
            return;
        }
        if(!isNumeric(Day)){
            System.out.println("日格式不合法");
            return;
        }


        int month=Integer.parseInt(Month);
        int year = Integer.parseInt(Year);
        int day = Integer.parseInt(Day);

        //定义域边界
        if(year==0||year>9999){
            System.out.println("年不合法");
            return;
        }
        if(year==9999&&day==31&&month==12){
            System.out.println("已达“末日”，无法计算");
            return;
        }

        boolean leap = isLeapYear(year);


        if(month>12||month==0){
            System.out.println("月不合法");
            return;
        }
        if(day==0){
            System.out.println("日不合法");
            return;
        }
        //日期的合法
        switch(month){
            case 1:
                if(day>31) {
                    System.out.println("日不合法");
                    return;
                }
                break;
            case 2:
                if( !leap&&(day>28) || leap&&(day>29)) {
                    System.out.println("日不合法");
                    return;
                }
                break;
            case 3:
                if(day>31) {
                    System.out.println("日不合法");
                    return;
                }
                break;
            case 4:
                if(day>30) {
                    System.out.println("日不合法");
                    return;
                }
                break;
            case 5:
                if(day>31) {
                    System.out.println("日不合法");
                    return;
                }
                break;
            case 6:
                if(day>30) {
                    System.out.println("日不合法");
                    return;
                }
                break;
            case 7:
                if(day>31) {
                    System.out.println("日不合法");
                    return;
                }
                break;
            case 8:
                if(day>31) {
                    System.out.println("日不合法");
                    return;
                }
                break;
            case 9:
                if(day>30) {
                    System.out.println("日不合法");
                    return;
                }
                break;
            case 10:
                if(day>31) {
                    System.out.println("日不合法");
                    return;
                }
                break;
            case 11:
                if(day>30) {
                    System.out.println("日不合法");
                    return;
                }
                break;
            case 12:
                if(day>31) {
                    System.out.println("日不合法");
                    return;
                }
                break;
        }

        //计算下一天
        //算年
        if(month==12&&day==31){
            year++;
            month=day=1;
            System.out.println(Year+"/"+Month+"/"+Day+"的明天是"+year+"/"+month+"/"+day);
            return;
        }
        //月
        switch (month){
            case 1:
                if(day==31)  {
                    month++;day=1;
                    System.out.println(Year+"/"+Month+"/"+Day+"的明天是"+year+"/"+month+"/"+day);
                    return;
                }
                break;
            case 2:
                if(!leap&&(day==28) || leap&&(day==29))  {
                    month++;day=1;
                    System.out.println(Year+"/"+Month+"/"+Day+"的明天是"+year+"/"+month+"/"+day);
                    return;
                }
                break;
            case 3:
                if(day==31) {
                    month++;day=1;
                    System.out.println(Year+"/"+Month+"/"+Day+"的明天是"+year+"/"+month+"/"+day);
                    return;
                }
                break;
            case 4:
                if(day==30)  {
                    month++;day=1;
                    System.out.println(Year+"/"+Month+"/"+Day+"的明天是"+year+"/"+month+"/"+day);
                    return;
                }
                break;
            case 5:
                if(day==31)  {
                    month++;day=1;
                    System.out.println(Year+"/"+Month+"/"+Day+"的明天是"+year+"/"+month+"/"+day);
                    return;
                }
                break;
            case 6:
                if(day==30)  {
                    month++;day=1;
                    System.out.println(Year+"/"+Month+"/"+Day+"的明天是"+year+"/"+month+"/"+day);
                    return;
                }
                break;
            case 7:
                if(day==31)  {
                    month++;day=1;
                    System.out.println(Year+"/"+Month+"/"+Day+"的明天是"+year+"/"+month+"/"+day);
                    return;
                }
                break;
            case 8:
                if(day==31)  {
                    month++;day=1;
                    System.out.println(Year+"/"+Month+"/"+Day+"的明天是"+year+"/"+month+"/"+day);
                    return;
                }
                break;
            case 9:
                if(day==30)  {
                    month++;day=1;
                    System.out.println(Year+"/"+Month+"/"+Day+"的明天是"+year+"/"+month+"/"+day);
                    return;
                }
                break;
            case 10:
                if(day==31)  {
                    month++;day=1;
                    System.out.println(Year+"/"+Month+"/"+Day+"的明天是"+year+"/"+month+"/"+day);
                    return;
                }
                break;
            case 11:
                if(day==30)  {
                    month++;day=1;
                    System.out.println(Year+"/"+Month+"/"+Day+"的明天是"+year+"/"+month+"/"+day);
                    return;
                }
                break;
        }

        //日
        day++;
        System.out.println(Year+"/"+Month+"/"+Day+"的明天是"+year+"/"+month+"/"+day);
        return;
    }

    //用正则表达式判断输入是否是整数
    public final static boolean isNumeric(String s) {
        if (s != null && !"".equals(s.trim()))
            return s.matches("^[0-9]*$");
        else
            return false;
    }
    public final static boolean isLeapYear(int y) {
        if(y%4==0 && y%100!=0){
            return true;
        }else if(y%400==0){
            return true;
        }
        return false;
    }
}
