package io._57blocks.sms;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.Locale;
import org.springframework.context.support.ResourceBundleMessageSource;

public class SmsServiceTwilioImpl implements SmsService {

  private ResourceBundleMessageSource messageSource;

  public SmsServiceTwilioImpl(ResourceBundleMessageSource smsMessageSource) {
    this.messageSource = smsMessageSource;
  }

  public Object send(String from, String to, String template, Locale locale, Object[] args) {
    String body = messageSource.getMessage(template, args, locale);

    Message message = Message.creator(new PhoneNumber(to), new PhoneNumber(from), body).create();
    return message.getSid();
  }
}
