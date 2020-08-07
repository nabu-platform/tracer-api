package be.nabu.libs.tracer.api;

import java.net.URI;

public interface IncomingWebRequestTracer {
	/**
	 * 
	 * @param uri The incoming uri
	 * @return
	 */
	public IncomingWebRequestTrace start(URI uri);
}
