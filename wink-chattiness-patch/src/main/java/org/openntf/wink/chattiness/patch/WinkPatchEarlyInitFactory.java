/**
 * Copyright (c) 2023 Jesse Gallagher
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openntf.wink.chattiness.patch;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.MessageFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slf4j.ILoggerFactory;
import org.slf4j.impl.SimpleLoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

import com.ibm.designer.runtime.domino.adapter.HttpService;
import com.ibm.designer.runtime.domino.adapter.IServiceFactory;
import com.ibm.designer.runtime.domino.adapter.LCDEnvironment;

public class WinkPatchEarlyInitFactory implements IServiceFactory {
	private static final Logger log = Logger.getLogger(WinkPatchEarlyInitFactory.class.getPackage().getName());

	@Override
	public HttpService[] getServices(LCDEnvironment env) {
		if(log.isLoggable(Level.FINEST)) {
			log.finest(MessageFormat.format("{0}: Going patch Wink loggers", getClass().getName())); //$NON-NLS-1$
		}

		AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
			try {
				String[] classes = new String[] {
					"org.apache.wink.server.internal.log.Providers", //$NON-NLS-1$
					"org.apache.wink.server.internal.log.Requests", //$NON-NLS-1$
					"org.apache.wink.server.internal.log.ResourceInvocation", //$NON-NLS-1$
					"org.apache.wink.server.internal.log.Resources", //$NON-NLS-1$
					"org.apache.wink.server.internal.log.Responses", //$NON-NLS-1$

					"org.apache.wink.server.internal.application.ApplicationProcessor", //$NON-NLS-1$
					"org.apache.wink.server.internal.servlet.RestServlet", //$NON-NLS-1$
					"org.apache.wink.server.internal.servlet.RestFilter" //$NON-NLS-1$
				};

				ILoggerFactory factory = StaticLoggerBinder.getSingleton().getLoggerFactory();
				if(factory instanceof SimpleLoggerFactory) {
					Field loggerMapField = factory.getClass().getDeclaredField("loggerMap"); //$NON-NLS-1$
					loggerMapField.setAccessible(true);
					@SuppressWarnings("unchecked")
					Map<String, org.slf4j.Logger> loggerMap = (Map<String, org.slf4j.Logger>)loggerMapField.get(factory);
					
					// Read the Map "loggerMap" property and fill in loggers for the above names
					for(String className : classes) {
						org.slf4j.Logger log = new WinkShimLoggerFacade(Logger.getLogger(className));
						loggerMap.put(className, log);
					}
				}

			} catch(Throwable t) {
				if(log.isLoggable(Level.SEVERE)) {
					log.log(Level.SEVERE, MessageFormat.format("{0}: Exception while patching Wink loggers", getClass().getName()), t); //$NON-NLS-1$
				}
			}

			return null;
		});
		
		return new HttpService[0];
	}

}
