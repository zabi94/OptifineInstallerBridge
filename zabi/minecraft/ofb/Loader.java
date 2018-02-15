/**
 * Class written by Zabi94
 * Feb 15, 2018
 * Distributed under MIT license
 * 
 * This class allows the installation of optifine via command line
 * This is not affiliated with Optifine
 */

package zabi.minecraft.ofb;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Loader {

	@SuppressWarnings({ "rawtypes", "unchecked"})
	public static void main(String[] args) {
		if (args.length==0) {
			throw new IllegalArgumentException("No destination directory specified");
		}
		File destDir = new File(args[0]);
		if (!destDir.exists()) {
			throw new IllegalArgumentException("The specified directory doesn't exist");
		}
		if (destDir.isFile()) {
			throw new IllegalArgumentException("The specified directory is actually a file");
		}
		File file = new File("ofb");
		if (!file.exists() || file.isFile()) throw new IllegalStateException("No \"ofb\" directory found");
		File[] files = file.listFiles(f -> f.exists() && f.isFile() && f.getName().toLowerCase().contains("optifine") && f.getName().toLowerCase().endsWith(".jar"));
		boolean success = false;
		for (File f:files) {
			try {
				URLClassLoader child = new URLClassLoader(new URL[] {f.toURI().toURL()}, Loader.class.getClassLoader());
				Class classToLoad = Class.forName("optifine.Installer", true, child);
				Method method = classToLoad.getDeclaredMethod("doInstall", File.class);
				method.invoke(null, destDir);
				success=true;
				System.out.println("Optifine installation successful");
				System.exit(0);
			} catch (Exception e) {
				System.err.println(f.getName()+" is not a valid Optifine Jar");
				e.printStackTrace();
			}
		}
		
		if (!success) {
			System.err.println("No valid optifine file found");
			System.exit(-1);
		}
	}

}
