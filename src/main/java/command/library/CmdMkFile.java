/*
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */

package command.library;

import interfaces.IDrive;
import interfaces.IOutputter;
import command.framework.Command;
import filesystem.File;

class CmdMkFile extends Command {

	public CmdMkFile(String cmdName, IDrive drive) {
		super(cmdName, drive);
	}

	@Override
	public void execute(IOutputter outputter) {
		String fileName = this.getParameterAt(0);
		String fileContent = "";
		if(this.getParameterCount()>1) {
			fileContent = this.getParameterAt(1);
		}
		File newFile = new File(fileName, fileContent);
		this.getDrive().getCurrentDirectory().add(newFile);
	}

	@Override
	protected boolean checkNumberOfParameters(int number) {
		// Commands like "mkdir dir1 dir2 dir3" are allowed too.
		return number >= 1 ? true : false;
	}

}
