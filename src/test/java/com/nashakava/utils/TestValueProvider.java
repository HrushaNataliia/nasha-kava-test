package com.nashakava.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestValueProvider {
    Properties properties;

    public TestValueProvider() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException err) {
            System.out.println("Config.properties not found, using system properties or env variables");
        }
    }

    public String getBaseUIUrl() {
        return System.getProperty("base.ui.url",
                properties != null ? properties.getProperty("base.ui.url") :
                        System.getenv("BASE_UI_URL"));
    }

    public int getImplicitlyWait() {
        String wait = System.getProperty("implicitlyWait",
                properties != null ? properties.getProperty("implicitlyWait") :
                        System.getenv("IMPLICITLY_WAIT"));
        return wait != null ? Integer.parseInt(wait) : 5;
    }

    public String getCmsUIUrl() {
        return System.getProperty("cms.ui.url",
                properties != null ? properties.getProperty("cms.ui.url") :
                        System.getenv("CMS_UI_URL"));
    }

    public String getAdminEmail() {
        return System.getProperty("admin.email",
                properties != null ? properties.getProperty("admin.email") :
                        System.getenv("ADMIN_EMAIL"));
    }

    public String getAdminPassword() {
        return System.getProperty("admin.password",
                properties != null ? properties.getProperty("admin.password") :
                        System.getenv("ADMIN_PASSWORD"));
    }
}
