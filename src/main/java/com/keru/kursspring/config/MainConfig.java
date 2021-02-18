package com.keru.kursspring.config;

import com.keru.kursspring.domain.Knight;
import com.keru.kursspring.domain.Quest;
import com.keru.kursspring.domain.repository.DbKnightRepository;
import com.keru.kursspring.domain.repository.InMemoryRepository;
import com.keru.kursspring.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
//@PropertySource("classpath:knightRepository.properties")
public class MainConfig {

    @Bean(name = "inMemoryKnightRepo")
    @Profile("dev")
    public KnightRepository createInMemoryRepo(){
        KnightRepository repo = new InMemoryRepository();
        return repo;
    }

    @Bean(name = "DBKnightMemoryRepo")
    @Profile("prod")
    public KnightRepository createDbMemoryRepo(){
        KnightRepository repo = new DbKnightRepository();
        return repo;
    }


}
