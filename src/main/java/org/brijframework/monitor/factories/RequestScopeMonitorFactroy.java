package org.brijframework.monitor.factories;

import java.util.concurrent.ConcurrentHashMap;

import org.brijframework.monitor.RequestScope;
import org.brijframework.monitor.threads.RequestThreadLocal;
import org.brijframework.util.reflect.InstanceUtil;

public class RequestScopeMonitorFactroy{
	
	public int count;
	private static RequestScopeMonitorFactroy factory;
	private RequestThreadLocal thread;
	private RequestScope service;
	private static ConcurrentHashMap<Object, RequestScope> container = new ConcurrentHashMap<>();

	public static RequestScopeMonitorFactroy factory() {
		if (factory == null) {
			factory = InstanceUtil.getSingletonInstance(RequestScopeMonitorFactroy.class);
		}
		return factory;
	}

	public RequestScope currentService() {
		if (this.thread == null) {
			registerService(new RequestScope());
		}
		return thread.get();
	}

	public RequestScopeMonitorFactroy registerService(RequestScope service) {
		this.service = service;
		this.thread = new RequestThreadLocal();
		return factory;
	}

	public RequestScope getService() {
		return this.service;
	}

	public void setObject(Object key, RequestScope service) {
		container.put(key, service);
	}

}