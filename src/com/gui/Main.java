package com.gui;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.framework.swing.ui.SwingConfig;

public class Main {
	private static final Logger LOG = Logger.getLogger(Main.class);

	public Main() {

	}

	public static void main(String[] args) {
		try {
			new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","applicationContext-gui.xml"});
//			ApplicationManager.getInstance().setRuleFile("rules.xml");
//			ApplicationManager.getInstance().setConfigFile("autoinsure_config.xml");
//			ApplicationManager.getInstance().initialize();
			SwingConfig.getSwingConfig().init("frames.xml");
		} catch (Exception e) {
			LOG.error("", e);
		}
	}
}
