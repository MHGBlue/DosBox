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

import helpers.TestHelper;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CmdLabelTest extends CmdTest {

    @Before
    public void setUp() {
        // Check this file structure in base class: crucial to understand the tests.
        this.createTestFileStructure();

        // Add all commands which are necessary to execute this unit test
        // Important: Other commands are not available unless added here.
        this.commandInvoker.addCommand(new CmdLabel("label", this.drive));
    }

    @Test
    public void CmdLabel_updateDriveLabelName_validateDriveName() {
        final String labelName = "myTestLabelName";

        executeCommand("label " + labelName);

        assertEquals(this.drive.getLabel(), labelName);
    }

    @Test
    public void CmdLabel_updateDriveLabelName_validateOutput() {
        final String labelName = "myTestLabelName";

        executeCommand("label C: " + labelName);

        TestHelper.assertContains("Volume in drive C: is " + labelName, testOutput);
        TestHelper.assertContains("Volume Serial Number is ", testOutput);
    }
}
