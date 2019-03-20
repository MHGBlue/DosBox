/*
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */

package command.library;

import command.framework.Command;
import filesystem.FileSystemItem;
import interfaces.IDrive;
import interfaces.IOutputter;

class CmdDelFile extends Command {

	public CmdDelFile(String cmdName, IDrive drive) {
		super(cmdName, drive);
	}

	@Override
	public void execute(IOutputter outputter) {
		String fileName = this.getParameterAt(0);
		for (FileSystemItem item : this.getDrive().getCurrentDirectory().getContent()) {
			if (item.getName().equals(fileName)&& !item.isDirectory()) {	
				this.getDrive().getCurrentDirectory().remove(item);
				return;
			}
			
		// Delete entire Directory 
			/*while(root.getContent().size() > 0) {
				     root.remove(root.getContent().get(0));
				 }*/

		}
		outputter.printLine("File not found"+fileName);
	}
}
