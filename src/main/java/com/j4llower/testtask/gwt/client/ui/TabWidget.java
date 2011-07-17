package com.j4llower.testtask.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.j4llower.testtask.gwt.client.mvp.UserDataProvider;

public class TabWidget extends Composite {

    interface Binder extends UiBinder<Widget, TabWidget> {
    }

    @UiField(provided = true)
    final FormWidget form;
    @UiField(provided = true)
    final TableWidget table;
    @UiField
    TabLayoutPanel tabPanel;

    private final UserDataProvider provider;

    public TabWidget(UserDataProvider provider) {
        this.provider = provider;
        form = new FormWidget();
        table = new TableWidget(provider, 10);
        Binder binder = GWT.create(Binder.class);
        initWidget(binder.createAndBindUi(this));
        initTab();
    }

    private void initTab() {
        tabPanel.selectTab(0);

        tabPanel.addSelectionHandler(new SelectionHandler<Integer>() {
            public void onSelection(SelectionEvent<Integer> event) {
                if (event.getSelectedItem() == 1) { // View Tab Index
                    provider.updateRowData();
                }
            }
        });
    }
}
