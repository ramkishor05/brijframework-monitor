package org.brijframework.monitor.factories;

import org.brijframework.factories.impl.AbstractFactory;
import org.brijframework.monitor.PrototypeScope;
import org.brijframework.monitor.threads.PrototypeThreadLocal;
import org.brijframework.util.reflect.InstanceUtil;

public class PrototypeScopeMonitorFactroy extends AbstractFactory<String, PrototypeScope>{
	
	public int count;
	private static PrototypeScopeMonitorFactroy factory;
	private PrototypeThreadLocal thread;
	private PrototypeScope service;

	public static PrototypeScopeMonitorFactroy factory() {
		if (factory == null) {
			factory = InstanceUtil.getSingletonInstance(PrototypeScopeMonitorFactroy.class);
		}
		return factory;
	}

	public PrototypeScope currentService() {
		if (this.thread == null) {
			registerService(new PrototypeScope());
		}
		return thread.get();
	}

	public PrototypeScopeMonitorFactroy registerService(PrototypeScope service) {
		this.service = service;
		this.thread = new PrototypeThreadLocal();
		return factory;
	}

	public PrototypeScope getService() {
		return this.service;
	}

	@Override
	public PrototypeScopeMonitorFactroy loadFactory() {
		return null;
	}

	@Override
	protected void preregister(String key, PrototypeScope value) {
	}

	@Override
	protected void postregister(String key, PrototypeScope value) {
	}

	@Override
	protected void loadContainer(String key, PrototypeScope value) {
		
	}

}