package com.infytel.util;


/**
 * The Enum ExceptionConstants.
 */

public enum InfyTelConstants {

	//Exception message constants
		
		PLAN_NOT_FOUND("Plan.not.found"), 
		GENERAL_EXCEPTION_MESSAGE("general.exception");
	
		
		

		private final String type;

		private InfyTelConstants(String type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return this.type;
		}
}
