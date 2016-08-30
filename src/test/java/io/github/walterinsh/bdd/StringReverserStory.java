package io.github.walterinsh.bdd;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.testng.Assert.assertEquals;

/**
 * Created by Walter on 16-8-29.
 */
public class StringReverserStory {

    StringReverser stringReverser;
    String result;

    @Given("create a reverser need uppercase $uppercase")
    public void createReverser(boolean uppercase) throws Exception {
        stringReverser = new StringReverser(uppercase);
    }

    @When("reverse $testString")
    public void reverse(String testString) throws Exception {
        result = stringReverser.inverse(testString);
    }

    @Then("I should get $result")
    public void theResultShouldBe(String result) throws Exception {
        assertEquals(this.result, result);
    }
}
