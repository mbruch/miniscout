package com.example.miniscout.client.services;

import java.net.URI;

import com.example.miniscout.shared.Form;
import com.example.miniscout.shared.IDatabaseService;

public class ProxyDatabaseService implements IDatabaseService {

  @Override
  public Form load(URI source) {
    // TODO will ask a server to load some data
    return new Form();
  }

  @Override
  public void save(Form form, URI target) {
    // TODO will ask the server to stream the data
  }
}
