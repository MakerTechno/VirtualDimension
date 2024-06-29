package io.github.makertechno;

import io.github.makertechno.user.gui.Cover;
import io.github.makertechno.user.sys.BaseDispatcher;

import javax.naming.NameNotFoundException;
import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException, NameNotFoundException {
        new BaseDispatcher().start();
        new Cover();
    }
}
