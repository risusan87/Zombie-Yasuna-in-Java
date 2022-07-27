package jp.risu87.zombieyasuna.command;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.api.entities.TextChannel;

public abstract class Command {
	
	public static final List<Command> COMMANDS = new ArrayList<Command>();
	static {
		new CommandSpam();
	}
	
	private final String comPrefix;
	
	public Command(String prefix) {
		this.comPrefix = prefix;
		COMMANDS.add(this);
	}
	
	public String getComPrefix() {
		return comPrefix;
	}
	
	public abstract void onCommand(TextChannel source, String... args);
	
}
