package com.javaweb;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class LogTest {
    private static final Logger log = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void testLog(){
//        System.out.println(LocalDateTime.now() + " : start calculate...");
        log.debug("start calculate.......");

        int sum = 0;
        int[] nums = {1, 5, 3, 2, 1, 4, 5, 4, 6, 7, 4, 34, 2, 23};
        for (int num : nums) {
            sum += num;
        }

        log.info("sum:{}",sum);
        log.debug("end calculate.......");
       /* System.out.println("The result is: "+sum);
        System.out.println(LocalDateTime.now() + " finish calculate...");
   */ }

}
