package com.api.app.controller;

import com.api.app.service.CodeService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CodeController {
  private final CodeService service;
  @GetMapping(value = "/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
  public byte[] getQrCode(){
    return service.QRCodeGenerator();
  }

}
