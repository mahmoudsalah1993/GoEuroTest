package Utils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class Client {

    private String url;

    public Client(String url) {
        this.url = url;
    }

    public String makeRequest() throws IOException {
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);
        InputStream stream = method.getResponseBodyAsStream();
        String response = IOUtils.toString(stream);
        method.releaseConnection();
        return response;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



}
