package com.jai.oms;

import com.jai.oms.springconfig.OmsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class OmsBootstrapApplication {

    private static final Logger logger = LoggerFactory.getLogger(OmsBootstrapApplication.class);

    public static void main(String[] args) {
        logger.info("Running bootstrap ...");

        Class clazz = OmsConfig.class;

        try {
            logger.info("Setting up application context : {}", clazz.getName());
            AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(clazz);

            applicationContext.registerShutdownHook();
            logger.info("Registering shutdown hook");

            logger.info("Bootstrap has completed. OMS has started at {}", LocalDateTime.now());
        } catch (Exception e) {
            logger.error("Cannot startup due to exception: {}", e.toString());
            System.exit(1);
        }
    }

}
