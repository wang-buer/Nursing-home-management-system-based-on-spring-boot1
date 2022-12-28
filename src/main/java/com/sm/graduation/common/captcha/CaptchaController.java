package com.sm.graduation.common.captcha;


import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.ChineseGifCaptcha;
import com.wf.captcha.GifCaptcha;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/captcha")
public class CaptchaController {

    @RequestMapping("/getCode")
    public void getCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        // 动态英文和数字验证码
        GifCaptcha gifCaptcha = new GifCaptcha(120,40,4);

        String captCode = gifCaptcha.text();
        request.getSession().setAttribute("captCode",captCode);

        gifCaptcha.out(outputStream);
    }
}
