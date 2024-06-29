package io.github.makertechno.user.logic.compile;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class SimpleRandoms {
    public static int simpleRandom(@NotNull Random random, int from, int to){
        assert to > from;
        return random.nextInt(to - from) + from;
    }
    private static int NonRepetitiveLoop(Random random, int from, int elementLength, int[] source, int stopPoint){
        int tmp = SimpleRandoms.simpleRandom(random, from, elementLength);
        for (int i = 0; i < stopPoint; i++){
            if (source[i] == tmp)
                return NonRepetitiveLoop(random, from, elementLength, source, stopPoint);
        }
        return tmp;
    }
    public static void configureNonRepetitiveArray(int from, int elementLength, int[] source, int stopPoint){
        NonRepetitiveLoop(new Random(), from, elementLength, source, stopPoint);
    }
}
