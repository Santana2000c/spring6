package com.powernode.spring6.vo;

import com.powernode.spring6.util.NumUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author wangguangtao
 * @date 2023/5/10
 * @apiNote
 */
@Data
@AllArgsConstructor
public class RepaymentOrderVo {
    public RepaymentOrderVo() {
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
