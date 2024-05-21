package com.bbva.rbvd.lib.r410.impl;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.rbvd.lib.r410.RBVDR410;
import com.bbva.rbvd.lib.r414.RBVDR414;

/**
 * This class automatically defines the libraries and utilities that it will use.
 */
public abstract class RBVDR410Abstract extends AbstractLibrary implements RBVDR410 {

	protected ApplicationConfigurationService applicationConfigurationService;

	protected RBVDR414 rbvdR414;


	/**
	* @param applicationConfigurationService the this.applicationConfigurationService to set
	*/
	public void setApplicationConfigurationService(ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}

	/**
	* @param rbvdR414 the this.rbvdR414 to set
	*/
	public void setRbvdR414(RBVDR414 rbvdR414) {
		this.rbvdR414 = rbvdR414;
	}

}