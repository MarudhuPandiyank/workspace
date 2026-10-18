package com.micro.basetemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BaseTemplateApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void helloEndpointRejectsUnauthenticatedRequest() throws Exception {
		mockMvc.perform(get("/api/hello"))
				.andExpect(status().isUnauthorized());
	}

	@Test
	void helloEndpointReturnsServiceNameForAuthenticatedRequest() throws Exception {
		mockMvc.perform(get("/api/hello").with(SecurityMockMvcRequestPostProcessors.jwt()))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello from base-template"));
	}

	@Test
	void instanceEndpointReportsServerPortForAuthenticatedRequest() throws Exception {
		mockMvc.perform(get("/api/instance").with(SecurityMockMvcRequestPostProcessors.jwt()))
				.andExpect(status().isOk())
				.andExpect(content().string("base-template on port 8080"));
	}

}
