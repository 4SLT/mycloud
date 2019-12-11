package com.fslt.mycloudserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: MycloudServerApplication
 * @date: 2019/12/11 16:13
 * @author: zongxiong.lin
 * @version: 1.0
 */

@SpringBootApplication
@MapperScan(basePackages = "com.fslt.mycloudserver.modules.**.mapper")
public class MycloudServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycloudServerApplication.class, args);
    }

}
