package com.devChallenge.funnyStr;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.devChallenge.services.ChallengeServices;

@SpringBootTest
class FunnyStrApplicationTests {

	@Test
	public void resultShouldBe_ilovejava() {
		ChallengeServices serv = new ChallengeServices("aWxvdmVqYXZh");
		assertEquals("ilovejava", serv.decode());
	}

	@Test
	public void resultShouldBe_ThrowException() {
		ChallengeServices serv = new ChallengeServices("aTFKYXZh");
		try {
			assertEquals("ilovejava", serv.checkWord());
		} catch (Exception e) {
			assertEquals("Error input is not English capital letter", e.getMessage());
		}
	}

	@Test
	public void wordShouldBe_i1love1java() {
		ChallengeServices serv = new ChallengeServices("aSBsb3ZlIGphdmE=");
		assertEquals("i1love1java", serv.countSpace());
	}

	@Test
	public void wordShouldBe_i1love2java3too1much() {
		ChallengeServices serv = new ChallengeServices("aSBsb3ZlICBqYXZhICAgdG9vIG11Y2g=");
		assertEquals("i1love2java3too1much", serv.countSpace());
	}

	@Test
	public void wordShouldBe_avaj1evol1i() {
		ChallengeServices serv = new ChallengeServices("aSBsb3ZlIGphdmE=");
		assertEquals("avaj1evol1i", serv.revertString());
	}

	@Test
	public void wordShouldBe_avaj1evol1i_InBase64() {
		ChallengeServices serv = new ChallengeServices("aSBsb3ZlIGphdmE=");
		assertEquals("YXZhajFldm9sMWk=", serv.encode());
	}
	
	@Autowired
	WebApplicationContext webApplicationContext;

	@Test
	public void updateProduct() throws Exception {
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String uri = "/devchallenge";
		String funnyStr = "aSBsb3ZlIGphdmE=";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri).param("funnyStr",funnyStr)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "YXZhajFldm9sMWk=");
	}
	 
}
