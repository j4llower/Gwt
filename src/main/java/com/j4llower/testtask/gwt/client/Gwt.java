package com.j4llower.testtask.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.j4llower.testtask.gwt.client.mvp.UserDataProvider;
import com.j4llower.testtask.gwt.client.ui.TabWidget;
import com.j4llower.testtask.gwt.shared.service.PersonRequestFactory;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwt implements EntryPoint {

    private SimpleEventBus eventBus = new SimpleEventBus();
        
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        PersonRequestFactory requests = GWT.create(PersonRequestFactory.class);
        requests.initialize(eventBus);
        UserDataProvider provider = new UserDataProvider(requests);

        TabWidget tab = new TabWidget(provider);

        RootLayoutPanel.get().add(tab);
    }

}