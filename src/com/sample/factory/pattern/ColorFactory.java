package com.sample.factory.pattern;

public class ColorFactory {
	public Color getColor(String color) {
		if (color.equals("RED"))
			return new RedColor();
		else if (color.equals("BLUE"))
			return new BlueColor();
		else
			return null;
	}
}
