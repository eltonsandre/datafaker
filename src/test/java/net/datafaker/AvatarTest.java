package net.datafaker;

import net.datafaker.repeating.Repeat;
import org.junit.Test;

import static net.datafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class AvatarTest extends AbstractFakerTest {

    @Test
    @Repeat(times = 10)
    public void testAvatar() {
        String avatar = faker.avatar().image();
        assertThat(avatar, matchesRegularExpression("^https:\\/\\/s3.amazonaws\\.com\\/uifaces\\/faces\\/twitter\\/[a-zA-Z0-9_]+\\/128\\.jpg$"));
    }
}
