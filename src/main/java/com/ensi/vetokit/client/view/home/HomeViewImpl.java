package com.ensi.vetokit.client.view.home;

import com.bradrydzewski.gwt.calendar.client.Appointment;
import com.bradrydzewski.gwt.calendar.client.AppointmentStyle;
import com.bradrydzewski.gwt.calendar.client.Calendar;
import com.bradrydzewski.gwt.calendar.client.CalendarViews;
import com.ensi.vetokit.client.view.socle.CalendarWidgetImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DatePicker;

import java.util.Date;

public class HomeViewImpl extends Composite implements HomeView {

    private static ViewImplUiBinder uiBinder = GWT.create(ViewImplUiBinder.class);

    interface ViewImplUiBinder extends UiBinder<Widget, HomeViewImpl> {
    }

    private Presenter presenter;
    @UiField
    Calendar calendar;
    @UiField
    DecoratorPanel datePickerDecorator;
    @UiField
    DatePicker datePicker;
    @UiField
    DecoratedTabBar calendarViewsTabBar;
    @UiField
    DecoratorPanel dayViewDecorator;

    public HomeViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));
        calendarViewsTabBar.addTab("1 Day");
        calendarViewsTabBar.addTab("3 Day");
        calendarViewsTabBar.addTab("Work Week");
        calendarViewsTabBar.addTab("Week");
        calendarViewsTabBar.addTab("Agenda");
        calendarViewsTabBar.addTab("Month");
        calendarViewsTabBar.selectTab(1);
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