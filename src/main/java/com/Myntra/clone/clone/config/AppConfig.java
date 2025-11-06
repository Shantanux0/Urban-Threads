package com.Myntra.clone.clone.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class AppConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
				// 🔐 authorization rules
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/api/**").authenticated()
						.anyRequest().permitAll()
				)

				// 🧩 stateless sessions (replacement for deprecated .sessionManagement().sessionCreationPolicy(...))
				.sessionManagement(session -> session
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				)

				// 🔄 CORS (lambda style)
				.cors(cors -> cors.configurationSource(corsConfigurationSource()))

				// 🛡️ CSRF (lambda style)
				.csrf(csrf -> csrf.disable())

				// 🔑 Filters
				.addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class)

				// 👇 keep if you really want these; for pure JWT APIs you can remove both
				.httpBasic(withDefaults())
				.formLogin(withDefaults());

		return http.build();
	}

	// moved to a method so we can use it in the lambda above
	private CorsConfigurationSource corsConfigurationSource() {
		return new CorsConfigurationSource() {
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration cfg = new CorsConfiguration();

				// ⚠️ avoid trailing slashes in origins; they must match exactly
				cfg.setAllowedOrigins(Arrays.asList(
						"http://localhost:3000",
						"http://localhost:4000",
						"http://localhost:4200",
						"https://shopwithzosh.vercel.app",
						"https://ecommerce-angular-blue.vercel.app"
				));

				cfg.setAllowedMethods(Collections.singletonList("*"));
				cfg.setAllowCredentials(true);
				cfg.setAllowedHeaders(Collections.singletonList("*"));
				cfg.setExposedHeaders(Arrays.asList("Authorization"));
				cfg.setMaxAge(3600L);
				return cfg;
			}
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
