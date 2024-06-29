package io.github.makertechno.user.sys;

import io.github.makertechno.user.logic.transport.variables.ObservableValue;
import io.github.makertechno.user.logic.transport.TransportHandler;
import io.github.makertechno.user.logic.transport.process.ProcessAbility;
import io.github.makertechno.user.logic.transport.process.ProcessAbilityFactory;
import io.github.makertechno.user.logic.transport.process.ProcessTransmitter;
import org.jetbrains.annotations.NotNull;

import java.util.Timer;
import java.util.TimerTask;

public class BaseDispatcher {
    private static final ProcessTransmitter<ProcessAbility> LOADING_TASKS = new ProcessTransmitter<>();
    private static final ObservableValue<Integer> taskProcess = new ObservableValue<>(0);
    public static ProcessAbility BASE_EVENT = ProcessAbilityFactory.create("TASK1", () -> taskProcess, () -> taskProcess.getValue() == 100);
    static {
    }
    public void start(){
        defineLoadingTasks();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (taskProcess.getValue() < 100) {
                    taskProcess.setValue(taskProcess.getValue() + 1);
                } else this.cancel();
            }
        },100,100);
    }
    private void defineLoadingTasks(){
        LOADING_TASKS.register(BASE_EVENT);
    }
    public static void registerEventListener(@NotNull ProcessAbility process, @NotNull TransportHandler<ProcessAbility> handler) {
        process.getProcessObservable().addPropertyChangeListener(event -> {
            try {
                handler.dispatch(process);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
