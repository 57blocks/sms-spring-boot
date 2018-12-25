package io._57blocks.sms;

import java.util.Locale;

public interface SmsService {

  Object send(String from, String to, String template, Locale locale, Object[] args);
}
