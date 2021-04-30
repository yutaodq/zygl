package mike.wolf.zygl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class IvmsApplication  extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(IvmsApplication.class, args);
  }

  @Override//为了打包springboot项目
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return super.configure(builder);
//    return builder.sources(this.getClass());
  }
}
