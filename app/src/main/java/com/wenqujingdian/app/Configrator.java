package com.wenqujingdian.app;

import java.util.HashMap;

/**
 * # 作者：王宏伟
 * # 时间：2017/11/29    上午11:21
 * # 描述：织巢鸟科技
 */

public class Configrator {

    private static final HashMap<String , Object> LATTE_CONFIGS = new HashMap<>();



    private Configrator(){

        LATTE_CONFIGS.put(ConfigTyep.CONFIG_READY.name(),false);

    }

    public static Configrator getInstince(){
        return Holder.INSTANCE;
    }

    final HashMap<String,Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }

    private static class Holder{
        private static final Configrator INSTANCE = new Configrator();

    }

    public final void configure(){
        LATTE_CONFIGS.put(ConfigTyep.CONFIG_READY.name(),true);
    }


    public final Configrator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigTyep.API_HOST.name(),host);
        return this;
    }


    private void checkConfiguration(){
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigTyep.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("Configuration is not ready");
        }
    }

    @SuppressWarnings("unchecked")
    final  <T> T getConfiguration(Enum<ConfigTyep> key){
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());

    }

}
