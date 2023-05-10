package com.powernode.spring6.vo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author wangguangtao
 * @date 2023/4/20
 * @apiNote
 */

@Data
public class DateLoopCarVo {
    private String assetCode;
    private LocalDate startDate;
    private LocalDate endDate;

    //0-未封包 1-已封包
    private Integer packetStatus;

    public DateLoopCarVo(String assetCode, LocalDate startDate, LocalDate endDate, Integer packetStatus) {
        this.assetCode = assetCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.packetStatus = packetStatus;
    }

    public DateLoopCarVo() {
    }
    
}
