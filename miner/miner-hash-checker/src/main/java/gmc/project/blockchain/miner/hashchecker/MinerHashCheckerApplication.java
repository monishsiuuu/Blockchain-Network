package gmc.project.blockchain.miner.hashchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EnableDiscoveryClient
@SpringBootApplication
public class MinerHashCheckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinerHashCheckerApplication.class, args);
	}

}
