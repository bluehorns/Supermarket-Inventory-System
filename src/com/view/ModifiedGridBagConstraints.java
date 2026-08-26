package com.view;

import java.awt.GridBagConstraints;

public class ModifiedGridBagConstraints extends GridBagConstraints {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7381414670007356328L;
	
	public ModifiedGridBagConstraints() {
		
		
	}
	
	public ModifiedGridBagConstraints setGrid(int x, int y) {
		this.gridx = x;
		this.gridy = y;
		return this;
	}
	
	public ModifiedGridBagConstraints setWeightX(double x) {
		this.weightx = x;
		return this;
	}
	
	public ModifiedGridBagConstraints setWeightY(double y) {
		this.weighty = y;
		return this;
	}
	
	public ModifiedGridBagConstraints setFill() {
		this.fill = BOTH;
		return this;
	}
	
	
}
