package com.liu.study.littery.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * 学习RoundingMode。
 *
 * <note>
 *     up和ceiling的区别；
 *     down和floor的区别：
 *     half_up、half_down、half_even的区别。
 * </note>
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/1/5 13:38
 */
public class StudyRoundingMode {

    public static void main(String[] args) {
        /**
         * RoundingMode：
         *      UP：向上取整（负数特别），等于BigDecimal的ROUND_UP。如果是负数，取绝对值进行向上取整，让后把负号加上去。
         *      DOWN：向下取整（负数特别），等于BigDecimal的ROUND_DOWN。如果是负数，取绝对值进行向下取整，然后把负号加上去。
         *      CEILING：向上取整，等于BigDecimal的ROUND_CEILING。
         *      FLOOR：向下取整，等于BigDecimal的ROUND_FLOOR。
         *      HALF_UP：无符号四舍五入，然后再把正负号加上去。等于BigDecimal的ROUND_HALF_UP，如果刚好到上下两变一样大，向上取整。
         *      HALF_DOWN：无符号四舍五入，然后再把正负号加上去。等于BigDecimal的ROUND_HALF_UP，如果刚好到上下两变一样大，向下取整。
         *      HALF_EVEN：无符号四舍五入，然后再把正负号加上去。等于BigDecimal的ROUND_HALF_UP，如果刚好到上下两变一样大，需要看舍弃位前一位，前一个是奇数，则加1；如果是偶数，则减1
         *      UNNECESSARY：
         */


        /**
         *
         */
        // up();


        /**
         *
         */
        // down();

        /**
         *
         */
        // ceiling();

        /**
         *
         */
        // floor();

        /**
         *
         */
        // halfUp();

        // System.out.println("---------------------");
        /**
         *
         */
        // halfDown();

        /**
         *
         */
        halfEven();

    }

    /**
     * 无符号操作，向上取整，然后把正负号加上去。如果是舍去为0，直接舍去。
     */
    public static void up() {
        BigDecimal a = new BigDecimal("12.239323").setScale(2, RoundingMode.UP);
        BigDecimal b = new BigDecimal("12.231323").setScale(2, RoundingMode.UP);
        BigDecimal c = new BigDecimal("-12.231323").setScale(2, RoundingMode.UP);
        BigDecimal d = new BigDecimal("-12.239323").setScale(2, RoundingMode.UP);

        BigDecimal e = new BigDecimal("12.230323").setScale(2, RoundingMode.UP);
        BigDecimal f = new BigDecimal("-12.230000").setScale(2, RoundingMode.UP);
        System.out.println(a + "__" + b);
        System.out.println(c + "__" + d);
        System.out.println(e + "__" + f);
    }


    /**
     * 无符号操作，不论舍入位是否为零，都直接舍弃，然后把正负号加上去。
     */
    public static void down() {
        BigDecimal a = new BigDecimal("12.239323").setScale(2, RoundingMode.DOWN);
        BigDecimal b = new BigDecimal("12.231323").setScale(2, RoundingMode.DOWN);
        BigDecimal c = new BigDecimal("-12.231323").setScale(2, RoundingMode.DOWN);
        BigDecimal d = new BigDecimal("-12.239323").setScale(2, RoundingMode.DOWN);

        BigDecimal e = new BigDecimal("12.230323").setScale(2, RoundingMode.DOWN);
        BigDecimal f = new BigDecimal("-12.230000").setScale(2, RoundingMode.DOWN);
        System.out.println(a + "___" + b);
        System.out.println(c + "___" + d);
        System.out.println(e + "___" + f);
    }

    /**
     * 有符号的向上取整：
     *      1、比如-12.23999向上取整就是-12.23.
     *      1、比如12.23999向上取整就是12.23
     */
    public static void ceiling() {
        BigDecimal a = new BigDecimal("12.239323").setScale(2, RoundingMode.CEILING);
        BigDecimal b = new BigDecimal("12.231323").setScale(2, RoundingMode.CEILING);
        BigDecimal c = new BigDecimal("-12.231323").setScale(2, RoundingMode.CEILING);
        BigDecimal d = new BigDecimal("-12.239323").setScale(2, RoundingMode.CEILING);

        BigDecimal e = new BigDecimal("12.230323").setScale(2, RoundingMode.CEILING);
        BigDecimal f = new BigDecimal("-12.230000").setScale(2, RoundingMode.CEILING);

        System.out.println(a + "___" + b);
        System.out.println(c + "___" + d);
        System.out.println(e + "___" + f);
    }

