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
package net.sf.jasperreports.engine;

/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id$
 */
public interface JRAlignment 
{


	/**
	 *
	 */
	public static final byte HORIZONTAL_ALIGN_LEFT = 1;
	public static final byte HORIZONTAL_ALIGN_CENTER = 2;
	public static final byte HORIZONTAL_ALIGN_RIGHT = 3;
	public static final byte HORIZONTAL_ALIGN_JUSTIFIED = 4;

	/**
	 *
	 */
	public static final byte VERTICAL_ALIGN_TOP = 1;
	public static final byte VERTICAL_ALIGN_MIDDLE = 2;
	public static final byte VERTICAL_ALIGN_BOTTOM = 3;


}
