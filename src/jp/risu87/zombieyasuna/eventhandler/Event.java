package jp.risu87.zombieyasuna.eventhandler;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public abstract class Event extends ListenerAdapter {
	
	public Event() {
		System.out.println("called");
		this.addEvent();
	}
	
	private void addEvent() {
		DiscordEventRegistry.events.add(this);
	}
	
}
