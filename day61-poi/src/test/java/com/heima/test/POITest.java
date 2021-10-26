package com.heima.test;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class POITest {


    @Test
    public void test1(){
        System.out.println("===test1");
    }
    //测试1： 读取03版本的excel一行数据
    @Test
    public void readOnLineTest() throws IOException {
        //1. 读取excel资源的输入流
        InputStream inputStream = POITest.class.getResourceAsStream("/excel/上传货物模板2.xls");
        // 2. 创建一个工作薄  , 注意：03版本的excel对应的实现类
        Workbook workbook = new HSSFWorkbook(inputStream);

        //3. 获取一个工作单
        Sheet sheet = workbook.getSheetAt(0);

        //4. 得到行
        Row row = sheet.getRow(0);

        //5. 得到单元格
        //System.out.print(row.getCell(0).getStringCellValue()+"===000\t");
        System.out.print(row.getCell(1).getStringCellValue()+"\t");
        System.out.print(row.getCell(2).getStringCellValue()+"\t");
        System.out.print(row.getCell(3).getStringCellValue()+"\t");
        System.out.print(row.getCell(4).getStringCellValue()+"\t");
        System.out.print(row.getCell(5).getStringCellValue()+"\t");
        System.out.print(row.getCell(6).getStringCellValue()+"\t");
        System.out.print(row.getCell(7).getStringCellValue()+"\t");
        System.out.print(row.getCell(8).getStringCellValue()+"\t");
        System.out.println(row.getCell(9).getStringCellValue());

    }

    // 测试2： 读取03版本的excel所有行数据
    @Test
    public void readAllRowTest() throws IOException {
        //1. 读取excel资源的输入流
        InputStream inputStream = POITest.class.getResourceAsStream("/excel/上传货物模板2.xls");
        // 2. 创建一个工作薄  , 注意：03版本的excel对应的实现类
        Workbook workbook = new HSSFWorkbook(inputStream);

        //3. 获取一个工作单
        Sheet sheet = workbook.getSheetAt(0);

        //4. 得到行
        Row row = sheet.getRow(0);

        //5. 得到单元格
        System.out.print(row.getCell(1).getStringCellValue()+"\t");
        System.out.print(row.getCell(2).getStringCellValue()+"\t");
        System.out.print(row.getCell(3).getStringCellValue()+"\t");
        System.out.print(row.getCell(4).getStringCellValue()+"\t");
        System.out.print(row.getCell(5).getStringCellValue()+"\t");
        System.out.print(row.getCell(6).getStringCellValue()+"\t");
        System.out.print(row.getCell(7).getStringCellValue()+"\t");
        System.out.print(row.getCell(8).getStringCellValue()+"\t");
        System.out.println(row.getCell(9).getStringCellValue());


        //得到excel表格的所有行数
        int rows = sheet.getPhysicalNumberOfRows();
        //遍历读取其他行的数据
        for (int i = 1; i < rows; i++) {
            //得到行
            row = sheet.getRow(i);
            System.out.println("===i:"+i);
            //输出单元格的数据
            System.out.print(row.getCell(1).getStringCellValue()+"\t");
            System.out.print(row.getCell(2).getStringCellValue()+"\t");
            System.out.print(row.getCell(3).getNumericCellValue()+"\t");
            System.out.print(row.getCell(4).getStringCellValue()+"\t");
            System.out.print(row.getCell(5).getNumericCellValue()+"\t");
            System.out.print(row.getCell(6).getNumericCellValue()+"\t");
            System.out.print(row.getCell(7).getNumericCellValue()+"\t");
            System.out.print(row.getCell(8).getStringCellValue()+"\t");
            System.out.println(row.getCell(9).getStringCellValue());
        }
    }


    // 测试3： 读取07版本的excel所有行数据
    @Test
    public void read07ExcelAllRowTest() throws IOException {
        //1. 读取excel资源的输入流
        InputStream inputStream = POITest.class.getResourceAsStream("/excel/上传货物模板.xlsx");
        // 2. 创建一个工作薄  , 注意：03版本的excel对应的实现类HSSFWorkbook，07版本的excel对应的实现类XSSFWorkbook
        Workbook workbook = new XSSFWorkbook(inputStream);

        //3. 获取一个工作单
        Sheet sheet = workbook.getSheetAt(0);

        //4. 得到行
        Row row = sheet.getRow(0);

        //5. 得到单元格
        System.out.print(row.getCell(1).getStringCellValue()+"\t");
        System.out.print(row.getCell(2).getStringCellValue()+"\t");
        System.out.print(row.getCell(3).getStringCellValue()+"\t");
        System.out.print(row.getCell(4).getStringCellValue()+"\t");
        System.out.print(row.getCell(5).getStringCellValue()+"\t");
        System.out.print(row.getCell(6).getStringCellValue()+"\t");
        System.out.print(row.getCell(7).getStringCellValue()+"\t");
        System.out.print(row.getCell(8).getStringCellValue()+"\t");
        System.out.println(row.getCell(9).getStringCellValue());


        //得到excel表格的所有行数
        int rows = sheet.getPhysicalNumberOfRows();
        //遍历读取其他行的数据
        for (int i = 1; i < rows; i++) {
            //得到行
            row = sheet.getRow(i);
            //输出单元格的数据
            System.out.print(row.getCell(1).getStringCellValue()+"\t");
            System.out.print(row.getCell(2).getStringCellValue()+"\t");
            System.out.print(row.getCell(3).getNumericCellValue()+"\t");
            System.out.print(row.getCell(4).getStringCellValue()+"\t");
            System.out.print(row.getCell(5).getNumericCellValue()+"\t");
            System.out.print(row.getCell(6).getNumericCellValue()+"\t");
            System.out.print(row.getCell(7).getNumericCellValue()+"\t");
            System.out.print(row.getCell(8).getStringCellValue()+"\t");
            System.out.println(row.getCell(9).getStringCellValue());
        }
    }

    //生成excel文件
    @Test
    public void  createExcel() throws Exception {
        //1. 创建工作薄
        Workbook workbook = new XSSFWorkbook();

        //2. 创建工作单
        Sheet sheet = workbook.createSheet("最帅男生表");

        //3. 创建行
        Row row = sheet.createRow(0);

        //4. 创建单元格并设置内容
        row.createCell(0).setCellValue("姓名");
        row.createCell(1).setCellValue("年龄");
        row.createCell(2).setCellValue("身高");
        row.createCell(3).setCellValue("收入");
        row.createCell(4).setCellValue("人品");
        //5. 把工作薄写出
        workbook.write(new FileOutputStream("E:/shuaige.xlsx"));
    }


    //使用excel模板去生成excel的数据

    /**
     * 模板导出最为关键一步： 保存模板的样式，后面的数据需要复用样式
     * @throws Exception
     */
    @Test
    public void  createBaseExcel() throws Exception {
        //1. 读取模板的输入流
        InputStream inputStream = POITest.class.getResourceAsStream("/excel/users.xlsx");

        //2. 基于模板的输入流创建工作薄
        Workbook workbook = new XSSFWorkbook(inputStream);

        //3. 得到模板的工作单
        Sheet sheet = workbook.getSheetAt(0);

        //4. 得到索引值为1这个行的数据
        Row row = sheet.getRow(1);


        //5. 模板导出最为关键的一步：提取模板的样式存储集合中
        List<CellStyle> styleList =new ArrayList<>();
        //六个单元格，所有我们需要提取6个样式出来
        for (int i = 1; i <=6 ; i++) {
            Cell cell = row.getCell(i);//得到单元格
            styleList.add(cell.getCellStyle());
        }

        //6. 创建行，创建单元格去设置样式.写入内容
        row = sheet.createRow(1);

        //设置单元格的内容与样式
        //姓名
        Cell cell = row.createCell(1);
        cell.setCellValue("ztl");
        cell.setCellStyle(styleList.get(0));


        //密码
        cell = row.createCell(2);
        cell.setCellValue("123456");
        cell.setCellStyle(styleList.get(1));


        //姓名
        cell = row.createCell(3);
        cell.setCellValue("小钟");
        cell.setCellStyle(styleList.get(2));

        //年龄
        cell = row.createCell(4);
        cell.setCellValue(18);
        cell.setCellStyle(styleList.get(3));


        //邮箱
        cell = row.createCell(5);
        cell.setCellValue("ztl@itcast.cn");
        cell.setCellStyle(styleList.get(4));

        //性别
        cell = row.createCell(6);
        cell.setCellValue("男");
        cell.setCellStyle(styleList.get(5));

        //把表格写出
        workbook.write(new FileOutputStream("E:/person.xlsx"));
    }

}

