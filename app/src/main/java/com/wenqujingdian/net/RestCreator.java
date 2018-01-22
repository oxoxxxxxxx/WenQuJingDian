package com.wenqujingdian.net;

import com.wenqujingdian.app.ConfigTyep;
import com.wenqujingdian.app.Latte;

import java.io.File;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * # 作者：王宏伟
 * # 时间：2017/11/29    下午4:58
 * # 描述：织巢鸟科技
 */

public class RestCreator {

    public static final class ParamsHolder {
        public static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    public static WeakHashMap<String, Object> getParams() {
        return ParamsHolder.PARAMS;
    }


    public static RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }

    private static final class RetrofitHolder {
        private static final String   BASE_URL        = (String) Latte.getConfigurations().get(ConfigTyep.API_HOST.name());
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(OKHttpHolder.OK_HTTP_CLIENT)
                .build();
    }

    private static final class OKHttpHolder {
        private static final int          TIME_OUT       = 60;

       private static final File cacheFile = new File(Latte.getApplication().getCacheDir(), "HttpCache");
       private static final Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new CacheInterceptor())
                .cache(cache).build();
    }

    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }
}
