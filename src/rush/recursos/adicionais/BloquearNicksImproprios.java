package rush.recursos.adicionais;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.event.player.PlayerPreLoginEvent.Result;

import rush.Main;

@SuppressWarnings({ "deprecation", "unused" })
public class BloquearNicksImproprios implements Listener {
	
	@EventHandler
	public void aoEntrar(PlayerPreLoginEvent e) {
        for (String nomebloqueado: Main.aqui.getConfig().getStringList("Nicks-Bloqueados")) {
        	String nome = e.getName().toLowerCase();
        	String check = nomebloqueado.toLowerCase();
		if (nome.contains(check)) {
			e.setKickMessage(Main.aqui.getMensagens().getString("Nick-Bloqueado").replaceAll("&", "�").replaceAll("%nick%", nomebloqueado));
			e.setResult(Result.KICK_OTHER);
		}
	}
	}
}
