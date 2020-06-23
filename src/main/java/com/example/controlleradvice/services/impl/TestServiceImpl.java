package com.example.controlleradvice.services.impl;

import com.example.controlleradvice.common.R;
import com.example.controlleradvice.exception.MyException;
import com.example.controlleradvice.services.TestService;
import org.springframework.stereotype.Service;

/**
 * @author 陈孟飞
 * @date 2020/6/22
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public R test() throws Exception {
        return this.test2();
    }

    public R match() throws Exception{
        int i = 1/0;
        return R.data(null);
    }

    @Override
    public R test2() {
        //..执行了update操作，如果a不能被2整除则回滚
        int a = 5;
        if (a%2 == 1) {
            throw new MyException("自定义异常");
        }
        return R.data(null);
    }
}
