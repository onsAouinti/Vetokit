package com.ensi.vetokit.client.view.home;

import com.bradrydzewski.gwt.calendar.client.Appointment;
import com.bradrydzewski.gwt.calendar.client.AppointmentStyle;
import com.bradrydzewski.gwt.calendar.client.Calendar;
import com.bradrydzewski.gwt.calendar.client.CalendarViews;
import com.ensi.vetokit.client.view.socle.CalendarWidgetImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import java.util.Date;

public class HomeViewImpl extends Composite implements HomeView {

    private static ViewImplUiBinder uiBinder = GWT.create(ViewImplUiBinder.class);

    interface ViewImplUiBinder extends UiBinder<Widget, HomeViewImpl> {
    }

    private Presenter presenter;
    @UiField
    CalendarWidgetImpl calendar;

    public HomeViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
        /*Appointment appt = new Appointment();
        appt.setStart(new Date());
        appt.setEnd(new Date());
        appt.setTitle("First Appointment");
        appt.setStyle(AppointmentStyle.BLUE);
        calendar.setView(CalendarViews.DAY, 7);
        calendar.addAppointment(appt);*/
    }

    public void setPresenter(final Presenter listener) {
        presenter = listener;
    }

}