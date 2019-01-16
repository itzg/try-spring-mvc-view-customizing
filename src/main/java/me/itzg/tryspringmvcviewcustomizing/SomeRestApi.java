package me.itzg.tryspringmvcviewcustomizing;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SomeRestApi {

  @GetMapping("currentTime")
  public TimeResponse getCurrentTime() {
    return new TimeResponse(new Date().toString());
  }
}
