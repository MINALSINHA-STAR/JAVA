package com.search.product.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class RedisConfig {

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {

		RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration("climbing-vervet-27202.upstash.io",
				6379);
		redisConfig.setUsername("default");
		redisConfig.setPassword("AWpCAAIncDE5MDI2NWM3NjNhYTk0ZDU0ODk1MDhlZDA2YTFlOTg1YnAxMjcyMDI");

		LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
				.commandTimeout(Duration.ofSeconds(10)).shutdownTimeout(Duration.ofMillis(100)).useSsl().build();

		return new LettuceConnectionFactory(redisConfig, clientConfig);
	}

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {

		RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofMinutes(1)) // TTL
				.serializeValuesWith(RedisSerializationContext.SerializationPair
						.fromSerializer(new GenericJackson2JsonRedisSerializer()));

		return RedisCacheManager.builder(connectionFactory).cacheDefaults(cacheConfig).build();
	}
}