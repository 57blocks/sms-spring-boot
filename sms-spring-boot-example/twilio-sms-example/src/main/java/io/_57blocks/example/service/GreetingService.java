package io._57blocks.example.service;

import io._57blocks.sms.SmsService;
import java.util.Locale;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

  private final SmsService smsService;

  public GreetingService(SmsService smsService) {
    this.smsService = smsService;
  }

  public void sendMessage() {
    this.smsService.send("+12056357762", "+13882201684", "greeting", Locale.ENGLISH,
        new Object[]{"Mr. Smith"});
  }

}
