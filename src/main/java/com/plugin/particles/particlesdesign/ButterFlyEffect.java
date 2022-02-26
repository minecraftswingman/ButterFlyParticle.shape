package com.plugin.particles.particlesdesign;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class ButterFlyEffect extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void CreateShape(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_AIR) {
            System.out.println("Debug");
            Location loc = e.getPlayer().getLocation();

            for (double t = 0; t <= Math.PI*12; t += Math.PI/8) {
                double x = Math.sin(t)*(Math.exp(Math.cos(t)) - 2*Math.cos(4*t) - Math.pow(Math.sin(t/12), 5));
                double y = Math.cos(t)*(Math.exp(Math.cos(t)) - 2*Math.cos(4*t) - Math.pow(Math.sin(t/12), 5));
                loc.add(x, y, 2);
                e.getPlayer().spawnParticle(Particle.FLAME, loc, 0, 0, 0, 0, 1);
                loc.subtract(x, y, 2);
            }









        }

    }

}