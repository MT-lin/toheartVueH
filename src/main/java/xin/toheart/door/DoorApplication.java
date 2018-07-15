package xin.toheart.door;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("xin.toheart.door.mapper")
public class DoorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoorApplication.class, args);
	}
}
