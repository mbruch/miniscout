package com.example.miniscout.client.services;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

import com.example.miniscout.shared.Form;
import com.example.miniscout.shared.IDatabaseService;
import com.google.common.base.Throwables;
import com.google.common.io.CharStreams;
import com.google.gson.Gson;

public class ProxyDatabaseService implements IDatabaseService {

  @Override
  public Form load(URI source) {
    try {
      if (!source.getScheme().startsWith("http")) {
        // we trick a bit. use hardcoded urls for demo purpose:
        source = new URI("http://localhost:8080/form");
      }
      InputStream stream = source.toURL().openStream();
      String form = CharStreams.toString(new InputStreamReader(stream));
      return new Gson().fromJson(form, Form.class);
    } catch (Exception e) {
      throw Throwables.propagate(e);
    }
  }

  @Override
  public void save(Form form, URI target) {
    // we don't save implement save.
  }
}
