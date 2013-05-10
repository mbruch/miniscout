package com.example.miniscout.client.editor;

import java.net.URI;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class Editor extends EditorPart {

  private Text area;
  private String content;
  private URI input;

  @Override
  public void init(IEditorSite site, IEditorInput editorInput)
      throws PartInitException {
    setSite(site);
    setInput(editorInput);
    this.input = ((ContactEditorInput) editorInput).getInput();
    content = DatabaseService.load(this.input);
  }

  @Override
  public void createPartControl(Composite parent) {
    area = new Text(parent, SWT.MULTI);
    area.setText(content);
  }

  @Override
  public void doSave(IProgressMonitor monitor) {
    // not implemented yet
  }

  @Override
  public boolean isDirty() {
    // not implemented yet
    return false;
  }

  @Override
  public boolean isSaveAsAllowed() {
    return false;
  }

  @Override
  public void doSaveAs() {
  }

  @Override
  public void setFocus() {
  }

}
