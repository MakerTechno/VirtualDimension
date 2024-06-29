package io.github.makertechno.user.sys.console;

import io.github.makertechno.user.logic.transport.variables.IBaseElement;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface PatternHandler<T extends IBaseElement<T>> extends IFunctional {
    String getMagicPattern();
    String manageVariable(T variable);
    @Contract(value = "_, _ -> new", pure = true)
    static <A extends IBaseElement<A>> @NotNull PatternHandler<A> newPattern(String pattern, DoSth<IBaseElement<?>, String> supplier){
        return new PatternHandler<A>() {
            @Override
            public String getMagicPattern() {
                return pattern;
            }

            @Override
            public String manageVariable(A variable) {
                return supplier.doIt(variable);
            }
        };
    }
    interface DoSth<I,O> {
        O doIt(I in);
    }
}
