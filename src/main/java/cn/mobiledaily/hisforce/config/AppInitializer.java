package cn.mobiledaily.hisforce.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Johnson on 2014/10/16.
 */
public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/api/*", "*.jpg", "*.png");
        configSpringSessionRepositoryFilter(servletContext, context);
        configureSpringSecurity(servletContext, context);
        dispatcher.setAsyncSupported(true);
        configureEncodingFilter(servletContext);
    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("cn.mobiledaily.hisforce.config");
        return context;
    }

    private void configureSpringSecurity(ServletContext servletContext, WebApplicationContext rootContext) {
        FilterRegistration.Dynamic springSecurity = servletContext.addFilter("springSecurityFilterChain",
                new DelegatingFilterProxy("springSecurityFilterChain", rootContext));
        springSecurity.addMappingForUrlPatterns(null, true, "/*");
    }

    private void configSpringSessionRepositoryFilter(ServletContext servletContext, WebApplicationContext rootContext) {
        FilterRegistration.Dynamic springSecurity = servletContext.addFilter("springSessionRepositoryFilter",
                new DelegatingFilterProxy("springSessionRepositoryFilter", rootContext));
        springSecurity.addMappingForUrlPatterns(null, true, "/*");
    }

    private void configureEncodingFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        fr.setInitParameter("encoding", "UTF-8");
        fr.setInitParameter("forceEncoding", "true");
        fr.addMappingForUrlPatterns(null, true, "/*");
    }
}