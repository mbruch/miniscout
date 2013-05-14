package com.example.miniscout.client.editor;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import com.example.miniscout.client.fields.Fields;
import com.example.miniscout.client.fields.FormField;
import com.example.miniscout.client.fields.FormField.Listener;
import com.example.miniscout.client.fields.FormField.ValueChangedEvent;
import com.example.miniscout.client.services.Services;
import com.example.miniscout.shared.Field;
import com.example.miniscout.shared.Form;
import com.example.miniscout.shared.IDatabaseService;

public class Editor extends EditorPart implements Listener<ValueChangedEvent> {

  private URI input;
  private Form form;
  private List<FormField> fields;
  private boolean dirty;

  @Override
  public void init(IEditorSite site, IEditorInput in) throws PartInitException {
    setSite(site);
    setInput(in);
    this.input = ((ContactEditorInput) in).getInput();
    form = Services.get(IDatabaseService.class).load(input);
  }

  @Override
  public void createPartControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NONE);
    container.setLayout(new GridLayout(2, false));
    fields = new LinkedList<FormField>();
    for (Field field : form.fields) {
      FormField f = Fields.newField(field.type);
      fields.add(f);
      f.createControls(container, field);
      f.addListener(this);
    }
    parent.layout();
  }

  @Override
  public void setFocus() {
  }

  @Override
  public boolean isDirty() {
    return dirty;
  }

  @Override
  public void doSave(IProgressMonitor monitor) {
    for (FormField f : fields) {
      f.save();
    }
    Services.get(IDatabaseService.class).save(form, input);
    dirty = false;
    firePropertyChange(IEditorPart.PROP_DIRTY);
  }

  @Override
  public boolean isSaveAsAllowed() {
    return false;
  }

  @Override
  public void doSaveAs() {
  }

  @Override
  public void onEvent(ValueChangedEvent event) {
    dirty = true;
    firePropertyChange(IEditorPart.PROP_DIRTY);
  }
}
