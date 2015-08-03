package com.gmail.utils.appenders;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.testng.Reporter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;


/**
 * Appender для передачи logs в отчет TestNg
 */
@Plugin(name = "TestNgReportAppender", category = "Core", elementType = "appender", printObject = true)
public class TestNgReportAppender extends AbstractAppender {

	protected TestNgReportAppender(String name, Filter filter, Layout<? extends Serializable> layout, final boolean ignoreExceptions) {
		super(name, filter, layout, ignoreExceptions);
	}

	@PluginFactory
	public static TestNgReportAppender createAppender(
			@PluginAttribute("name") String name,
			@PluginElement("Layout") Layout<? extends Serializable> layout,
			@PluginElement("Filter") final Filter filter) {

		if (name == null) {
			LOGGER.error("No name provided for TestNgReportAppender");
			return null;
		}
		if (layout == null) {
			layout = PatternLayout.createDefaultLayout();
		}

		return new TestNgReportAppender(name, filter, layout, true);

	}

	@Override
	public void append(LogEvent logEvent) {

		final byte[] logs = getLayout().toByteArray(logEvent);

		try {

			Reporter.log(new String(logs, "UTF-8"));

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		}

	}

}
