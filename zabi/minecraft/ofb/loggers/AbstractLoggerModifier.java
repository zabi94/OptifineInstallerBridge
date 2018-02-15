package zabi.minecraft.ofb.loggers;

import java.io.PrintStream;

public abstract class AbstractLoggerModifier {
	
	private PrintStream oldOutput;
	private PrintStream currentOutput;
	
	public void engage() {
		oldOutput = System.out;
		currentOutput = createNewStream();
		System.setOut(currentOutput);
	}
	
	public void disengage() {
		System.setOut(oldOutput);
		currentOutput.flush();
		currentOutput.close();
	}
	
	public abstract PrintStream createNewStream();
}
