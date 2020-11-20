package se.jorgenlundberg.sasviewer;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHelper {

  @ExceptionHandler(NoSasFileException.class)
  public String handleMyCustomExceptions(NoSasFileException e, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("message", e.getMessage());
    return "redirect:/";
  }
}
