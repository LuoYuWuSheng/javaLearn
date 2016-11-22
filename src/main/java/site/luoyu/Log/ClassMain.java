package site.luoyu.Log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ClassMain {
	private static Logger log = Logger.getLogger(ClassMain.class.getName());
	public static void main(String[] args) {
		BasicConfigurator.configure();
		//可以通过handler 设置formatter 与 filter
//		ConsoleHandler consoleHandler = new ConsoleHandler();
		log.setLevel(Level.ALL);
		log.error("error");
		log.debug("debug");
		log.info("info");
	}
}
