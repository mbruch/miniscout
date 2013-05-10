package com.example.miniscout.client.editor;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import com.google.common.base.Throwables;
import com.google.common.io.CharStreams;

public class Editor extends EditorPart {

	private Text area;
	private String content;

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
		File file = ((FileEditorInput) input).getFile();
		try {
			content = CharStreams.toString(new FileReader(file));
		} catch (IOException e) {
			Throwables.propagate(e);
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		area = new Text(parent, SWT.MULTI);
		area.setText(content);
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
	}

	@Override
	public void doSaveAs() {
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void setFocus() {
	}

}
