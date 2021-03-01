package com.keru.kursspring;

import com.keru.kursspring.domain.repository.InMemoryRepository;
import com.keru.kursspring.domain.Knight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KursspringApplicationTests {

//	@Autowired
//	Knight knight;

	@Autowired
	InMemoryRepository inMemoryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCastle(){


	}

}
