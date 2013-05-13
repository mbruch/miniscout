package com.example.miniscout.client.fields;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.swt.widgets.Composite;

import com.example.miniscout.shared.Field;

public abstract class FormField {

  public class ValueChangedEvent {

    public FormField field;

    protected ValueChangedEvent(FormField field) {
      this.field = field;
    }

  }

  public static interface Listener<T> {
    void onEvent(T event);
  }

  private Set<Listener<ValueChangedEvent>> listeners = new HashSet<Listener<ValueChangedEvent>>();

  public abstract void createControls(Composite parent, Field field);

  public abstract void save();

  public void addListener(Listener<ValueChangedEvent> listener) {
    listeners.add(listener);
  }

  public void removeListener(Listener<ValueChangedEvent> listener) {
    listeners.remove(listener);
  }

  public void dispose() {
    listeners.clear();
  }

  public void fireValueChangedEvent() {
    for (Listener<ValueChangedEvent> l : listeners) {
      l.onEvent(new ValueChangedEvent(this));
    }
  }

}