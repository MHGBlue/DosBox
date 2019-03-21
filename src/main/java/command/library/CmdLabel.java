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
import filesystem.FileSystemItem;
import interfaces.IDrive;
import interfaces.IOutputter;

public class CmdLabel extends Command {

    public CmdLabel(String cmdName, IDrive drive) {
        super(cmdName, drive);
    }

    @Override
    public void execute(IOutputter outputter) {

        String newLabel = this.getParameterAt(0);

        if (newLabel.equalsIgnoreCase(this.getDrive().getDriveLetter())) {
            newLabel = this.getParameterAt(1);
            //outputter.printLine("Output: Volume in drive " + this.getDrive().getDriveLetter() + " is " + this.getDrive().getLabel());

        }

            this.getDrive().setLabel(newLabel);
            this.getDrive().generateSerialNumber();

            outputter.printLine("Output: Volume in drive " + this.getDrive().getDriveLetter() + " is " + this.getDrive().getLabel());
            outputter.printLine("Volume Serial Number is  " + this.getDrive().getSerialNumber());

    }

    @Override
    protected boolean checkNumberOfParameters(int number) {
        // Commands like "mkdir dir1 dir2 dir3" are allowed too.
        return number >= 1 ? true : false;
    }
}
