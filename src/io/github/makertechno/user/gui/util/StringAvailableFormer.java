package io.github.makertechno.user.gui.util;

import io.github.makertechno.user.logic.compile.SimpleRandoms;
import org.jetbrains.annotations.NotNull;

public class StringAvailableFormer {
    public static char @NotNull [] getRandomCharset(int length){
        char[] chars = new char[length];
        int[] ints = new int[length];
        SimpleRandoms.configureNonRepetitiveArray(33, 57, ints, length);
        for (int i = 0; i < length; i++){
            chars[i] = (char) ints[i];
        }
        return chars;
    }
}
