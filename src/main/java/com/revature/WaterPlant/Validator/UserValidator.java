package com.revature.WaterPlant.Validator;

import com.revature.WaterPlant.exception.ValidatorException;


public class UserValidator {

	public static void validateMobileNo(Long mno) throws ValidatorException {

		String num = String.valueOf(mno);

		if (num.length() != 10)

			throw new ValidatorException("Invalid Mobile Number");

	}

}
