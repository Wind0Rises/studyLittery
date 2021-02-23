package com.liu.study.reflect.second.annotatedtype;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/1/4 13:16
 */
@DirectlyPresent(id=2,description = "this is a DirectlyPresentElement")
@IndirectlyPresent({@IndirectlyPresentValue(name = "firstName")})
public class PresentElement extends ParentPresentElement {

    public static void main(String[] args) {
        Class<PresentElement> directlyPresentElementClass = PresentElement.class;
        DirectlyPresent annotation = directlyPresentElementClass.getDeclaredAnnotation(DirectlyPresent.class);

        System.out.println(annotation.description());
        System.out.println(annotation.id());
    }

}
