/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.appender.rolling.helper;

import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.core.appender.rolling.helper.AbstractAction;
import org.apache.logging.log4j.core.appender.rolling.helper.Action;

public class CompositeAction
extends AbstractAction {
    private final Action[] actions;
    private final boolean stopOnError;

    public CompositeAction(List<Action> list, boolean bl) {
        this.actions = new Action[list.size()];
        list.toArray(this.actions);
        this.stopOnError = bl;
    }

    @Override
    public void run() {
        try {
            this.execute();
        }
        catch (IOException iOException) {
            LOGGER.warn("Exception during file rollover.", (Throwable)iOException);
        }
    }

    @Override
    public boolean execute() throws IOException {
        if (this.stopOnError) {
            for (Action action : this.actions) {
                if (action.execute()) continue;
                return false;
            }
            return true;
        }
        boolean bl = true;
        IOException iOException = null;
        for (Action action : this.actions) {
            try {
                bl &= action.execute();
            }
            catch (IOException iOException2) {
                bl = false;
                if (iOException != null) continue;
                iOException = iOException2;
            }
        }
        if (iOException != null) {
            throw iOException;
        }
        return bl;
    }
}

