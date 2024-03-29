package testingil.unittesting.examples.demos.d04.spring.d01.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfiguration {
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource datasource ) {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.driverClassName("org.h2.Driver")
				.url("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1")
				.username("sa")
				.password("sa")
				.build();
	}
	
}
