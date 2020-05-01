package com.devChallenge.funnyStr;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.devChallenge.controller.FunnyStrApplication;

@SpringBootTest(classes = FunnyStrApplication.class)
class FunnyStrWsTests {
	@Autowired
	WebApplicationContext webApplicationContext;

	@Test
	public void resultShouldBe_Base64() throws Exception {
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String uri = "/devchallenge";
		String funnyStr = "aSBsb3ZlIGphdmE=";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri).param("funnyStr",funnyStr)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "YXZhajFldm9sMWk=");
	}
	
	@Test
	public void resultShouldBe_InternalServerError() throws Exception {
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String uri = "/devchallenge";
		String funnyStr = "bG92ZTFqYXZh";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri).param("funnyStr",funnyStr)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(500, status);
		String content = mvcResult.getResponse().getErrorMessage();
		assertEquals(content, "Error input is not English capital letter");
	}
	
}
