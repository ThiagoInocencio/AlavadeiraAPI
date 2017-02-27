package br.com.alavadeiraapi.util;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {
	//private HashMap<String, Object> message;

	public Response() {
	}

	public static Response Ok(String string) {
		Response r = new Response();
		//r.setStatus("OK");
		//r.setMsg(string);
		return r;
	}

	public static Response Error(String string) {
		Response r = new Response();
		//r.setStatus("ERROR");
		//r.setMsg(string);
		return r;
	}
	
}
