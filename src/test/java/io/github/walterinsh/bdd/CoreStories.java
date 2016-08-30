package io.github.walterinsh.bdd;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.StepFinder;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

/**
 * Created by Walter on 16-8-30.
 */
public class CoreStories extends JUnitStories {

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryReporterBuilder(new StoryReporterBuilder().withCodeLocation(codeLocationFromClass(this.getClass())));

    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new StringReverserStory());
    }

    @Override
    protected List<String> storyPaths() {
        List<String> paths = new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "");
        return paths;
    }

    @org.testng.annotations.Test
    @Override
    public void run() throws Throwable {
        super.run();
    }

}
