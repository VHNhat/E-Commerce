package cybersoft.javabackend.java11.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;


@Configuration
//@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {
	
//	// Auditor Aware
//	@Bean
//	AuditorAware<String> auditorAware(){
//		return new AuditorAwareImpl();
//	}
	
	@Component
	public interface GenericRepository<T, ID> extends JpaRepository<T, ID> {

	}
}
