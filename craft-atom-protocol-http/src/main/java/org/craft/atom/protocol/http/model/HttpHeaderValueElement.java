package org.craft.atom.protocol.http.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * One element of an HTTP {@link HttpHeader header} value consisting of a name /
 * value pair and a number of optional name / value parameters.
 * <p>
 * Some HTTP headers (such as the set-cookie header) have values that can be
 * decomposed into multiple elements. Such headers must be in the following
 * form:
 * </p>
 * 
 * <pre>
 * header  = [ element ] *( "," [ element ] )
 * element = name [ "=" [ value ] ] *( ";" [ param ] )
 * param   = name [ "=" [ value ] ]
 * 
 * name    = token
 * value   = ( token | quoted-string )
 * 
 * token         = 1*&lt;any char except "=", ",", ";", &lt;"&gt; and white space&gt;
 * quoted-string = &lt;"&gt; *( text | quoted-char ) &lt;"&gt;
 * text          = any char except &lt;"&gt;
 * quoted-char   = "\" char
 * </pre>
 * <p>
 * Any amount of white space is allowed between any part of the header, element
 * or param and is ignored. A missing value in any element or param will be
 * stored as the empty {@link String}; if the "=" is also missing
 * <var>null</var> will be stored instead.
 * 
 * @author mindwind
 * @version 1.0, Feb 1, 2013
 * @see HttpHeader
 */
public class HttpHeaderValueElement implements Serializable {

	private static final long serialVersionUID = -5552007949156024715L;

	private String name;
	private String value;
	private Map<String, String> params = new LinkedHashMap<String, String>();

	public HttpHeaderValueElement() {
		super();
	}

	public HttpHeaderValueElement(String name, String value, Map<String, String> params) {
		this.name = name;
		this.value = value;
		this.params = params;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return String.format("HttpHeaderValueElement [name=%s, value=%s, params=%s]", name, value, params);
	}

}
