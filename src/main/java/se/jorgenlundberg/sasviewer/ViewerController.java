package se.jorgenlundberg.sasviewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.parso.Column;
import com.epam.parso.SasFileReader;
import com.epam.parso.impl.SasFileReaderImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ViewerController {

  @GetMapping("/")
  public String listUploadedFiles() {
    return "uploadForm";
  }

  @PostMapping("/")
  public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes)
      throws IOException {

    SasFileReader sasFileReader = new SasFileReaderImpl(file.getInputStream());
    if(sasFileReader.getColumns().isEmpty()) {
      throw new NoSasFileException("Either the file was not a sas7bdat file or it was empty.");
    }

    List<String> headers = getHeaders(sasFileReader);
    List<List<String>> values = getValues(sasFileReader);

    redirectAttributes.addFlashAttribute("fileName", file.getOriginalFilename());
    redirectAttributes.addFlashAttribute("headers", headers);
    redirectAttributes.addFlashAttribute("values", values);
    return "redirect:/";
  }

  private List<List<String>> getValues(SasFileReader sasFileReader) {
    List<List<String>> values = new ArrayList<>();
    for(Object[] row: sasFileReader.readAll()) {
      List<String> rowValues = new ArrayList<>();
      for(Object value: row) {
        rowValues.add(Objects.toString(value, ""));
      }
      values.add(rowValues);
    }
    return values;
  }

  private List<String> getHeaders(SasFileReader sasFileReader) {
    return sasFileReader.getColumns().stream()
        .map(Column::getName)
        .collect(Collectors.toList());
  }

}
