
package com.dobi.niubility;

public class SessionUtils {
	private CacheManager cacheManager = new CacheManager();

	/**
	 * 
	 * @methodDesc: 功能描述:(初始化cacheManager)
	 *
	 */
	public void init() {
		if (cacheManager != null) {
			cacheManager = new CacheManager();
		}
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(新增一个session，返回一个sessionId)
	 *
	 */
	public String setAttribute(Object value) {
		// 生成SessionId
		String sessionId = TokenUtils.getToken();
		cacheManager.put(sessionId, value);
		return sessionId;

	}

	public Object getAttribute(String key) {
		return cacheManager.get(key);
	}

}
