package com.powernode.spring6.vo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author wangguangtao
 * @date 2023/4/20
 * @apiNote
 */

@Data
public class DateLoopVo {
    private String assetCode;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate packetDate;






    public DateLoopVo(String assetCode, LocalDate startDate, LocalDate endDate) {
        this.assetCode = assetCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public DateLoopVo(String assetCode, LocalDate startDate, LocalDate endDate, LocalDate packetDate) {
        this.assetCode = assetCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.packetDate = packetDate;
    }

    public DateLoopVo() {
    }
    
}
