package io._57blocks.sms.config;

import io._57blocks.sms.SmsService;
import io._57blocks.sms.SmsServiceTwilioImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

@ConditionalOnBean(type = "com.twilio.http.TwilioRestClient")
@AutoConfigureAfter(name = "io._57blocks.twilio.config.TwilioAutoConfig")
public class SmsServiceTwilioAutoConfig extends AbstractSmsServiceAutoConfig {

  @Override
  protected SmsService createSmsService() {
    return new SmsServiceTwilioImpl(smsMessageSource());
  }
}
