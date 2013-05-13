package com.example.miniscout.client.editor;

import java.net.URI;
import com.example.miniscout.shared.Field;
import com.example.miniscout.shared.Form;

public class DatabaseService {

  public static Form load(URI uri) {
    Form form = new Form();
    form.name = "In Memory Form";
    form.fields = new Field[] { new Field("string", "Firstname", "Max"),
        new Field("string", "Lastname", "Mustermann"),
        new Field("string", "Job Role", "Chief Architect"),
        new Field("string", "Company", "Codetrails UG"),
        new Field("string", "Street", "Seestraße 7") };
    return form;
  }

  public static void save(Form form, URI uri) {
    // in memory database does not persist
  }
}
