package com.heima.controller;


import com.heima.model.Contract;
import com.heima.service.ContractService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @RequestMapping("/getHour")
    public List<Map<Object,Object>> getHour(){
        return contractService.getHour();
    }


    @RequestMapping("/echars")
    public List<Map<String,Object>> getAmount(){
        List<Map<String,Object>> amount = contractService.getAmount();
        return amount;
    }
    /**
     * 作用： 根据船期找到对应的购销合同，并且把购销合同数据下载下来。
     * @param shipTime
     *
     * 如果一个方法的是下载内容：
     *      1. 返回值需要使用void
     *      2. 方法必须要添加@ResponseBody，但是我上面添加了@REstController所以可以省略@ResponseBody
     *
     */
    @RequestMapping("/findByShipTime")
    public void   findByShipTime(String shipTime, HttpServletResponse response) throws Exception {
        //1. 读取模板的输入流
        InputStream inputStream = ContractController.class.getResourceAsStream("/excel/product.xlsx");

        //2. 基于模板的输入流创建工作薄
        Workbook workbook = new XSSFWorkbook(inputStream);

        //3. 得到模板的工作单
        Sheet sheet = workbook.getSheetAt(0);

        //4. 得到索引值为1这个行的数据
        Row row = sheet.getRow(1);


        //5. 模板导出最为关键的一步：提取模板的样式存储集合中
        List<CellStyle> styleList =new ArrayList<>();
        //八个单元格，所有我们需要提取8个样式出来
        for (int i = 1; i <=8 ; i++) {
            Cell cell = row.getCell(i);//得到单元格
            styleList.add(cell.getCellStyle());
        }


        //6. 得到购销合同的数据
        List<Contract> contractList = contractService.findByShipTime(shipTime);

        //7. 遍历所有的购销合同,每一个购销合同生成一行数据
        for (int i = 0; i < contractList.size(); i++) {
            //创建行
            row = sheet.createRow(i + 1);

            //得到购销合同
            Contract contract = contractList.get(i);

            //创建单元格，并且设置数据

            //合同号
            Cell cell = row.createCell(1);
            cell.setCellValue(contract.getContractNo());
            cell.setCellStyle(styleList.get(0));

            //签约时间 ,如果有时间，一定要格式化,否则是数字
            cell = row.createCell(2);
            cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(contract.getSigningDate()));
            cell.setCellStyle(styleList.get(1));


            //审核人
            cell = row.createCell(3);
            cell.setCellValue(contract.getCheckBy());
            cell.setCellStyle(styleList.get(2));


            //总金额
            cell = row.createCell(4);
            cell.setCellValue(contract.getTotalAmount());
            cell.setCellStyle(styleList.get(3));


            //客户名称
            cell = row.createCell(5);
            cell.setCellValue(contract.getCustomName());
            cell.setCellStyle(styleList.get(4));


            //船期
            cell = row.createCell(6);
            cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(contract.getShipTime()));
            cell.setCellStyle(styleList.get(5));


            //企业名称
            cell = row.createCell(7);
            cell.setCellValue(contract.getCompanyName());
            cell.setCellStyle(styleList.get(6));


            //备注
            cell = row.createCell(8);
            cell.setCellValue(contract.getRemark());
            cell.setCellStyle(styleList.get(7));

        }

        //通知浏览器当前是以附件下载的形式处理响应内容
        response.setHeader("content-disposition","attachment;filename=contracts.xlsx");
        //把workBook写出，写出到浏览器上
        workbook.write(response.getOutputStream());

    }



}
