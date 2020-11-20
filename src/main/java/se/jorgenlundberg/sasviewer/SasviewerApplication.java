package se.jorgenlundberg.sasviewer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SasviewerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SasviewerApplication.class, args);
  }

}
