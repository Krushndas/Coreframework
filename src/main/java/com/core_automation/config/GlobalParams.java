package com.core_automation.config;

public class GlobalParams {
    private static final ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static final ThreadLocal<String> udid = new ThreadLocal<String>();
    private static final ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static final ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static final ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();
    private static final ThreadLocal<String> wdaLocalPort = new ThreadLocal<String>();
    private static final ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<String>();

    public void setPlatformName(String platformName1){
        platformName.set(platformName1);
    }

    public String getPlatformName(){
        return platformName.get();
    }

    public String getUDID() {
        return udid.get();
    }

    public void setUDID(String udid2) {
        udid.set(udid2);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }

    public String getSystemPort() {
        return systemPort.get();
    }

    public void setSystemPort(String systemPort2) {
        systemPort.set(systemPort2);
    }

    public String getChromeDriverPort() {
        return chromeDriverPort.get();
    }

    public void setChromeDriverPort(String chromeDriverPort2) {
        chromeDriverPort.set(chromeDriverPort2);
    }

    public String getWdaLocalPort() {
        return wdaLocalPort.get();
    }

    public void setWdaLocalPort(String wdaLocalPort2) {
        wdaLocalPort.set(wdaLocalPort2);
    }

    public String getWebkitDebugProxyPort() {
        return webkitDebugProxyPort.get();
    }

    public void setWebkitDebugProxyPort(String webkitDebugProxyPort2) {
        webkitDebugProxyPort.set(webkitDebugProxyPort2);
    }

    public void initializeGlobalParams(String udid){
        GlobalParams params = new GlobalParams();

        switch (params.getPlatformName()) {
            case "Android" -> {
                params.setSystemPort(System.getProperty("systemPort", "10000"));
                params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
            }
            case "iOS" -> {
                params.setWdaLocalPort(System.getProperty("wdaLocalPort", "10001"));
                params.setWebkitDebugProxyPort(System.getProperty("webkitDebugProxyPort", "11001"));
            }
            default -> throw new IllegalStateException("Invalid Platform Name!");
        }
    }
}
