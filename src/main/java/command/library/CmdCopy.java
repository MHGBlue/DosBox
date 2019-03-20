/*
*
* (c) 2018. The Hartford.
* 690 Asylum Ave, Hartford, Connecticut, 06155, U.S.A.
* All rights reserved.
*
* The Hartford is The Hartford Financial Services Group, Inc. and its
* subsidiaries, including Hartford Fire Insurance Company. Its
* headquarters is in Hartford, CT.
*
* The software, code and other information to which you have access is
* the confidential and proprietary information of The Hartford
* ("Proprietary Information").
*
* You shall not disclose such Proprietary Information to any third party
* without the prior, written permission of The Hartford.
*
* You shall not use such Proprietary Information for any purpose except
* to provide your service to The Hartford, and as may otherwise be
* permitted in the terms of the applicable agreement with The Hartford.
*
*/
package command.library;

import command.framework.Command;
import filesystem.File;
import filesystem.FileSystemItem;
import interfaces.IDrive;
import interfaces.IOutputter;

public class CmdCopy  extends Command {

    public CmdCopy(String cmdName, IDrive drive) {
        super(cmdName, drive);
    }

    @Override
    public void execute(IOutputter outputter) {
        String oldFileName = this.getParameterAt(0);
        String newFileName = this.getParameterAt(1);
        String content = "";
        for (FileSystemItem file : this.getDrive().getCurrentDirectory().getContent()) {
            if(oldFileName.equalsIgnoreCase(file.getName())) {
                content = getFileContent((File)file);
                break;
            }
        }
        File newFile = new File(newFileName, content);
        this.getDrive().getCurrentDirectory().add(newFile);
    }

    @Override
    protected boolean checkNumberOfParameters(int number) {
        // Commands like "mkdir dir1 dir2 dir3" are allowed too.
        return number >= 2 ? true : false;
    }

    private String getFileContent(File file) {
        return file.getFileContent();
    }

}
