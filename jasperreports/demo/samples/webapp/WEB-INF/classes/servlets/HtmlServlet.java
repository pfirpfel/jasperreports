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
package servlets;

import datasource.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.*;
import net.sf.jasperreports.engine.export.*;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id$
 */
public class HtmlServlet extends HttpServlet
{


	/**
	 *
	 */
	public void service(
		HttpServletRequest request,
		HttpServletResponse response
		) throws IOException, ServletException
	{
		ServletContext context = this.getServletConfig().getServletContext();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try
		{
			File reportFile = new File(context.getRealPath("/reports/WebappReport.jasper"));
		
			JasperReport jasperReport = (JasperReport)JRLoader.loadObject(reportFile.getPath());
		
			Map parameters = new HashMap();
			parameters.put("ReportTitle", "Address Report");
			parameters.put("BaseDir", reportFile.getParentFile());
						
			JasperPrint jasperPrint = 
				JasperFillManager.fillReport(
					jasperReport, 
					parameters, 
					new WebappDataSource()
					);
						
			JRHtmlExporter exporter = new JRHtmlExporter();
		
			Map imagesMap = new HashMap();
			request.getSession().setAttribute("IMAGES_MAP", imagesMap);
			
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
			exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagesMap);
			exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "image?image=");
			
			exporter.exportReport();
		}
		catch (JRException e)
		{
			out.println("<html>");
			out.println("<head>");
			out.println("<title>JasperReports - Web Application Sample</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../stylesheet.css\" title=\"Style\">");
			out.println("</head>");
			
			out.println("<body bgcolor=\"white\">");

			out.println("<span class=\"bnew\">JasperReports encountered this error :</span>");
			out.println("<pre>");

			e.printStackTrace(out);

			out.println("</pre>");

			out.println("</body>");
			out.println("</html>");
		}
	}


}
