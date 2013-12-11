package com.ensi.vetokit.dispatcher;

import com.google.gwt.user.client.rpc.AsyncCallback;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

public interface VetokitDispatcherAsync extends DispatchAsync {
    <A extends Action<R>, R extends Result> void execute(A action, AsyncCallback<R> callback, boolean modal);
}
