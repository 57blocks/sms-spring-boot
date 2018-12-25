package io._57blocks.sms;

import java.util.Locale;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DummySmsService implements SmsService {

  @Override
  public Object send(String from, String to, String template, Locale locale, Object[] args) {
    log.warn("############# Dummy SMS Service, No Message Sent #############");
    log.info("SMS template: {}, locale: {}, from: {}, to: {}, args:{}", template, locale, from, to,
        args);
    return null;
  }
}
