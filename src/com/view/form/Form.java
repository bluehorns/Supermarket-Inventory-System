package com.view.form;

import javax.swing.JPanel;

import com.model.DatabaseObject;
import com.service.DatabaseService;
import com.view.Submittable;

public abstract class Form implements Submittable {
	protected abstract void setUpForm();
	public abstract DatabaseObject readForm();
	public abstract void fillForm(DatabaseObject object);
	public abstract JPanel getPanel();
	public abstract DatabaseService getService();
	public abstract DatabaseObject getSubmitData();
}
