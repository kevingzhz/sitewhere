/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.common.request;

import com.sitewhere.spi.common.IColorProvider;
import com.sitewhere.spi.common.IIconProvider;
import com.sitewhere.spi.common.IImageProvider;

/**
 * Contains base fields for creating an entity with branding information.
 * 
 * @author Derek
 */
public interface IBrandedEntityCreateRequest
	extends IPersistentEntityCreateRequest, IColorProvider, IIconProvider, IImageProvider {
}