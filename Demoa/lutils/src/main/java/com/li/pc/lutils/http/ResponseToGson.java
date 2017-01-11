package com.li.pc.lutils.http;

import android.os.Handler;

import com.google.gson.Gson;

import org.xutils.common.util.LogUtil;
import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;

/**
 * author   ：mo
 * data     ：2017/1/11
 * time     ：17:56
 * function : 使用gson进行解析json数据
 * @HttpResponse(parser = JsonToResponse.class)
 */

public class ResponseToGson implements ResponseParser {
    Handler handler = new Handler();
    @Override
    public void checkResponse(UriRequest request) throws Throwable {
        LogUtil.i("请求数据为======="+request);
    }

    @Override
    public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        LogUtil.i("请求结果为======="+result);
        //        //进行判断是否为code 是否为0,进行json解析，
//        JSONObject jsonObject=new JSONObject(result);
//        String code=jsonObject.getString("code");
//        if(code.equals("0")){
        return new Gson().fromJson(result,resultType);
//        }else{
//            //即为code!=0的时候
//            JSONObject data=jsonObject.getJSONObject("data");
//            final String des = data.getString("des");
//            //打印des
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(x.app(), des, Toast.LENGTH_SHORT).show();
//                }
//            });
//            return null;
//        }
    }
}
