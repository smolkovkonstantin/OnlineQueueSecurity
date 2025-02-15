package org.online.queue.onlinequeuesecurity.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * RefreshRequest
 */

public class RefreshRequest {

  private String refreshToken;

  private String deviceId;


  /**
   * Constructor with only required parameters
   */
  public RefreshRequest(String refreshToken, String deviceId) {
    this.refreshToken = refreshToken;
    this.deviceId = deviceId;
  }

  public RefreshRequest refreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }

  @Schema(name = "refreshToken", description = "refresh token", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("refreshToken")
  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public RefreshRequest deviceId(String deviceId) {
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
    RefreshRequest refreshRequest = (RefreshRequest) o;
    return Objects.equals(this.refreshToken, refreshRequest.refreshToken) &&
        Objects.equals(this.deviceId, refreshRequest.deviceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(refreshToken, deviceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RefreshRequest {\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
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

