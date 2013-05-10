package com.example.miniscout.client.editor;

import java.io.File;

import org.eclipse.ui.internal.part.NullEditorInput;

public class FileEditorInput extends NullEditorInput {

	private File input;

	public FileEditorInput(File input) {
		this.input = input;
	}

	public File getFile() {
		return input;
	}

}
