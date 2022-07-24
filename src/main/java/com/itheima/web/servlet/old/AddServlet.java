package com.itheima.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    //创建service对象
    private BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//Json字符串

        //转换为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);


        //2.调用service
        brandService.add(brand);

        //3.响应成功的标识
        response.getWriter().write("success");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
