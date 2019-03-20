/*
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package command.library;

import interfaces.IDrive;

import java.util.ArrayList;
import command.framework.Command;

/**The factory is responsible to create an object of every command supported
 * and to add it to the list of known commands.
 * New commands must be added to the list of known commands here.
 */
public class CommandFactory {
	
	private ArrayList<Command> commands;

	public CommandFactory(IDrive drive) {
		this.commands = new ArrayList<Command>();
		
		this.commands.add(new CmdDir("dir", drive));
		this.commands.add(new CmdCd("cd", drive));
		this.commands.add(new CmdCd("chdir", drive));
		this.commands.add(new CmdMkDir("mkdir", drive));
		this.commands.add(new CmdMkDir("md", drive));
		this.commands.add(new CmdMkFile("mf", drive));
		this.commands.add(new CmdMkFile("mkfile", drive));


		// Add your commands here
		
	    this.commands.add(new CmdDelFile("delfile", drive));
		this.commands.add(new CmdCopy("cp", drive));
		this.commands.add(new CmdCopy("copy", drive));
		this.commands.add(new CmdTestSetup("testsetup", drive));
		this.commands.add(new CmdRmDir("rmdir", drive));
		
	}
	
	public ArrayList<Command> getCommandList() {
		return commands;
	}

}
