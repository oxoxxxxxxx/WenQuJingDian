package com.wenqujingdian.net;

import android.content.Context;

import com.wenqujingdian.net.callback.IError;
import com.wenqujingdian.net.callback.IFailure;
import com.wenqujingdian.net.callback.IRequest;
import com.wenqujingdian.net.callback.ISuccess;
import com.wenqujingdian.ui.LoaderStyle;

import java.io.File;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * # 作者：王宏伟
 * # 时间：2017/11/29    下午5:16
 * # 描述：织巢鸟科技
 */

public class RestClientBuilder {

    private              String                      mUrl         = null;
    private static final WeakHashMap<String, Object> PARAMS       = RestCreator.getParams();
    private              IRequest                    mIRequest    = null;
    private              ISuccess                    mISuccess    = null;
    private              IError                      mIError      = null;
    private              IFailure                    mIFailure    = null;
    private              RequestBody                 mBody        = null;
    private              LoaderStyle                 mLoaderStyle = null;
    private              Context                     mContext     = null;
    private              File                        mFile        = null;
    private              String                      downLoadDir  = null;
    private              String                      extension    = null;
    private              String                      name         = null;

    RestClientBuilder() {

    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);

        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }
    public final RestClientBuilder dir(String downLoadDir) {
        this.downLoadDir = downLoadDir;
        return this;
    }

    public final RestClientBuilder extension(String extension) {
        this.extension = extension;
        return this;
    }

    public final RestClientBuilder name(String name) {
        this.name = name;
        return this;
    }
    public final RestClientBuilder file(String file) {
        this.mFile = new File(file);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }


    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mIError = iError;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBuilder loader (Context context){
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallPulseIndicator;
        return this;
    }

    public final RestClientBuilder loader (Context context,LoaderStyle style){
        this.mContext = context;
        this.mLoaderStyle = style;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mIRequest, mISuccess, mIError, mIFailure, mBody,mLoaderStyle,mContext,mFile,downLoadDir,extension,name);
    }

}
