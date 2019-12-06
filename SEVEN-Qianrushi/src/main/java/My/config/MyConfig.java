package My.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 手动配置一个嵌入式的servlet容器的定制器WebServerFactoryCustomizer
 * 一起合并到MyServerConfig.java里面去了 并成一个配置类
*/
//@Configuration
//public class MyConfig {
//
//    @Bean
//    public WebServerFactoryCustomizer addWebServerFactoryCustomizer(){
//
//        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
//            @Override
//            public void customize(ConfigurableServletWebServerFactory factory) {
//                factory.setPort(8082);
//            }
//        };
//    }
//}
