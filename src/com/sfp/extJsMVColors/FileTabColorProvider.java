/*
 * Copyright 2013 snowflake productions GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sfp.extJsMVColors;


import com.intellij.openapi.fileEditor.impl.EditorTabColorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

import java.awt.*;

public class FileTabColorProvider implements EditorTabColorProvider {

	public static final Color COLOR_DEFAULT 	= new Color(241, 241, 240);

	public static final Color COLOR_MODEL		= new Color(243, 198, 196);		// red
	public static final Color COLOR_VIEW		= new Color(206, 250, 198);		// green
	public static final Color COLOR_CONTROLLER	= new Color(255, 251, 206);		// yellow



	@Override
	public Color getEditorTabColor(Project project, VirtualFile file) {
		FileAffiliator FileAffiliator = new FileAffiliator(file);

		if( FileAffiliator.isJavaScriptFile() ) {
                // Check path w/o filename
			if( FileAffiliator.isModelFile() ) {
				return COLOR_MODEL;
			}
			if( FileAffiliator.isViewFile() ) {
				return COLOR_VIEW;
			}
			if( FileAffiliator.isControllerFile() ) {
				return COLOR_CONTROLLER;
			}


                // Fallback: check also filename
            if( FileAffiliator.isModelFile(true) ) {
                return COLOR_MODEL;
            }
            if( FileAffiliator.isViewFile(true) ) {
                return COLOR_VIEW;
            }
            if( FileAffiliator.isControllerFile(true) ) {
                return COLOR_CONTROLLER;
            }
		}

		return COLOR_DEFAULT;
	}

}
