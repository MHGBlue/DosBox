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

	final String fileNameToDel = "testFile";

	
    @Test
    public void CmdMkFile_CreatesNewFile()
    {
       

        System.out.println("CmdMkFile_CreatesNewFile dir "+ drive.getCurrentDirectory().getPath());
        // when
        executeCommand("mkfile " + fileNameToDel);
        executeCommand("mkfile testfile1");

        // then
        assertEquals(numbersOfFilesBeforeTest + 2, drive.getCurrentDirectory().getNumberOfContainedFiles());
        TestHelper.assertOutputIsEmpty(testOutput);
        File createdFile = TestHelper.getFile(drive, drive.getCurrentDirectory().getPath(), fileNameToDel);
        assertNotNull(createdFile);
       // assertEquals("testFile",createdFile);
    }

    @Test
    public void CmdDelFile_DeleteFile()
    {
    	int numberofFile = drive.getCurrentDirectory().getNumberOfContainedFiles();
    	 executeCommand("mkfile testfile1");
    	 executeCommand("mkfile testfile2");
    	 numberofFile = drive.getCurrentDirectory().getNumberOfContainedFiles();
       
        // when
        executeCommand("delfile testfile1");
        
        assertEquals(numberofFile -1 , drive.getCurrentDirectory().getNumberOfContainedFiles());
        
        for(FileSystemItem item:drive.getCurrentDirectory().getContent()){
        	System.out.println(item.getName());
        }
        
    }


}
