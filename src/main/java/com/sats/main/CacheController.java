package com.sats.main;

import com.sats.internal.model.Storage;
import com.sats.internal.service.CacheServiceImplementation;
import com.sats.internal.service.CacheServiceInterface;

import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0.0
 * @author sats17
 * 
 */
public class CacheController {
	
	
	/**
	 * This constructor create cache, that will delete after some time.
	 * @param size
	 * @param timeLimit
	 */
	public CacheController(int size,long timeLimit){
		cacheService.createCache(size,timeLimit);
	}
	
	/**
	 * This constructor create cache.
	 * @param size
	 */
	public CacheController(int size) {
		cacheService.createCache(size);
	}

	/**
	 *  Object creation of cacheService class.
	 */
	private CacheServiceInterface cacheService = new CacheServiceImplementation();
	
	/**
	 * This method set cache.
	 * @param key
	 * @param value
	 * @return void
	 */
	public void setCache(String key,Object value) {
		cacheService.setCache(key, value);
	}
	
	/**
	 * Set cache, there is different time limit for every object in cache.
	 * Currently not implemented
	 * @param key
	 * @param value
	 * @param timeExpire
	 */
	public void setCache(String key,Object value,Boolean timeExpire) {
		if(timeExpire) {
			cacheService.setCacheWithTimeExpire(key, value);
		}
		else {
			cacheService.setCache(key, value);
		}
		
	}
	
	/**
	 * This method get cache by cache name.
	 * @param key
	 * @return CacheObject
	 */
	public Object getCache(String key) {
		return cacheService.getCacheByKey(key);
	}
	
	/**
	 * This method return concurrent hashmap of all stored cache.
	 * @return ConcurrentHashMap<Object, Storage>
	 */
	public ConcurrentHashMap<Object, Storage> getAll() {
		return cacheService.getAll();
	}
	
	/**
	 * Clear cache by cache key.
	 * @param key
	 * @return void
	 */
	public void clear(String key) {
		cacheService.clearCache(key);
	}
	
	/**
	 * Clear all present cache.
	 * @return void
	 */
	public void clear() {
		cacheService.clearCache();
	}
	
}
