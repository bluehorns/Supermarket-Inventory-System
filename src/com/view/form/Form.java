package com.view.form;

import com.model.DatabaseObject;

public abstract class Form {
	
	
	protected abstract void setUpForm();
	public abstract DatabaseObject readForm();
	public abstract void fillForm(DatabaseObject object);
	
}
