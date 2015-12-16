/*
 * Copyright (c) 2008, 2015, OneAPM and/or its affiliates. All rights reserved.
 */
package com.blueocn.api.controller;

import com.blueocn.api.support.spring.DateEditor;
import com.blueocn.api.support.spring.MapEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Title: Ajax基础交互控制器, 对指定类型绑定处理方法
 * Description:
 *
 * @author Yufan
 * @version 1.0.0
 * @since 2015-12-15 12:54
 */
public abstract class AbstractController {

    @InitBinder
    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws Exception {

        //对于需要转换为Date类型的属性，使用DateEditor进行处理
        binder.registerCustomEditor(Date.class, new DateEditor());
        binder.registerCustomEditor(Map.class, "extParams", new MapEditor());
    }
}
