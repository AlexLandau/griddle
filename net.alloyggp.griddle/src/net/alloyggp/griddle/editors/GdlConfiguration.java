package net.alloyggp.griddle.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class GdlConfiguration extends SourceViewerConfiguration {
	private XMLDoubleClickStrategy doubleClickStrategy;
//	private XMLTagScanner tagScanner;
	private GdlScanner scanner;
	private ColorManager colorManager;

	public GdlConfiguration(ColorManager colorManager) {
		this.colorManager = colorManager;
	}
	@Override
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] {
			IDocument.DEFAULT_CONTENT_TYPE,
//			GdlPartitionScanner.GDL,
//			GdlPartitionScanner.GDL_COMMENT
			};
	}
	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(
		ISourceViewer sourceViewer,
		String contentType) {
		if (doubleClickStrategy == null)
			doubleClickStrategy = new XMLDoubleClickStrategy();
		return doubleClickStrategy;
	}

	protected GdlScanner getGdlScanner() {
		if (scanner == null) {
			scanner = new GdlScanner(colorManager);
			scanner.setDefaultReturnToken(
				new Token(
					new TextAttribute(
						colorManager.getColor(GdlColorConstants.DEFAULT))));
		}
		return scanner;
	}
//	protected XMLTagScanner getXMLTagScanner() {
//		if (tagScanner == null) {
//			tagScanner = new XMLTagScanner(colorManager);
//			tagScanner.setDefaultReturnToken(
//				new Token(
//					new TextAttribute(
//						colorManager.getColor(GdlColorConstants.TAG))));
//		}
//		return tagScanner;
//	}

	@Override
	public IContentFormatter getContentFormatter(ISourceViewer sourceViewer) {
		return new GdlContentFormatter();
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

//		DefaultDamagerRepairer dr =
//			new DefaultDamagerRepairer(getXMLTagScanner());
//		reconciler.setDamager(dr, GdlPartitionScanner.GDL);
//		reconciler.setRepairer(dr, GdlPartitionScanner.GDL);

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getGdlScanner());
//		reconciler.setDamager(dr, GdlPartitionScanner.GDL);
//		reconciler.setRepairer(dr, GdlPartitionScanner.GDL);
		//TODO: Fix this?
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

//		NonRuleBasedDamagerRepairer ndr =
//			new NonRuleBasedDamagerRepairer(
//				new TextAttribute(
//					colorManager.getColor(GdlColorConstants.COMMENT)));
//		reconciler.setDamager(ndr, GdlPartitionScanner.GDL_COMMENT);
//		reconciler.setRepairer(ndr, GdlPartitionScanner.GDL_COMMENT);

		return reconciler;
	}

	//TODO: Override getIndentPrefixes?

}