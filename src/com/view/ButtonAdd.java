package com.view;

import javax.swing.JButton;

import com.model.DatabaseObject;
import com.model.Employee;
import com.service.DatabaseService;
import com.service.ReadForm;

public class ButtonAdd extends ButtonSubmitAbstract  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6708004129436995444L;
	public ButtonAdd() {
		this.setText("Add");
	}
	
	
	@Override
	public <T> ButtonSubmitAbstract buttonEvent(DatabaseService<T> service, Submittable submitData) {
		this.addActionListener(_->{
			service.addRecord(submitData.getSubmitData());
		});
		return this;
	}
	
}
