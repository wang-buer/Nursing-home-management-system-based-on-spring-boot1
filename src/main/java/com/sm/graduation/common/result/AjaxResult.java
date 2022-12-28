package com.sm.graduation.common.result;

import java.util.HashMap;


public class AjaxResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public AjaxResult() {}

    /**
     * 500 ---  操作失败
     */
    public static AjaxResult error() {
        return error(500, "操作失败");
    }

    /**
     * 500 --- msg
     */
    public static AjaxResult error(String msg)
    {
        return error(500, msg);
    }

    /**
     * code --- msg
     */
    public static AjaxResult error(int code, String msg) {
        AjaxResult json = new AjaxResult();
        json.put("code", code);
        json.put("msg", msg);
        return json;
    }


    public static AjaxResult success(int code, String msg) {
        AjaxResult json = new AjaxResult();
        json.put("code", code);
        json.put("msg", msg);
        return json;
    }


    /**
     * 200 --- msg
     */
    public static AjaxResult success(String msg)
    {
        AjaxResult json = new AjaxResult();
        json.put("msg", msg);
        json.put("code", 200);
        return json;
    }

    /**
     * 200 --- 操作成功
     */
    public static AjaxResult success()
    {
        return AjaxResult.success("操作成功");
    }



    public static AjaxResult successData(long total, Object value){
    	 AjaxResult json = new AjaxResult();
    	 json.put("code", 0);
    	 json.put("msg","操作成功");
         json.put("count",total);
         json.put("data", value);
         return json;
    }

    public static AjaxResult errorData(long total, Object data){
        AjaxResult json = new AjaxResult();
        json.put("code", 500);
        json.put("msg","操作失败");
        json.put("count",total);
        json.put("data", data);
        return json;
    }


    /**
     *  put( k, v)
     */
    @Override
    public AjaxResult put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }
}
