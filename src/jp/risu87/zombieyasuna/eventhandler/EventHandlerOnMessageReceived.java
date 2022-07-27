package jp.risu87.zombieyasuna.eventhandler;

import jp.risu87.zombieyasuna.command.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class EventHandlerOnMessageReceived extends Event {
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if (event.getAuthor().isBot()) return;
		
		String content = event.getMessage().getContentRaw();
		Command.COMMANDS.forEach(command -> {
			System.out.println("checking command " + command.getComPrefix());
			String comPre = String.format("!y %s", command.getComPrefix());
			if ( content.toLowerCase().startsWith(comPre) ) {
				command.onCommand(event.getChannel().asTextChannel(), content.replace(comPre, "").split(" "));
			} else {
				System.out.println("no command found for: " + content.replace(comPre, "").split(" ")[1]);
			}
		});
	}
	
}
