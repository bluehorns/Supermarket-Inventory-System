package com.view;


import javax.swing.JButton;

import com.model.DatabaseObject;
import com.service.DatabaseService;
import com.service.ReadForm;

public abstract class ButtonSubmitAbstract extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1673388550894511700L;

	public abstract <T> ButtonSubmitAbstract buttonEvent(DatabaseService<T> service, Submittable data);
}
