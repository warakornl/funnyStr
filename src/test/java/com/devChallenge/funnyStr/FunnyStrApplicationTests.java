package com.devChallenge.funnyStr;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
	 
}
