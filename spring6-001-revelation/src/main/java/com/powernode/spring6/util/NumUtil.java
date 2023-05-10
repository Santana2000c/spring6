package com.powernode.spring6.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author wangguangtao
 * @date 2023/5/10
 * @apiNote
 */
public class NumUtil {

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况的时候,精确到小数点后10位,后面的四舍五入
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     * @since 3.1.0
     */
    public static BigDecimal div(Number v1, Number v2) {
        return div(v1, v2, 2, RoundingMode.HALF_UP);
    }

    /**
     * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
     *
     * @param v1           被除数
     * @param v2           除数
     * @param scale        精确度，如果为负值，取绝对值
     * @param roundingMode 保留小数的模式 {@link RoundingMode}
     * @return 两个参数的商
     * @since 3.0.9
     */
    public static BigDecimal div(Number v1, Number v2, int scale, RoundingMode roundingMode) {
        if (null == v1 || null == v2 || v2.intValue() == 0) {
            return BigDecimal.ZERO;
        }

        if (scale < 0) {
            scale = -scale;
        }
        BigDecimal bigDecimal = new BigDecimal(v2.toString());
        return new BigDecimal(v1.toString()).divide(bigDecimal, scale, roundingMode);
    }


    /**
     * 提供精确的乘法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 积
     */
    public static BigDecimal mul(Number v1, Number v2) {

        return mul(v1, v2, 2, RoundingMode.HALF_UP);
    }


    /**
     * 提供精确的乘法运算,由scale指定精确度
     *
     * @param v1           被乘数
     * @param v2           乘数
     * @param scale        精确度，如果为负值，取绝对值
     * @param roundingMode 保留小数的模式 {@link RoundingMode}
     * @return 积 由scale指定精确度
     *
     */
    public static BigDecimal mul(Number v1, Number v2, int scale, RoundingMode roundingMode) {
        if (v1 == null || v2 == null) {
            return BigDecimal.ZERO;
        }
        if (scale < 0) {
            scale = -scale;
        }
        return new BigDecimal(v1.toString()).multiply(new BigDecimal(v2.toString())).setScale(scale, roundingMode);
    }
}
