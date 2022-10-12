package com.tokiobank.transference;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TransferenceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(TransferenceApplication.class)
		.web(WebApplicationType.SERVLET)
		.bannerMode(Banner.Mode.OFF)
		.run(args);
	}

}
