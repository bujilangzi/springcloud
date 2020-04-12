package com.atgui.controller;

import com.atguigu.springcould.entites.CommonResult;
import com.atguigu.springcould.entites.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZKControler {
    private static final String Invoke_url="http://could-provider-payment";
    @Resource
    private RestTemplate restTemplate;
    public  String paymentinfo(){
       String result= restTemplate.getForObject(Invoke_url+"/payment/zk",String.class);
        return  result;
    }
    @GetMapping(value = "/consummer/payment/getForEnity/{id}")
    public CommonResult<Payment>getpayment2(@PathVariable("id")long id){
        ResponseEntity<CommonResult> Entity = restTemplate.getForEntity(Invoke_url + "/payment/zk" + id, CommonResult.class);
          if (Entity.getStatusCode().is2xxSuccessful()){
              return Entity.getBody();

          }else{
              return new CommonResult<>(44,"操作失败");
          }
    }

}
