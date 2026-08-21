package com.view;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class UserInterfaceIcons {
	
	public static Icon backIcon() {
		ImageIcon backIcon =  new ImageIcon();
		try {
			Image icon = ImageIO.read(UserInterfaceIcons.class.getResource("/images/arrow_back.png"));
			backIcon = new ImageIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return backIcon;
	}
	
	public static Icon backIconBlack() {
		ImageIcon icon = new ImageIcon();
		try {
			icon = new ImageIcon(ImageIO.read(UserInterfaceIcons.class.getResource("/images/arrow_back_black.png")));
		} catch(IOException e) {
			e.printStackTrace();
		}
		return icon;
	}
}
