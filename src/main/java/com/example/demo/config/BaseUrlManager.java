package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName BaseUrlManager
 * @Description baseUrl配置管理
 * retrofit 的baseUrl必须以"/"结尾
 * @Author zhanghaiyan
 * @Date 2021/8/1
 * @Modifier
 */
public class BaseUrlManager {
    public static String BAI_DU_URL;
    public static String GIT_HUB_URL;
    public static String DEFAULT_URL;

    @Value("${retrofit.base-url.baidu}")
    public void setBaiDuUrl(String baiDuUrl) {
        BAI_DU_URL = endWithSlashForce(baiDuUrl);
    }

    @Value("${retrofit.base-url.github}")
    public void setGitHubUrl(String gitHubUrl) {
        GIT_HUB_URL = endWithSlashForce(gitHubUrl);
    }

    @Value("${retrofit.base-url.baidu}")
    public void setDefaultUrl(String defaultUrl) {
        DEFAULT_URL = endWithSlashForce(defaultUrl);
    }

    /**
     * 强制斜杠结尾
     * @param baseUrl
     * @return
     */
    private String endWithSlashForce(String baseUrl) {
        if (baseUrl.endsWith("/")) return baseUrl;
        return baseUrl + "/";
    }
}
