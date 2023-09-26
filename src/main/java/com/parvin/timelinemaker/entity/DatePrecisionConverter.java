package com.parvin.timelinemaker.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Converts between DatePrecision objects and their short-named String equivalents.
 * Based on {@link https://thorben-janssen.com/jpa-21-type-converter-better-way-to}.
 */
@Converter(autoApply = true)
public class DatePrecisionConverter implements AttributeConverter<DatePrecision, String> {
	@Override
	public String convertToDatabaseColumn(DatePrecision datePrecision) {
		return datePrecision.getShortName();
	}
	
	@Override
	public DatePrecision convertToEntityAttribute(String dbData) {
		return DatePrecision.fromShortName(dbData);
	}
}
