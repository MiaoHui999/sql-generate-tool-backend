package com.wenzh.sqlGenerateTool.config;

import freemarker.template.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.freemarker.SpringTemplateLoader;
import org.springframework.core.io.ResourceLoader;
import javax.annotation.Resource;

/**
 * FreeMarker 模板配置
 *
 * @author wenzhou
 */

@org.springframework.context.annotation.Configuration
public class FreeMarkerConfigurationConfig {
    private static freemarker.template.Configuration cfg;

    @Resource
    private ResourceLoader resourceLoader;

    @Bean
    public Configuration configuration() {
        try{
            SpringTemplateLoader templateLoader = new SpringTemplateLoader(resourceLoader, "classpath:templates");
            cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
            cfg.setTemplateLoader(templateLoader);
            cfg.setDefaultEncoding("UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return cfg;
    }
}


