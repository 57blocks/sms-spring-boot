[![Travis-CI](https://travis-ci.org/57blocks/sms-spring-boot.svg?branch=master)](https://travis-ci.org/57blocks/sms-spring-boot)
[![License: MIT](https://img.shields.io/github/license/57blocks/sms-spring-boot.svg)](https://opensource.org/licenses/MIT)
[![Maven Central](hhttps://maven-badges.herokuapp.com/maven-central/io.57blocks/sms-spring-boot-starter.svg)](https://search.maven.org/search?q=a:sms-spring-boot-starter)
# SMS Spring Boot Starter
Configure an SMS service ready for sending messages. Supports templating with resource bundles.

## Getting Started
### Add the Starter in Maven Dependency
Edit `pom.xml`, add the starter:
```xml
    <dependency>
      <groupId>io.57blocks</groupId>
      <artifactId>sms-spring-boot-starter</artifactId>
      <version>${io.57blocks.sms.version}</version>
    </dependency>
```
If [twilio](https://www.twilio.com) is selected as the backend for sending SMS:

```xml
    <dependency>
      <groupId>io.57blocks</groupId>
      <artifactId>twilio-spring-boot-starter</artifactId>
      <version>${twilio-spring-boot-starter.version}</version>
    </dependency>
```

### Configure the Service

Edit `application.yml`, add the following properties:
```yaml
io.57blocks.sms:
  enabled: true
  message_base_name: /sms/messages
```

Edit `application.yml` for `twilio` credentials:

```yaml
io.57blocks.twilio:
  account_sid: ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
  auth_token: your_auth_token
```

### Create SMS Template

Default layout in `/src/main/resources`:

```
sms/
  messages.properties
  messages_zh.properties
```

### Send SMS

To send messages, inject `SmsService` into the bean.

```java
public class GreetingService {

  @Autowired
  private SmsService smsService;

  public void sendMessage() {
    smsService.send("+9876543210", "+1234567890", "greeting", Locale.ENGLISH,
        new Object[]{"Mr. Smith"});
      
  }
}
```
