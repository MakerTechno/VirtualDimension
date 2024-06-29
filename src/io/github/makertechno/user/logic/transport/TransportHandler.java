package io.github.makertechno.user.logic.transport;

import io.github.makertechno.user.logic.transport.process.ProcessAbility;
import io.github.makertechno.user.logic.transport.process.ProcessTransmitter;

public interface TransportHandler<T extends ProcessAbility> {
    void dispatch(ProcessAbility ability) throws Exception;
}
