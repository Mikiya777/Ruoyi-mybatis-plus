package com.ruoyi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestResult <T>{
    /**
     * 状态码
     */
    private Integer CODE = 400;

    /**
     * 返回内容
     */
    private String MSG = "请求失败";

    /**
     * 数据对象
     */
    private T DATA;

   public RequestResult(T data){
       this.DATA = data;
       this.CODE = 200;
       this.MSG = "请求成功";
   }

}
