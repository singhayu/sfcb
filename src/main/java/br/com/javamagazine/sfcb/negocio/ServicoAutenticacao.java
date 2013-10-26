package br.com.javamagazine.sfcb.negocio;

import com.restfb.DefaultWebRequestor;
import com.restfb.FacebookClient;
import com.restfb.WebRequestor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicoAutenticacao extends ServicoFacebook {
    private static final Logger log = Logger.getLogger(ServicoAutenticacao.class.getName());

    private final String appId;
    private final String appSecret;
    private final String redirectUrl;
    private final String scope;
    private final String code;

    public ServicoAutenticacao(String code) {
        final Properties p = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream("/facebook-app.properties")) {
            p.load(inputStream);
        } catch (IOException e) {
            log.log(Level.SEVERE, "Não foi possível abrir o arquivo acebook-app-id.properties", e);
        }

        appId = p.getProperty("facebok.app.id");
        appSecret = p.getProperty("facebook.app.secret");
        scope = p.getProperty("facebook.app.permissions");
        redirectUrl = p.getProperty("facebook.app.site_url");
        this.code = code;

    }

    public FacebookClient.AccessToken getFacebookUserToken() throws IOException {

        final WebRequestor wr = new DefaultWebRequestor();
        final String urlCall = String.format("https://graph.facebook.com/oauth/access_token" +
                "?client_id=%s&redirect_uri=%s&client_secret=%s&code=%s&scope=%s",
                appId, redirectUrl, appSecret, code, scope
        );
        log.info("URL called: " + urlCall);
        WebRequestor.Response accessTokenResponse = wr.executeGet(urlCall);
        return FacebookClient.AccessToken.fromQueryString(accessTokenResponse.getBody());
    }
}

