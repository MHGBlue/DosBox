/*
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package command.library;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import helpers.TestHelper;
import filesystem.File;
import filesystem.FileSystemItem;

public class CmdDelFileTest extends CmdTest {

	@Before
	public void setUp() {
        // Check this file structure in base class: crucial to understand the tests.
        this.createTestFileStructure();
		
		// Add all commands which are necessary to execute this unit test
		// Important: Other commands are not available unless added here.
		this.commandInvoker.addCommand(new CmdMkFile("mkfile", this.drive));
		this.commandInvoker.addCommand(new CmdDelFile("delfile", this.drive));
	}

    @Test
    public void CmdMkFile_CreatesNewFile()
    {
        // given
        final String newFileName = "testFile";

        // when
        executeCommand("mkfile " + newFileName);
        executeCommand("mkfile testfile1");

        // then
        assertEquals(numbersOfFilesBeforeTest + 2, drive.getCurrentDirectory().getNumberOfContainedFiles());
        TestHelper.assertOutputIsEmpty(testOutput);
        File createdFile = TestHelper.getFile(drive, drive.getCurrentDirectory().getPath(), newFileName);
        assertNotNull(createdFile);
       // assertEquals("testFile",createdFile);
    }

    @Test
    public void CmdDelFile_DeleteFile()
    {
    	int numberofFile = drive.getCurrentDirectory().getNumberOfContainedFiles();
    	
        // given
        final String newFileName = "testfile1";

        // when
        executeCommand("delFile " + newFileName);
        
        assertEquals(numberofFile , drive.getCurrentDirectory().getNumberOfContainedFiles());
        
        /*for(FileSystemItem item:drive.getCurrentDirectory().getContent()){
        	if(item.getName().equals("testFile") && !item.isDirectory()){
        		fail("File testFile still exists");
                	
        	}
        }*/
        
    }


}
