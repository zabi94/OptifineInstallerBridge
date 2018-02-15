# OptifineInstallerBridge

### What's this

This is a bridge executable jar to install optifine through terminal/command line.  
This was originally designed to allow the installation of optifine in vanilla in GDLauncher.

### How to

Place the optifine jar in the "ofb" subdirectory of the directory you are going to call this from.  
Then call this with the command `java -jar [jar_name] [minecraft_instances_directory]`.  

### Notes

By default this redirects the whole optifine output to a log file.  
You can use `-log=none` as your **second** arg to stop optifine from logging or you can use `-log=console` to print the log to console