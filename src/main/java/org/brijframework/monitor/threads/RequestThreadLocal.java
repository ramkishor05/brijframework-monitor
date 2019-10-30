package org.brijframework.monitor.threads;

import org.brijframework.monitor.RequestScope;
import org.brijframework.monitor.factories.RequestScopeMonitorFactroy;

public class RequestThreadLocal extends ThreadLocal<RequestScope> {
	@Override
	protected RequestScope initialValue() {
		RequestScope service = RequestScopeMonitorFactroy.factory().getService();
		RequestScopeMonitorFactroy.factory().count++;
		RequestScopeMonitorFactroy.factory().register(service.getId(), service);
		return service;
	}
	
	@Override
	public RequestScope get() {
		return super.get();
	}
}