package jp.risu87.zombieyasuna.eventhandler;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.api.JDABuilder;

public class DiscordEventRegistry {
	
	protected static List<Event> events = new ArrayList<Event>();
	
	static {
		new EventHandlerOnMessageReceived();
	}
	
	/**
	 * Called once from main thread
	 */
	public static void registerEvent(JDABuilder builder) {
		
		events.forEach(event -> {builder.addEventListeners(event);});
		
	}
	
}
