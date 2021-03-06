package com.alibaba.middleware.race.decoupling;

import com.alibaba.middleware.race.RaceConf;
import com.alibaba.middleware.race.models.comparableKeys.*;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xiyuanbupt on 7/18/16.
 * 用于解耦的中间队列都在这里维护
 * 当待排序的行插入到文件之后,会在DiskLocQueues 中缓存key 值,以及对应的DiskLoc
 */
public class DiskLocQueues {

    public static final LinkedBlockingDeque<ComparableKeysByBuyerId> comparableKeysByBuyerIdQueue = new LinkedBlockingDeque<>(RaceConf.INMEMORYMAXQUEUESIZE);
    public static final LinkedBlockingDeque<ComparableKeysByGoodId> comparableKeysByGoodIdQueue = new LinkedBlockingDeque<>(RaceConf.INMEMORYMAXQUEUESIZE);
    public static final LinkedBlockingDeque<ComparableKeysByOrderId> comparableKeysByOrderId = new LinkedBlockingDeque<>(RaceConf.INMEMORYMAXQUEUESIZE);

    public static final LinkedBlockingDeque<ComparableKeysByBuyerCreateTimeOrderId> comparableKeysByBuyerCreateTimeOrderId = new LinkedBlockingDeque<>(RaceConf.INMEMORYMAXQUEUESIZE);
    public static final LinkedBlockingDeque<ComparableKeysByGoodOrderId> comparableKeysByGoodOrderId = new LinkedBlockingDeque<>(RaceConf.INMEMORYMAXQUEUESIZE);

    public static final LinkedBlockingDeque<OrderLineWithDiskLoc> originalOrderLineWithDisklocQueues = new LinkedBlockingDeque<>(RaceConf.INMEMORY_MAX_ORIGINAL_ORDERLINE);

    /**
     * 获得队列状态信息
     * @return
     */
    public static String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("CacheQueue Size##### ");
        sb.append("buyerId: ").append(comparableKeysByBuyerIdQueue.size());
        sb.append(", goodId: ").append(comparableKeysByGoodIdQueue.size());
        sb.append(", orderId: ").append(comparableKeysByOrderId.size());
        sb.append(", buyerCreateTimeOrder: ").append(comparableKeysByBuyerCreateTimeOrderId.size());
        sb.append(", goodOrder: ").append(comparableKeysByGoodOrderId.size());
        sb.append(", originalOrderLineWithDisklocQueues: ").append(originalOrderLineWithDisklocQueues.size());
        return sb.toString();
    }
}
