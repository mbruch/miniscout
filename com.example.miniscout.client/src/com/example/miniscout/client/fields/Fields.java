package com.example.miniscout.client.fields;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.google.common.base.Throwables;

public class Fields {

  private static Map<String /* type */, IConfigurationElement> fields = new HashMap<String, IConfigurationElement>();

  private static Map<String, IConfigurationElement> getFields() {
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IConfigurationElement[] elements = registry
        .getConfigurationElementsFor("com.example.miniscout.client.fields");
    for (IConfigurationElement e : elements) {
      fields.put(e.getAttribute("type"), e);
    }
    return fields;
  }

  public static FormField newField(String type) {
    try {
      Map<String, IConfigurationElement> f = getFields();
      IConfigurationElement e = f.get(type);
      return (FormField) e.createExecutableExtension("class");
    } catch (CoreException e) {
      throw Throwables.propagate(e);
    }
  }
}
