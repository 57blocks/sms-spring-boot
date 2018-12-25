package io._57blocks.sms.config;

import io._57blocks.sms.DummySmsService;
import io._57blocks.sms.SmsService;
import io._57blocks.sms.config.properties.SmsServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ConditionalOnClass(SmsService.class)
@EnableConfigurationProperties(SmsServiceProperties.class)
public abstract class AbstractSmsServiceAutoConfig {

  @Autowired
  private SmsServiceProperties properties;

  protected ResourceBundleMessageSource smsMessageSource() {
    final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename(properties.getMessageBaseName());

    return messageSource;
  }

  @Bean
  @ConditionalOnMissingBean
  public SmsService smsService() {
    if (properties.getEnabled()) {
      return createSmsService();
    } else {
      return new DummySmsService();
    }
  }

  protected abstract SmsService createSmsService();
}