    /**
     * 有符号向下取整。
     *      1、比如-12.230001向下取整-12.24
     *      2、比如-12.233434向下取整-12.23
     */
    public static void floor() {
        BigDecimal a = new BigDecimal("12.239323").setScale(2, RoundingMode.FLOOR);
        BigDecimal b = new BigDecimal("12.231323").setScale(2, RoundingMode.FLOOR);
        BigDecimal c = new BigDecimal("-12.231323").setScale(2, RoundingMode.FLOOR);
        BigDecimal d = new BigDecimal("-12.239323").setScale(2, RoundingMode.FLOOR);

        BigDecimal e = new BigDecimal("12.230323").setScale(2, RoundingMode.FLOOR);
        BigDecimal f = new BigDecimal("-12.230000").setScale(2, RoundingMode.FLOOR);

        System.out.println(a + "___" + b);
        System.out.println(c + "___" + d);
        System.out.println(e + "___" + f);
    }

    /**
     * 无符号四舍五入。
     *      取绝对值以后，进行四舍五入，然后再把正负号加上去。
     *      如果距离两边相等，比如1.5距离2和1都是0.5，当出现这样的距离两边相等的时候，【【向上取整】】。
     */
    public static void halfUp() {
        BigDecimal a = new BigDecimal("12.235323").setScale(2, RoundingMode.HALF_UP);
        BigDecimal b = new BigDecimal("12.234323").setScale(2, RoundingMode.HALF_UP);
        BigDecimal c = new BigDecimal("-12.234323").setScale(2, RoundingMode.HALF_UP);
        BigDecimal d = new BigDecimal("-12.235323").setScale(2, RoundingMode.HALF_UP);

        BigDecimal e = new BigDecimal("12.230323").setScale(2, RoundingMode.HALF_UP);
        BigDecimal f = new BigDecimal("-12.230000").setScale(2, RoundingMode.HALF_UP);

        BigDecimal g = new BigDecimal("12.235").setScale(2, RoundingMode.HALF_UP);


        System.out.println(a + "___" + b);
        System.out.println(c + "___" + d);
        System.out.println(e + "___" + f);
        System.out.println(g);
    }

    /**
     * 无符号四舍五入。
     *      取绝对值以后，进行四舍五入，然后再把正负号加上去。
     *      如果距离两边相等，比如1.5距离2和1都是0.5，当出现这样的距离两边相等的时候，【【向下取整】】。
     */
    public static void halfDown() {
        BigDecimal a = new BigDecimal("12.236323").setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal b = new BigDecimal("12.234323").setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal c = new BigDecimal("-12.235323").setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal d = new BigDecimal("-12.234323").setScale(2, RoundingMode.HALF_DOWN);

        BigDecimal e = new BigDecimal("12.230323").setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal f = new BigDecimal("-12.230000").setScale(2, RoundingMode.HALF_DOWN);

        BigDecimal g = new BigDecimal("12.235").setScale(2, RoundingMode.HALF_DOWN);

        System.out.println(a + "___" + b);
        System.out.println(c + "___" + d);
        System.out.println(e + "___" + f);
        System.out.println(g);
    }

    /**
     无符号四舍五入。
     *      取绝对值以后，进行四舍五入，然后再把正负号加上去。
     *      如果距离两边相等，比如1.5距离2和1都是0.5，当出现这样的距离两边相等的时候，【【如果舍弃位，是五，需要看舍弃位前一位，前一个是奇数，则加1；如果是偶数，则减1】】。
     *
     */
    public static void halfEven() {
        BigDecimal a = new BigDecimal("12.236323").setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal b = new BigDecimal("12.234323").setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal c = new BigDecimal("-12.236323").setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal d = new BigDecimal("-12.234323").setScale(2, RoundingMode.HALF_EVEN);

        BigDecimal e = new BigDecimal("31.11500").setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal f = new BigDecimal("31.12500").setScale(2, RoundingMode.HALF_EVEN);

        System.out.println(a + "___" + b);
        System.out.println(c + "___" + d);
        System.out.println(e + "___" + f);

    }

}
