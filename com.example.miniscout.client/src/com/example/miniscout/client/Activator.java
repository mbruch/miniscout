package com.example.miniscout.client;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.example.miniscout.client.services.LocalDatabaseService;
import com.example.miniscout.shared.IDatabaseService;

public class Activator extends AbstractUIPlugin {

  private static Activator plugin;

  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
    context.registerService(IDatabaseService.class, new LocalDatabaseService(),
        null);
  }

  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  public static Activator getDefault() {
    return plugin;
  }

}
