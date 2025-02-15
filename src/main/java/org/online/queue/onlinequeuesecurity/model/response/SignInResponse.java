package org.online.queue.onlinequeuesecurity.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class SignInResponse {

  private String accessToken;

  public SignInResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SignInResponse(String accessToken) {
    this.accessToken = accessToken;
  }

  public SignInResponse accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  @JsonProperty("accessToken")
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignInResponse signInResponse = (SignInResponse) o;
    return Objects.equals(this.accessToken, signInResponse.accessToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignInResponse {\n");
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

