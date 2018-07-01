package com.imooc.miaosha.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @description:
 * @author:tz
 * @date:Created in 上午10:48 2018/6/29
 */
public class CashierImportDTO implements Serializable, IExcelModel, IExcelDataModel {
    private static final long serialVersionUID = 4942356752792711985L;
    @Excel(name = "收银员账号")
    @NotBlank(message = "收银员账号不能为空")
    private String cashierAccount;

    @Excel(name = "姓名")
    @NotBlank(message = "姓名不能为空")
    private String cashierName;

    @Excel(name = "角色")
    @NotBlank(message = "角色不能为空")
    private String role;

    @Excel(name = "商户名称")
    @NotBlank(message = "商户名称不能为空")
    private String custName;

    private String errorMsg;

    private int rowNum;

    public String getCashierAccount() {
        return cashierAccount;
    }

    public void setCashierAccount(String cashierAccount) {
        this.cashierAccount = cashierAccount;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
    public String toString() {
        return "CashierImportDTO{" +
                "cashierAccount='" + cashierAccount + '\'' +
                ", cashierName='" + cashierName + '\'' +
                ", role='" + role + '\'' +
                ", custName='" + custName + '\'' +
                '}';
    }

    @Override
    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public int getRowNum() {
        return this.rowNum;
    }

    @Override
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }
}
