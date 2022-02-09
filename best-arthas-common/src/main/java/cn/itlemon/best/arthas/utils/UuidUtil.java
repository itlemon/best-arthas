package cn.itlemon.best.arthas.utils;

import cn.hutool.core.util.IdUtil;

/**
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-26
 */
public final class UuidUtil {

    private UuidUtil() {
    }

    public static String uuid() {
        return IdUtil.simpleUUID();
    }

}
