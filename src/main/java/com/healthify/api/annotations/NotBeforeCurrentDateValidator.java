package com.healthify.api.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.sql.Date;
import java.time.LocalDate;

/**
 * @author RAM
 *
 */
public class NotBeforeCurrentDateValidator implements ConstraintValidator<NotBeforeCurrentDate, Date> {

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {
        // Check if the date is not before the current date
    	LocalDate currentDate = LocalDate.now();
    	return date == null || !date.toLocalDate().isBefore(currentDate);
    }
}

