package gmc.project.blockchain.miner.peer.configurations;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import gmc.project.blockchain.miner.peer.models.KafkaModel;

@Configuration
public class KafkaProducerConfig {
	
	@Autowired
	private KafkaConfig kafkaConfigs;
	
	public Map<String, Object> getProducerConfiguration() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfigs.getServerUrl());
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return configs;
	}
	
	public ProducerFactory<String, KafkaModel> getProducer() {
		return new DefaultKafkaProducerFactory<>(getProducerConfiguration());
	}
	
	@Bean
	public KafkaTemplate<String, KafkaModel> kafkaTemplate() {
		return new KafkaTemplate<String, KafkaModel>(getProducer());
	}

}