package io.github.makertechno.user.logic.transport.process;

import io.github.makertechno.user.logic.transport.variables.ObservableValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ProcessAbilityFactory{
    private static int ELEMENT_ID = 0;
    private ProcessAbilityFactory(){}
    @Contract("_, _, _ -> new")
    public static @NotNull ProcessAbility create(String description, Supplier<ObservableValue<Integer>> process, Supplier<Boolean> state){
        return new ProcessAbility(description, process, state, ELEMENT_ID++);
    };
}
