package org.online.queue.onlinequeuesecurity.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * SignUpRequest
 */

public class SignUpRequest {

  private String firstName;

  private String lastName;

  private String email;

  private String password;

  private String username;

  public SignUpRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SignUpRequest(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public SignUpRequest firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public SignUpRequest lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  @Schema(name = "lastName", description = "user's last name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public SignUpRequest email(String email) {
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

  public SignUpRequest password(String password) {
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

  public SignUpRequest username(String username) {
    this.username = username;
    return this;
  }

  /**
   * unique username
   * @return username
  */

  @Schema(name = "username", description = "unique username", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignUpRequest signUpRequest = (SignUpRequest) o;
    return Objects.equals(this.firstName, signUpRequest.firstName) &&
        Objects.equals(this.lastName, signUpRequest.lastName) &&
        Objects.equals(this.email, signUpRequest.email) &&
        Objects.equals(this.password, signUpRequest.password) &&
        Objects.equals(this.username, signUpRequest.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, email, password, username);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignUpRequest {\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
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

