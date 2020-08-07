package be.nabu.libs.tracer.api;

public interface IncomingWebRequestTrace extends Trace {
	/**
	 * 
	 * @param type This could be PREPROCESS or POSTPROCESS or REST or RESOURCE (static) or...
	 */
	public void setHandlerType(String type);
	public void setResponseCode(int code);
}
