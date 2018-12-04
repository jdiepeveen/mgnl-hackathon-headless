package info.magnolia.hackathon2018.headless.setup;

import info.magnolia.cms.security.Permission;
import info.magnolia.module.DefaultModuleVersionHandler;
import info.magnolia.module.InstallContext;
import info.magnolia.module.delta.AddPermissionTask;
import info.magnolia.module.delta.Task;
import info.magnolia.repository.RepositoryConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is optional and lets you manage the versions of your module,
 * by registering "deltas" to maintain the module's configuration, or other type of content.
 * If you don't need this, simply remove the reference to this class in the module descriptor xml.
 *
 * @see info.magnolia.module.DefaultModuleVersionHandler
 * @see info.magnolia.module.ModuleVersionHandler
 * @see info.magnolia.module.delta.Task
 */
public class HeadlessModuleVersionHandler extends DefaultModuleVersionHandler {

    private final List<Task> updateTasks = new ArrayList<>();

    @Override
    protected List<Task> getExtraInstallTasks(InstallContext installContext) {
        final List<Task> tasks = new ArrayList<>();

        tasks.add(new AddPermissionTask("Allow 'anonymous' to access to 'website:/'", "rest-anonymous", RepositoryConstants.WEBSITE, "/", Permission.READ, true));
        tasks.add(new AddPermissionTask("Allow 'anonymous' to access to 'dam:/'", "rest-anonymous", "dam", "/", Permission.READ, true));

        tasks.addAll(updateTasks);

        return tasks;
    }
}
