package com.example.miniscout.client.services;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;

import com.example.miniscout.shared.Form;
import com.example.miniscout.shared.IDatabaseService;
import com.google.common.base.Throwables;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * A Gson based database service that reads data from JSON files and converts
 * them to forms.
 */
public class LocalDatabaseService implements IDatabaseService {

  @Override
  public Form load(URI source) {
    try {
      File f = new File(source);
      FileReader r = new FileReader(f);
      Gson b = new GsonBuilder().create();
      return b.fromJson(r, Form.class);
    } catch (Exception e) {
      throw Throwables.propagate(e);
    }
  }

  @Override
  public void save(Form form, URI target) {
    try {
      Gson b = new GsonBuilder().create();
      File f = new File(target);
      FileWriter w = new FileWriter(f);
      b.toJson(form, w);
      w.close();
    } catch (Exception e) {
      throw Throwables.propagate(e);
    }
  }
}
