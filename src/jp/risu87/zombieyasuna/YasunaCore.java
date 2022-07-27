package jp.risu87.zombieyasuna;

import javax.security.auth.login.LoginException;

import jp.risu87.zombieyasuna.eventhandler.DiscordEventRegistry;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class YasunaCore {
	
	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.out.println("token not given.");
			return; //exit
		}
		@SuppressWarnings("unused")
		JDA jda;
		if ( (jda = setupJDA(args[0])) == null) {
			System.out.println("Invalid token.");
			return; //exit
		}
	}
	
	private static JDA setupJDA(String token) {
		JDA retJdaObj = null;
		try {
			
			JDABuilder builder = JDABuilder.createDefault(token);
			
			//builder configure
			DiscordEventRegistry.registerEvent(builder);
			builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
			
			retJdaObj = builder.build();
			retJdaObj.awaitReady();
			
		} catch (LoginException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
			retJdaObj = null;
		}
		return retJdaObj;
	}
	
}
