package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("Inside main");
        
        displayDate();
    }

    public static void displayDate() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Parsed Date: {}", date);
        } catch (Exception e) {
            LOGGER.error("Error parsing static context target date pattern match: ", e);
        }
        LOGGER.info("END");
    }
}
/*
OUTPUT:
28-06-26 14:02:11.104 | main | INFO  | SpringLearnApplication | Inside main
28-06-26 14:02:11.115 | main | INFO  | SpringLearnApplication | START
28-06-26 14:02:11.450 | main | DEBUG | SpringLearnApplication | Parsed Date: Mon Dec 31 00:00:00 IST 2018
28-06-26 14:02:11.455 | main | INFO  | SpringLearnApplication | END
*/