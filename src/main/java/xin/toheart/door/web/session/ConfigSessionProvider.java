package xin.toheart.door.web.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSessionProvider {

    @Bean(name = "SessionProvider")
    public SessionProvider sessionProvider(){
        return new HttpSessionProvider();
    }
}
