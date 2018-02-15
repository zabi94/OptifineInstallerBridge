package zabi.minecraft.ofb.loggers;

import java.io.PrintStream;

public class NormalLoggerModifier extends AbstractLoggerModifier {

	@Override
	public PrintStream createNewStream() {
		return null;
	}
	
	@Override
	public void engage() {
	}
	
	@Override
	public void disengage() {
	}

}
