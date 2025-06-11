package com.keru.kursspring;

import com.keru.kursspring.domain.repository.InMemoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)   // zamiast @RunWith(SpringRunner.class)
@SpringBootTest
class KursspringApplicationTests {

	@Autowired
	InMemoryRepository inMemoryRepository;

	@Test
	void contextLoads() {
		// test „czy wstaje kontekst”
	}

	@Test
	void testCastle() {
		// TODO: asercje - np.
		// assertNotNull(inMemoryRepository);
	}
}
