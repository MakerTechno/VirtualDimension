package io.github.makertechno.user.logic.transport.process;

import io.github.makertechno.user.logic.transport.variables.ObservableValue;
import io.github.makertechno.user.logic.transport.Transitive;

import java.util.function.Supplier;

public class ProcessAbility implements Transitive {
    private final String description;
    private final Supplier<ObservableValue<Integer>> process;
    private final Supplier<Boolean> state;
    private final int id;
    ProcessAbility(String description, Supplier<ObservableValue<Integer>> process, Supplier<Boolean> state, final int id){
        this.description = description;
        this.process = process;
        this.state = state;
        this.id = id;
    }
    public int queryProcess(){
        return this.process.get().getValue();
    }
    public boolean queryState(){
        return this.state.get();
    }
    public int id(){
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }
    public ObservableValue<Integer> getProcessObservable(){
        return this.process.get();
    }
}
