package com.sfp.extJsMVColors;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;



public class FileOpenedProjectComponent implements ProjectComponent {

	Project project;

    /**
     * Constructor
     *
     * @param   project
     */
	public FileOpenedProjectComponent(Project project) {
		this.project	= project;
	}



    /**
     * Component initialization logic
     */
	public void initComponent() {
        this.project.getMessageBus().connect().subscribe(
            FileEditorManagerListener.FILE_EDITOR_MANAGER, new MyFileEditorManagerListener(project) );
	}



	public void disposeComponent() {
		// component disposal logic
	}



	@NotNull
	public String getComponentName() {
		return "com.sfp.extJsMVColors.FileOpenedProjectComponent";
	}



	public void projectClosed() {
		// called when project is being closed
	}



	public void projectOpened() {

	}

}
