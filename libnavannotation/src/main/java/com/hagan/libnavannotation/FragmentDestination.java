package com.hagan.libnavannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface FragmentDestination {

    String pageUrl();

    /**
     * 是否需要登录后跳转
     *
     * @return
     */
    boolean needLogin() default false;

    /**
     * 是否是首页
     *
     * @return
     */
    boolean asStarter() default false;
}
