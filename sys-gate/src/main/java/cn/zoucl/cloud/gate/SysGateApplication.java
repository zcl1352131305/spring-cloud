package cn.zoucl.cloud.gate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SysGateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysGateApplication.class, args);
	}
}
