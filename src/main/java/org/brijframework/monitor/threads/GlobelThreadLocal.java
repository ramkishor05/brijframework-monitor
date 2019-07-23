package org.brijframework.monitor.threads;

import org.brijframework.monitor.GlobelScope;
import org.brijframework.monitor.factories.GlobelScopeMonitorFactroy;

public class GlobelThreadLocal extends ThreadLocal<GlobelScope> {
	@Override
	protected GlobelScope initialValue() {
		GlobelScope service = GlobelScopeMonitorFactroy.factory().getService();
		GlobelScopeMonitorFactroy.factory().count++;
		GlobelScopeMonitorFactroy.factory().register(service.getId(), service);
		return service;
	}
	
	@Override
	public GlobelScope get() {
		return super.get();
	}
}