package com.eric.generics;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/10/2019 1:38 PM
 */
public class StoryCharacters_8 {
    private static int count = 0;
    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + count++;
    }
}

class GoodGuys extends StoryCharacters_8 {}

class BadGuys extends StoryCharacters_8 {
}

class GoodGuy extends StoryCharacters_8 {}
class LukeSkywalker extends GoodGuy {}
class Yoda extends GoodGuy {}
class BadGuy extends StoryCharacters_8 {}
class DarthVader extends BadGuy {}
class JabbaTheHut extends BadGuy {}
