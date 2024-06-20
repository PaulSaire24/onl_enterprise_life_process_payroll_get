package com.bbva.rbvd.lib.r410.impl;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.pisd.lib.r404.PISDR404;
import com.bbva.rbvd.lib.r410.RBVDR410;

/**
 * This class automatically defines the libraries and utilities that it will use.
 */
public abstract class RBVDR410Abstract extends AbstractLibrary implements RBVDR410 {

	protected ApplicationConfigurationService applicationConfigurationService;

	protected PISDR404 pisdR404;


	/**
	* @param applicationConfigurationService the this.applicationConfigurationService to set
	*/
	public void setApplicationConfigurationService(ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}

	/**
	* @param pisdR404 the this.pisdR404 to set
	*/
	public void setPisdR404(PISDR404 pisdR404) {
		this.pisdR404 = pisdR404;
	}

}