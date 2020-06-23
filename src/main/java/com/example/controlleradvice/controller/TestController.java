package com.example.controlleradvice.controller;

import com.example.controlleradvice.common.R;
import com.example.controlleradvice.services.TestService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 陈孟飞
 * @date 2020/6/22
 */
@RestController
@RequestMapping(value="test")
public class TestController {

    @Resource
    private TestService testService;

    /**
     * controller处理异常
     * @return
     * @throws Exception
     */
    @RequestMapping(value="test")
    public R test() throws Exception {
        return testService.test();
    }

    /**
     * service捕获异常，controller无需再处理了
     * @return
     */
    @RequestMapping(value="test2")
    public R test2() {
        return testService.test2();
    }

    @RequestMapping(value="test3")
    public R test3() {
        try {
            return testService.test2();
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
    }
}
