package group.channel_pizza.integration;


import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*@Configuration*/
public class MongoDbTestConfiguration {

    private static final String IP = "localhost";
    private static final int PORT = 27017; 
    @Bean
    public IMongodConfig embeddedMongoConfiguration() throws IOException {
        return new MongodConfigBuilder()
                .version(Version.V4_0_2)
                .net(new Net(IP, PORT, Network.localhostIsIPv6()))
                .build();
    }
}
  