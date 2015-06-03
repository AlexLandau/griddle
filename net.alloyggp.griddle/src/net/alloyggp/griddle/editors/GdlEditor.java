package net.alloyggp.griddle.editors;

import org.eclipse.ui.editors.text.TextEditor;

public class GdlEditor extends TextEditor {

	private ColorManager colorManager;

	public GdlEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new GdlConfiguration(colorManager));
		setDocumentProvider(new XMLDocumentProvider());
//		this.getSourceViewer().getAnnotationModel().addAnnotation(
//				new Annotation("org.eclipse.ui.workbench.texteditor.error", true, "I'm an annotation!"),
//				new Position(1));
	}
	@Override
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
