package org.brijframework.monitor.threads;

import org.brijframework.monitor.PrototypeScope;
import org.brijframework.monitor.factories.PrototypeScopeMonitorFactroy;

public class PrototypeThreadLocal extends ThreadLocal<PrototypeScope> {
	@Override
	protected PrototypeScope initialValue() {
		PrototypeScope service = PrototypeScopeMonitorFactroy.factory().getService();
		PrototypeScopeMonitorFactroy.factory().count++;
		PrototypeScopeMonitorFactroy.factory().setObject(service.getId(), service);
		return service;
	}
	
	@Override
	public PrototypeScope get() {
		return super.get();
	}
}