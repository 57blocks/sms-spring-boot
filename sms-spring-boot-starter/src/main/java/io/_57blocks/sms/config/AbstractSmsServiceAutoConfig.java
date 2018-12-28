package io._57blocks.sms.config;

import io._57blocks.sms.config.properties.SmsServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

abstract class AbstractSmsServiceAutoConfig {

  @Autowired
  private SmsServiceProperties properties;

  ResourceBundleMessageSource smsMessageSource() {
    final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename(properties.getMessageBaseName());

    return messageSource;
  }

}
