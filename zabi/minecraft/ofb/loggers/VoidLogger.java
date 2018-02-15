package zabi.minecraft.ofb.loggers;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class VoidLogger extends AbstractLoggerModifier {

	@Override
	public PrintStream createNewStream() {
		return new PrintStream(new NullOutputStream());
	}
	
	public static class NullOutputStream extends OutputStream {
		@Override
		public void write(int b) throws IOException {
		}
	}

}
