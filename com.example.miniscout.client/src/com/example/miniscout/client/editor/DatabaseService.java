package com.example.miniscout.client.editor;

import static com.google.common.base.Charsets.UTF_8;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import com.google.common.base.Throwables;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;

public class DatabaseService {

  public static String load(URI uri) {
    try {
      return CharStreams.toString(Files.newReader(new File(uri), UTF_8));
    } catch (IOException e) {
      throw Throwables.propagate(e);
    }
  }

  public static void save(String data, URI uri) {
    try {
      if (uri.getScheme().equals("file")) {
        Files.write(data, new File(uri), UTF_8);
      } else
        throw new IllegalArgumentException("scheme " + uri + " not supported");
    } catch (IOException e) {
      throw Throwables.propagate(e);
    }
  }
}
