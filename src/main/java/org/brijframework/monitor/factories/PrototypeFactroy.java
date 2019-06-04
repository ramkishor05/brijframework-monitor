package org.brijframework.monitor.factories;

import java.util.concurrent.ConcurrentHashMap;

import org.brijframework.monitor.PrototypeScope;
import org.brijframework.monitor.threads.PrototypeThreadLocal;
import org.brijframework.util.reflect.InstanceUtil;

public class PrototypeFactroy{
	
	public int count;
	private static PrototypeFactroy factory;
	private PrototypeThreadLocal thread;
	private PrototypeScope service;
	private static ConcurrentHashMap<Object, PrototypeScope> container = new ConcurrentHashMap<>();

	public static PrototypeFactroy factory() {
		if (factory == null) {
			factory = InstanceUtil.getSingletonInstance(PrototypeFactroy.class);
		}
		return factory;
	}

	public PrototypeScope currentService() {
		if (this.thread == null) {
			registerService(new PrototypeScope());
		}
		return thread.get();
	}

	public PrototypeFactroy registerService(PrototypeScope service) {
		this.service = service;
		this.thread = new PrototypeThreadLocal();
		return factory;
	}

	public PrototypeScope getService() {
		return this.service;
	}

	public void setObject(Object key, PrototypeScope service) {
		container.put(key, service);
	}

}