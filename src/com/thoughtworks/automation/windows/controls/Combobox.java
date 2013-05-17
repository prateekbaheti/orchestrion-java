package com.thoughtworks.automation.windows.controls;

import com.thoughtworks.automation.windows.RemoteServer;

/**
 * Represents a combobox.
 *
 */
public class Combobox extends Control {

	/**
	 * Creates a new combobox instance
	 * 
	 * @param refId		Ref id for this object
	 * @param windowId	Ref id of the window where this control belongs to
	 */
	public Combobox(int refId, int windowId) {
		super(refId, windowId);
	}
	
	/**
	 * Selects the specified text from the list  
	 * 
	 * @param textToSelect	Text to be selected
	 * @throws Exception
	 */
	public void selectText(String textToSelect) throws Exception {
		if (textToSelect == null) {
			throw new IllegalArgumentException(textToSelect);
		}
		
		RemoteServer.instance().execute("selecttext", getRefId(), textToSelect);
	}
	
	/**
	 * Checks whether this combobox can be edited
	 * 
	 * @return				true if combobox can be edited, false otherwise
	 * @throws Exception
	 */
	public boolean isEditable() throws Exception {
		String result = RemoteServer.instance().execute("iseditable", getRefId());
		return Boolean.parseBoolean(result);
	}
	
}