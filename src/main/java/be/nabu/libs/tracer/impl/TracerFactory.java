package be.nabu.libs.tracer.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import be.nabu.libs.tracer.api.TracerProvider;
import be.nabu.libs.tracer.api.TracerProviderFactory;
import be.nabu.libs.tracer.multi.TracerProviderImpl;

public class TracerFactory implements TracerProviderFactory {

	private List<TracerProvider> tracerProviders;
	
	private static TracerFactory instance;
	
	public static TracerFactory getInstance() {
		if (instance == null) {
			synchronized(TracerFactory.class) {
				if (instance == null) {
					instance = new TracerFactory();
				}
			}
		}
		return instance;
	}
	
	@Override
	public TracerProvider newTracerProvider() {
		return new TracerProviderImpl(getTracerProviders());
	}
	
	public List<TracerProvider> getTracerProviders() {
		if (tracerProviders == null) {
			synchronized(this) {
				if (tracerProviders == null) {
					List<TracerProvider> tracerProviders = new ArrayList<TracerProvider>();
					// use SPI to find them all
					ServiceLoader<TracerProvider> serviceLoader = ServiceLoader.load(TracerProvider.class);
					for (TracerProvider provider : serviceLoader) {
						tracerProviders.add(provider);
					}
					this.tracerProviders = tracerProviders;
				}
			}
		}
		return tracerProviders;
	}

}
