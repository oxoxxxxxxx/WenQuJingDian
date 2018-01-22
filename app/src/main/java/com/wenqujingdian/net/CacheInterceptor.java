package com.wenqujingdian.net;

import android.util.Log;

import com.wenqujingdian.app.Latte;
import com.wenqujingdian.util.LogUtils;
import com.wenqujingdian.util.NetUtils;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * # 作者：王宏伟
 * # 时间：2017/8/17    下午2:53
 * # 描述：织巢鸟科技
 */

public class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        LogUtils.i(String.valueOf( request.url()));

        //缓存
        if(!NetUtils.isNetworkAvailable(Latte.getApplication())){
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }
        Response response = chain.proceed(request);
        ResponseBody responseBody = response.peekBody(1024 * 1024);
        LogUtils.iJsonFormat(responseBody.string(),false);
        //缓存响应
        if(NetUtils.isNetworkAvailable(Latte.getApplication())){
            //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
            String cacheControl = request.cacheControl().toString();
            Log.d("zgx","cacheControl====="+cacheControl);
            return response.newBuilder()
                    .header("Cache-Control", cacheControl)
                    //http1.0的旧东西，优先级比Cache-Control低
                    .removeHeader("Pragma")
                    .build();
        }else{
            return response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=30*24*60*60")
                    .removeHeader("Pragma")
                    .build();
        }
    }
}
