package org.blade.demo.kafkawithspringboot.TestController;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class TestKafkaController {

	// @Autowired
	// private KafkaController controller;

	@Autowired
	private MockMvc mvc;
	/*
	 * @Test public void contexLoads() throws Exception {
	 * assertThat(controller).isNotNull(); }
	 */

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/kafka/publish").param("message", "test")
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("")));
	}
}