package com.example.miniscout.client.fields;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.example.miniscout.shared.Field;

public class StringFormField extends FormField {

  private Text text;
  private Label label;
  private Field field;

  @Override
  public void createControls(Composite parent, Field field) {
    this.field = field;
    label = new Label(parent, SWT.None);
    label.setText(field.name);
    text = new Text(parent, SWT.BORDER);
    text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    text.setText(field.value);
    text.addModifyListener(new ModifyListener() {

      @Override
      public void modifyText(ModifyEvent e) {
        fireValueChangedEvent();
      }
    });
  }

  @Override
  public void save() {
    field.value = text.getText();
  }

}
