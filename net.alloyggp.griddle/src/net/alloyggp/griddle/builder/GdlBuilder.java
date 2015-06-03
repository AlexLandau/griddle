package net.alloyggp.griddle.builder;

import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

//Note: Much of this code was lifted from the Eclipse Platform Plug-in Developer Guide.
public class GdlBuilder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "net.alloyggp.griddle.gdlValidator";

	@Override
	protected IProject[] build(int kind, Map<String, String> args,
			IProgressMonitor monitor) throws CoreException {
		if (kind == IncrementalProjectBuilder.FULL_BUILD) {
	         fullBuild(monitor);
	      } else {
	         IResourceDelta delta = getDelta(getProject());
	         if (delta == null) {
	            fullBuild(monitor);
	         } else {
	            incrementalBuild(delta, monitor);
	         }
	      }
	      return null;
	}

	private void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) {
		try {
			delta.accept(new GdlMarkingDeltaVisitor());
		} catch (CoreException e) {
			//TODO: Remove this?
			e.printStackTrace();
			//Do nothing
		}
	}

	private void fullBuild(final IProgressMonitor monitor) throws CoreException {
		try {
			getProject().accept(new GdlMarkingVisitor());
		} catch (CoreException e) {
			//TODO: Remove this?
			e.printStackTrace();
			//Do nothing
		}
	}

	private static class GdlMarkingVisitor implements IResourceVisitor {
		@Override
		public boolean visit(IResource resource) {
			//build the specified resource.
			try {
				if (resource.getType() == IResource.FILE && resource.exists()
						&& ("kif".equalsIgnoreCase(resource.getFileExtension()) ||
								"gdl".equalsIgnoreCase(resource.getFileExtension()))) {
					//TODO: ...
					//Can get contents... but we want the associated document, right?
					resource.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);

					//TODO: Do correct marker creation code
					IMarker marker = resource.createMarker(IMarker.PROBLEM);
					marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
					marker.setAttribute(IMarker.MESSAGE, "This is the marker message! " + Math.random());
					marker.setAttribute(IMarker.CHAR_START, 2);
					marker.setAttribute(IMarker.CHAR_END, 4);
				}
			} catch (CoreException e) {
				//TODO: Remove this?
				e.printStackTrace();
				//Do nothing
			}
			//return true to continue visiting children.
			return true;
		}
	}

	private static class GdlMarkingDeltaVisitor implements IResourceDeltaVisitor {

		@Override
		public boolean visit(IResourceDelta delta) throws CoreException {
			//build the specified resource.
			try {
				IResource resource = delta.getResource();
				if (resource.getType() == IResource.FILE && resource.exists()
						&& ("kif".equalsIgnoreCase(resource.getFileExtension()) ||
								"gdl".equalsIgnoreCase(resource.getFileExtension()))) {
					if (delta.getKind() == IResourceDelta.REMOVED) {
						resource.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
					} else {
						//TODO: ...
						//Can get contents... but we want the associated document, right?
						resource.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);

						//TODO: Do correct marker creation code
						IMarker marker = resource.createMarker(IMarker.PROBLEM);
						marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
						marker.setAttribute(IMarker.MESSAGE, "This is the marker message!" + Math.random());
						marker.setAttribute(IMarker.CHAR_START, 2);
						marker.setAttribute(IMarker.CHAR_END, 4);
					}
				}
			} catch (CoreException e) {
				//TODO: Remove this?
				e.printStackTrace();
				//Do nothing
			}
			//return true to continue visiting children.
			return true;
		}

	}

	public static IResourceVisitor getMarkerClearingVisitor() {
		return new IResourceVisitor() {
			@Override
			public boolean visit(IResource resource) throws CoreException {
				if (resource.getType() == IResource.FILE && resource.exists()
						&& ("kif".equalsIgnoreCase(resource.getFileExtension()) ||
								"gdl".equalsIgnoreCase(resource.getFileExtension()))) {
						resource.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
				}

				//return true to continue visiting children.
				return true;
			}
		};
	}

	//TODO: Figure this out
//	@Override
//	public ISchedulingRule getRule(int kind, Map<String, String> args) {
//		// TODO Auto-generated method stub
//		return super.getRule(kind, args);
//	}

}
