package com.view;


import javax.swing.JButton;

import com.service.DatabaseService;

public abstract class ButtonSubmitAbstract extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1673388550894511700L;

	public abstract  ButtonSubmitAbstract buttonEvent(DatabaseService service, Submittable data);
}
