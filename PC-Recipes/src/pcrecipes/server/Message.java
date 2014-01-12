package pcrecipes.server;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Message {
	@Persistent
	public String _name;
	@Persistent
	public String _mail;
	@Persistent
	public String _subject;
	@Persistent
	public String _text;
	public Message(String _name, String _mail, String _subject, String _text) {
		this._name = _name;
		this._mail = _mail;
		this._subject = _subject;
		this._text = _text;
	}
	
	
}
