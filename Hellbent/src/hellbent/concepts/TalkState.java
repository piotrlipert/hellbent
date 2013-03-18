package hellbent.concepts;

import java.util.Vector;

public class TalkState 
{
	
	private String stateId;
	
	public Vector<TalkOption> options = new Vector<TalkOption>();
	private String initText;
	private String response;
	
	
	public void addOption(TalkOption a)
	{
		options.add(a);
	}

	public void removeOption(TalkOption a)
	{
		options.remove(a);
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getInitText() {
		return initText;
	}

	public void setInitText(String initText) {
		this.initText = initText;
		this.response = initText;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
}
