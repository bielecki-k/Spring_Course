package com.keru.kursspring;

import com.keru.kursspring.domain.repository.InMemoryRepository;
import com.keru.kursspring.domain.Knight;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KursspringApplicationTests {

	@Autowired
	Knight knight;

	@Autowired
	InMemoryRepository castle;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCastle(){


	}

}
