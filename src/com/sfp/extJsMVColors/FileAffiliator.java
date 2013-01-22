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

import com.intellij.openapi.vfs.VirtualFile;
import com.sfp.extJsMVColors.utils.StringHelper;

/**
 * Detection whether and what part of (Ext Js) MVC a file seems to be
 */
public class FileAffiliator {

	private VirtualFile file;

	private String fileName;
	private String fileNameWithoutExtension;
	private String fileExtension;
	private String filePath;


    /**
     * @param   file
     */
	public FileAffiliator(VirtualFile file) {
		this.file		= file;

		this.fileName					= this.file.getName();
		this.fileNameWithoutExtension	= this.file.getNameWithoutExtension();

		this.fileExtension	= this.file.getExtension();
		if( this.fileExtension != null && this.fileExtension.length() > 0 ) {
			this.fileExtension	= this.fileExtension.toLowerCase();
		}

		this.filePath	= this.file.getPath();
	}



    /**
     * @return  VirtualFile
     */
	public VirtualFile getFile() {
		return this.file;
	}



    /**
     * @return  String
     */
	public String getFilePath() {
		return this.filePath;
	}



    /**
     * @return  String
     */
	public String getFileExtension() {
		return this.fileExtension;
	}



    /**
     * @return  String
     */
	public String getFileName() {
		return this.fileName;
	}



    /**
     * @return  String
     */
	public String getFileNameWithoutExtension() {
		return this.fileNameWithoutExtension;
	}




    /**
     * @return  Boolean
     */
	public boolean isJavaScriptFile() {
		return this.fileExtension != null && this.fileExtension.equals("js");
	}



    /**
     * @return  Boolean
     */
	public boolean isModelFile() {
        return this.isModelFile(false);
    }

	public boolean isModelFile(Boolean includeFilename) {
        if( includeFilename ) {
		    return this.filePath.toLowerCase().contains(wrapInFileSeparator("model"));
        }

        return StringHelper.removeLast(this.filePath, this.fileName).contains(wrapInFileSeparator("model"));
	}



    /**
     * @return  Boolean
     */
	public boolean isViewFile() {
        return this.isViewFile(false);
    }

	public boolean isViewFile(Boolean includeFilename) {
        if( includeFilename ) {
		    return this.filePath.toLowerCase().contains(wrapInFileSeparator("view"));
        }

        return StringHelper.removeLast(this.filePath, this.fileName).contains(wrapInFileSeparator("view"));
	}



    /**
     * @return  Boolean
     */
    public boolean isControllerFile() {
        return this.isControllerFile(false);
    }

	public boolean isControllerFile(Boolean includeFilename) {
        if( includeFilename ) {
		    return this.filePath.toLowerCase().contains(wrapInFileSeparator("controller"));
        }

        return StringHelper.removeLast(this.filePath, this.fileName).contains(wrapInFileSeparator("controller"));
	}



    /**
     * @return  Boolean
     */
	public boolean isStoreFile() {
        return this.isStoreFile(false);
    }



    /**
     * @param   includeFilename
     * @return  Boolean
     */
	public boolean isStoreFile(Boolean includeFilename) {
        if( includeFilename ) {
		    return this.filePath.toLowerCase().contains(wrapInFileSeparator("store"));
        }

        return StringHelper.removeLast(this.filePath, this.fileName).contains(wrapInFileSeparator("store"));
	}



    /**
     * @return  Boolean
     */
	public boolean isMVCSfile() {
		return 	   this.isModelFile()
				|| this.isViewFile()
				|| this.isControllerFile()
				|| this.isStoreFile();
	}



    /**
     * @param   filename
     * @return  String
     */
	private String wrapInFileSeparator(String filename) {
		return filename;
	}
}
