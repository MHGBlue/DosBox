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

public class CmdEnterTest extends CmdTest {
    @Before
    public void setUp()
    {
        // Check this file structure in base class: crucial to understand the tests.
        this.createTestFileStructure();

        // Add all commands which are necessary to execute this unit test
        // Important: Other commands are not available unless added here.
        commandInvoker.addCommand(new CmdDir("dir", drive));
    }

    @Test
    public void ExecuteCommand_WithoutCommandName_PrintNoError()
    {
        executeCommand("\n");
        TestHelper.assertContains("", testOutput);
    }

    @Test
    public void ExecuteCommand_WithInvalidCommandName_PrintError()
    {
        executeCommand("test");
        TestHelper.assertContains("is not recognized as an internal or external command,\n" +
                "operable program or batch file.", testOutput);
    }

    @Test
    public void ExecuteCommand_WithExitCommandName_PrintGoodbye()
    {
        executeCommand("exit");
        TestHelper.assertContains("", testOutput);
    }

    @Test
    public void ExecuteCommandHelp_PrintCommandList()
    {
        executeCommand("help");
        TestHelper.assertContains("\nPlease find command list below: ", testOutput);
    }
}
