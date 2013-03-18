package hellbent.concepts;

import hellbent.entity.Entity;

public class TalkOption 
{
	private String identifier;
	private String stateId;
	private String responseText;
	private String queryText;
	private String stateGoTo;
	
	
	public TalkOption(String id, String sid, String queryText, String responseText,String stateGoTo)
	{
		setIdentifier(id);
		setStateId(sid);
		setResponseText(responseText);
		setQueryText(queryText);
		setStateGoTo(stateGoTo);
	}
	public boolean available(Entity talking, Entity talkedTo)
	{
		return true;
	}
	
	public String response(Entity e)
	{
		onTalk(e);
		return "";
	}

	public void onTalk(Entity e)
	{
		
	}
	
	

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	
	public boolean once()
	{
		return false;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}
	public String getStateGoTo() {
		return stateGoTo;
	}
	public void setStateGoTo(String stateGoTo) {
		this.stateGoTo = stateGoTo;
	}
}
