package co.edu.uco.mensajes.servicios.inicializador;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import redis.clients.jedis.Jedis;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = { "co.edu.uco.mensajes" })
public class Application implements CommandLineRunner {

	/*private final Logger LOG = LoggerFactory.getLogger(getClass());
	private final MensajeRedis mensajeredis;

	public Application(MensajeRedis mensajeredis) {
		this.mensajeredis = mensajeredis;
		// TODO Auto-generated constructor stub
	}*/

	/*
	 * @Bean JedisConnectionFactory jedisConnectionFactory() { return new
	 * JedisConnectionFactory(); }
	 * 
	 * @Bean RedisTemplate<String, Prueba> redisTemplate1 (){ RedisTemplate<String,
	 * Prueba> redisTemplate1 = new RedisTemplate<>();
	 * redisTemplate1.setConnectionFactory(jedisConnectionFactory()); return
	 * redisTemplate1; }
	 */

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		Jedis jedis = new Jedis("localhost", 6379);
		//jedis.auth(SuperDificil);
		System.out.println("---------------------------------->ping!: " + jedis.ping());
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
