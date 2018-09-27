package it.infn.ba.indigo.chronos.client.utils;



import feign.RequestInterceptor;
import feign.RequestTemplate;

import static feign.Util.checkNotNull;

/**
 * An interceptor that adds the request header needed to use HTTP basic authentication.
 */
public class TokenAuthRequestInterceptor implements RequestInterceptor {

  private final String token;

  /**
   * Creates an interceptor that authenticates all requests with the specified bearer token
   *
   * @param token the token to use for authentication
   */
  public TokenAuthRequestInterceptor(String token) {
    checkNotNull(token, "token");
    this.token = "bearer " + token;
  }

  @Override
  public void apply(RequestTemplate template) {
    template.header("Authorization", token);
  }
}

