import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class output_try {

    public static void main(String[] args) {
        createExeclFile();
    }

    public static void createExeclFile() {

        //1.创建Excel工作薄对象
        XSSFWorkbook wb = new XSSFWorkbook();
        //2.创建Excel工作表对象
        XSSFSheet sheet = wb.createSheet("Sheet_1");
        //3.创建Excel工作表的行
        Row row = sheet.createRow(0);
        //4.创建列
        for (int i = 0; i < 11; i++) {
            Cell cell_1 = row.createCell(i, Cell.CELL_TYPE_STRING);

            CellStyle style = wb.getCellStyleAt((short)0);
            cell_1.setCellStyle(style);
            cell_1.setCellValue("Hello Column" + i);

            sheet.autoSizeColumn(i);
        }

        try {
            Class<?> cls = Class.forName("Experimental");
            Object obj = cls.newInstance();
            Method addMethod = cls.getMethod("fun_1", int.class, int.class, int.class);
            Object result = addMethod.invoke(obj, 1, 2, 3);

            System.out.println(result.toString());

            OutputStream out = new FileOutputStream("D:/hello.xlsx");
            wb.write(out);
            out.flush();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }



    }
}
