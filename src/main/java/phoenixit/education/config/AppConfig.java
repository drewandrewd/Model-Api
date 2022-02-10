package phoenixit.education.config;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class AppConfig {

//    private String url = "http://localhost:8080";
    private String url = "http://10.128.17.10:8838";

    @Bean
    public static AutoJsonRpcServiceImplExporter autoJsonRpcServiceImplExporter() {
        AutoJsonRpcServiceImplExporter exp = new AutoJsonRpcServiceImplExporter();
        return exp;
    }

    @Bean
    public  JsonRpcHttpClient jsonRpcHttpClient() throws MalformedURLException {
        return new JsonRpcHttpClient(new URL(url + "/api/v1/modelLink.json"));
    }

}
