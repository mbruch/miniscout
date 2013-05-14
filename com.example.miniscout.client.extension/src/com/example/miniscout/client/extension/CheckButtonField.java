package com.example.miniscout.client.extension;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.example.miniscout.client.fields.FormField;
import com.example.miniscout.shared.Field;

public class CheckButtonField extends FormField {

  private Button check;
  private Label label;
  private Field field;

  @Override
  public void createControls(Composite parent, Field field) {
    this.field = field;
    label = new Label(parent, SWT.None);
    label.setText(field.name);
    check = new Button(parent, SWT.CHECK);
    check.setSelection(Boolean.parseBoolean(field.value));
    check.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        fireValueChangedEvent();
      }
    });
  }

  @Override
  public void save() {
    field.value = check.getText();
  }

}
