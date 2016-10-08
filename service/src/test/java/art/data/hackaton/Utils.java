package art.data.hackaton;

import static java.util.Collections.singletonList;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.net.URI;

public class Utils {

    public static URI morningUri(int port) throws Exception {
        return new URI("http://localhost:" + port + "/api/search?time=8");
    }

    public static URI eveningUri(int port) throws Exception {
        return new URI("http://localhost:" + port + "/api/search?time=21");
    }

    public static URI dayUri(int port) throws Exception {
        return new URI("http://localhost:" + port + "/api/search?time=12");
    }

    public static HttpEntity<String> getHttpHeadersEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(singletonList(APPLICATION_JSON_UTF8));

        HttpEntity<String> getSearchEntity = new HttpEntity<>(httpHeaders);

        return getSearchEntity;
    }
}
