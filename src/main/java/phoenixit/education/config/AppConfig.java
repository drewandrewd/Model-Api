package phoenixit.education.config;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import phoenixit.education.jsonRPC.API;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    private static final String endpoint = "http://localhost:8080";

    @Bean
    public JsonRpcHttpClient jsonRpcHttpClient() {
        URL url = null;
        Map<String, String> map = new HashMap<>();
        try {
            url = new URL(AppConfig.endpoint);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new JsonRpcHttpClient(url, map);
    }

    @Bean
    public API exampleClientAPI(JsonRpcHttpClient jsonRpcHttpClient) {
        return ProxyUtil.createClientProxy(getClass().getClassLoader(), API.class, jsonRpcHttpClient);
    }

    @Bean
    public static AutoJsonRpcServiceImplExporter autoJsonRpcServiceImplExporter() {
        AutoJsonRpcServiceImplExporter exp = new AutoJsonRpcServiceImplExporter();
        return exp;
    }
}
