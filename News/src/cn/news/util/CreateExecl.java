package cn.news.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
public class CreateExecl {
    //��������
    public static <T> void createExecl(List<T> list) throws IntrospectionException, InvocationTargetException, IllegalAccessException, IOException {
        //����һ��Excel�ļ�
        HSSFWorkbook workbook = new HSSFWorkbook();
        //����һ��������
        HSSFSheet sheet = workbook.createSheet();
        //��ӱ�ͷ��
        HSSFRow hssfRow = sheet.createRow(0);
        //���õ�Ԫ���ʽ����
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //��ӱ�ͷ����
        HSSFCell headCell;
        Class<?> tClass = list.get(0).getClass();
        Field[] fields = tClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            ColumnName annotation = fields[i].getAnnotation(ColumnName.class);
            headCell = hssfRow.createCell(i);
            if (annotation != null) {
                headCell.setCellValue(annotation.getName());
            } else {
                headCell.setCellValue(fields[i].getName());
            }
            headCell.setCellStyle(cellStyle);
        }
        //���ϳ���size����
        for (int i = 0; i < list.size(); i++) {
            hssfRow = sheet.createRow((int) i + 1);
            T t = list.get(i);
            Class<?> aClass = t.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (int j = 0; j < declaredFields.length; j++) {
                //���ÿ��Է���˽���ֶ�
                declaredFields[j].setAccessible(true);
                //��ȡget��set����
                PropertyDescriptor descriptor = new PropertyDescriptor(declaredFields[j].getName(), aClass);
                Method getMethod = descriptor.getReadMethod();  //���get����
                Object object = getMethod.invoke(t);  //ִ��get��������һ��object����
                if (object != null) {
                    HSSFCell cell = hssfRow.createCell(j);
                    cell.setCellValue(object.toString());
                    cell.setCellStyle(cellStyle);
                }
            }
        }
        OutputStream outputStream = new FileOutputStream("E:/" + tClass.getSimpleName() + ".xls");
        workbook.write(outputStream);
        outputStream.close();
    }

    //���뱨��
    public static <T> List<T> readExecl(String path, Class<T> cls) throws IOException, IllegalAccessException, InstantiationException {
        List<T> list = new ArrayList<T>();
        HSSFWorkbook workbook = null;
        //��ȡExcel�ļ�
        InputStream inputStream = new FileInputStream(path);
        workbook = new HSSFWorkbook(inputStream);
        inputStream.close();
        //ѭ��������
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            //ѭ����
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                //ʵ��������
                T t = cls.newInstance();
                //��ȡ������������
                Field[] fid = cls.getDeclaredFields();
                //��������
                for (int i = 0; i < fid.length; i++) {
                    HSSFCell cell = hssfRow.getCell(i);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    //���ÿ��Է���˽���ֶ�
                    Field field = fid[i];
                    field.setAccessible(true);
                    //Ϊ������������
                    Object object = cell.getStringCellValue();
                    String name = field.getType().getName();
                    String value = cell.getStringCellValue();
                    if (name.equals("java.lang.Integer") || name.equals("int")) {
                        field.set(t, Integer.parseInt(value));
                    } else if (name.equals("java.lang.Double") || name.equals("double")) {
                        field.set(t, Double.parseDouble(value));
                    } else {
                        field.set(t, value);
                    }
                }
                list.add(t);   //��ӵ�����
            }
        }
        return list;
    }
    
    
    @Test
    public void poiTest01() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException {
        Message book1 = new Message();
        book1.setVin("0001");
        book1.setMessagetime("2016-01-08");
        book1.setReceivetime("2016-05-06");
        book1.setMessagetype("��������");
        book1.setMessagelength("123");
        book1.setMessage("{115v23v}");
        List<Message> list = new ArrayList<Message>();
        list.add(book1);
        CreateExecl.createExecl(list);
    }
    
    
}



