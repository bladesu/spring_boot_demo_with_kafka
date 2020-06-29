package org.blade.demo.TestController;

import static org.assertj.core.api.Assertions.assertThat;

import org.blade.demo.controllers.KafkaController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes=KafkaController.class)
public class TestKafkaController {

    
	@Autowired
	private KafkaController controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}