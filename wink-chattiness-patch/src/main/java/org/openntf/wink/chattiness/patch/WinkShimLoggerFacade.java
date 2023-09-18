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

import java.util.logging.Level;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

/**
 * This class acts a basic wrapper for an SLF4J {@link Logger} to its
 * JUL equivalent, albeit without processing {@link Marker} objects.
 */
class WinkShimLoggerFacade implements Logger {

	private final java.util.logging.Logger delegate;

	public WinkShimLoggerFacade(final java.util.logging.Logger delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public boolean isTraceEnabled() {
		return delegate.isLoggable(Level.FINE);
	}

	@Override
	public void trace(final String msg) {
		if(isTraceEnabled()) {
			delegate.fine(msg);
		}
	}

	@Override
	public void trace(final String msg, final Object paramObject) {
		if(isTraceEnabled()) {
			FormattingTuple tp = MessageFormatter.format(msg, paramObject);
			delegate.fine(tp.getMessage());
		}
	}

	@Override
	public void trace(final String msg, final Object paramObject1, final Object paramObject2) {
		if(isTraceEnabled()) {
			FormattingTuple tp = MessageFormatter.format(msg, paramObject1, paramObject2);
			delegate.fine(tp.getMessage());
		}
	}

	@Override
	public void trace(final String msg, final Object[] paramArrayOfObject) {
		if(isTraceEnabled()) {
			FormattingTuple tp = MessageFormatter.arrayFormat(msg, paramArrayOfObject);
			delegate.fine(tp.getMessage());
		}
	}

	@Override
	public void trace(final String msg, final Throwable paramThrowable) {
		if(isTraceEnabled()) {
			delegate.log(Level.FINE, msg, paramThrowable);
		}
	}

	@Override
	public boolean isTraceEnabled(final Marker marker) {
		return isTraceEnabled();
	}

	@Override
	public void trace(final Marker marker, final String msg) {
		if(isTraceEnabled()) {
			delegate.fine(msg);
		}
	}

	@Override
	public void trace(final Marker marker, final String msg, final Object paramObject) {
		trace(msg, paramObject);
	}

	@Override
	public void trace(final Marker marker, final String msg, final Object paramObject1, final Object paramObject2) {
		trace(msg, paramObject1, paramObject2);
	}

	@Override
	public void trace(final Marker marker, final String msg, final Object[] paramArrayOfObject) {
		trace(msg, paramArrayOfObject);
	}

	@Override
	public void trace(final Marker marker, final String msg, final Throwable paramThrowable) {
		trace(msg, paramThrowable);
	}

	@Override
	public boolean isDebugEnabled() {
		return delegate.isLoggable(Level.FINEST);
	}

	@Override
	public void debug(final String msg) {
		if(isDebugEnabled()) {
			delegate.finest(msg);
		}
	}

	@Override
	public void debug(final String msg, final Object paramObject) {
		if(isDebugEnabled()) {
			FormattingTuple tp = MessageFormatter.format(msg, paramObject);
			delegate.finest(tp.getMessage());
		}
	}

	@Override
	public void debug(final String msg, final Object paramObject1, final Object paramObject2) {
		if(isDebugEnabled()) {
			FormattingTuple tp = MessageFormatter.format(msg, paramObject1, paramObject2);
			delegate.finest(tp.getMessage());
		}
	}

	@Override
	public void debug(final String msg, final Object[] paramArrayOfObject) {
		if(isDebugEnabled()) {
			FormattingTuple tp = MessageFormatter.arrayFormat(msg, paramArrayOfObject);
			delegate.finest(tp.getMessage());
		}
	}

	@Override
	public void debug(final String msg, final Throwable paramThrowable) {
		if(isDebugEnabled()) {
			delegate.log(Level.FINEST, msg, paramThrowable);
		}
	}

	@Override
	public boolean isDebugEnabled(final Marker marker) {
		return isDebugEnabled();
	}

	@Override
	public void debug(final Marker marker, final String msg) {
		debug(msg);
	}

	@Override
	public void debug(final Marker marker, final String msg, final Object paramObject) {
		debug(msg, paramObject);
	}

	@Override
	public void debug(final Marker marker, final String msg, final Object paramObject1, final Object paramObject2) {
		debug(msg, paramObject1, paramObject2);
	}

	@Override
	public void debug(final Marker marker, final String msg, final Object[] paramArrayOfObject) {
		debug(msg, paramArrayOfObject);
	}

	@Override
	public void debug(final Marker marker, final String msg, final Throwable paramThrowable) {
		debug(msg, paramThrowable);
	}

	@Override
	public boolean isInfoEnabled() {
		return delegate.isLoggable(Level.INFO);
	}

	@Override
	public void info(final String msg) {
		if(isInfoEnabled()) {
			delegate.info(msg);
		}
	}

	@Override
	public void info(final String msg, final Object paramObject) {
		if(isInfoEnabled()) {
			FormattingTuple tp = MessageFormatter.format(msg, paramObject);
			delegate.info(tp.getMessage());
		}
	}

	@Override
	public void info(final String msg, final Object paramObject1, final Object paramObject2) {
		if(isInfoEnabled()) {
			FormattingTuple tp = MessageFormatter.format(msg, paramObject1, paramObject2);
			delegate.info(tp.getMessage());
		}
	}

	@Override
	public void info(final String msg, final Object[] paramArrayOfObject) {
		if(isInfoEnabled()) {
			FormattingTuple tp = MessageFormatter.arrayFormat(msg, paramArrayOfObject);
			delegate.info(tp.getMessage());
		}
	}

	@Override
	public void info(final String msg, final Throwable paramThrowable) {
		if(isInfoEnabled()) {
			delegate.log(Level.INFO, msg, paramThrowable);
		}
	}

	@Override
	public boolean isInfoEnabled(final Marker marker) {
		return isInfoEnabled();
	}

	@Override
	public void info(final Marker marker, final String msg) {
		info(msg);
	}

	@Override
	public void info(final Marker marker, final String msg, final Object paramObject) {
		info(msg, paramObject);
	}

	@Override
	public void info(final Marker marker, final String msg, final Object paramObject1, final Object paramObject2) {
		info(msg, paramObject1, paramObject2);
	}

	@Override
	public void info(final Marker marker, final String msg, final Object[] paramArrayOfObject) {
		info(msg, paramArrayOfObject);
	}

	@Override
	public void info(final Marker marker, final String msg, final Throwable paramThrowable) {
		info(msg, paramThrowable);
	}

	@Override
	public boolean isWarnEnabled() {
		return delegate.isLoggable(Level.WARNING);
	}

	@Override
	public void warn(final String msg) {
		if(isWarnEnabled()) {
			delegate.warning(msg);
		}
	}

	@Override
	public void warn(final String msg, final Object paramObject) {
		if(isWarnEnabled()) {
			FormattingTuple tp = MessageFormatter.format(msg, paramObject);
			delegate.warning(tp.getMessage());
		}
	}

	@Override
	public void warn(final String msg, final Object[] paramArrayOfObject) {
		if(isWarnEnabled()) {
			FormattingTuple tp = MessageFormatter.arrayFormat(msg, paramArrayOfObject);
			delegate.warning(tp.getMessage());
		}
	}

	@Override
	public void warn(final String msg, final Object paramObject1, final Object paramObject2) {
		if(isWarnEnabled()) {
			FormattingTuple tp = MessageFormatter.format(msg, paramObject1, paramObject2);
			delegate.warning(tp.getMessage());
		}
	}

	@Override
	public void warn(final String msg, final Throwable paramThrowable) {
		if(isWarnEnabled()) {
			delegate.log(Level.WARNING, msg, paramThrowable);
		}
	}

	@Override
	public boolean isWarnEnabled(final Marker marker) {
		return isWarnEnabled();
	}

	@Override
	public void warn(final Marker marker, final String msg) {
		warn(msg);
	}

	@Override
	public void warn(final Marker marker, final String msg, final Object paramObject) {
		warn(msg, paramObject);
	}

	@Override
	public void warn(final Marker marker, final String msg, final Object paramObject1, final Object paramObject2) {
		warn(msg, paramObject1, paramObject2);
	}

	@Override
	public void warn(final Marker marker, final String msg, final Object[] paramArrayOfObject) {
		warn(msg, paramArrayOfObject);
	}

	@Override
	public void warn(final Marker marker, final String msg, final Throwable paramThrowable) {
		warn(msg, paramThrowable);
	}

	@Override
	public boolean isErrorEnabled() {
		return delegate.isLoggable(Level.SEVERE);
	}

	@Override
	public void error(final String msg) {
		if(isErrorEnabled()) {
			delegate.severe(msg);
		}
	}

	@Override
	public void error(final String msg, final Object paramObject) {
		if(isErrorEnabled()) {
			FormattingTuple tp = MessageFormatter.format(msg, paramObject);
			delegate.severe(tp.getMessage());
		}
	}

	@Override
	public void error(final String msg, final Object paramObject1, final Object paramObject2) {
		if(isErrorEnabled()) {
			FormattingTuple tp = MessageFormatter.format(msg, paramObject1, paramObject2);
			delegate.severe(tp.getMessage());
		}
	}

	@Override
	public void error(final String msg, final Object[] paramArrayOfObject) {
		if(isErrorEnabled()) {
			FormattingTuple tp = MessageFormatter.arrayFormat(msg, paramArrayOfObject);
			delegate.severe(tp.getMessage());
		}
	}

	@Override
	public void error(final String msg, final Throwable paramThrowable) {
		if(isErrorEnabled()) {
			delegate.log(Level.SEVERE, msg, paramThrowable);
		}
	}

	@Override
	public boolean isErrorEnabled(final Marker marker) {
		return isErrorEnabled();
	}

	@Override
	public void error(final Marker marker, final String msg) {
		error(msg);
	}

	@Override
	public void error(final Marker marker, final String msg, final Object paramObject) {
		error(msg, paramObject);
	}

	@Override
	public void error(final Marker marker, final String msg, final Object paramObject1, final Object paramObject2) {
		error(msg, paramObject1, paramObject2);
	}

	@Override
	public void error(final Marker marker, final String msg, final Object[] paramArrayOfObject) {
		error(msg, paramArrayOfObject);
	}

	@Override
	public void error(final Marker marker, final String msg, final Throwable paramThrowable) {
		error(msg, paramThrowable);
	}

}
