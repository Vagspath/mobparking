package com.example.mvc.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;




public class ApplicationInitilizeListener implements ServletContextListener {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ApplicationInitilizeListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.debug("initializing..");
        WebApplicationContext ctx = WebApplicationContextUtils
                .getWebApplicationContext(sce.getServletContext());
      
      
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
