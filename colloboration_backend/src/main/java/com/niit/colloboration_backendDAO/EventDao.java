package com.niit.colloboration_backendDAO;

import java.util.ArrayList;

import com.niit.colloboration_backendModel.EventParticipants;
import com.niit.colloboration_backendModel.Events;

public interface EventDao
{
	public Events addEvent(Events event);
	public boolean updateEvent(Events event);
	public boolean deleteEvent(Events event);
	public Events getevent(int eventid);
	public ArrayList<Events> getAllevents();
	public boolean applyevent(EventParticipants eventparticipants);
	public ArrayList<EventParticipants> myevents(int myid);
	public ArrayList<EventParticipants> checkIfeveAppliied(int eventid,int myid);
	public ArrayList<EventParticipants> eventpars(int eventid);
	public boolean deleteEventpars(EventParticipants eventparticipants);
	public ArrayList<Events> eventrequests();
	public boolean approveevent(Events events);
	public boolean rejectevent(Events events);
}


