package prueba;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PruebaRepository implements PruebaInterface {
	
	private RedisTemplate<String, Prueba> redisTemplate;
	private HashOperations<String, String, Prueba> hashOperations;
	
	
	public PruebaRepository(RedisTemplate<String, Prueba> redisTemplate) {
		this.redisTemplate = redisTemplate;
		hashOperations=redisTemplate.opsForHash();
	}

	@Override
	public void guardar(Prueba prueba) {
		hashOperations.put("PRUEBA", prueba.getId(), prueba);
	}

	@Override
	public Map<String, Prueba> buscarTodo() {
		return hashOperations.entries("PRUEBA");
	}

	
}
