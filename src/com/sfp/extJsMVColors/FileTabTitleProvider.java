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


import com.intellij.openapi.fileEditor.impl.EditorTabTitleProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;

public class FileTabTitleProvider implements EditorTabTitleProvider {

	public String getEditorTabTitle(Project project, VirtualFile file) {
		String title;

		FileAffiliator FileAffiliator = new FileAffiliator(file);

		if( FileAffiliator.isJavaScriptFile() && FileAffiliator.isMVCSfile() ) {
			final PsiManager psiManager = PsiManager.getInstance(project);
			final PsiFile psiFile = psiManager.findFile(file);

			try {
				String fileContents	= psiFile.getOriginalFile().getText();

					// Grab alias if available
				title	= extractPropertyValue(fileContents, "alias");
				if( title != null ) return title.replace("widget.", "");

					// Grab title if available
				title	= extractPropertyValue(fileContents, "title");
				if( title != null ) return title;

			} catch(NullPointerException e) {

			}

			return FileAffiliator.getFileNameWithoutExtension();
		}

		return null;
	}



	/**
	 * @param	fileContents		Sourcecode of file
	 * @param	propertyName		Property who's value is to be extracted
	 * @return	The extracted value or null if the property is not found
	 */
	private String extractPropertyValue(String fileContents, String propertyName) {
		String propertyDeclarationLHS	= propertyName + ":";

		if( fileContents.contains(propertyDeclarationLHS) ) {
			String value	= fileContents.split(propertyDeclarationLHS)[1];
			if( value.contains("\n") ) {
				value	= value.split("\n")[0];
			}

			return value.replaceAll("['|,]", "").trim();
		}

		return null;
	}

}
