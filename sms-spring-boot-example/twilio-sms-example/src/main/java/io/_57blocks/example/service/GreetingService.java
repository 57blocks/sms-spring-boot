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
    this.smsService.send("+1234567890", "+987654321", "greeting", Locale.ENGLISH,
        new Object[]{"Mr. Smith"});
  }

}
