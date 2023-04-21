package com.powernode.spring6.bean;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

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

    public DateLoopVo(String assetCode, LocalDate startDate, LocalDate endDate) {
        this.assetCode = assetCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public DateLoopVo() {
    }
    
}
