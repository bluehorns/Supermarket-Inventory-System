package com.view;

import java.awt.GridBagConstraints;

public class GBC extends GridBagConstraints {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7381414670007356328L;
	
	public GBC() {
		
		
	}
	
	public GBC setGrid(int x, int y) {
		this.gridx = x;
		this.gridy = y;
		return this;
	}
	
	public GBC setWeightX(double x) {
		this.weightx = x;
		return this;
	}
	
	public GBC setWeightY(double y) {
		this.weighty = y;
		return this;
	}
	
	public GBC setFill(int orientation) {
		this.fill = orientation;
		return this;
	}
	
	
}
