package io._57blocks.sms.config;

import io._57blocks.sms.DummySmsService;
import io._57blocks.sms.SmsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(SmsService.class)
@ConditionalOnProperty(prefix = "io.57blocks.sms", value = "enabled", havingValue = "false")
public class DummySmsServiceAutoConfig {

  @Bean
  @ConditionalOnMissingBean
  public SmsService smsService() {
    return new DummySmsService();
  }
}
