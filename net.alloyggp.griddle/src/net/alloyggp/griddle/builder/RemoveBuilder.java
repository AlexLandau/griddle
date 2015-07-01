package net.alloyggp.griddle.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;

/*
 * Note: Much of this code was lifted from the tutorial at
 * http://codeandme.blogspot.com/2012/10/integrating-custom-builder.html
 */
public class RemoveBuilder extends AbstractHandler implements IHandler {

    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        final IProject project = AddBuilder.getProject(event);

        if (project != null) {
            try {
                final IProjectDescription description = project.getDescription();
                final List<ICommand> commands = new ArrayList<ICommand>();
                commands.addAll(Arrays.asList(description.getBuildSpec()));

                boolean wasRemoved = false;
                for (final ICommand buildSpec : description.getBuildSpec()) {
                    if (GdlBuilder.BUILDER_ID.equals(buildSpec.getBuilderName())) {
                        // remove builder
                        //TODO: Remove all markers from GDL files...
                        //TODO: Make that a call into GdlBuilder
                        wasRemoved = true;
                        commands.remove(buildSpec);
                    }
                }
                project.accept(GdlBuilder.getMarkerClearingVisitor());

                description.setBuildSpec(commands.toArray(new ICommand[commands.size()]));
                project.setDescription(description, null);
            } catch (final CoreException e) {
                // TODO could not read/write project description
                e.printStackTrace();
            }
        }

        return null;
    }
}
