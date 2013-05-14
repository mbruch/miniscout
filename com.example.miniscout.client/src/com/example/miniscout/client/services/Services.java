package com.example.miniscout.client.services;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class Services {
	public static <T> T get(Class<T> clazz) {
		Bundle bundle = FrameworkUtil.getBundle(Services.class);
		BundleContext context = bundle.getBundleContext();
		ServiceReference<T> ref = context.getServiceReference(clazz);
		T service = context.getService(ref);
		context.ungetService(ref);
		return service;
	}
}
