/*
 * DRACOON
 * REST Web Services for DRACOON<br>Version: 4.8.0-LTS  - built at: 2018-05-03 15:44:37<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a>
 *
 * OpenAPI spec version: 4.8.0-LTS
 * Contact: develop@dracoon.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.sds.io.swagger.client.model;

/*
 * Copyright (c) 2002-2018 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * InfrastructureProperties
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-23T09:31:14.222+02:00")
public class InfrastructureProperties {
  @JsonProperty("smsConfigEnabled")
  private Boolean smsConfigEnabled = null;

  @JsonProperty("mediaServerConfigEnabled")
  private Boolean mediaServerConfigEnabled = null;

  @JsonProperty("s3DefaultRegion")
  private String s3DefaultRegion = null;

  public InfrastructureProperties smsConfigEnabled(Boolean smsConfigEnabled) {
    this.smsConfigEnabled = smsConfigEnabled;
    return this;
  }

   /**
   * Allow sending of share passwords via SMS
   * @return smsConfigEnabled
  **/
  @ApiModelProperty(example = "false", value = "Allow sending of share passwords via SMS")
  public Boolean getSmsConfigEnabled() {
    return smsConfigEnabled;
  }

  public void setSmsConfigEnabled(Boolean smsConfigEnabled) {
    this.smsConfigEnabled = smsConfigEnabled;
  }

  public InfrastructureProperties mediaServerConfigEnabled(Boolean mediaServerConfigEnabled) {
    this.mediaServerConfigEnabled = mediaServerConfigEnabled;
    return this;
  }

   /**
   * Is media server enabled?
   * @return mediaServerConfigEnabled
  **/
  @ApiModelProperty(example = "false", value = "Is media server enabled?")
  public Boolean getMediaServerConfigEnabled() {
    return mediaServerConfigEnabled;
  }

  public void setMediaServerConfigEnabled(Boolean mediaServerConfigEnabled) {
    this.mediaServerConfigEnabled = mediaServerConfigEnabled;
  }

  public InfrastructureProperties s3DefaultRegion(String s3DefaultRegion) {
    this.s3DefaultRegion = s3DefaultRegion;
    return this;
  }

   /**
   * Suggested S3 Region
   * @return s3DefaultRegion
  **/
  @ApiModelProperty(value = "Suggested S3 Region")
  public String getS3DefaultRegion() {
    return s3DefaultRegion;
  }

  public void setS3DefaultRegion(String s3DefaultRegion) {
    this.s3DefaultRegion = s3DefaultRegion;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InfrastructureProperties infrastructureProperties = (InfrastructureProperties) o;
    return Objects.equals(this.smsConfigEnabled, infrastructureProperties.smsConfigEnabled) &&
        Objects.equals(this.mediaServerConfigEnabled, infrastructureProperties.mediaServerConfigEnabled) &&
        Objects.equals(this.s3DefaultRegion, infrastructureProperties.s3DefaultRegion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(smsConfigEnabled, mediaServerConfigEnabled, s3DefaultRegion);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InfrastructureProperties {\n");

    sb.append("    smsConfigEnabled: ").append(toIndentedString(smsConfigEnabled)).append("\n");
    sb.append("    mediaServerConfigEnabled: ").append(toIndentedString(mediaServerConfigEnabled)).append("\n");
    sb.append("    s3DefaultRegion: ").append(toIndentedString(s3DefaultRegion)).append("\n");
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

