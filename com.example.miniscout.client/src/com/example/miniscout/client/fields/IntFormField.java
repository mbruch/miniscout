package com.example.miniscout.client.fields;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

import com.example.miniscout.shared.Field;

public class IntFormField extends FormField {

  private Spinner spinner;
  private Label label;
  private Field field;

  @Override
  public void createControls(Composite parent, Field field) {
    this.field = field;
    label = new Label(parent, SWT.None);
    label.setText(field.name);
    spinner = new Spinner(parent, SWT.BORDER);
    spinner.setValues(Integer.parseInt(field.value), 0, 150, 0, 1, 1);
    spinner.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        fireValueChangedEvent();
      }
    });
  }

  @Override
  public void save() {
    field.value = spinner.getText();
  }

}
