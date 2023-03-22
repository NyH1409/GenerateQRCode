package com.api.app.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
  @Value(value = "${qrcode.base.url}")
  private String baseUrl;

  public byte[] QRCodeGenerator() {
    QRCodeWriter writer = new QRCodeWriter();
    try {
      BitMatrix bitMatrix = writer.encode(baseUrl, BarcodeFormat.QR_CODE, 350, 350);
      BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      ImageIO.write(bufferedImage, "png", outputStream);
      return outputStream.toByteArray();
    } catch (WriterException | IOException e) {
      throw new RuntimeException(e);
    }
  }

}
