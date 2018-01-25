package com.wenqujingdian.net;

import android.content.Context;

import com.wenqujingdian.net.callback.IError;
import com.wenqujingdian.net.callback.IFailure;
import com.wenqujingdian.net.callback.IRequest;
import com.wenqujingdian.net.callback.ISuccess;
import com.wenqujingdian.net.callback.RequestCallBack;
import com.wenqujingdian.net.download.DownloadHandler;
import com.wenqujingdian.ui.LoaderStyle;

import java.io.File;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * # 作者：王宏伟
 * # 时间：2017/11/29    下午4:19
 * # 描述：织巢鸟科技
 */

public class RestClient {

    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest    REQUST;
    private final ISuccess    SUCCESS;
    private final IError      ERROR;
    private final IFailure    FAILURE;
    private final String      DOWNLOAD_DIR;
    private final String      EXTENSION;
    private final String      NAME;
    private final RequestBody BODY;
    private final LoaderStyle LOADER_STYLE;
    private final Context     CONTEXT;
    private final File        FILE;


    public RestClient(String url,
                      WeakHashMap<String, Object> params,
                      IRequest requst,
                      ISuccess success,
                      IError error,
                      IFailure failure,
                      RequestBody body,
                      LoaderStyle loaderStyle,
                      Context context,
                      File file,
                      String downLoadDir,
                      String extension,
                      String name) {
        URL = url;
        PARAMS.putAll(params);
        REQUST = requst;
        SUCCESS = success;
        ERROR = error;
        FAILURE = failure;
        BODY = body;
        LOADER_STYLE = loaderStyle;
        CONTEXT = context;
        FILE = file;
        DOWNLOAD_DIR = downLoadDir;
        EXTENSION = extension;
        NAME = name;
    }

    public static RestClientBuilder sBuilder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;
        if (REQUST != null) {
            REQUST.onRequstStart();
        }
//        if (LOADER_STYLE != null) {
//            Log.i("显示了","请求开始了");
////            LatteLoader.showLoading(CONTEXT, LOADER_STYLE);
//        }
        switch (method) {
            case GET:

                call = service.get(URL, PARAMS);
                break;
            case POST:

                call = service.post(URL, PARAMS);
                break;
            case POST_RAW:

                call = service.postRaw(URL, BODY);
                break;
            case PUT:

                call = service.put(URL, PARAMS);
                break;

            case PUT_RAW:

                call = service.putRaw(URL, BODY);
                break;
            case DELETE:

                call = service.delete(URL, PARAMS);
                break;
            case UPLOAD:

                final RequestBody requestBody = RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part body = MultipartBody.Part.createFormData("file", FILE.getName());
                call = service.upload(URL, body);
                break;

            default:
                break;
        }

        if (call != null) {
            call.enqueue(getRequestCallback());
        }

    }

    private Callback<String> getRequestCallback() {
        return new RequestCallBack(SUCCESS, ERROR, FAILURE, REQUST, LOADER_STYLE);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        if (BODY == null) {
            request(HttpMethod.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.POST_RAW);
        }

    }

    public final void put() {
        if (BODY == null) {
            request(HttpMethod.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.PUT_RAW);
        }
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }

    public final void upload() {
        request(HttpMethod.UPLOAD);
    }

    public final void download() {
        new DownloadHandler(URL, REQUST, SUCCESS, ERROR, FAILURE, DOWNLOAD_DIR, EXTENSION, NAME).handlerDownload();
    }

}
