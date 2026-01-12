package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategy() {
        User millenial = new Millenials("Steve");
        User ygeneration = new YGeneration("Brajanek");
        User zgeneration = new ZGeneration("Alibaba");

        String millenialSocial = millenial.sharePost();
        String ygenerationSocial = ygeneration.sharePost();
        String zgenerationSocial = zgeneration.sharePost();

        assertEquals("Facebook", millenialSocial);
        assertEquals("Twitter", ygenerationSocial);
        assertEquals("Snapchat", zgenerationSocial);
    }

    @Test
    void testInvidualSharingStrategy() {
        User millenial = new Millenials("Steven");

        String defaulSocuial = millenial.sharePost();
        millenial.setSocialPublisher(new SnapChatPublisher());
        String changedSocial = millenial.sharePost();

        assertEquals("Facebook", defaulSocuial);
        assertEquals("Snapchat", changedSocial);

    }
}
