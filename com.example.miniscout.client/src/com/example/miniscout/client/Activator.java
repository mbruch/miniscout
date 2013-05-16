package com.example.miniscout.client;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import com.example.miniscout.client.services.LocalDatabaseService;
import com.example.miniscout.client.services.ProxyDatabaseService;
import com.example.miniscout.shared.IDatabaseService;

public class Activator extends AbstractUIPlugin {

  private static Activator plugin;

  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
    context.registerService(IDatabaseService.class, new LocalDatabaseService(),
        null);

    // Register a proxy service with a higher priority:
    Dictionary<String, Object> props = new Hashtable<>();
    props.put(Constants.SERVICE_RANKING, 1000);
    context.registerService(IDatabaseService.class, new ProxyDatabaseService(),
        props);

  }

  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  public static Activator getDefault() {
    return plugin;
  }

}
