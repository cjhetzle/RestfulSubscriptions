/**
 * 
 */
package com.cameronhetzler.data.model;

import java.util.UUID;

/**
 * @author chagu
 *
 */
public class Service {
	private String hexChars = "0123456789abcdef";
	private UUID id;
	private String name;
	private double price;
	private String iconUrl;
	private String color;

	/**
	 * @param id id of the service 
	 * @param name name of the service
	 * @param price price of the service per month
	 * @param iconUrl location of the icon for the service
	 * @param color primary color of the service
	 */
	public Service(UUID id, String name, double price, String iconUrl, String color) {
		setId(id);
		setName(name);
		setPrice(price);
		setIconUrl(iconUrl);
		setColor(color);
	}

	public Service(String id, String name, double price, String iconUrl, String color) {
		setId(id);
		setName(name);
		setPrice(price);
		setIconUrl(iconUrl);
		setColor(color);
	}

	public Service() {
		this(UUID.randomUUID(), "", 0.00, "", "000000");
	}

	/**
	 * color format rrggbb
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * color format rrggbb
	 * @param color the color to set
	 */
	public void setColor(String color) {
		if (color == null) {
			throw new IllegalArgumentException("color cannot be null");
		}
		color = color.toLowerCase();
		if (color.length() != 6) {
			throw new IllegalArgumentException("string format is invalid");
		}
		for (int i = 0; i < color.length(); i++) {
			boolean found = false;
			for (int j  = 0; j < hexChars.length(); j++) {
				if (hexChars.charAt(j) == color.charAt(i)) {
					found = true;
					break;
				}
			}
			if (!found) {
				throw new IllegalArgumentException("string format is invalid");
			}
		}
		this.color = color;
	}

	/**
	 * example https://www.google.com/favicon.ico
	 * @return the icon url
	 */
	public String getIconUrl() {
		return iconUrl;
	}

	/**
	 * example https://www.google.com/favicon.ico
	 * @param iconUrl the icon url to set
	 */
	public void setIconUrl(String iconUrl) {
		if (iconUrl == null) {
			throw new IllegalArgumentException("id cannot be null");
		}
		this.iconUrl = iconUrl;
	}

	/**
	 * in dollars
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * in dollars
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("id cannot be null");
		}
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		if (id == null) {
			throw new IllegalArgumentException("id cannot be null");
		}
		this.id = id;
	}

	public void setId(String id) {
		if (id == null) {
			throw new IllegalArgumentException("id cannot be null");
		}
		try {
			this.setId(UUID.fromString(id));
		}
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("provided string is not a valid uuid");
		}
	}
}
