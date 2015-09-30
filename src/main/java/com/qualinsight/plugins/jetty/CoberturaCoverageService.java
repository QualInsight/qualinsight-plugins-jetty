/*
 * qualinsight-plugins-jetty
 * Copyright (c) 2015, QualInsight
 * http://www.qualinsight.com/
 *
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, you can retrieve a copy
 * from <http://www.gnu.org/licenses/>.
 */
package com.qualinsight.plugins.jetty;

import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject(value = "Jetty HTTP Servlet server (tweaked for Cobertura)")
public class CoberturaCoverageService extends AbstractLifeCycle {

    private static final Logger LOGGER = Log.getLogger(CoberturaCoverageService.class);

    @Override
    protected void doStart() throws Exception {
        LOGGER.info("Started Cobertura coverage collection service...");
    }

    @Override
    protected void doStop() throws Exception {
        LOGGER.info("Saving Cobertura coverage data...");
        final String className = "net.sourceforge.cobertura.coveragedata.ProjectData";
        final String methodName = "saveGlobalProjectData";
        final Class<?> saveClass = Class.forName(className);
        final java.lang.reflect.Method saveMethod = saveClass.getDeclaredMethod(methodName, new Class[0]);
        saveMethod.invoke(null, new Object[0]);
        LOGGER.info("Stopped Cobertura coverage collection service...");
    }

}
