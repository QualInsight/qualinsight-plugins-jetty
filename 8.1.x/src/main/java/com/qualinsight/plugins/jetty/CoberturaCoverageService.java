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

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ShutdownHandler;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class CoberturaCoverageService extends ShutdownHandler {

    public CoberturaCoverageService(final Server server, final String shutdownToken) {
        super(server, shutdownToken);
    }

    private static final Logger LOGGER = Log.getLogger(CoberturaCoverageService.class);

    @Override
    protected void doStart() throws Exception {
        LOGGER.info("Starting Cobertura coverage collection service...");
    }

    @Override
    public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
        try {
            LOGGER.info("Saving Cobertura coverage data...");
            final String projectDataClassName = "net.sourceforge.cobertura.coveragedata.ProjectData";
            final String saveGlobalProjectDataMethodName = "saveGlobalProjectData";
            final Class<?> projectDataClass = Class.forName(projectDataClassName);
            final java.lang.reflect.Method saveGlobalProjectDataMethod = projectDataClass.getDeclaredMethod(saveGlobalProjectDataMethodName, new Class[0]);
            saveGlobalProjectDataMethod.invoke(null, new Object[0]);
            final String turnOffAutoSaveMethodName = "turnOffAutoSave";
            final java.lang.reflect.Method turnOffAutoSaveMethod = projectDataClass.getDeclaredMethod(turnOffAutoSaveMethodName, new Class[0]);
            turnOffAutoSaveMethod.invoke(null, new Object[0]);
            LOGGER.info("Stopped Cobertura coverage collection service...");
        } catch (final Exception e) {
            LOGGER.warn("Could not shutdown", e);
        }
        super.handle(target, baseRequest, request, response);
    }

}
