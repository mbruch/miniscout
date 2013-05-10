package com.example.miniscout.client.editor;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class OpenHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow ww = wb.getActiveWorkbenchWindow();
		Shell shell = ww.getShell();
		FileDialog dialog = new FileDialog(shell);
		dialog.setFilterExtensions(new String[] { "*.json" });
		String file = dialog.open();
		if (file != null) {
			openEditor(ww, file);
		}
		return true;
	}

	private void openEditor(IWorkbenchWindow ww, final String file) {
		final File in = new File(file);
		try {
			ww.getActivePage().openEditor(new FileEditorInput(in),
					"com.example.miniscout.client.editor");
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}
}