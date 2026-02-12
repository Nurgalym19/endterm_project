package com.example.endtermapi.Cache;
import com.example.endtermapi.model.Player;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerCache {

    private static PlayerCache instance;
    private final Map<String, List<Player>> cache = new ConcurrentHashMap<>();
    private PlayerCache() {}
    public static PlayerCache getInstance() {
        if (instance == null) {
            instance = new PlayerCache();
        }
        return instance;
    }
    public List<Player> get(String key) {
        return cache.get(key);
    }
    public void put(String key, List<Player> players) {
        cache.put(key, players);
    }
    public void clear() {
        cache.clear();
    }
}
