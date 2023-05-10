package com.powernode.spring6.vo;

import com.powernode.spring6.util.NumUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author wangguangtao
 * @date 2023/5/10
 * @apiNote
 */
@Data
public class RepaymentOrderVo {
    public RepaymentOrderVo() {
    }

    public RepaymentOrderVo(String trustCode, String loanPactNo, Integer planPeriods, LocalDate execDate, LocalDate realRepayDate, Integer repayMoney, Integer repayPrincipal, Integer repayInterest, Integer repayPenalty, String assetCode, Integer trustRepayPrincipal, Integer trustRepayInterest, Integer trustRepayPenalty, Integer assetRepayPrincipal, Integer assetRepayInterest, Integer assetRepayPenalty, Integer repayFee, String transferCode, String repayType) {
        this.trustCode = trustCode;
        this.loanPactNo = loanPactNo;
        this.planPeriods = planPeriods;
        this.execDate = execDate;
        this.realRepayDate = realRepayDate;
        this.repayMoney = repayMoney;
        this.repayPrincipal = repayPrincipal;
        this.repayInterest = repayInterest;
        this.repayPenalty = repayPenalty;
        this.assetCode = assetCode;
        this.trustRepayPrincipal = trustRepayPrincipal;
        this.trustRepayInterest = trustRepayInterest;
        this.trustRepayPenalty = trustRepayPenalty;
        this.assetRepayPrincipal = assetRepayPrincipal;
        this.assetRepayInterest = assetRepayInterest;
        this.assetRepayPenalty = assetRepayPenalty;
        this.repayFee = repayFee;
        this.transferCode = transferCode;
        this.repayType = repayType;
    }

    //private static final long serialVersionUID = 1L;
    private String trustCode;
    private String loanPactNo;
    private Integer planPeriods;
    private LocalDate execDate;
    private LocalDate realRepayDate;
    private Integer repayMoney;
    private Integer repayPrincipal;
    private Integer repayInterest;
    private Integer repayPenalty;
    private String assetCode;
    private Integer trustRepayPrincipal;
    private Integer trustRepayInterest;
    private Integer trustRepayPenalty;
    private Integer assetRepayPrincipal;
    private Integer assetRepayInterest;
    private Integer assetRepayPenalty;
    private Integer repayFee;
    private String transferCode;
    private String repayType;
}
