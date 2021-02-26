package com.liu.study.reflect.core.construct;

import lombok.Data;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/9/24 15:03
 */
@Data
public class ConstructObject {

    static {
        System.out.println("--------- static code lump（静态代码块） by executed-----------");
    }

    {
        System.out.println("--------- code lump（非静态代码块） by executed-----------");
    }

    public ConstructObject() {
        System.out.println("-----------  no args construct（无参） by executed -------------");
    }

    private String username;

    private String like;

}