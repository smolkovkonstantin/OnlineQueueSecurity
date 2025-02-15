package org.online.queue.onlinequeuesecurity.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * SignInRequest
 */

public class SignInRequest {

  private String email;

  private String password;

  private String deviceId;

  public SignInRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SignInRequest(String email, String password, String deviceId) {
    this.email = email;
    this.password = password;
    this.deviceId = deviceId;
  }

  public SignInRequest email(String email) {
    this.email = email;
    return this;
  }

  @Schema(name = "email", description = "user email", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public SignInRequest password(String password) {
    this.password = password;
    return this;
  }

  @Schema(name = "password", description = "user password", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public SignInRequest deviceId(String deviceId) {
    this.deviceId = deviceId;
    return this;
  }

  @Schema(name = "deviceId", description = "fingerprint", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("deviceId")
  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignInRequest signInRequest = (SignInRequest) o;
    return Objects.equals(this.email, signInRequest.email) &&
        Objects.equals(this.password, signInRequest.password) &&
        Objects.equals(this.deviceId, signInRequest.deviceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password, deviceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignInRequest {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    deviceId: ").append(toIndentedString(deviceId)).append("\n");
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

