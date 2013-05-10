package com.example.miniscout.client.editor;

import java.net.URI;

import org.eclipse.ui.internal.part.NullEditorInput;

public class ContactEditorInput extends NullEditorInput {

  private URI input;

  public ContactEditorInput(URI input) {
    this.input = input;
  }

  public URI getInput() {
    return input;
  }
}
