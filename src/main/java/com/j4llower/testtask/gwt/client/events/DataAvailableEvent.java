package com.j4llower.testtask.gwt.client.events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.j4llower.testtask.gwt.shared.proxy.PersonProxy;

/**
 * Indicates that new data is available to the application.
 */
public class DataAvailableEvent extends GwtEvent<DataAvailableEvent.Handler> {

    /**
     * Handles {@link DataAvailableEvent}.
     */
    public interface Handler extends EventHandler {
        void onRowData(DataAvailableEvent event);
    }

    public static final Type<Handler> TYPE = new Type<Handler>();

    private final List<PersonProxy> people;

    public DataAvailableEvent(List<PersonProxy> people) {
        this.people = Collections.unmodifiableList(
                new ArrayList<PersonProxy>(people));
    }

    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    public List<PersonProxy> getPeople() {
        return people;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onRowData(this);
    }
}
