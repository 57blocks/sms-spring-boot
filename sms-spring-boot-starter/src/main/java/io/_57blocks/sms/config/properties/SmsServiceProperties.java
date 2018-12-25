package io._57blocks.sms.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("io.57blocks.sms")
public class SmsServiceProperties {

  private Boolean enabled = Boolean.TRUE;
  private String messageBaseName = "/sms/messages";
}
