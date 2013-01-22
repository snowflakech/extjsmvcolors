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

import com.intellij.ide.IconProvider;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.sfp.extJsMVColors.resources.PluginIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Provides custom icons for *.js files that seem to be model / view / controllers
 */
public class FileIconProvider extends IconProvider {

	public Icon getIcon(@NotNull PsiElement psiElement, int flags) {
		PsiFile containingFile = psiElement.getContainingFile();

		if( containingFile != null ) {
			VirtualFile vFile = containingFile.getVirtualFile();

			if( vFile != null ) {
				FileAffiliator FileAffiliator = new FileAffiliator( vFile );

				if( FileAffiliator.isJavaScriptFile() ) {
					if( FileAffiliator.isModelFile() ) {
						return IconLoader.getIcon(PluginIcons.ICON_URL_MODEL);
					}
					if( FileAffiliator.isViewFile() ) {
						return IconLoader.getIcon(PluginIcons.ICON_URL_VIEW);
					}
					if( FileAffiliator.isControllerFile() ) {
						return IconLoader.getIcon(PluginIcons.ICON_URL_CONTROLLER);
					}

					if(  FileAffiliator.isStoreFile() ) {
						return IconLoader.getIcon(PluginIcons.ICON_URL_STORE);
					}

					if(  vFile.getPath().toLowerCase().endsWith("app.js") ) {
						return IconLoader.getIcon(PluginIcons.ICON_URL_EXTJS);
					}
				}
			}
		}

		return null;
	}

}
