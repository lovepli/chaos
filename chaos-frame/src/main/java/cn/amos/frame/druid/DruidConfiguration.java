package cn.amos.frame.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * PROJECT: hello <br>
 * DESCRIPTION: notes
 *
 * @author wangdaoyuan
 * @date 2018/8/28
 */
@Configuration
public class DruidConfiguration {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {

        return new DruidDataSource();
    }

    /**
     * 1、配置一个管理后台的Servlet
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        Map<String, String> initParams = new HashMap<>(4);
        // 监控页面登录用户名/密码
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");

        // ip白名单（没有配置或者为空，则允许所有访问）
        initParams.put("allow", "");

        // ip黑名单（如果某个ip同时存在，deny优先于allow）
        initParams.put("deny", "");

        bean.setInitParameters(initParams);

        return bean;
    }

    /**
     * 2、配置一个web监控的filter
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String, String> initParams = new HashMap<>(1);

        // 不拦截的静态资源
        initParams.put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        bean.setInitParameters(initParams);

        // 拦截所有的请求
        bean.setUrlPatterns(Collections.singletonList("/*"));

        return bean;
    }


}
