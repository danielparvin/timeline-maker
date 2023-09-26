package com.parvin.timelinemaker.entity;

public enum DatePrecision {
	YEAR("Y"), MONTH("M"), DAY("D");

	private String shortName;

	private DatePrecision(String shortName) {
		this.shortName = shortName;
	}

	public String getShortName() {
		return shortName;
	}

	public static DatePrecision fromShortName(String shortName) {
		switch (shortName) {
			case "Y": return DatePrecision.YEAR;
			case "M": return DatePrecision.MONTH;
			case "D": return DatePrecision.DAY;
			default: return DatePrecision.DAY;
		}
	}
}
