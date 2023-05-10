package com.powernode.spring6.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author wangguangtao
 * @date 2023/5/10
 * @apiNote
 */
@Data
public class RepaymentSchedule {
    public RepaymentSchedule(String trustCode, String loanPactNo, Integer planPeriods, LocalDate payableTime, Integer payableMoney, Integer payablePrincipal, Integer payableInterest, Integer payablePenalty, LocalDate execDate, String assetCode, String transferCode, Integer maxTerm) {
        this.trustCode = trustCode;
        this.loanPactNo = loanPactNo;
        this.planPeriods = planPeriods;
        this.payableTime = payableTime;
        this.payableMoney = payableMoney;
        this.payablePrincipal = payablePrincipal;
        this.payableInterest = payableInterest;
        this.payablePenalty = payablePenalty;
        this.execDate = execDate;
        this.assetCode = assetCode;
        this.transferCode = transferCode;
        this.maxTerm = maxTerm;
    }

    private static final long serialVersionUID = 1L;


    /**
     * 信托计划编号
     */

    private String trustCode;

    /**
     * 贷款合同号
     */

    private String loanPactNo;


    /**
     * 期数
     */

    private Integer planPeriods;

    /**
     * 应还日期
     */

    private LocalDate payableTime;

    /**
     * 应还总额
     */

    private Integer payableMoney;

    /**
     * 应还本金
     */

    private Integer payablePrincipal;

    /**
     * 应还利息
     */

    private Integer payableInterest;

    /**
     * 应还罚息
     */

    private Integer payablePenalty;

    /**
     * 数据日期
     */

    private LocalDate execDate;

    /**
     * 资产项目编号
     */

    private String assetCode;

    /**
     * 转让编号
     */

    private String transferCode;
    /**
     * 最大期数
     */
    private Integer maxTerm;



}
