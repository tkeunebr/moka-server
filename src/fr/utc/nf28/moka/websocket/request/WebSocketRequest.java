package fr.utc.nf28.moka.websocket.request;

abstract public class WebSocketRequest {
	public String type;
	public Object content ;

	public WebSocketRequest(String type){
		this.type = type;
	}
}
