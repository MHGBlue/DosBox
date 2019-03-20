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
import filesystem.Directory;
import filesystem.File;
import interfaces.IDrive;
import interfaces.IOutputter;

public class CmdTestSetup extends Command {

    public CmdTestSetup(String cmdName, IDrive drive) {
        super(cmdName, drive);
    }

    @Override
    public void execute(IOutputter outputter) {

        Directory rootDir = getDrive().getRootDirectory();

        File fileInRoot1 = new File("File1InRoot", "an entry");
        rootDir.add(fileInRoot1);
        File fileInRoot2 = new File("File2InRoot", "a long entry in a file");
        rootDir.add(fileInRoot2);

        Directory subDir1 = new Directory("subDir1");
        rootDir.add(subDir1);
        File file1InDir1 = new File("File1InDir1", "");
        subDir1.add(file1InDir1);
        File file2InDir1 = new File("File2InDir1", "");
        subDir1.add(file2InDir1);

        Directory subDir2 = new Directory("subDir2");
        rootDir.add(subDir2);


    }
}
