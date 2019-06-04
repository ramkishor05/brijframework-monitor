package org.brijframework.monitor.threads;

import org.brijframework.monitor.PrototypeScope;
import org.brijframework.monitor.factories.PrototypeFactroy;

public class PrototypeThreadLocal extends ThreadLocal<PrototypeScope> {
	@Override
	protected PrototypeScope initialValue() {
		PrototypeScope service = PrototypeFactroy.factory().getService();
		PrototypeFactroy.factory().count++;
		PrototypeFactroy.factory().setObject(service.getId(), service);
		return service;
	}
	
	@Override
	public PrototypeScope get() {
		return super.get();
	}
}