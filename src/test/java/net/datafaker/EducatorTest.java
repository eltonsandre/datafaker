package net.datafaker;

import org.junit.Test;

import static net.datafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class EducatorTest extends AbstractFakerTest {

    @Test
    public void testUniversity() {
        assertThat(faker.educator().university(), matchesRegularExpression("(\\w+ ?){2,3}"));
    }

    @Test
    public void testCourse() {
        assertThat(faker.educator().course(), matchesRegularExpression("(\\(?\\w+\\)? ?){3,6}"));
    }

    @Test
    public void testSecondarySchool() {
        assertThat(faker.educator().secondarySchool(), matchesRegularExpression("(\\w+ ?){2,3}"));
    }

    @Test
    public void testCampus() {
        assertThat(faker.educator().campus(), matchesRegularExpression("(\\w+ ?){1,2}"));
    }
}
