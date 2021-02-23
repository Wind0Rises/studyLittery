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
        System.out.println("--------- static code lump -----------");
    }

    public ConstructObject() {
        System.out.println("-----------  no args construct  -------------");
    }

    private String username;

    private String like;

}