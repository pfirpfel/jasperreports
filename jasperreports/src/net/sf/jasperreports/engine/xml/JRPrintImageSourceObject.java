/*
 * ============================================================================
 *                   GNU Lesser General Public License
 * ============================================================================
 *
 * JasperReports - Free Java report-generating library.
 * Copyright (C) 2001-2004 Teodor Danciu teodord@users.sourceforge.net
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * Teodor Danciu
 * 173, Calea Calarasilor, Bl. 42, Sc. 1, Ap. 18
 * Postal code 030615, Sector 3
 * Bucharest, ROMANIA
 * Email: teodord@users.sourceforge.net
 */
package net.sf.jasperreports.engine.xml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.w3c.tools.codec.Base64Decoder;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRImageRenderer;
import net.sf.jasperreports.engine.JRPrintImage;
import net.sf.jasperreports.engine.util.JRImageLoader;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id$
 */
public class JRPrintImageSourceObject
{


	/**
	 *
	 */
	private JRPrintImage printImage = null;

	/**
	 *
	 */
	private boolean isEmbedded = false;


	/**
	 *
	 */
	public void setPrintImage(JRPrintImage printImage)
	{
		this.printImage = printImage;
	}
	

	/**
	 *
	 */
	public void setEmbedded(boolean isEmbedded)
	{
		this.isEmbedded = isEmbedded;
	}
	

	/**
	 *
	 */
	public void setImageSource(String imageSource) throws JRException
	{
		if (this.isEmbedded)
		{
			try
			{
				ByteArrayInputStream bais = new ByteArrayInputStream(imageSource.getBytes("UTF-8"));//FIXME other encodings ?
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				
				Base64Decoder decoder = new Base64Decoder(bais, baos);
				decoder.process();
				
				this.printImage.setRenderer(JRImageRenderer.getInstance(baos.toByteArray()));
			}
			catch (Exception e)
			{
				throw new JRException("Error decoding embedded image.", e);
			}
		}
		else
		{
			printImage.setRenderer(
				JRImageRenderer.getInstance(
					JRImageLoader.loadImageDataFromLocation(imageSource)
					)
				);
		}
	}
	

}
