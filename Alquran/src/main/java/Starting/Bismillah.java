package Starting;

import java.sql.Connection;

import org.apache.log4j.Logger;

import Firebug.FirebugModule;
import MyAction.ActionModule;
import MyVariable.VariableModule;


public class Bismillah {
	static Logger logBismillah = Logger.getLogger(Bismillah.class.getName());
	//VariableModule variabledo = new VariableModule();
	public static void main(String[] args) {
		logBismillah.debug("Bismillah Module is going to start");

		new VariableModule().StartModule();
		//FirebugModule.FacebookLogin("");
	}

}
