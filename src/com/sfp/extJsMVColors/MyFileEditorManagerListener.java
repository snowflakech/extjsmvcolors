package com.sfp.extJsMVColors;

import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerEvent;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManager;

import javax.swing.*;


public class MyFileEditorManagerListener implements FileEditorManagerListener {

	private final Project project;


    /**
     * Constructor
     *
     * @param project
     */
	public MyFileEditorManagerListener(Project project) {
		this.project = project;
	}



    /**
     * File opened
     *
     * @param source
     * @param file
     */
	public void fileOpened(FileEditorManager source, VirtualFile file) {

	}



    /**
     * File closed
     *
     * @param source
     * @param file
     */
	public void fileClosed(FileEditorManager source, VirtualFile file) {

	}



	/**
	 * Opened file changed (tab switched)
	 *
	 * @param event
	 */
	public void selectionChanged(FileEditorManagerEvent event) {

	}

}