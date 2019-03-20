/*
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package command.library;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CmdRmDirTest extends CmdTest {

	@Before
	public void setUp() {
        // Check this file structure in base class: crucial to understand the tests.
        this.createTestFileStructure();

		// Add all commands which are necessary to execute this unit test
		// Important: Other commands are not available unless added here.
		this.commandInvoker.addCommand(new CmdMkDir("mkdir", this.drive));
		this.commandInvoker.addCommand(new CmdRmDir("rmdir", this.drive));
	}

	@Ignore
    @Test
    public void CmdRmDir_DelNewDirectory()
    {
        executeCommand("mkdir testDirName");
        
        /*Directory testDirectory = TestHelper.getDirectory(drive, Path.Combine(drive.getDriveLetter(), testDirName),
                                                          testDirName);
        assertSame(drive.getRootDirectory(), testDirectory.getParent());*/
        assertEquals(numbersOfDirectoriesBeforeTest + 1, drive.getRootDirectory().getNumberOfContainedDirectories());
        //TestHelper.assertOutputIsEmpty(testOutput);

        
        executeCommand("rmdir testDirName");
        /*testDirectory = TestHelper.getDirectory(drive, Path.Combine(drive.getDriveLetter(), testDirName),
                testDirName);
        assertSame(drive.getRootDirectory(), testDirectory.getParent());*/
        assertEquals(numbersOfDirectoriesBeforeTest -1, drive.getRootDirectory().getNumberOfContainedDirectories());
        //TestHelper.assertOutputIsEmpty(testOutput);
        
    }
}
