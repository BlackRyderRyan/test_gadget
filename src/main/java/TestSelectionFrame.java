import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestSelectionFrame extends JFrame {

    private JPanel contentPane;
    private JButton jbReadJava, jbReadxls, jbFresh, jbText;
    private JTextField javaName, xlsxName;
    private JComboBox functionName;
    private DefaultComboBoxModel model;
    private FileDialog fd;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestSelectionFrame frame = new TestSelectionFrame();
                    frame.setVisible(true);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TestSelectionFrame() {
        setTitle("Software Testing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JPanel panel = new JPanel(new GridLayout(4, 1, 4, 10));
        panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(panel, BorderLayout.CENTER);

        JPanel panel_null = new JPanel();
        panel.add(panel_null);

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        JLabel labelJava = new JLabel("JAVA文件");
        panel_1.add(labelJava);
        javaName = new JTextField();
        panel_1.add(javaName);
        javaName.setColumns(20);
        javaName.setEnabled(false);
        jbReadJava = new JButton("选择");
        panel_1.add(jbReadJava);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2);
        JLabel labelExample = new JLabel("xlsx文件");
        panel_2.add(labelExample);
        xlsxName = new JTextField();
        panel_2.add(xlsxName);
        xlsxName.setColumns(20);
        xlsxName.setEnabled(false);
        jbReadxls = new JButton("选择");
        panel_2.add(jbReadxls);

        JPanel panel_3 = new JPanel();
        panel.add(panel_3);
        model = new DefaultComboBoxModel();
        functionName = new JComboBox();
        functionName.setEditable(true);
        functionName.setModel(model);
        panel_3.add(functionName);
        jbFresh = new JButton("刷新");
        panel_3.add(jbFresh);
        jbText = new JButton("测试");
        panel_3.add(jbText);

        jbReadJava.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fd = new FileDialog(new JFrame(), "Open", FileDialog.LOAD);
                fd.setVisible(true);
                if((fd.getDirectory() != null) && (fd.getFile() != null)){
                    String name = fd.getFile();
                    String newName = name.replace(".java", "");
                    javaName.setText(newName);
                }
            }
        });

        jbReadxls.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fd = new FileDialog(new JFrame(), "Open", FileDialog.LOAD);
                fd.setVisible(true);
                if((fd.getDirectory() != null) && (fd.getFile() != null)){
                    xlsxName.setText(fd.getDirectory() + fd.getFile());
                    System.out.println(xlsxName.getText());
                }
            }
        });

        jbFresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jaName = javaName.getText();

                try {
                    Class<?> cls = Class.forName("Experimental");

                    Method[] methods = cls.getDeclaredMethods();

                    model.removeAllElements();

                    for (Method method : methods) {
                        model.addElement(method.getName());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jbText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String janame = javaName.getText();
                String methodname = (String)functionName.getSelectedItem();
                String xlname = xlsxName.getText();
                Method currentMethod = null;

                try {

                    Class<?> cls = Class.forName(janame);

                    Object obj = cls.newInstance();

                    Method[] methods = cls.getDeclaredMethods();


                    for (Method method : methods) {
                        if (method.getName() == methodname) {
                            currentMethod = cls.getMethod(method.getName(), int.class, int.class, int.class);
                        }
                    }

                    //得到Excel常用对象
                    FileInputStream fIP = new FileInputStream(xlname);

                    //得到Excel工作簿对象
                    XSSFWorkbook wb = new XSSFWorkbook(fIP);

                    //得到Excel工作表对象
                    XSSFSheet sheet = wb.getSheetAt(0);

                    //总行数
                    int trLength = sheet.getLastRowNum() + 1;

                    //得到Excel工作表的行
                    XSSFRow row = sheet.getRow(0);

                    //总列数
                    int tdLength = row.getLastCellNum();

                    //得到Excel工作表指定行的单元格
                    XSSFCell cell = row.getCell((short)1);

                    //得到单元格样式
                    CellStyle cellStyle = cell.getCellStyle();

                    double[] value = new double[3];

                    for(int i=0;i<trLength;i++){
                        //得到Excel工作表的行
                        XSSFRow row1 = sheet.getRow(i);

                        for(int j=0;j<tdLength;j++){

                            //得到Excel工作表指定行的单元格
                            XSSFCell cell1 = row1.getCell(j);

                            /**
                             * 为了处理：Excel异常Cannot get a text value from a numeric cell
                             * 将所有列中的内容都设置成Numeric类型格式
                             */
                            if(cell1!=null){
                                cell1.setCellType(Cell.CELL_TYPE_NUMERIC);
                            }

                            //获得每一列中的值
//                            System.out.print(cell1.getStringCellValue()+"\t\t\t");

                            value[i] = cell1.getNumericCellValue();
                        }

                        currentMethod.invoke(obj, (int)value[0], (int)value[1], (int)value[2]);

                        System.out.println();
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }catch (InstantiationException ex) {
                    ex.printStackTrace();
                }catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                }catch (InvocationTargetException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
