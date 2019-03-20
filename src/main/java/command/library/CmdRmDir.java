package command.library;

import command.framework.Command;
import filesystem.FileSystemItem;
import interfaces.IDrive;
import interfaces.IOutputter;

public class CmdRmDir extends Command {

	public CmdRmDir(String commandName, IDrive drive) {
		super(commandName, drive);
	}

		
	@Override
	public void execute(IOutputter outputter) {
		String fileName = this.getParameterAt(0);
		for (FileSystemItem item : this.getDrive().getCurrentDirectory().getContent()) {
			if (item.getName().equals(fileName)&& item.isDirectory()) {	
				this.getDrive().getCurrentDirectory().remove(item);
				return;
			}
			
		// Delete entire Directory 
			/*while(root.getContent().size() > 0) {
				     root.remove(root.getContent().get(0));
				 }*/

		}
		outputter.printLine("Directory not found"+fileName);
	}

}
