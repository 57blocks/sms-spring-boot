package io._57blocks.sms.config;

import io._57blocks.sms.SmsService;
import io._57blocks.sms.SmsServiceTwilioImpl;
import io._57blocks.sms.config.properties.SmsServiceProperties;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SmsServiceProperties.class)
@ConditionalOnMissingBean(SmsService.class)
@ConditionalOnBean(type = "com.twilio.http.TwilioRestClient")
@AutoConfigureAfter(name = "io._57blocks.twilio.config.TwilioAutoConfig", value = DummySmsServiceAutoConfig.class)
public class SmsServiceTwilioAutoConfig extends AbstractSmsServiceAutoConfig {

  @Bean
  public SmsService smsService() {
    return new SmsServiceTwilioImpl(smsMessageSource());
  }

}
