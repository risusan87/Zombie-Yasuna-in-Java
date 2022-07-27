package jp.risu87.zombieyasuna.command;

import net.dv8tion.jda.api.entities.TextChannel;

public class CommandSpam extends Command {

	public CommandSpam() {
		super("spam");
	}

	@Override
	public void onCommand(TextChannel source, String... args) {
		for (int i = 0; i < 10; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < 10; j++) {
				for (String s : args) {
					sb.append(s).append(" ");
				}
			}
			if (sb.toString().isBlank()) return;
			source.sendMessage(sb.toString()).queue();
		}
	}

}
