import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.repository.SomeRepository;

import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;

import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
    classes = {
        AbstractTestConfiguration.BaseConfiguration.class
    })
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@EnableAutoConfiguration
public abstract class AbstractTestConfiguration implements TestData {
    protected static EmbeddedPostgres embeddedPostgres;

    @Autowired
    private SomeRepository someRepository;

    @BeforeAll
    public static void initPostgres() {
        try {
            embeddedPostgres = EmbeddedPostgres.builder()
            .setPort(5432)
            .start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void started() {
        System.out.println("Hello World");
    }

    @ComponentScan(basePackages = {
            "com.example.repository",
            "com.example.entity",
    })
    @EnableJpaRepositories(basePackages = {
        "com.example.repository"
    })
    @EntityScan(basePackages = {
        "com.example.entity"
    })
    @Configuration
    public static class BaseConfiguration {
    
    }
}


