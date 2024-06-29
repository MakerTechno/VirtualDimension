package io.github.makertechno.user.logic.transport.process;

import javax.naming.NameNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

public class ProcessTransmitter<T extends ProcessAbility> implements Iterator<T> {
    private final List<T> registryList = new ArrayList<>();
    private final Iterator<T> iterator = registryList.listIterator();
    public void register(T process){
        for (T t : registryList){
            if (t.id() == process.id()) throw new RejectedExecutionException(t.getDescription()+" has already registered!");
        }
        registryList.add(process);
    }
    public int queryProcess(T process) throws NameNotFoundException {
        for (T t : registryList){
            if (process.getDescription().equals(t.getDescription())) return t.queryProcess();
        }
        throw new NameNotFoundException("The process " + process.getDescription() + " could not be found.");
    }
    public boolean queryState(T process) throws NameNotFoundException {
        for (T t : registryList){
            if (process.getDescription().equals(t.getDescription())) return t.queryState();
        }
        throw new NameNotFoundException("The process " + process.getDescription() + " could not be found.");
    }
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
    @Override
    public T next(){
        return iterator.next();
    }
}
