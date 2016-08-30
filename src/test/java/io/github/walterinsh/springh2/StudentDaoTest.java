package io.github.walterinsh.springh2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Usually we build systems with a database. Test the interaction between these two
 * parts could be hard.
 *
 * If we use a real database(eg. MySQL), we have to delete rows we create during tests.
 * Otherwise these rows would affect the tests that we run in the future.
 *
 * AbstractTestNGSpringContextTests is a helping tool to roll back those useless rows. But it has limits.
 *
 * H2 is a handy in-memory database. It gives you a highly controllable testing environment.
 *
 * NOTE: H2 gives more flexibilities but it also has limits (Not every database function is runnable on H2).
 * Sometimes we have to compromise.
 *
 * Created by Walter on 16-8-29.
 */
@ContextConfiguration(locations = "classpath:springh2/application-context.xml")
public class StudentDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testSave() throws Exception {
        studentDao.save("Luca");

        String newStudent = studentDao.getName(3);
        assertEquals(newStudent, "Luca");
    }

    @Test
    public void testGetName() throws Exception {
        String name = studentDao.getName(1);
        assertEquals(name, "Jim");
    }
}