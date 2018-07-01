package com.imooc.miaosha.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.exception.excel.ExcelImportException;
import com.imooc.miaosha.dto.CashierImportDTO;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @description:
 * @author:tz
 * @date:Created in 下午1:58 2018/6/28
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World";
    }

    // rest json api输出
    @RequestMapping("/import")
    @ResponseBody
    public List<CashierImportDTO> importExcel(@RequestParam("file") MultipartFile multipartFile) {
        ImportParams params = new ImportParams();
        String[] fileds = {"收银员账号", "姓名", "角色", "商户名称"};
        params.setImportFields(fileds);
        params.setNeedVerfiy(true);
        List<CashierImportDTO> objects = null;
        try {
//            objects = ExcelImportUtil.importExcel(multipartFile.getInputStream(), CashierImportDTO.class, params);
            ExcelImportResult<CashierImportDTO> result = ExcelImportUtil.importExcelMore(multipartFile.getInputStream(), CashierImportDTO.class, params);
            Assert.isTrue(result.isVerfiyFail());
        } catch (ExcelImportException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objects;
    }
}
