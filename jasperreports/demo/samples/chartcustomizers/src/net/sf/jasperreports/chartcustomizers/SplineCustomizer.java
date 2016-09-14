/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2016 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.chartcustomizers;

import java.util.Map;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;

import net.sf.jasperreports.engine.JRChart;
import net.sf.jasperreports.engine.JRChartCustomizer;

/**
 * This customizer plots a line chart as spline.
 * 
 * @author gtoffoli
 */
public class SplineCustomizer implements JRChartCustomizer, ConfigurableChartCustomizer {

    @SuppressWarnings("unused")
	private Map<String, String> configuration = null;
    
    @Override
    public void customize(JFreeChart jfc, JRChart jrc) {
        
            Plot plot = jfc.getPlot();
            
            if (plot instanceof XYPlot)
            {
                ((XYPlot)plot).setRenderer( new XYSplineRenderer());
            }
    }

    @Override
    public void setConfiguration(Map<String, String> properties) {
        this.configuration = properties;
    }
    
}